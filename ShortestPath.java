/*Example 1:
input=5 
0 6 5 0 13
6 0 12 9 5
5 12 0 0 0
0 9 0 0 7
13 5 0 7 0
2
output=
Vertex           Distance from Source
0                5
1                11
2                0
3                20
4                16

Example 2:
input =9 
0 4 0 0 0 0 0 8 0
4 0 8 0 0 0 0 11 0
0 8 0 7 0 4 0 0 2
0 0 7 0 9 14 0 0 0
0 0 0 9 0 10 0 0 0
0 0 4 14 10 0 2 0 0
0 0 0 0 0 2 0 1 6
8 11 0 0 0 0 1 0 7
0 0 2 0 0 0 6 7 0
5
Vertex           Distance from Source
0                11
1                12
2                4
3                11
4                10
5                0
6                2
7                3
8                6
*/


// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.util.*;
class Test
{
    static int V;
    public static int  helper(int a[] ,Boolean vis[])
    {
        int min=Integer.MAX_VALUE,idx=-1;
        for(int i=0;i<V;i++)
        {
            if(vis[i]==false&&a[i]<=min)
            {
                min=a[i];
                idx=i;
            }
        }
        return idx;
    }
    public static int[] help(int a[][],int src)
    {
        int dis[]=new int[V];
        Boolean vis[]=new Boolean[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        Arrays.fill(vis,false);
        dis[src]=0;
        for(int i=0;i<V-1;i++)
        {
            int u=helper(dis,vis);
            vis[u]=true;
            for(int j=0;j<V;j++)
            {
                if(!vis[j]&&a[u][j]!=0&&dis[u]!=Integer.MAX_VALUE&&dis[u]+a[u][j]<dis[j])
                {
                    dis[j]=dis[u]+a[u][j];
                }
            }
        }
        return dis;
    }
    public static void main(String v[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] a=new int[n][n];
        V=n;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
        int src=sc.nextInt();
        int[] res=help(a,src);
        for(int i=0;i<res.length;i++)
        {
            System.out.println(i+"-"+res[i]);
        }
        
    }
}