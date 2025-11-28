package org.skypro.skyshop;


import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
    private Set<Searchable> searchBase = new HashSet<>();

    public Set<Searchable> getSearchBase() {
        return searchBase;
    }

    public Set<Searchable> search(String searchWord) {
        Set<Searchable> results = new TreeSet<>(new ReverseLengthComparator());
        for (Searchable s : searchBase) {
            if (Objects.nonNull(s) && s.getSearchTerm().toLowerCase().contains(searchWord.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }

    public static class ReverseLengthComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            if (s1.getSearchableName().length() == s2.getSearchableName().length()) {
                return s1.getSearchableName().compareTo(s2.getSearchableName());
            }
            return s2.getSearchableName().length() - s1.getSearchableName().length();
        }
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
