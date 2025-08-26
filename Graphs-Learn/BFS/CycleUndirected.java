package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleUndirected {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>>  adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[] :edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(bfsCycle(i,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean bfsCycle(int src, List<List<Integer>>  adj , boolean visited[]){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,-1});
        visited[src] = true;
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int node = curr[0];
            int parent = curr[1];
            for(int it:adj.get(node)){
                if(!visited[it]){
                    visited[it] = true;
                    q.add(new int[]{it,node});
                }
                else if(it != parent )return true;
            }
        }
        
        return false;
    }
}
