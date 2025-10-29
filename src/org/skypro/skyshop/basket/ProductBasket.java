package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Objects;

public class ProductBasket {
    private Product[] basket = new Product[5];

    public Product[] getBasket() {
        return basket;
    }

    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (Objects.isNull(basket[i])) {
                basket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт!");
    }

    public int totalCost() {
        int totalCost = 0;
        for (Product product : basket) {
            if (Objects.nonNull(product)) {
                totalCost += product.getProductPrice();
            }
        }
        return totalCost;
    }

    public void printInfo() {
        if (basket.length == 0) {
            System.out.println("В корзине пусто!");
        }
        for (Product product : basket) {
            if (Objects.nonNull(product)) {
                System.out.println(product.getProductName() + ": " + product.getProductPrice());
            }
        }
        System.out.println("Итого: " + totalCost());
    }

    public boolean isIn(String productName) {
        for (Product product : basket) {
            if (Objects.nonNull(product) && product.getProductName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        Arrays.fill(basket, null);
    }
}
