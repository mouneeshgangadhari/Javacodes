/*Given a list containing future price predictions of two different stocks for the next n days, find the maximum profit earned by selling the stocks with a constraint that the second stock can be sold, only if no transaction happened on the previous day for any of the stock.

Assume that the given prices are relative to the buying price. Each day, we can either sell a single share of the first stock or a single share of the second stock or sell nothing.
input format:an integer m
             m number of integers for x
			 m number of integers for y
output format : integer
example
sample case 1:
5
5 3 4 6 3
8 4 3 5 10
output = 25
explanation:
Day 1: Sell stock y at a price of 8
Day 2: Sell stock x at a price of 3
Day 3: Sell stock x at a price of 4
Day 4: Do not sell anything
Day 5: Sell stock y at a price of 10


*/
import java.util.*;
class Main
{
	// Function to find the maximum earnings that can be earned by selling the stocks.
	// Here, arrays x[0 to n-1] and y[0 to n-1] contains the two different stocks
	// future price predictions for the next n days.
	public static int findMaxProfit(int[] x, int[] y)
	{
		// base case
		if (x.length == 0) {
			return 0;
		}

		// create an auxiliary array `T[]` to save solutions to the subproblems.
		// Here, `T[i]` stores the maximum earnings till day `i`.
		int[] T = new int[x.length + 1];

		// Base cases
		T[0] = 0;
		T[1] = Integer.max(x[0], y[0]);

		// Fill the auxiliary array `T[]` in a bottom-up manner
		for (int i = 2; i <= x.length; i++) {
			T[i] = Integer.max(x[i - 1] + T[i - 1], y[i - 1] + T[i - 2]);
		}

		// `T[n]` stores the maximum earnings till day `n`
		return T[x.length];
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int m = sc.nextInt();
		int[] x = new int[m];
		int[] y = new int[m];
		for(int i=0;i<m;i++)
			x[i]=sc.nextInt();
		for(int i=0;i<m;i++)
			y[i]=sc.nextInt();
		System.out.println(findMaxProfit(x, y));
	}
}
/*
test cases
case =1
input= 5
1 2 3 4 5
6 7 8 9 10
output =24
case =2
input=6
10 20 30 40 50 60
1 2 3 4 5 6
output = 210
case =3
input =6
-1 -2 -3 -4 -5 -6
1 2 3 4 5 6
output =12
case =4
input=5
100 10 200 30 400
10 200 20 300 40
output=900
case =5
input =8
1 100 2 200 3 300 4 400
1 -100 2 -200 3 -300 4 -400
output =1010
*/