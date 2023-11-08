import java.util.*;
public class Graph_Implementation{
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
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    
    public static void bfs(ArrayList<Edge> graph[], int start, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.println(curr);
                visited[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }


    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] visited){
        System.out.println(curr);
        visited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph,e.dest, visited);
            }
        }
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

    public static void main(String[] args) {
        int v = 7;
        int nodeNumber = 0;
        
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean[] visited = new boolean[graph.length];

        
        
        // //bfs implementation
        // for(int i=0; i<graph.length; i++){
        //     if(!visited[i]){
        //         bfs(graph, i, visited);
        //     }
        // }


        // // dfs implementation
        // dfs(graph, 0, visited);
        // for(int i=0; i<graph.length; i++){
        //     if(!visited[i]){
        //         dfs(graph, i, visited);
        //     }
        // }
        
        allPath(graph, 0, 5,"", new boolean[v]);
    }
}