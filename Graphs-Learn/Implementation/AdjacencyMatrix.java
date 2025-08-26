package Implementation;
public class AdjacencyMatrix{
    public static void main(String[] args) {
        int n = 5; // number of nodes
        int m  = 6; // number of edges
        int graph[][] = new int[n+1][n+1];
        graph[1][2] = 1;
        graph[2][1] = 1;
        graph[3][4] = 1;
        graph[4][3] = 1;

        for(int i=0;i<n+1;i++){
            System.out.print("[");
            for(int j=0;j<n+1;j++){
               System.out.print(graph[i][j] + ",");
            }
            System.out.print("]");
            System.out.println();
        }

    }

}