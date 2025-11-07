package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

public final class Article implements Searchable {
    String title;
    String text;

    public Article(String name, String text) {
        this.title = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getSearchableType() {
        return "ARTICLE";
    }

    @Override
    public String getSearchableName() {
        return title;
    }
}
