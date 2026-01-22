package Day5_DSA.Homework7;

public class Solution {
    Queue q = new Queue();

    // --------------enQueue--------------
    public void enQueue(int value){
        Node newNode = new Node(value);

        // Nêu queue rỗng
        if (q.front == null) {
            q.front = q.rear = newNode;
            q.rear.link = q.front; // trỏ vòng
        } else {
            q.rear.link = newNode; // rear cũ trỏ node mới
            q.rear = newNode; // cập nhật rear sang node mới
            q.rear.link = q.front; // rear mới trỏ về front
        }
    }

    // --------------deQueue--------------
    public Integer deQueue(){
        // Nếu rỗng
        if (q.front == null) {
            System.out.println("Queue is empty");
            return null;
        }

        int value = q.front.data;

        // nếu chỉ có 1 phần tử
        if (q.front == q.rear) {
            q.front = q.rear = null;
        } else  {
            q.front = q.front.link; // front sang node kế
            q.rear.link = q.front; // rear trỏ lại front mới
        }
        return value;
    }

    // --------------displayQueue--------------
    public void displayQueue(){
        if (q.front == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = q.front;
        System.out.println("Queue: ");

        do {
            System.out.println(temp.data + " ");
            temp = temp.link;
        } while (temp != q.front);

        System.out.println();
    }
}
