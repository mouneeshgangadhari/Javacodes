/*
5 7
0 1 2
0 2 4
1 2 1
1 3 7
2 3 3
2 4 5
3 4 6
output:
Minimum Spanning Tree:
Edge: 0 - 1 Weight: 2
Edge: 1 - 2 Weight: 1
Edge: 2 - 3 Weight: 3
Edge: 2 - 4 Weight: 5

 */
import java.util.*;

class SpanningTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int arr[][] = new int[E][3];
        for (int i = 0; i < E; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        spanningTree(V, E, arr);
    }

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void spanningTree(int V, int E, int edges[][]) {
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int arr[] : edges) {
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];
            graph[u].add(new Edge(u, v, wt));
            graph[v].add(new Edge(v, u, wt));
        }

        boolean[] visited = new boolean[V];
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.wt));
        
        // Start with the first vertex (vertex 0)
        visited[0] = true;
        for (Edge e : graph[0]) {
            minHeap.offer(e);
        }

        System.out.println("Minimum Spanning Tree:");

        while (!minHeap.isEmpty()) {
            Edge currentEdge = minHeap.poll();

            if (visited[currentEdge.dest]) {
                continue;
            }

            visited[currentEdge.dest] = true;
            System.out.println("Edge: " + currentEdge.src + " - " + currentEdge.dest + " Weight: " + currentEdge.wt);

            for (Edge neighbor : graph[currentEdge.dest]) {
                if (!visited[neighbor.dest]) {
                    minHeap.offer(neighbor);
                }
            }
        }
    }
}
