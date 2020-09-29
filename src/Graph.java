import java.util.HashMap;
import java.util.LinkedList;

public class Graph{

    HashMap<Integer, LinkedList<Integer>> adj;
    boolean directed;

    public Graph(boolean directed){
        adj = new HashMap<>();
        this.directed = directed;
    }

    public boolean isAdjacent(int x, int y){
        return adj.get(x).contains(y);
    }

    public void addVertex(int x){
        adj.put(x, new LinkedList<>());
    }

    public void addEdge(int x, int y){
        if (adj.get(x) == null){
            addVertex(x);
        }
        if(adj.get(y) == null){
            addVertex(y);
        }

        adj.get(x).add(y);
        adj.get(y).add(x);

    }

    public int order(){
        return adj.size();
    }

    public int size() {
        int size = 0;
        for (Integer i : adj.keySet()) {
            size += adj.get(i).size();
        }
        return size/2;
    }


    public Iterable<Integer> neighbours(int x){
        return adj.get(x);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Integer i : adj.keySet()) {
            sb.append(i + adj.get(i).toString() + "\n");
        }
        return sb.toString();
    }

    public static void main(String [] args){
        Graph g = new Graph(false);
        g.addVertex(1);
        g.addVertex(3);
        g.addVertex(2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);

        System.out.println(g);
        System.out.println("Adjacent: 2, 4 - "  + g.isAdjacent(2,4));
        System.out.println("Adjacent: 3, 4 - "  + g.isAdjacent(3,4));

        System.out.print("Neighbours: 2 - ");
        for (Integer i : g.neighbours(2)) {
            System.out.print(i + ", ");
        }
        System.out.println();

        System.out.println("Order: " + g.order());
        System.out.println("Size: " + g.size());
    }

}