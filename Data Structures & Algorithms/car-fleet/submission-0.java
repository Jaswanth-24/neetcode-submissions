class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];

        for(int i = 0; i < n; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Stack<Double> st = new Stack<>();
        Arrays.sort(pair, (a,b) ->Integer.compare(b[0], a[0]));
        for(int i = 0; i < n; i++){
            st.push((double)(target - pair[i][0]) / pair[i][1]);
            while(st.size() >= 2 && st.peek() <= st.get(st.size() - 2)){
                st.pop();
            }
        }
        return st.size();
    }
}
