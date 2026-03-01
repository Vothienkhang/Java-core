package Day5_DSA.Homework11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductManagerArrayList {
    private final List<Product> products = new ArrayList<>();

    private int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) return i;
        }
        return -1;
    }

    public boolean addProduct(Product p) {
        if (findIndexById(p.getId()) != -1) return false; // ID đã tồn tại
        products.add(p);
        return true;
    }

    public boolean updateById(int id, String newName, double newPrice) {
        int index = findIndexById(id);
        if (index == -1) return false;
        Product p = products.get(index);
        p.setName(newName);
        p.setPrice(newPrice);
        return true;
    }

    public boolean removeById(int id) {
        int index = findIndexById(id);
        if (index == -1) return false;
        products.remove(index);
        return true;
    }

    public void display() {
        if (products.isEmpty()) {
            System.out.println("There are no products in the list");
            return;
        }
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getName() != null && p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    public void sortByPriceAsc() {
        products.sort(Comparator.comparingDouble(Product::getPrice));
    }

    public void sortByPriceDesc() {
        products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
    }
}
