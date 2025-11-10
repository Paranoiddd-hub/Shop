package org.skypro.skyshop;

public interface Searchable {
    String getSearchTerm();

    String getSearchableType();

    String getSearchableName();

    default String getStringRepresentation() {
        return getSearchableName() + getSearchableType();
    }
}
