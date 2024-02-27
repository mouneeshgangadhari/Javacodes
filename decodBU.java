/*
Given a positive number, map its digits to the corresponding alphabet in the mapping table [(1, 'A'), (2, 'B'),(26, 'Z')], and return the count of the total number of decodings possible. Assume that the input number can be split into valid single-digit or two-digit numbers that are present in the mapping table.
A single-digit between 1 to 9 can be mapped to a corresponding alphabet between A to I.
Two digits between 10 to 26 can be mapped to a corresponding alphabet between J to Z.
input format: an intger number 
output format : an integer number
Example
Input:  123
Output: 3
Explanation : with 123 combination we can form [ABC(123), AW(A=1,W=23), LC(L=12 and C=3)]
Input:  1221
Output: 5
Explanation :with 1221 combination we can form [ABBA, ABU, AVA, LBA, LU]
*/
import java.util.*;
class Main
{
	// Function to count the total decodings of a given sequence of digits
	public static int count(int x)
	{
		// convert `x` to a string
		String seq = String.valueOf(x);

		// create an auxiliary array to store results to the subproblems
		int[] T = new int[seq.length() + 1];

		// base case
		T[0] = 1;
		T[1] = 1;

		// fill the auxiliary array `T[]` in a bottom-up manner
		for (int i = 2; i <= seq.length(); i++)
		{
			// consider single-digit numbers (1, 2, upto  9)
			if (seq.charAt(i - 1) > '0') 
			{
				T[i] = T[i - 1];
			}

			// consider 2-digit numbers (10, 11, upto 26)
			if (seq.charAt(i - 2) == '1' || (seq.charAt(i - 2) == '2' && seq.charAt(i - 1) <= '6')) 
			{
				T[i] += T[i - 2];
			}
		}

		// last element in the auxiliary array stores the result
		return T[seq.length()];
	}

	public static void main(String[] args)
	{
	    Scanner sc=new Scanner(System.in);	
		int x = sc.nextInt();
		System.out.println(count(x));
	}
}
/*
Test cases 
case =1
input =1234
output =3
case =2
input=123321
output=6
case =3
input =222120
output=5
case =4
input=112233
output=8
case =5
input=88888
outpu=1
case =6
input=898989
output=1

*/