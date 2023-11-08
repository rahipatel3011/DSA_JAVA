
import java.util.*;

public class cycle_detection_undirected_graph {
    static class Edge{
        int src; 
        int dest; 
        int w;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
            //this.w = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 4));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));
        
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));

    }

    public static boolean isCyclic(ArrayList<Edge> graph[], int curr, int parent, boolean[] visited){

        visited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                if(isCyclic(graph, e.dest, curr, visited)){
                    return true;
                }
            }
            else if(visited[e.dest] && e.dest != parent){
                return true;
            }
        }

        return false;
    }
    
    

    public static void main(String[] args) {
        int v = 6;
        
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean[] visited = new boolean[v];
        boolean is_cyclic = false;
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                // this condition check any path is cyclic or not in multiple seprated path in graph.
                is_cyclic = is_cyclic || isCyclic(graph, i, -1, visited);
            }
        }
        System.out.println(is_cyclic);
    }

}
