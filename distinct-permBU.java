/*
Given an array of distinct positive integers, find the total number of distinct permutations that add up to a given target, where each array element may be used any number of times.
input format: integer number m
              m number of integers
			  target value
output format : integer value
Example
Sample 1:
input = 4
1 2 3 4
3
output =4
Explanation: The permutations of [1, 2, 3, 4] with sum 3 are:
[1, 1, 1]
[1, 2]
[2, 1]
[3]
sample 2:
input = 3
1 3 5
5
output =5
Explanation: The permutations of [1, 3, 5] with sum 5 are:
[1, 1, 1, 1, 1]
[1, 1, 3]
[1, 3, 1]
[3, 1, 1]
[5]

*/
import java.util.*;
class Main
{
	public static int findPermutations(int[] nums, int target)
	{
		// create an array to store the solution of the subproblems
		int[] T = new int[target + 1];

		// there is only one way to reach the target of 0 - don't consider any element
		T[0] = 1;

		// fill T[] in bottom-up manner  
		for (int i = 1; i < T.length; i++)
		{
			for (int k : nums)
			{
				if (i - k >= 0) {
					T[i] += T[i - k];
				}
			}
		}

		System.out.println("T " + Arrays.toString(T));
		// last element of T[] stores the result
		return T[target];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int[] nums = new int[m];
		for(int i=0;i<m;i++)
			nums[i] = sc.nextInt();
		int target = sc.nextInt();
		System.out.println(findPermutations(nums, target));
	}
}
/*
Test Cases:
case =1
input =5
1 2 3 4 5
3
output =4
case =2
input =8
1 2 3 4 5 6 7 8
10
output=509
case =3
input=8
10 20 30 40 50 60 70 80
40
output=8
case =4
input=8
1 2 3 4 5 6 7 8
25
output=16190208
case =5
input=8
1 2 3 4 5 6 7 8
2
output=2

*/