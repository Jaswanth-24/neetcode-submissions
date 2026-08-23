class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0, n = intervals.length;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int end = intervals[0][1];
        for(int i = 1; i < n; i++){
            if(end > intervals[i][0]){
                count++;
            }
            else{
                end = Math.max(end, intervals[i][1]);
            }
        }
        return count;
    }
}
