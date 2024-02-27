/*
You are given N nodes of a Binary search tree.
To search a node in the binary serach tree, it will cost some freq.
You are given the N nodes as keys[] in sorted order, and the search costs of N nodes
 as freq[], where freq[i] is the cost to search keys[i] element in the BST.

The cost to search a BST node is the level of that node multiplied by its freq. The level of the root is 1.

Your task is to findout the minimum cost of a BST is defines as the total cost of all the BST nodes.
You can form the BST with any element as the root node.

Input Format:
------------------
Line-1: An integer N, number of nodes.
Line-2: N space separate integers, node vals[].
Line-3: N space separate integers, node cost[].

Output Format:
-------------------
Print an integer, minimum search cost of BST.


Sample Input-1:
--------------------
3
10 20 30
23 32 14

Sample Output-1:
----------------------
106

Explanation:
----------------
The BST is: 
		20
		/\
	  10  30

Sample Input-2:
--------------------
4
8 10 12 20
26 34 8 50

Sample Output-2:
----------------------
210

Explanation:
----------------
The BST is: 
		10
		/\
	  8  20
		/
	 12

=== testcases ===
case =1
input =3
10 20 30
23 32 14
output =106

case =2
input =4
8 10 12 20
26 34 8 50
output =210

case =3
input =5
1 12 23 24 35
52 11 79 3 71
output =367

case =4
input =6
10 20 30 40 50 60
19 53 68 14 53 14
output =421

case =5
input =7
12 15 17 22 34 36 38
40 52 53 97 33 23 92
output =855

case =6
input =15
12 13 15 16 18 28 34 36 38 41 43 48 49 50 52
64 66 30 65 72 44 21 40 53 6 48 86 17 96 11
output =2166

case =7
input =20
12 13 15 16 18 28 34 36 38 41 43 48 49 50 52 56 59 74 75 80
83 51 41 36 76 77 69 82 16 43 81 23 48 92 38 42 39 87 49 40
output =3766

case =8
input =20
12 13 15 16 18 28 34 36 38 41 43 48 49 50 52 56 59 74 75 80
42 86 40 46 67 25 81 12 78 26 79 21 75 29 9 53 69 2 17 6
output =2714

*/

import java.util.*;

/*

The optimal cost for freq[i..j] can be recursively calculated using the following formula. 
optcost(i, j) = sum{k=i to j} freq[k]+ min{r=i to j} optcost(i, r-1) + optcost(r+1, j)        
We need to calculate optCost(0, n-1) to find the result. 
The idea of above formula is simple, we one by one try all nodes as root (r varies from i to j in second term).
When we make rth node as root, we recursively calculate optimal cost from i to r-1 and r+1 to j. 
We add sum of frequencies from i to j (see first term in the above formula)

This can be divided into 2 parts one is the freq[r]+sum of frequencies of all elements 
from i to j except r. 
The term freq[r] is added because it is going to be root and that means level of 1, 
so freq[r]*1=freq[r]. Now the actual part comes, we are adding the frequencies of 
remaining elements because as we take r as root then all the elements other than 
that are going 1 level down than that is calculated in the subproblem. 

For calculating optcost(i,j) we assume that the r is taken as root and 
calculate min of opt(i,r-1)+opt(r+1,j) for all i<=r<=j. 

Here for every subproblem we are  choosing one node as a root. 
But in reality the level of subproblem root and all its descendant nodes 
will be 1 greater than the level of the parent problem root. 

Therefore the frequency of all the nodes except r should be added 
which accounts to the descend in their level compared to level assumed in subproblem.

Time Complexity: Exponential

*/

// A naive recursive implementation of optimal binary search tree problem
public class OBSTRecursive
{
	// A recursive function to calculate cost of optimal binary search tree
	static int optCost(int freq[], int i, int j)
	{
		System.out.println("optCost " + i + " " + j);
		// Base cases
		if (j < i)	 // no elements in this subarray
			return 0;
		if (j == i)	 // one element in this subarray
			return freq[i];
		
		// Get sum of freq[i], freq[i+1], ... freq[j]
		int sum = fsum(freq, i, j);

		// Initialize minimum value
		int min = Integer.MAX_VALUE;
		
		for (int r = i; r <= j; ++r)
		{
			min = Math.min(optCost(freq, i, r-1) + optCost(freq, r+1, j), min);
		}
		
		System.out.println("min cost " + (min + sum));
		// Return minimum value
		return min + sum;
	}
	
	static int optimalSearchTree(int keys[], int freq[], int n)
	{
		return optCost(freq, 0, n-1);
	}
	
	// A utility function to get sum of array elements freq[i] to freq[j]
	static int fsum(int freq[], int i, int j)
	{
		int s = 0;
		for (int k = i; k <=j; k++)
			s += freq[k];

		System.out.println("fsum " + i + " " + j + " " + s);
		return s;
	}
	
	public static void main(String[] args) 
	{
		/*
		4
		5 10 20 25
		3 4 2 6
		*/

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int keys[] = new int[n];
		int freq[] = new int[n];
		for(int i = 0; i < n; i++)
			keys[i] = sc.nextInt();

		for(int i = 0; i < n; i++)
			freq[i] = sc.nextInt();

		System.out.println("Cost of Optimal BST is " + optimalSearchTree(keys, freq, n));
	}
}
