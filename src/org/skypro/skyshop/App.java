package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Product chiken = new Product("Chicken", 500);
        Product butter = new Product("Butter", 200);
        Product bread = new Product("Bread", 50);
        Product eggs = new Product("Eggs", 100);
        Product buckwheat = new Product("Buckwheat", 100);
        Product milk = new Product("Milk", 80);

        ProductBasket basket = new ProductBasket();
        // 1. Добавление продукта в корзину.
        basket.addProduct(chiken);
        basket.addProduct(butter);
        basket.addProduct(bread);
        basket.addProduct(eggs);
        basket.addProduct(buckwheat);
        System.out.println();
        // 2. Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.addProduct(milk);
        System.out.println();
        // 3. Печать содержимого корзины с несколькими товарами.
        basket.printInfo();
        System.out.println();
        // 4. Получение стоимости корзины с несколькими товарами.
        System.out.println(basket.totalCost());
        System.out.println();
        // 5. Поиск товара, которого нет в корзине.
        System.out.println(basket.isIn("eggs"));
        System.out.println();
        // 6. Поиск товара, которого нет в корзине.
        System.out.println(basket.isIn("milk"));
        System.out.println();
        // 7. Очистка корзины.
        basket.clear();
        System.out.println(Arrays.toString(basket.getBasket()));
        System.out.println();
        // 8. Печать содержимого пустой корзины.
        basket.printInfo();
        System.out.println();
        // 9. Получение стоимости пустой корзины.
        System.out.println(basket.totalCost());
        System.out.println();
        // 10. Поиск товара по имени в пустой корзине.
        System.out.println(basket.isIn("icecream"));
    }
}