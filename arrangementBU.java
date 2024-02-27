/*
Given r red, b blue, and g green balls, find the total number of arrangements in a row such that 
no two balls of the same color end up together.
input format : three integers (first integer is for r second is b and last is for g)
output format : integer number

Input:1  2 1
Output: Total number of arrangements are 6
The arrangements are [bgbr, bgrb, brbg, brgb, gbrb, rbgb]
Input:  2 3 1
 
Output: Total number of arrangements are 10
 
The arrangements are [bgbrbr, bgrbrb, brbgbr, brbgrb, brbrbg, brbrgb, brgbrb, gbrbrb, rbgbrb, rbrbgb]


Note : The following is the approach for this solution
The idea is to use Dynamic Programming. 
We will create a 4D lookup table, DP, to store the solutions to the subproblems where DP[i][j][k][l] 
denotes the number of ways to arrange the 'i' balls of type A,'j' balls of type B and 'k' balls of 
type C in the required fashion when the next ball we need to add in the line will be known
from the value of 'l', that is when 'l' is 0, we need to place a ball of type 'A' 
and when 'l' is 1, we need to place a ball of type B and when 'l' is 2, we need to place a ball of type C.

Note that 'l' can only attain three values, 0, 1, and 2.
Algorithm
Initialize the table to 0.
The detailed algorithm to fill the DP table will be as follows:
Loop 1: For i = 0 to a+1:
Loop 2: For j = 0 to b+1:
Loop 3: For k = 0 to c+1:
Loop 4: For l = 0 to 3:
if the 'l' is 0, means we have to add a ball of type A.
If i is 1 and j and k are 0, update DP[i][j][k][l] =1 as we have found an  arrangement.
Else if i >0, update DP[i][j][k][l] += DP[i-1][j][k][1] + DP[i-1][j][k][2];
If the 'l' is 1, means we have to add a ball of type B.
If j is 1 and i and k are 0, update DP[i][j][k][l] =1 as we have found an  arrangement.
Else if j > 0, update DP[i][j][k][l] += DP[i][j-1][k][0] + DP[i][j-1][k][2];
If the 'l' is 2, means we have to add a ball of type C.
If k is 1 and i and j are 0, update DP[i][j][k][l] =1 as we have found an  arrangement.
Else if k > 0, update DP[i][j][k][l] += DP[i][j][k-1[0] + DP[i][j][k-1][1];
Return (DP[a][b][c][0] + DP[a][b][c][1] + DP[a][b][c][2]) as it is the total no. of ways 
to arrange the balls in the required manner.

Time Complexity
O(a*b*c), where 'a', 'b', 'c' are the number of balls of type 'A', 'B' and 'C' respectively. 
As we are using 4 nested loops of size 'a', 'b', 'c' and 3.  Asymptotically, the time complexity is O(a*b*c).

Space Complexity
O(a*b*c), where a, b, c denoting the number of balls of type 'A', 'B' and 'C' respectively.
As we are using a lookup table, DP, of size a*b*c*3, the space complexity is O(a*b*c).
*/

import java.util.*;
class Solution
{
public static long totalWays(int red, int green, int blue)
    {
        long[][][][] dp = new long[red + 1][green + 1][blue + 1][3];
        for (int r = 0; r <= red; r++)
        {
            for (int g = 0; g <= green; g++)
            {
                for (int b = 0; b <= blue;b++)
                {
                    for (int l = 0; l < 3; l++)
                    {
						if (l == 0)
                        {
                            if (r == 1 && g == 0 && b == 0)
                            {
                                dp[r][g][b][l] = 1;
                            }
                            else if (r > 0)
                            {
                                dp[r][g][b][l] += dp[r - 1][g][b][1] + dp[r - 1][g][b][2];
                            }
                        }                        
                        else if (l == 1)
                        {
                            if (r == 0 && g == 1 && b == 0)
                            {
                                dp[r][g][b][l] = 1;
                            }
                            else if (g > 0)
                            {
                                dp[r][g][b][l] += dp[r][g - 1][b][0] + dp[r][g - 1][b][2];
                            }
                        }                        
                        else if (l == 2)
                        {
                            if (r == 0 && g == 0 && b == 1)
                            {
                                dp[r][g][b][l] = 1;
                            }
                            else if (b > 0)
                            {
                                dp[r][g][b][l] += dp[r][g][b - 1][0] + dp[r][g][b - 1][1];
                            }
                        }
                    }
                }
            }
        }        
        return dp[red][green][blue][0] + dp[red][green][blue][1] + dp[red][green][blue][2];
    }

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int r = sc.nextInt();
		int b = sc.nextInt();
		int g = sc.nextInt();
        System.out.println(new Solution().totalWays(r, g, b));
	}
}

