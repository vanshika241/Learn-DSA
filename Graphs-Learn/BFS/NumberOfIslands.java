package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
     
    public void bfs(int i,int j,boolean [][]visited, char [][]grid){
         int n = grid.length;
        int m = grid[0].length;
        int directions[][] = {
            {-1,0},{1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,1},{1,-1}
        };
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            for(int dir[]:directions){
                int nowX = dir[0]+currX;
                int nowY = dir[1]+currY;
                
                if(nowX >=0 && nowX < n && nowY >=0 && nowY <m && grid[nowX][nowY] == 'L' && !visited[nowX][nowY]){
                    visited[nowX][nowY] = true;
                    q.add(new int[]{nowX, nowY});
                }
            }
        }
        
    }
    public int countIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        boolean visited[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 'L' && !visited[i][j]){
                    bfs(i,j,visited,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
