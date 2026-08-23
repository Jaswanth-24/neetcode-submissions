/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        int n = intervals.size();
        if(n == 0){
            return true;
        }
        int last = intervals.get(0).end;
        
        for(int i = 1; i < n; i++){
            Interval curr = intervals.get(i);
            if(curr.start < last){
                return  false;
            }
            last = Math.max(curr.end, last);
        }
        return true;
    }
}
