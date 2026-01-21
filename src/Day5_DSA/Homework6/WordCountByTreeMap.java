package Day5_DSA.Homework6;

import java.util.Map;
import java.util.TreeMap;

public class WordCountByTreeMap {
    public static void main(String[] args) {
        String text = "Java is fun and Java is powerful and fun";

        // Tạo TreeMap
        TreeMap<String, Integer> wordMap = new TreeMap<>();

        // Tách từ và tạo mảng (theo khoang trắng)
        String[] words = text.split("\\s+");

        // Duyệt từng từ
        for (String word : words) {
            word = word.toLowerCase(); // chuẩn hóa chữ thường

            if(wordMap.containsKey(word)){
                wordMap.put(word,wordMap.get(word)+1);
            } else {
                wordMap.put(word,1);
            }
        }

        // In kết quả
        System.out.println("Word count (alphabet order):");
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
