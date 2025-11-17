package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchEngine {
    private List<Searchable> searchBase = new ArrayList<>();

    public List<Searchable> getSearchBase() {
        return searchBase;
    }

    public List<Searchable> search(String searchWord) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable s : searchBase) {
            if (Objects.nonNull(s) && s.getSearchTerm().toLowerCase().contains(searchWord.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        searchBase.add(searchable);
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
