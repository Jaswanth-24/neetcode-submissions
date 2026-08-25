class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int INF = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] arr = q.poll();
                int x = arr[0], y = arr[1];
                for(int d = 0; d < 4; d++){
                    int nx = dx[d] + x;
                    int ny = dy[d] + y;
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != INF){
                        continue;
                    }
                    grid[nx][ny] = dist + 1;
                    q.add(new int[]{nx, ny});
                }
            }
            dist++;
        }
    }
}
