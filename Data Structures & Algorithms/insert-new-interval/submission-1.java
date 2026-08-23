class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0, n = intervals.length;
        List<int[]> list = new ArrayList<>();
        while(i < n && intervals[i][1] < newInterval[0]){
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        int start = newInterval[0], end = newInterval[1];

        while(i < n && intervals[i][0] <= newInterval[1]){
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end);
            i++;
        }
        list.add(new int[] {start, end});
        while(i < n){
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
