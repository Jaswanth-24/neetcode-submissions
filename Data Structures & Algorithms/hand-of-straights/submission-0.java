class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i : hand){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int i : map.keySet()){
            pq.add(i);
        }
        while(!pq.isEmpty()){
            int firstCard = pq.peek();
            for(int i = firstCard; i < firstCard + groupSize; i++){
                if(!map.containsKey(i)){
                    return false;
                }
                map.put(i, map.get(i) - 1);
                if(map.get(i) == 0){
                    map.remove(i);
                    pq.remove(i);
                }
            }
        }
        return true;
    }
}
