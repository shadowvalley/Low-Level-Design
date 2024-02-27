package StrategyDesignPattern;

import StrategyDesignPattern.Strategy.SortingStrategy;

public class Sorter {
    SortingStrategy sortingStrategy;

    public Sorter(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public int[] sort(int[] arr) {
        return sortingStrategy.sort(arr);
    }
}
