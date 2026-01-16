package Day5_DSA.Homework1;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();

        //add(E)
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("After add: " + list); // [10, 20, 30]

        //add(index, E)
        list.add(1, 99);
        System.out.println("After insert at 1 " + list); // [10, 99, 20, 30]

        //get(i)
        System.out.println("get(2): " + list.get(2)); // 20

        // contains, indexOf
        System.out.println("contain(99): "+ list.contains(99)); //true
        System.out.println("indexOf(30): " + list.indexOf(30)); //3

        // remove(index)
        int removed = list.remove(1);
        System.out.println("removed: " + removed); // 99
        System.out.println("After remove: " + list); // [10, 20, 30]

        // clone()
        MyList<Integer> cloned = list.clone();
        cloned.add(40);
        System.out.println("Original: " + list); // [10, 20, 30]
        System.out.println("Cloned:   " + cloned); // [10, 20, 30, 40]

        // clear()
        list.clear();
        System.out.println("After clear original: " + list); // []
        System.out.println("Size original: " + list.size()); // 0
    }
}
