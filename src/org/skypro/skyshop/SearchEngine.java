package org.skypro.skyshop;

import java.util.Objects;

public class SearchEngine {
    private Searchable[] searchBase;

    public SearchEngine(int arrayLength) {
        this.searchBase = new Searchable[arrayLength];
    }

    public Searchable[] getSearchBase() {
        return searchBase;
    }

    public Searchable[] search(String searchWord) {
        Searchable[] results = new Searchable[5];
        int counter = 0;
        for (int i = 0; i < searchBase.length; i++) {
            if (counter == 5) {
                break;
            }
            if (Objects.nonNull(searchBase[i]) && searchBase[i].searchTerm().toLowerCase().contains(searchWord.toLowerCase())) {
                for (int j = 0; j < results.length; j++) {
                    if (Objects.isNull(results[j])) {
                        results[j] = searchBase[i];
                        break;
                    }
                }
                counter++;
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < searchBase.length; i++) {
            if (searchBase[i] == null) {
                searchBase[i] = searchable;
                break;
            }
        }
    }
}
