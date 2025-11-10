package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("Введено неправильное название продукта!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getSearchableType() {
        return "PRODUCT";
    }

    @Override
    public String getSearchableName() {
        return name;
    }
}
