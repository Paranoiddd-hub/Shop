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
            if (Objects.nonNull(searchBase[i]) && searchBase[i].getSearchTerm().toLowerCase().contains(searchWord.toLowerCase())) {
                results[counter] = searchBase[i];
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

    public Searchable searchMostSuitable(String search) throws BestResultNotFound {
        Searchable mostSuitable = null;
        int max = 0;
        for (Searchable el : searchBase) {
            int amount = 0;
            int index = 0;
            int substringIndex = el.getSearchTerm().toLowerCase().indexOf(search.toLowerCase(), index);
            while (substringIndex != -1) {
                amount++;
                index = substringIndex + search.length();
                substringIndex = el.getSearchTerm().toLowerCase().indexOf(search.toLowerCase(), index);;
            }
            if (amount > max) {
                max = amount;
                mostSuitable = el;
            }
        }
        if (Objects.isNull(mostSuitable)) {
            throw new BestResultNotFound("Для запроса " + "\"" + search + "\"" + " подходящий результат не найден!");
        }
        return mostSuitable;
    }
}
