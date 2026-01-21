package Day5_DSA.Homework5;

import java.util.Arrays;
import java.util.Stack;

// Đảo ngược phần tử trong mảng số nguyên sử dụng Stack
//
//Ý tưởng giải quyết vấn đề:
//
//1. Khởi tạo một Stack rỗng, có kiểu số.
//
//2. Với n phần tử của mảng, lần lượt đưa vào Stack thông qua hàm Push: Push a[i] into Stack.
//
//3. Lần lượt lấy ra từ Stack n phần tử và đưa vào trở lại mảng ban đầu:
//
//4. Kết thúc giải thuật.
public class ReverseArrayByStack {
    public static void reverseArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        // Đưa toàn bộ phần tử vào stack
        for (int num : arr) {
            stack.push(num);
        }

        // Lấy ra khỏi stack và gán lại cho mảng
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(" Mảng ban đầu: "+ Arrays.toString(arr));
        reverseArray(arr);
        System.out.println("Mảng sau khi đảo: "+ Arrays.toString(arr));
    }
}
