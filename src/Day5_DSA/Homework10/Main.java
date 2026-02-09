package Day5_DSA.Homework10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student("Khang", 30, "HCM");
        Student st2 = new Student("Vo", 30, "HN");
        Student st3 = new Student("Thien", 30, "HCM");

        Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
        studentMap.put(1, st1);
        studentMap.put(2, st2);
        studentMap.put(3, st3);
        studentMap.put(4, st1);

        for (Map.Entry<Integer, Student> student : studentMap.entrySet()) {
            System.out.println(student.toString());
        }
        System.out.println("----------Set------");
        Set<Student> studentSet = new HashSet<Student>();

        studentSet.add(st1);
        studentSet.add(st2);
        studentSet.add(st3);
        studentSet.add(st1);

        for (Student student : studentSet) {
            System.out.println(student.toString());
        }
    }
}
