package Day5_DSA.Homework8;

public class MyQueue {
    private int capacity;
    private int queueArr[];
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }

    public boolean isQueueFull() {
        boolean status = false;
        if (currentSize == capacity) {
            status = true;
        }
        return status;
    }

    public boolean isQueueEmpty() {
        boolean status = false;
        if (currentSize == 0) {
            status = true;
        }
        return status;
    }

    public void enQueue(int item) {
        if (isQueueFull()) {
            System.out.println("Queue is full! Unable to add element: " + item);
        } else {
            tail = (tail + 1) % capacity;
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Added element to the queue: " + item);
        }
    }

    public void deQueue() {
        if (isQueueEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            head++;
            if (head == capacity -1) {
                System.out.println("Pop operation done ! removed: " + queueArr[head-1]);
                head = 0;
            } else {
                System.out.println("Pop operation done ! removed: " + queueArr[head-1]);
            }
            currentSize--;
        }
    }
}


