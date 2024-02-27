/*
You are given N nodes of a Binary search tree.
To serach a node in the binary serach tree, it will cost some freq.
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
We use an auxiliary array cost[n][n] to store the solutions of subproblems. 
cost[0][n-1] will hold the final result. All diagonal values must be filled first,
then the values which lie on the line just above the diagonal. 
In other words, we must first fill all cost[i][i] values, 
then all cost[i][i+1] values, then all cost[i][i+2] values.

Time complexity: n^3
Space complexity: n^2
*/

class OBSTDP 
{
    /* A Dynamic Programming based function that calculates
        minimum cost of a Binary Search Tree.  */
    int minSearchCostBST(int keys[], int freq[], int n) 
	{ 
        /* Create an auxiliary 2D matrix to store results of subproblems */
        int dp[][] = new int[n][n];
 
        /* dp[i][j] = Optimal cost of binary search tree that
           can be formed from keys[i] to keys[j]. dp[0][n-1]
           will store the resultant cost */
 
        // For a single key, dp is equal to freq/frequency of the key
        for (int i = 0; i < n; i++)
            dp[i][i] = freq[i];
 
        // Now we need to consider chains of length 2, 3, ...
        // len is chain length.
        for (int len = 2; len <= n; len++) 
		{ 
            // i is row number in cost[][]
            for (int i = 0; i <= n - len; i++) 
			{ 
                // Get column number j from row number i and chain length len
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
				int sum = fsum(freq, i, j);
 
                // Try making all keys in interval keys[i..j] as root
                for (int r = i; r <= j; r++) 
				{ 
					// Formula to calculate the mimimum cost where r is root considered
					// c[i,j] = min{c[i, r-1] + c[r+1,j]} + w(i,j) where i << r < j

					int c = sum;
					if(r > i) c += dp[i][r-1];
					if(r < j) c += dp[r+1][j];
					System.out.println("i " + i + " j " + j + " r " + r + " c " + c);
					if(c < dp[i][j]) 
						dp[i][j]=c;
                }
				System.out.println(Arrays.deepToString(dp));
            }
        }
        return dp[0][n - 1];
    }
 
    // A utility function to get sum of array elements freq[i] to freq[j]
    int fsum(int freq[], int i, int j) 
	{
        int s = 0;
        for (int k = i; k <= j; k++) 
		{
            if (k >= freq.length)
                continue;
            s += freq[k];
        }
		System.out.println("fsum " + " i "+ i + " j " + j + " sum " + s);
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

		System.out.println(new OBSTDP().minSearchCostBST(keys, freq, n));
	}
}
