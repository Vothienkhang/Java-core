package Day5_DSA.Homework2;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>(10);

        list.addFirst(5); // [5, 10]
        list.addLast(10); // [5, 10, 20]
        list.add(1,7); // [5, 7, 10, 20]
        list.add(30); // [5, 7, 10, 20, 30]
        list.printList();

        System.out.println("size = " + list.size());
        System.out.println("get(2) =" + list.get(2));
        System.out.println("indexOf(20) =" + list.indexOf(20));
        System.out.println("contain(99) =" + list.contains(99));

        System.out.println("remove index 1: " + list.remove(1)); // remove 7
        list.printList(); // [5, 10, 20, 30]

        System.out.println("remove object 20: " + list.remove(Integer.valueOf(20)));
        list.printList(); // [5, 10, 30]

        MyLinkedList<Integer> cloned = list.clone();
        System.out.print("cloned = ");
        cloned.printList();

        // test độc lập
        cloned.addLast(999);
        System.out.print("original = ");
        list.printList();
        System.out.print("cloned after add = ");
        cloned.printList();
    }
}
