package StrategyDesignPattern;

import StrategyDesignPattern.Strategy.InsertionSortingStrategy;
import StrategyDesignPattern.Strategy.SortingStrategy;

public class HackerEarthPlatform extends Sorter {
    public HackerEarthPlatform() {
        super(new InsertionSortingStrategy());
    }
}
