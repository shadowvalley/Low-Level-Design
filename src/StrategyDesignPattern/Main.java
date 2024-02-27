package StrategyDesignPattern;

public class Main {
    public static void main(String[] args) {

        System.out.println("Strategy Design Pattern!");
        int[] arr = {6,2,8,4,9,5};
        Sorter mettle = new MettlePlatform();
        int[] mettle_output = mettle.sort(arr);
        for (int k : mettle_output) {
            System.out.print(k + " ");
        }
        System.out.println("\n");

        int[] arr2 = {1,8,6,7,5,3};
        Sorter hackerearth = new HackerEarthPlatform();
        int[] hackerearth_output = hackerearth.sort(arr2);
        for (int j : hackerearth_output) {
            System.out.print(j + " ");
        }
        System.out.println("\n");

        int[] arr3 = {1,8,6,7,5,3};
        Sorter hackerrank = new HackerRankPlatform();
        int[] hackerrank_output = hackerrank.sort(arr3);
        for (int j : hackerrank_output) {
            System.out.print(j + " ");
        }
        System.out.println("\n");
    }
}