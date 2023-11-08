import java.util.ArrayList;

public class cycle_detection_directed_graph {
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

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 2));
    }

    

    /**
     * 
     * @param graph graph itself
     * @param curr current node
     * @param dest destination node
     * @param path store path details
     * @param visited boolean array to store visited vertex
     */
    public static void allPath(ArrayList<Edge> graph[], int curr, int dest, String path, boolean[] visited){
        if(curr == dest){
            System.out.println(path + dest);
            return;
        }

        path += curr + "->";
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                visited[curr] = true;
                allPath(graph, e.dest, dest, path, visited);
                visited[curr] = false;
            }
            
        }
    }

    public static boolean detectCycle(ArrayList<Edge> graph[], int curr, boolean[] visited, boolean[] stack){
        visited[curr] = true;
        stack[curr] = true;
        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!visited[e.dest]){
                if(detectCycle(graph, e.dest, visited, stack)){
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        int nodeNumber = 0;
        
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean[] visited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
            System.out.println(detectCycle(graph, i, visited, stack));
        }
        }
        
    }
}
