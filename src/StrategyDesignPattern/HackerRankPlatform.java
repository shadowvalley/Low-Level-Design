package StrategyDesignPattern;

import StrategyDesignPattern.Strategy.InsertionSortingStrategy;
import StrategyDesignPattern.Strategy.SortingStrategy;

public class HackerRankPlatform extends Sorter {
    public HackerRankPlatform() {
        super(new InsertionSortingStrategy());
    }
}
