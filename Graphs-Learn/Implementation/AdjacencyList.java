package Implementation;
import java.util.ArrayList;

public class AdjacencyList {

    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n+1);
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(3).add(4);
        graph.get(4).add(3);

         graph.get(2).add(5);
        graph.get(5).add(2);

        for(int i=0;i<=n;i++){
            System.out.print("[");
            for(int j=0;j<graph.get(i).size();j++){
                System.out.print(graph.get(i).get(j) + ",");
            }
             System.out.print("]");
            System.out.println();
        }


    }
}
