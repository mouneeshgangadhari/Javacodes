//graph creation using Adjacent matrix
import java.util.*;
public class graph {
    static int V;
    static LinkedList<Integer>[] adjList;
    graph(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    public static void addEdge(int src, int des) {
        adjList[src].add(des);
        adjList[des].add(src);
    }
    public static void print() {
        for (int v = 0; v < V; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (int x : adjList[v]) {
                System.out.print("  " + x);
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        V = sc.nextInt();
        graph g = new graph(V);
        System.out.println("Enter edges (src des): ");
        for (int i = 0; i < V; i++) {
            addEdge(sc.nextInt(), sc.nextInt());
        }
        print();
    }
}
