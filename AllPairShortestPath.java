/*
Mr Abdul planned to visit all the tourist paths in a city.
There are P number of tourist places connected using some routes 
in a city, the routes are one-directional.

Your task is to help Mr Abdul, to find the shortest routes between every pair 
of tourist-places in the city.

Input Format:
------------------
Line-1: An integer P, number of places.
Next P lines: P space separated integers, the routes[][].

Value 99 represents infinity (Large value)

Output Format:
--------------------
Print the shortest distance routes[][].

Sample Input-1:
--------------------
4
0 5 99 10
99 0 3 99
99 99 0 1
99 99 99 0

Sample Output-1:
----------------------
0 5 8 9
INF 0 3 4
INF INF 0 1
INF INF INF 0


Sample Input-2:
--------------------
5
0 4 5 6 99
99 0 5 99 10
1 99 0 3 99
2 99 99 0 1
1 99 99 99 0

Sample Output-2:
----------------------
0 4 5 6 7
6 0 5 8 9
1 5 0 3 4
2 6 7 0 1
1 5 6 7 0


=== testcases ===
case =1
input =4
0 5 99 10
99 0 3 99
99 99 0 1
99 99 99 0
output ='0 5 8 9
INF 0 3 4
INF INF 0 1
INF INF INF 0'

case =2
input =5
0 4 5 6 99
99 0 5 99 10
1 99 0 3 99
2 99 99 0 1
1 99 99 99 0
output ='0 4 5 6 7
6 0 5 8 9
1 5 0 3 4
2 6 7 0 1
1 5 6 7 0'

case =3
input =6
0 4 2 4 4 3
99 0 6 1 2 5
99 99 0 1 4 5
99 99 99 0 2 4
99 99 99 7 0 9
99 99 99 5 4 0
output ='0 4 2 3 4 3
INF 0 6 1 2 5
INF INF 0 1 3 5
INF INF INF 0 2 4
INF INF INF 7 0 9
INF INF INF 5 4 0'

case =4
input =7
0 9 9 2 9 5 5
99 0 7 3 1 7 4
4 99 0 1 4 4 8
99 99 99 0 5 8 9
99 99 99 99 0 5 2
99 99 99 99 2 0 4
99 99 6 99 99 99 0
output ='0 9 9 2 7 5 5
11 0 7 3 1 6 3
4 13 0 1 4 4 6
17 26 13 0 5 8 7
12 21 8 9 0 5 2
14 23 10 11 2 0 4
10 19 6 7 10 10 0'

case =5
input =8
0 8 2 8 3 3 5 9
99 0 9 3 5 2 1 2
99 99 0 5 8 9 4 5
6 99 99 0 2 2 4 2
2 99 99 99 0 9 9 6
99 99 99 99 99 0 1 3
99 99 99 99 99 99 0 4
99 99 99 99 99 99 99 0
output ='0 8 2 7 3 3 4 6
7 0 9 3 5 2 1 2
9 17 0 5 7 7 4 5
4 12 6 0 2 2 3 2
2 10 4 9 0 5 6 6
INF INF INF INF INF 0 1 3
INF INF INF INF INF INF 0 4
INF INF INF INF INF INF INF 0'

case =6
input =8
0 9 7 8 8 9 8 8
99 0 5 1 6 5 1 6
99 99 0 9 7 1 6 2
99 99 99 0 7 2 3 4
4 99 99 99 0 1 7 9
99 99 99 99 7 0 1 2
99 99 9 99 99 99 0 6
99 99 99 99 99 99 99 0
output ='0 9 7 8 8 8 8 8
10 0 5 1 6 3 1 5
11 20 0 9 7 1 2 2
11 20 12 0 7 2 3 4
4 13 11 12 0 1 2 3
11 20 10 19 7 0 1 2
20 29 9 18 16 10 0 6
INF INF INF INF INF INF INF 0'

*/


/*

Input:
4
0 3 99 7
8 0 2 99
5 99 0 1
2 99 99 0

Output:
0 3 5 6
5 0 2 3
3 6 0 1
2 5 7 0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class AllPairShortestPath
{
	static int V;

	/*
	Time Complexity: O(V^3)
	Auxiliary Space: O(V^2)

	Ideally you should take INF as INT_MAX. In that case modify the below code to

	if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j])
	{
		dist[i][j] = dist[i][k] + dist[k][j];
	}

	https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/

	*/
	void floydWarshall(int graph[][])
	{
		int dist[][] = new int[V][V];
		int i, j, k;

		for (i = 0; i < V; i++)
			for (j = 0; j < V; j++)
				dist[i][j] = graph[i][j];

		for (k = 0; k < V; k++)	// Intermediate vertices
		{
			// Pick all vertices as source one by one
			for (i = 0; i < V; i++)
			{
				// Pick all vertices as destination for the above picked source
				for (j = 0; j < V; j++)
				{
					// If vertex k is on the shortest path from i to j, then update the value of dist[i][j]
					if (dist[i][j] > dist[i][k] + dist[k][j])
					{
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		printSolution(dist);
	}

	void printSolution(int dist[][])
	{
		for (int i=0; i<V; ++i)
		{
			for (int j=0; j<V; ++j)
			{
				if (dist[i][j]==99)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int graph[][] = new int[V][V];
		for(int i = 0; i < V; i++)
			for(int j = 0;j < V; j++)
				graph[i][j] = sc.nextInt();
		
		AllPairShortestPath a = new AllPairShortestPath();

		a.floydWarshall(graph);
	}
}