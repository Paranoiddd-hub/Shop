package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ProductBasket {
    private List<Product> basket = new ArrayList<>();

    public List<Product> getBasket() {
        return basket;
    }

    public void addProduct(Product product) {
        basket.add(product);
    }

    public int totalCost() {
        int totalCost = 0;
        for (Product product : basket) {
            if (Objects.nonNull(product)) {
                totalCost += product.getPrice();
            }
        }
        return totalCost;
    }

    public void printInfo() {
        if (basket.size() == 0) {
            System.out.println("В корзине пусто!");
        }
        int specialCounter = 0;
        for (Product product : basket) {
            if (Objects.nonNull(product)) {
                if (product.isSpecial()) {
                    specialCounter++;
                }
                System.out.println(product);
            }
        }
        System.out.println("Итого: " + totalCost());
        System.out.println("Специальных товаров: " + specialCounter);
    }

    public boolean contain(String productName) {
        for (Product product : basket) {
            if (Objects.nonNull(product) && product.getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        basket.clear();
    }

    public List<Product> deleteProduct(String name) {
        Iterator<Product> iterator = basket.iterator();
        ArrayList<Product> results = new ArrayList<>();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (element.getName().equalsIgnoreCase(name)) {
                results.add(element);
                iterator.remove();
            }
        }
        return results;
    }
}
