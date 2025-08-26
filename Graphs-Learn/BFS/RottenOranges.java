package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
     public class Pair{
        int row;
        int col;
        int tm;
        Pair(int r, int c, int t){
            this.row = r;
            this.col = c;
            this.tm = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cntFresh = 0;
        Queue<Pair> q = new LinkedList<>();
        int visited[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                }
                if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }

        int directions[][] = {
            {-1,0},{1,0},{0,1},{0,-1}
        };
        int maxTime = 0;
        int rottenFresh = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int t = curr.tm;
            maxTime = Math.max(maxTime, t);
            for(int dr[]:directions){
                int nx = r+dr[0];
                int ny = c+dr[1];

                if(nx>=0 && nx < n && ny>=0 && ny<m && visited[nx][ny] != 2 && grid[nx][ny] == 1){
                    rottenFresh++;
                    q.add(new Pair(nx,ny,t+1));
                    visited[nx][ny] = 2;
                }
            }
        }
        if(rottenFresh != cntFresh)return -1;
        return maxTime;
    }
}
