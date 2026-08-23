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
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        int n = intervals.size();
        if(n == 0){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Interval i : intervals){
            if(!pq.isEmpty() && pq.peek() <= i.start){
                pq.poll();
            }
            pq.add(i.end);
        }
        return pq.size();
    }
}
