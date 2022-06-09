package DP;

public class ZeroOneKnapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if( weights.length == 0 )
            return 0;
        if( weights.length == 1 )
            return profits[0];

        int[][] profitMemory = new int[profits.length][capacity + 1];
        return this.recursive(profits, weights, profitMemory, capacity, 0);
    }
    private int recursive(int[] profits, int[] weights,int[][] profitMemory, int capacity, int index) {

        if( capacity <= 0 || index >= profits.length)
            return 0;

        int profitLeft = 0;


        if( profitMemory[index][capacity] != 0 )
            return profitMemory[index][capacity];


        if( weights[index] <= capacity )

            profitLeft = profits[index] + recursive(profits, weights, profitMemory, capacity - weights[index], index + 1);


        int profitRight =  recursive(profits, weights,profitMemory, capacity, index + 1);

        profitMemory[index][capacity] =  Math.max(profitLeft, profitRight);

        return profitMemory[index][capacity];
    }

    public static void main(String[] args) {
        ZeroOneKnapsack ks = new ZeroOneKnapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
