package Graph;
import java.util.*;
public class Implementation {
    static class Edge{
        int scr;
        int des;
        int wt;

        public Edge(int s ,int d, int w){
            this.scr = s;
            this.des = d;
            this.wt = w;
        }
    }

    //CREATE A GRAPH
    static void creategraph(ArrayList<Edge> graph[]){
        for (int i=0;i< graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        //0-vertex
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        //1-vertex
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        //2-vertex
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        //3-vertex
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        //4-vertex
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        //5-vertex
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        //6-vertex
        graph[6].add(new Edge(6,5,1));
        for (int i =0;i<graph[2].size();i++){
            Edge e =graph[2].get(i);
//            System.out.println(e.des);
        }
    }



    //TRAVERSAL-BY ADJACENCY LIST       COMPLEXITYO(V+E)
    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.offer(0);
        while (!q.isEmpty()){
            int cur = q.poll();
            if (!vis[cur]){
                System.out.println(cur+ " ");
                vis[cur]=true;
                for (int i=0;i<graph[cur].size();i++){
                    Edge e = graph[cur].get(i);
                    q.add(e.des);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge>[] graph , int curr , boolean vis[]){
        System.out.println(curr + " ");
        vis[curr] =true;

        for (int i =0 ;i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.des]){
                dfs(graph , e.des ,vis);
            }
        }
    }
    public static boolean hasPath(ArrayList<Edge>[] graph, int scr, int des, boolean vis[]){
        if (scr == des){
            return true;
        }
        vis[scr]= true;
        for (int i=0;i<graph[scr].size();i++){
            Edge e = graph[scr].get(i);
            if (!vis[e.des] && hasPath(graph, e.des, des, vis)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
    int v = 7;
    ArrayList<Edge> graph[] = new ArrayList[v];
    creategraph(graph);
//    bfs(graph);
//    dfs(graph , 0,new boolean[v]);
        System.out.println(hasPath(graph , 0, 7,new boolean[v]));
    }
}
