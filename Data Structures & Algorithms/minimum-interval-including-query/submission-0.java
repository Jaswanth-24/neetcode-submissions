class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        int i =  0, n = queries.length;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int q : Arrays.stream(queries).sorted().toArray()){
            while(i < intervals.length && intervals[i][0] <= q){
                pq.add(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1] < q){
                pq.poll();
            }
            map.put(q, pq.isEmpty() ? -1 :pq.peek()[0]);
        }
        int[] ans = new int[n];
        for(int j = 0; j < n; j++){
            ans[j] = map.get(queries[j]);
        }
        return ans;
    }
}
