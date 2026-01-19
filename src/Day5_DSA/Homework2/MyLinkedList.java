package Day5_DSA.Homework2;

import java.util.Objects;

public class MyLinkedList<E> implements Cloneable {
    private static class Node {
        Object data;
        Node next;
        public Node(Object data) {
            this.data = data;
        }

        Object getData() {
            return data;
        }
    }

    private Node head;
    private int numNodes = 0;

    // Constructor 1 tham số: tạo node đầu tiên
    public MyLinkedList(E firstData) {
        head = new Node(firstData);
        numNodes = 1;
    }

    // Constructor rỗng (tiện cho clone/ tạo list tống)
    public MyLinkedList() {
        head = null;
        numNodes = 0;
    }

    // Add first(E e): thêm vào đầu danh sách
    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head.next;
        head.next = newNode;
        numNodes++;
    }

    // Add Last(E e): thêm vào cuối danh sách
    public void addLast(E e) {
        Node newNode = new Node(e);

        if(head == null) {
            head = newNode;
            numNodes = 1;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        numNodes++;
    }

    // Add (E e): thêm vào cuối danh sách
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    // Add(int index, E element): chèn vào vị trí index
    public void add(int index,E element) {
        checkPositionIndex(index); // cho phép index == size (add cuối)

        if (index == 0) {
            addFirst(element);
            return;
        }

        Node prev = getNode(index -1);
        Node newNode = new Node(element);
        newNode.next = prev.next;
        prev.next = newNode;
        numNodes++;
    }

    //Get (int index): lấy phần tử tại index
    public E get(int index) {
        checkElementIndex(index);
        return (E) getNode(index).data;
    }

    //Size(): số phần tử của danh sách
    public int size() {
        return numNodes;
    }

    // Remove(int index): xóa phần tử tại index và trả về phân tử đã xóa
    public E remove(int index) {
        checkElementIndex(index);

        if (index == 0) {
            E removed = (E) head.data;
            head = head.next;
            numNodes--;
            return removed;
        }

        Node prev = getNode(index -1);
        Node target = prev.next;

        E removed = (E) target.data;
        prev.next = target.next;
        numNodes--;
        return removed;
    }

    // Remove(Object o)L xóa phần tử đầu tiên bằng o, tra true nếu xóa được
    public boolean remove(Object o) {
        if (head == null) return false;

        if (Objects.equals(head.data, o)) {
            head = head.next;
            numNodes--;
            return true;
        }

        Node prev = head;
        Node cur = head.next;
        while (cur != null) {
            if (Objects.equals(cur.data, o)) {
                prev.next = cur.next;
                numNodes--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    //Contains (E o): có chứa phần tử o không
    public boolean contains(E o) {
        return indexOf(o) != -1;
    }

    // indexOf (E o): vị trí đầu tiên của o, -1 nếu không có
    public int indexOf(E o) {
        int idx = 0;
        Node cur = head;
        while (cur != null) {
            if (Objects.equals(cur.data, o)) return idx;
            cur = cur.next;
            idx++;
        }
        return -1;
    }
    /** clone(): sao chép sang list mới (deep copy node, shallow copy data) */
    @Override
    public MyLinkedList<E> clone() {
        MyLinkedList<E> copied = new MyLinkedList<>();
        if (this.head == null) return copied;

        Node cur = this.head;
        while (cur != null) {
            copied.addLast((E) cur.data);
            cur = cur.next;
        }
        return copied;
    }

    /** printList(): in ra các phần tử */
    public void printList() {
        Node cur = head;
        System.out.print("[");
        while (cur != null) {
            System.out.print(cur.data);
            cur = cur.next;
            if (cur != null) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ===== Helpers =====

    private Node getNode(int index) {
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index " + index + ", Size " + numNodes);
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index " + index + ", Size " + numNodes);
        }
    }
}
