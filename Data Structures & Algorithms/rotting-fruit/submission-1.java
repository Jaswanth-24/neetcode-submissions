class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int total = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    total++;
                }
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int count = 0, time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            count += size;
            for(int i = 0; i < size; i++){
                int[] a = q.poll();
                int x = a[0], y = a[1];
                for(int d = 0; d < 4; d++){
                    int nx = dx[d] + x;
                    int ny = dy[d] + y;
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 1){
                        continue;
                    } 
                    grid[nx][ny] = 2;
                    q.add(new int[] {nx ,ny});
                }
            }
            if(!q.isEmpty())    time++;
        }
        return count == total ? time: -1;
    }
}
