package Day5_DSA.Homework8;

import java.io.IOException;

public class QueueClient {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(4);
        queue.enQueue(4);
        queue.deQueue();
        queue.enQueue(56);
        queue.enQueue(2);
        queue.enQueue(67);
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(24);
        queue.deQueue();
        queue.enQueue(98);
        queue.enQueue(45);
        queue.enQueue(23);
        queue.enQueue(435);
    }
}
