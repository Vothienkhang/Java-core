package Exception.Triangle;

public class TriangleCalculation {
    public static void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        // Kiểm tra số âm hoặc bằng 0
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Cạnh tam giác phải là số dương!");
        }

        // Kiểm tra điều kiện tam giác
        if (a + b <= c || b + c <= a || c + a <= b) {
            throw new IllegalTriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại!");
        }

        System.out.println(" Đây là một tam giác hợp lệ");
    }
}
