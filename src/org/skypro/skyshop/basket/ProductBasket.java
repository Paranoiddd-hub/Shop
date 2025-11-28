package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProductBasket {
    private Map<String, List<Product>> basket = new HashMap<>();

    public Map<String, List<Product>> getBasket() {
        return basket;
    }

    public void addProduct(Product product) {
        basket.computeIfAbsent(product.getName().toLowerCase(), key -> new ArrayList<>()).add(product);
        if (basket.containsKey(product.getName())) {
            basket.get(product.getName().toLowerCase()).add(product);
        }
    }

    public int totalCost() {
        int totalCost = 0;
        for (List<Product> list : basket.values()) {
            for (Product product : list) {
                if (Objects.nonNull(product)) {
                    totalCost += product.getPrice();
                }
            }
        }
        return totalCost;
    }

    public void printInfo() {
        if (basket.size() == 0) {
            System.out.println("В корзине пусто!");
        }
        int specialCounter = 0;
        for (List<Product> list : basket.values()) {
            for (Product product : list) {
                if (Objects.nonNull(product)) {
                    if (product.isSpecial()) {
                        specialCounter++;
                    }
                    System.out.println(product);
                }
            }
        }
        System.out.println("Итого: " + totalCost());
        System.out.println("Специальных товаров: " + specialCounter);
    }

    public boolean contain(String productName) {
        return basket.containsKey(productName.toLowerCase());
    }

    public void clear() {
        basket.clear();
    }

    public List<Product> deleteProduct(String productName) {
        List<Product> results = new ArrayList<>();
        if (basket.containsKey(productName.toLowerCase())) {
            results = basket.get(productName.toLowerCase());
            basket.remove(productName.toLowerCase());
        }
        return results;
    }
}
