package Exception.Triangle;

import java.util.Scanner;

public class MainTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println(" Nhập cạnh a: ");
            double a = sc.nextDouble();

            System.out.println(" Nhập cạnh b: ");
            double b = sc.nextDouble();

            System.out.println(" Nhập cạnh c: ");
            double c = sc.nextDouble();

            TriangleCalculation.checkTriangle(a,b,c);
        }
        catch (IllegalTriangleException e) {
            System.out.println("Tam giác này bị lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" Lỗi nhập liệu! ");
        }
    }
}
