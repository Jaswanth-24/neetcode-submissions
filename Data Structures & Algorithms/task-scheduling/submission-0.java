class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char task : tasks){
            map[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> Integer.compare(b, a));
        for(int i = 0; i < 26; i++){
            if(map[i] > 0){
                pq.add(map[i]);
            }
        }
        int time = 0;
        while(!pq.isEmpty()){
            int cycle = n + 1;
            List<Integer> list = new ArrayList<>();
            int count = 0;
            while(cycle-- > 0 && !pq.isEmpty()){
                int curr = pq.poll();
                if(curr > 1){
                    list.add(curr - 1);
                }
                count++;
            }
            time += list.isEmpty() ? count : n + 1;
            for(int i : list){
                pq.add(i);
            }
        }
        return time;
    }
}
