class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        Queue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            int dist1 = p1[0] * p1[0] + p1[1] * p1[1];
            int dist2 = p2[0] * p2[0] + p2[1] * p2[1];
            return Integer.compare(dist2, dist1); 
        });

        for(int i = 0; i < n; i++){
            pq.add(new int[] {points[i][0], points[i][1]});
            while(pq.size() > k){
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            res[i][0] = curr[0];
            res[i][1] = curr[1];
            i++;
        }
        return res;
    }
}
