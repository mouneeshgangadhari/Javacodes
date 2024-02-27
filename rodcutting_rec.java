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
import java.util.*;
class Main
{
	// Function to find the best way to cut a rod of length `n`
	// where the rod of length `i` has a cost `price[i-1]`
	public static int rodCut(int[] price, int n)
	{
		// base case
		if (n == 0) {
			return 0;
		}

		int maxValue = Integer.MIN_VALUE;

		// one by one, partition the given rod of length `n` into two parts of
		// length (1, n-1), (2, n-2), (3, n-3), … ,(n-1, 1), (n, 0) and
		// take maximum
		for (int i = 1; i <= n; i++)
		{
			// rod of length `i` has a cost `price[i-1]`
			int cost = price[i - 1] + rodCut(price, n - i);

			if (cost > maxValue) {
				maxValue = cost;
			}
		}

		return maxValue;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
        //System.out.print("Enter the rod length: ");
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