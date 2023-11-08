import java.util.ArrayList;
import java.util.PriorityQueue;


/**
 * for shortest path here we are using Dijkstra's algorithm
 */
public class shortestPath {
    static class Edge{
        int src; 
        int dest; 
        int weight;
        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair p) {
            return this.dist - p.dist;
        }

        
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2,4));

        graph[1].add(new Edge(1, 2,1));
        graph[1].add(new Edge(1, 3,7));

        graph[2].add(new Edge(2, 4,3));

        graph[3].add(new Edge(3, 5,1));

        graph[4].add(new Edge(4, 3,2));
        graph[4].add(new Edge(4, 5,5));
    }

    
    public static void shortestPath(ArrayList<Edge> graph[], int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        boolean visited[] = new boolean[V];

        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(0, 0));


        while(!pq.isEmpty()){
            Pair curr = pq.remove(); //shortest
            if(!visited[curr.node]){
                visited[curr.node] = true;

                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u] + e.weight < dist[v]){ // relaxation
                        dist[v] = dist[u] + e.weight;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0; i< dist.length; i++){
            System.out.println(dist[i] + " ");
        }
    }

    
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        shortestPath(graph, 0, v);
         
    }
}
