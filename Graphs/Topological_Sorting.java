import java.util.*;


/**
 * Topological sorting only applied on directed-acyclic graph(DAG)
 */
public class Topological_Sorting {
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

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
    }

    

    public static void topological_sorting(ArrayList<Edge> graph[], int curr, boolean[] visited, Stack<Integer> stack){
        
        visited[curr]=true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                topological_sorting(graph, e.dest, visited, stack);
            }
        }
        stack.push(curr);
    }
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=graph.length-1; i>=0; i--){
            if(!visited[i]){
                topological_sorting(graph, i, visited, stack);
            }
        }

        while(!stack.empty()){
            System.out.println(stack.pop());
        }
        
    }
}
