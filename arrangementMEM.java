/*Given r red, b blue, and g green balls, find the total number of arrangements in a row such that no two balls of the same color end up together.
input format : three integers (first integer is for r second is b and last is for g)
output format : integer number

Input:1  2 1
Output:6
The arrangements are [bgbr, bgrb, brbg, brgb, gbrb, rbgb]

Input:  2 3 1
 
Output:10
 
The arrangements are [bgbrbr, bgrbrb, brbgbr, brbgrb, brbrbg, brbrgb, brgbrb, gbrbrb, rbgbrb, rbrbgb]
*/
import java.util.*;
class Main
{
	static final int MAX = 100;
	static int dp[][][][] = new int[MAX][MAX][MAX][3];

	static int countWays(int r, int g, int b, int last)
	{
		if (r < 0 || g < 0 || b < 0)
	    	return 0;
		else if (r == 1 && g == 0 && b == 0 && last == 0)
			return 1;
		else if (r == 0 && g == 1 && b == 0 && last == 1)
			return 1;
		else if (r == 0 && g == 0 && b == 1 && last == 2)
			return 1;

		else if (dp[r][g][b][last] != -1)
			return dp[r][g][b][last];

		if (last == 0)
			dp[r][g][b][last] = countWays(r - 1, g, b, 1) +	countWays(r - 1, g, b, 2);
		else if (last == 1)
			dp[r][g][b][last] = countWays(r, g - 1, b, 0) +	countWays(r, g - 1, b, 2);
		else
			dp[r][g][b][last] = countWays(r, g, b - 1, 0) +	countWays(r, g, b - 1, 1);

		return dp[r][g][b][last];
	}

	static int countUtil(int r, int g, int b)
	{
		for (int[][][] row : dp)
		{
			for (int[][] innerRow : row)
			{
				for (int[] innerInnerRow : innerRow)
				{
					Arrays.fill(innerInnerRow, -1);
				}
			}
		};	
		
		return countWays(r, g, b, 0) + // Last required balls is type red
			countWays(r, g, b, 1) + // Last required balls is type green
			countWays(r, g, b, 2);	 // Last required balls is type blue
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int r = sc.nextInt();
		int b = sc.nextInt();
		int g = sc.nextInt();
		System.out.println(countUtil(r, g, b));
	}
}

/*testcases
case=1
input=2 1 2
output=12

case=2
input=6 7 8
output=232610

case3
input=1 1 1
output=6

case=4
input=3 3 3
output=174

case=5
input=1 2 1
output=6
*/
