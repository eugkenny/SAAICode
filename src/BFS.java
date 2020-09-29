import java.util.LinkedList;

public class BFS {
    Graph g;
    LinkedList<Integer> visited = new LinkedList<>();

    public BFS(Graph g){
        this.g = g;
    }

    public void bfs(int x){
        Queue<Integer> q = new Queue<>();

        q.enqueue(x);

        while(!q.isEmpty()) {
            Integer v = q.dequeue();
            visited.add(v);

            for (Integer i : g.neighbours(v)) {
                if (!visited.contains(i)) {
                    q.enqueue(i);
                }
            }
        }
    }

    public String toString(){
        return visited.toString();
    }


    public static void main(String[] args) {
        Graph g = new Graph(false);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(2,5);
        g.addEdge(4,6);
        g.addEdge(6,7);
        g.addEdge(6,8);

        BFS bfs = new BFS(g);
        bfs.bfs(4);

        System.out.println(bfs);
    }
}
