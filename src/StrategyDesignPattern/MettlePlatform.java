package StrategyDesignPattern;

import StrategyDesignPattern.Strategy.BubbleSortingStrategy;
import StrategyDesignPattern.Strategy.SortingStrategy;

public class MettlePlatform extends Sorter {
    public MettlePlatform() {
        super(new BubbleSortingStrategy());
    }
}
