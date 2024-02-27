/*
Given r red, b blue, and g green balls, find the total number of arrangements
in a row such that no two balls of the same color end up together.

input format : three integers (first integer is for r second is b and last is for g)
output format : integer number

Input: 1 2 1
Output: 6
The arrangements are [bgbr, bgrb, brbg, brgb, gbrb, rbgb]
Input:  2 3 1
 
Output:10
 
The arrangements are [bgbrbr, bgrbrb, brbgbr, brbgrb, brbrbg, brbrgb, brgbrb, gbrbrb, rbgbrb, rbrbgb]
*/























import java.util.*;
class Main
{
	// Function to find the total number of arrangements of `r` red, `b` blue, and
	// `g` green balls such that no two balls of the same color are together
	public static int f(int r, int b, int g, char prev)
	{
		System.out.println("r " + r + " b " + b + " g " + g + " prev " + prev);
		// base case: invalid number of balls
		if (r < 0 || b < 0 || g < 0) {
			return 0;
		}
		// base case: all balls are exhausted
		if (r == 0 && b == 0 && g == 0) {
			return 1;
		}

		// if the last ball was red
		if (prev == 'r')
		{
			// current ball can be either blue or green recur with one less ball			
			return f(r, b - 1, g, 'b') + f(r, b, g - 1, 'g');
		}
		else if (prev == 'b')	// if the last ball was blue
		{
			// current ball can be either red or green recur with one less ball
			return f(r - 1, b, g, 'r') + f(r, b, g - 1, 'g');
		}
		else if (prev == 'g')	// if the last ball was green
		{
			// current ball can be either red or blue recur with one less ball
			return f(r - 1, b, g, 'r') + f(r, b - 1, g, 'b');
		}
		return 0;
	}

	// Wrapper over method `f()`
	public static int totalWays(int r, int b, int g)
	{
		/*
		Recursively call `f()` for the following cases and return their total:

			1. Start with the red ball and recur with one less red ball
			2. Start with the blue ball and recur with one less blue ball
			3. Start with the green ball and recur with one less green ball
		*/
		return f(r - 1, b, g, 'r') +
				f(r, b - 1, g, 'b') +
				f(r, b, g - 1, 'g');
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int r = sc.nextInt();
		int b = sc.nextInt();
		int g = sc.nextInt();
		System.out.println(totalWays(r, b, g));
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
