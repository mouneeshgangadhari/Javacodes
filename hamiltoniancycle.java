/*
N cities are connected through roads, the cities are numbered from 0 to N-1. 
The roadmaps are given as a grid of size N*N, roadmap[][], 
the grid contains 0 and 1 as values grid[i][j]=0, indicates no road 
between i to j cities, grid[i][j]=1, indicates a road between i and j cities.

You are given an integer N, and the roadmap[][]of size N*N.
Your task is to find that there exists a loop in the roadmap, such that 
there exists a route consists of all the cities eaxctly once and the 
last city in the route should be connected to first city of the same route directly.

If you found such route print the route, otherwise print "No Solution"

Input Format:
-------------
Line-1: An integer N, size of the chess board.
Next N lines: N space separated integers, 0 or 1.

Output Format:
--------------
Print any possible route or "No Solution".

Sample Input-1:
---------------
5
0 1 0 1 0
1 0 1 1 1
0 1 0 0 1
1 1 0 0 1
0 1 1 1 0

Sample Output-1:
----------------
0  1  2  4  3  0

Sample Input-2:
---------------
5
0 1 0 1 0
1 0 1 1 1
0 1 0 0 1
1 1 0 0 0
0 1 1 0 0

Sample Output-2:
----------------
No Solution

*/
import java.util.*;

class hamiltoniancycle
{
	static int V;
	int path[];

	/* A utility function to check if the vertex v can be added at index 'pos'
	in the Hamiltonian Cycle constructed so far (stored in 'path[]') */
	boolean isSafe(int v, int graph[][], int path[], int pos)
	{
		if(graph[path[pos - 1]][v] == 0)
		{
            return false;
		}
        for(int i = 0; i < pos; i++) 
        {
            if(path[i] == v)
            {
                return false;
            }
        }
        return true;
	}

	// A recursive utility function to solve hamiltonian cycle problem 
	boolean hamCycleUtil(int graph[][], int path[], int pos)
	{
	    if(pos==V)
	    {
            return graph[path[pos - 1]][path[0]] == 1;
	    }

        for(int v = 1; v < V; v++) 
        {
            if(isSafe(v, graph, path, pos)) 
            {
                path[pos]=v;

                if(hamCycleUtil(graph, path, pos + 1))
                {
                    return true;
                }

                path[pos]=-1;
            }
        }
        return false;
	}

	int hamCycle(int graph[][])
	{
		path = new int[V];
		for (int i = 0; i < V; i++)
			path[i] = -1;
			
		path[0] = 0;
		if (hamCycleUtil(graph, path, 1) == false)
		{
			System.out.println("No Solution");
			return 0;
		}
		
		printSolution(path);
		return 1;
	}

	/* A utility function to print solution */
	void printSolution(int path[])
	{
		for (int i = 0; i < V; i++)
			System.out.print(path[i] + " ");
		System.out.println(path[0]);
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		V = sc.nextInt();
		int graph[][]=new int[V][V];

		for(int i=0;i<V;i++)
			for(int j=0;j<V;j++)
				graph[i][j]=sc.nextInt();

		hamiltoniancycle obj = new hamiltoniancycle();
		obj.hamCycle(graph);
	}
}
