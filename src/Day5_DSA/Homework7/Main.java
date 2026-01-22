package Day5_DSA.Homework7;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.enQueue(14);
        sol.enQueue(22);
        sol.enQueue(-6);
        sol.displayQueue();

        sol.deQueue();
        sol.displayQueue();

        sol.enQueue(9);
        sol.enQueue(20);
        sol.displayQueue();
    }
}
