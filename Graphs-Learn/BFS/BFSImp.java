package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSImp {
     public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>(); 
        int v = adj.size(); //Total number of vertices
        Queue<Integer> q = new LinkedList<>(); //queue used in bfs
        boolean visited[] = new boolean[v]; // track all nodes
        q.add(0); // insert the starting point 
        visited[0] = true; // set it to true
        while(!q.isEmpty()){ // till queue isn't empty 
            int curr = q.poll(); // remove from queue
            ans.add(curr);
            for(int it : adj.get(curr)){ // add its neighbours
                if(visited[it] == false){ // first check so that no vertex come again
                    visited[it] = true;
                    q.add(it);
                }
            }
        }
        return ans;
        
    }
}
