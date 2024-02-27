/*
Bob Marley is a jamaican singer, he loves to travel around the globe.
He planned to travel N famous places and return to the starting station.
Each place is indicated with numbers from 0 to N-1.
He will start the travel from Place-0.
 
You are given an integer N and cost matrix cost[][],a symmetric matrix, 
where cost[i][j] indicates cost to travel from place-i to place-j and vice-versa, 
if cost[i][j]=0, indicates no way to travel from place-i to place-j and vice-versa. 

Your task is to help Bob Marley, to find the shortest possible travel plan
to visit every place and returns to starting place-0. 
Finally print the minimum cost to travel accordingly.

Input Format:
-------------
Line-1: An integer N. 
Next N lines: N space separated integers, cost of i to j.

Output Format:
--------------
Print an integer, the minimum cost to travel all the places and return to place-0.


Sample Input-1:
---------------
4
0 13 11 12
13 0 14 9
11 14 0 5
12 9 5 0

Sample Output-1:
----------------
38


Sample Input-2:
---------------
5
0 15 5 12 15
15 0 7 13 9
5 7 0 10 15
12 13 10 0 7
15 9 15 7 0

Sample Output-2:
----------------
40

******* Testcases *******
case =1
input =4
0 13 11 12
13 0 14 9
11 14 0 5
12 9 5 0
output =38

case =2
input =5
0 15 5 12 15
15 0 7 13 9
5 7 0 10 15
12 13 10 0 7
15 9 15 7 0
output =40

case =3
input =6
0 20 21 71 12 40
20 0 56 58 38 50
21 56 0 34 16 68
71 58 34 0 69 71
12 38 16 69 0 43
40 50 68 71 43 0
output =203

case =4
input =8
0 59 48 74 59 24 40 28
59 0 37 22 50 53 33 15
48 37 0 62 53 47 40 28
74 22 62 0 39 15 31 14
59 50 53 39 0 12 40 16
24 53 47 15 12 0 45 37
40 33 40 31 40 45 0 58
28 15 28 14 16 37 58 0
output =205

case =5
input =10
0 82 90 23 82 98 51 39 88 31
82 0 60 81 28 63 87 45 45 41
90 60 0 56 61 79 52 71 67 98
23 81 56 0 62 12 23 58 98 53
82 28 61 62 0 24 62 62 20 80
98 63 79 12 24 0 83 24 29 26
51 87 52 23 62 83 0 98 19 34
39 45 71 58 62 24 98 0 54 17
88 45 67 98 20 29 19 54 0 16
31 41 98 53 80 26 34 17 16 0
output =290

*/

import java.io.*;
import java.util.*;

/*
Time Complexity: O(N!), As for the first node there are N possibilities 
and for the second node there are n - 1 possibilities.
For N nodes time complexity = N * (N - 1) * . . . 1 = O(N!)

Auxiliary Space: O(N)
*/

public class TSP 
{	
	/*
	1) Consider city 1 (let say 0th node) as the starting and ending point.  
	Since route is cyclic, We can consider any point as starting point.
	2) Start traversing from the source to its adjacent nodes in dfs manner.
	3) Calculate cost of every traversal and keep track of minimum cost and keep on 
	updating the value of minimum cost stored value.
	4) Return the permutation with minimum cost.
	*/

	// Function to find the minimum weight Hamiltonian Cycle
    static int tsp(int[][] graph, boolean[] v, int currPos, int n, int count, int cost, int ans)
    { 
		System.out.println("currPos " + currPos + " n " + n + " count " + count + " cost " + cost + " ans " + ans);

        // If last node is reached and it has a link to the starting node 
		// i.e the source then keep the minimum value out of the total cost
        // of traversal and "ans"
        // Finally return to check for more possible values
        if (count == n && graph[currPos][0] > 0)
        {
            ans = Math.min(ans, cost + graph[currPos][0]);
			System.out.println("ans " + ans + " cost " + (cost + graph[currPos][0]));
            return ans;
        }
 
        // Backtracking 
        // Loop to traverse the adjacency list of currPos node and increasing the count
        // by 1 and cost by graph[currPos,i] value
        for (int i = 0; i < n; i++)
        {
            if (v[i] == false && graph[currPos][i] > 0)
            { 
                // Mark as visited
                v[i] = true;
                ans = tsp(graph, v, i, n, count + 1, cost + graph[currPos][i], ans);
 
                // Mark ith node as unvisited
                v[i] = false;
            }
        }
        return ans;
    }

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int[][] graph;
		graph = new int[n][n];
		for(int i=0 ; i < n;i++)
			for(int j=0; j < n;j++)
				graph[i][j] = sc.nextInt();

		// Boolean array to check if a node has been visited or not
        boolean[] v = new boolean[n];
 
        // Mark 0th node as visited
        v[0] = true;
        int ans = Integer.MAX_VALUE; 
		// Find the minimum weight Hamiltonian Cycle
        ans = tsp(graph, v, 0, n, 1, 0, ans);
		
		System.out.println(ans);
	}
}
