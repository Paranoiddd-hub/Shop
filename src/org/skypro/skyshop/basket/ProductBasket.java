package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Collection;
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
        basket.get(product.getName().toLowerCase()).add(product);
    }

    public int totalCost() {
        return basket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printInfo() {
        if (basket.size() == 0) {
            System.out.println("В корзине пусто!");
        }
        basket.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + totalCost());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    public long getSpecialCount() {
        return basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean contain(String productName) {
        return basket.containsKey(productName.toLowerCase());
    }

    public void clear() {
        basket.clear();
    }

    public List<Product> deleteProduct(String productName) {
        return basket.remove(productName.toLowerCase());
    }
}
