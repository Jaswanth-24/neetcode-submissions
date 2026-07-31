class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int n = heights.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            int start = i;
            while(!st.isEmpty() && st.peek()[1] > heights[i]){
                int[] top = st.pop();
                max = Math.max((i - top[0]) * top[1], max);
                start = top[0];
            }
            st.push(new int[]{start, heights[i]});
        }   
        for(int[] pair : st){
            max = Math.max(max, pair[1] * (n - pair[0]));
        }
        return max;
    }
}
