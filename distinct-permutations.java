/*
Given an array of distinct positive integers, find the total number of
distinct permutations that add up to a given target, where each array element may be used any number of times.
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
class distinctpermutations
{
	public static int findPermutations(int[] nums, int target)
	{
		System.out.println("target " + target);
		// if target is reached, return 1
		if (target == 0) {
			return 1;
		}

		// initialize the result with 0
		int count = 0;

		// do for each number
		for (int i : nums)
		{
			// recur to see if target can be reached by including the current number `i`
			if(target - i >= 0)
				count += findPermutations(nums, target - i);
		}

		// return the total number of permutations
		return count;
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