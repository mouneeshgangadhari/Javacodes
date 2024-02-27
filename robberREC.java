/*
There are N houses built in a line, each of which contains some value in it.
A thief is going to steal the maximum value of these houses, but he can not 
steal in two adjacent houses because the owner of the stolen houses will 
tell his two neighbors left and right sides. 
The task is to find what is the maximum stolen value.

input format : integer number N
               N number of integers
output format : integer number

Examples: 
Input: 7
6 7 1 3 8 2 4
Output: 19
Explanation: The thief will steal 6, 1, 8 and 4 from the house.
Case 2:
Input: 5 
5 3 4 11 2
Output: 16
Explanation: Thief will steal 5 and 11

*/
import java.io.*;
import java.util.*;

class Solution
{
	// Function to calculate the maximum stolen value
	static int maxLoot(int hval[], int n)
	{	
		// base case
		if (n < 0) {
			return 0;
		}

		if (n == 0) {
			return hval[0];
		}
		
		// if current element is picked then previous cannot be picked
		int pick = hval[n] + maxLoot(hval, n - 2);
		
		// if current element is not picked then previous element is picked
		int notPick = maxLoot(hval, n - 1);

		// return max of picked and not picked
		return Math.max(pick, notPick);
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int m = sc.nextInt();
		int[] hval=new int[m];
		for (int i=0;i<m ;i++ )
		{
		  hval[i]=sc.nextInt();
		}
		
		int n = hval.length;
		System.out.println(maxLoot(hval, n-1));
	}
}

/*test cases

case=1
input=8
2 3 8 3 7 1 10 12
output=29

case=2
input=6
9 7 4 1 5 10
output=23

case=3
input=3
9 1 10
output=19

case=4
input=6
9 1 10 2 11 1
output=30

case=5
input= 8
1 10 1 11 1 14 1 16
output=51

*/



