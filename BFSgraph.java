//implementation of BFS using graph
import java.util.*;
public class BFSgraph {
    public static int V;
    public static LinkedList<Integer>[] adj;
    BFSgraph(int V)
    {
        this.V=V;
        adj=new LinkedList[V];
        for(int i=0;i<V;i++)
        {
            adj[i]=new LinkedList<>();
        }
    }
    public static void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
    public static void bfs(int s)
    {
        boolean[] vis=new boolean[V];
        Arrays.fill(vis, false);
        Queue<Integer> q=new LinkedList<>();
        vis[s]=true;
        q.add(s);
        while(!q.isEmpty())
        {
            s=q.poll();
            System.out.print(s+" ");
            Iterator<Integer> itr=adj[s].listIterator();
            while(itr.hasNext())
            {
                int n=itr.next();
                if(!vis[n])
                {
                    vis[n]=true;
                    q.add(n);
                }
            }
        }
    }
    public static void main(String v[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        V = sc.nextInt();
        BFSgraph obj = new BFSgraph(V);
        System.out.println("Enter the number of edges:");
        int E = sc.nextInt();
        System.out.println("Enter the edges (vertex pairs):");
        for (int i = 0; i < E; i++) {
            addEdge(sc.nextInt(), sc.nextInt());
        }
        System.out.println("Start vertex for BFS:");
        bfs(sc.nextInt());
    }
}
