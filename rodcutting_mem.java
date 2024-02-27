/*
Given a rod of length n and a list of rod prices of length i, where 1 <= i <= n, find the optimal way to cut the rod into smaller rods to maximize profit.

For example, consider the following rod lengths and values:
sample case =1
Input:
length = 4
price=1 5 8 9












output=10
 

Best: Cut the rod into two pieces of length 2 each to gain revenue of 
5 + 5 = 10
 
Cut           Profit
4                9
1, 3            (1 + 8) = 9
2, 2            (5 + 5) = 10
3, 1            (8 + 1) = 9
1, 1, 2         (1 + 1 + 5) = 7
1, 2, 1         (1 + 5 + 1) = 7
2, 1, 1         (5 + 1 + 1) = 7
1, 1, 1, 1      (1 + 1 + 1 + 1) = 4
Sample cases :
case =2
input =6
1 5 4 9 10 6















output=15
explanation - 2+2+2 -> profit 5+5+5=15
*/

import java.util.Arrays;
import java.util.Scanner;
class Main {
    // Function to find the best way to cut a rod of length `n`
    // where the rod of length `i` has a cost `price[i-1]`
    public static int rodCut(int[] price, int n) {
        // Create a memoization table to store computed results
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        // Call the helper function with memoization
        return rodCutMemo(price, n, memo);
    }
    // Helper function for memoization
    private static int rodCutMemo(int[] price, int n, int[] memo) {
        // Base case: if the rod length is 0, the profit is 0
        if (n == 0) {
            return 0;
        }
        // Check if the result for the current rod length is already computed
        if (memo[n] != -1) {
            return memo[n];
        }
        // Initialize the maximum profit for the current rod length
        int maxProfit = Integer.MIN_VALUE;
        // Iterate through all possible cuts of the rod
        for (int i = 1; i <= n; i++) {
            // Update the maximum profit by considering the current cut
            maxProfit = Integer.max(maxProfit, price[i - 1] + rodCutMemo(price, n - i, memo));
        }

        // Cache the result for the current rod length
        memo[n] = maxProfit;

        // Return the maximum profit for the current rod length
        return maxProfit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // System.out.print("Enter the rod length: ");
        int n = sc.nextInt();
        int[] price = new int[n];
        //System.out.println("Enter the prices for each rod piece:");
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        System.out.println(rodCut(price, n));
    }
}
/*
case =1
input = 4
1 5 8 9
output=10
case =2
input=6
1 5 4 9 10 6
output=15
case =3
input=8
1 10 2 3 8 6 7 5
output=40
case =4
input=10
1 2 3 4 5 6 7 8 9 10
output=10
case =5
input=10
10 1 9 2 8 3 7 4 6 5
output=100
case =6
input=20
2 1 9 2 8 3 7 4 6 5 1 2 3 4 5 6 7 8 9 10
output=58
*/