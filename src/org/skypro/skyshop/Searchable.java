package org.skypro.skyshop;

public interface Searchable {
    String searchTerm();

    String getSearchableType();

    String getSearchableName();

    default String getStringRepresentation() {
        return getSearchableName() + getSearchableType();
    }
}
