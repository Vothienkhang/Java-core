package Day5_DSA.Homework11;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose implementation:");
        System.out.println("1. ArrayList");
        System.out.println("2. LinkedList");
        System.out.print("Your choice: ");
        int impl = readInt(sc);

        ProductManagerArrayList arrManager = null;
        ProductManagerLinkedList linkManager = null;

        if (impl == 2) linkManager = new ProductManagerLinkedList();
        else arrManager = new ProductManagerArrayList();

        while (true) {
            printMenu();
            System.out.print("Choose: ");
            int choice = readInt(sc);

            switch (choice) {
                case 1: { // add
                    System.out.print("Enter id: ");
                    int id = readInt(sc);
                    System.out.print("Enter name: ");
                    String name = readLine(sc);
                    System.out.print("Enter price: ");
                    double price = readDouble(sc);

                    boolean ok = (impl == 2)
                            ? linkManager.addProduct(new Product(id, name, price))
                            : arrManager.addProduct(new Product(id, name, price));

                    System.out.println(ok ? "Added successfully." : "Failed: ID already exists.");
                    break;
                }
                case 2: { // update
                    System.out.print("Enter id to update: ");
                    int id = readInt(sc);
                    System.out.print("Enter new name: ");
                    String name = readLine(sc);
                    System.out.print("Enter new price: ");
                    double price = readDouble(sc);

                    boolean ok = (impl == 2)
                            ? linkManager.updateById(id, name, price)
                            : arrManager.updateById(id, name, price);

                    System.out.println(ok ? "Updated successfully." : "Failed: ID not found.");
                    break;
                }
                case 3: { // remove
                    System.out.print("Enter id to remove: ");
                    int id = readInt(sc);

                    boolean ok = (impl == 2)
                            ? linkManager.removeById(id)
                            : arrManager.removeById(id);

                    System.out.println(ok ? "Removed successfully." : "Failed: ID not found.");
                    break;
                }
                case 4: { // display
                    if (impl == 2) linkManager.display();
                    else arrManager.display();
                    break;
                }
                case 5: { // search
                    System.out.print("Enter name keyword: ");
                    String key = readLine(sc);

                    List<Product> found = (impl == 2)
                            ? linkManager.searchByName(key)
                            : arrManager.searchByName(key);

                    if (found.isEmpty()) System.out.println("No products found.");
                    else found.forEach(System.out::println);
                    break;
                }
                case 6: { // sort asc
                    if (impl == 2) linkManager.sortByPriceAsc();
                    else arrManager.sortByPriceAsc();
                    System.out.println("Sorted by price ascending.");
                    break;
                }
                case 7: { // sort desc
                    if (impl == 2) linkManager.sortByPriceDesc();
                    else arrManager.sortByPriceDesc();
                    System.out.println("Sorted by price descending.");
                    break;
                }
                case 0:
                    System.out.println("Bye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== PRODUCT MANAGER =====");
        System.out.println("1. Add product");
        System.out.println("2. Update product by id");
        System.out.println("3. Remove product by id");
        System.out.println("4. Display products");
        System.out.println("5. Search products by name");
        System.out.println("6. Sort by price ASC");
        System.out.println("7. Sort by price DESC");
        System.out.println("0. Exit");
    }

    private static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Invalid integer. Re-enter: ");
            }
        }
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Invalid number. Re-enter: ");
            }
        }
    }

    private static String readLine(Scanner sc) {
        String s = sc.nextLine();
        return (s == null) ? "" : s.trim();
    }
}