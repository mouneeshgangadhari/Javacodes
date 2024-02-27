import java.util.*;
public class DFSgraph {
    public static int V;
    public static LinkedList<Integer>[] adj;
    DFSgraph(int V)
    {
        this.V=V;
        adj=new LinkedList[V];
        Arrays.fill(adj,new LinkedList<>());
    }
    public static void print()
    {
        for(int i=0;i<V;i++)
        {
            System.out.println(adj[i]);
            System.out.println();
        }
    }
    public static void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
    public static void DFS(int s)
    {
        boolean[] vis=new boolean[V];
        help(s,vis);
    }
    public static void help(int s,boolean[] v)
    {
        v[s]=true;
        System.out.print(s+"  ");
        Iterator<Integer> itr=adj[s].listIterator();
        while(itr.hasNext())
        {
            int n=itr.next();
            if(!v[n])
            {
                System.out.println("node"+n);
                System.out.println("");
                help(n,v);
            }
        }
    }
    public static void main(String v[])
    {
        Scanner sc=new Scanner(System.in);
        V=sc.nextInt();
        DFSgraph obj=new DFSgraph(V);
        // adj=new LinkedList[V];
        // for(int i=0;i<V;i++)
        // {
        //     LinkedList<Integer>
        // }
        int E=sc.nextInt();
        for(int i=0;i<E;i++)
        {
            addEdge(sc.nextInt(),sc.nextInt());
        }
        print();
        // DFS(sc.nextInt());
    }
}
