package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Product chicken = new SimpleProduct("Курица", 500);
        Product butter = new SimpleProduct("Масло", 200);
        Product bread = new FixPriceProduct("Хлеб");
        Product eggs = new DiscountedProduct("Яйца", 100, 10);
        Product buckwheat = new DiscountedProduct("Гречка", 100, 20);
        Product milk = new SimpleProduct("Milk", 80);

        ProductBasket basket = new ProductBasket();
        // 1. Добавление продукта в корзину.
        System.out.println("1. Добавление продукта в корзину");
        basket.addProduct(chicken);
        basket.addProduct(butter);
        basket.addProduct(bread);
        basket.addProduct(eggs);
        basket.addProduct(buckwheat);
        System.out.println();
        // 2. Добавление продукта в заполненную корзину, в которой нет свободного места.
        System.out.println("2. Добавление продукта в заполненную корзину, в которой нет свободного места.");
        basket.addProduct(milk);
        System.out.println();
        // 3. Печать содержимого корзины с несколькими товарами.
        System.out.println("3. Печать содержимого корзины с несколькими товарами.");
        basket.printInfo();
        System.out.println();
        // 4. Получение стоимости корзины с несколькими товарами.
        System.out.println("4. Получение стоимости корзины с несколькими товарами.");
        System.out.println(basket.totalCost());
        System.out.println();
        // 5. Поиск товара, которого нет в корзине.
        System.out.println("5. Поиск товара, которого нет в корзине.");
        System.out.println(basket.contain("eggs"));
        System.out.println();
        // 6. Поиск товара, которого нет в корзине.
        System.out.println("6. Поиск товара, которого нет в корзине.");
        System.out.println(basket.contain("milk"));
        System.out.println();
        // 7. Очистка корзины.
        System.out.println(" 7. Очистка корзины.");
        basket.clear();
        System.out.println(basket.getBasket());
        System.out.println();
        // 8. Печать содержимого пустой корзины.
        System.out.println("8. Печать содержимого пустой корзины.");
        basket.printInfo();
        System.out.println();
        // 9. Получение стоимости пустой корзины.
        System.out.println("9. Получение стоимости пустой корзины.");
        System.out.println(basket.totalCost());
        System.out.println();
        // 10. Поиск товара по имени в пустой корзине.
        System.out.println("10. Поиск товара по имени в пустой корзине.");
        System.out.println(basket.contain("icecream"));
        System.out.println();
        // Домашка ООП.Полиморфизм.Интерфейсы
        System.out.println("Домашка ООП.Полиморфизм.Интерфейсы");
        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(chicken);
        searchEngine.add(butter);
        searchEngine.add(bread);
        searchEngine.add(eggs);
        searchEngine.add(buckwheat);
        searchEngine.add(milk);

        Article article1 = new Article("Бородинский хлеб", "Ой вкусный хлеб прям вообще.");
        Article article2 = new Article("Курица - не птица", "Курица – не птица, Болгария – не заграница");
        searchEngine.add(article1);
        searchEngine.add(article2);

        System.out.println(searchEngine.getSearchBase());
        System.out.println(searchEngine.search("хлеб"));
        System.out.println();

        // Домашка Исключения в Java.
        System.out.println("Домашка Исключения в Java.");
        System.out.println("         Исключения в Java");
        try {
            Product testProduct1 = new SimpleProduct(" ", 30);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product testProduct2 = new SimpleProduct("testProduct2", -30);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product testProduct3 = new DiscountedProduct("testProduct3", 20, -2);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("Наиболее подходящий элемент поиска");
        try {
            System.out.println(searchEngine.searchMostSuitable("Курица").toString());
            System.out.println(searchEngine.searchMostSuitable("Сахар").toString());
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }
        System.out.println();

        // Домашка Java Collections Framework: List
        System.out.println("Домашка Java Collections Framework: List");
        basket.addProduct(chicken);
        basket.addProduct(butter);
        basket.addProduct(bread);
        basket.addProduct(eggs);
        basket.addProduct(buckwheat);
        System.out.println(basket.deleteProduct("курица"));
        basket.printInfo();
        System.out.println();

        basket.printInfo();
        System.out.println();

        System.out.println(basket.deleteProduct("молоко") + " Список пуст!");
        System.out.println();

        basket.printInfo();

    }
}