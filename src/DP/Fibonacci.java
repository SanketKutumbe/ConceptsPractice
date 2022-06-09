package DP;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(printFibonacci(8));
    }

    private static int printFibonacci(int i) {
        int[] memo = new int[i+1];
        return fibonacci(i, memo);
    }

    private static int fibonacci(int i, int[] memo) {

        if( i < 2 )
            return i;

        if( memo[i] != 0 )
            return memo[i];

        memo[i] = fibonacci(i-1, memo) + fibonacci( i-2, memo);

        return memo[i];
    }
}
