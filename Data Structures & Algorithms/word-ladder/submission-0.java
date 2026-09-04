class Solution {
    class Info{
        int val;
        String s;
        public Info(int i,String s){
            this.val = i;
            this.s = s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(1,beginWord));
        while(!q.isEmpty()){
            String str = q.peek().s;
            int steps = q.poll().val;
            if(str.equals(endWord)){
                return steps;
            }
            for(int i = 0; i < str.length(); i++){
               for(char c = 'a'; c <= 'z'; c++){
                    char[] ch = str.toCharArray();
                    ch[i] = c;
                    String replacedStr = new String(ch);
                    if(set.contains(replacedStr)){
                        q.add(new Info(steps + 1, replacedStr));
                        set.remove(replacedStr);
                    }
                }
            } 
        }
        return 0;
    }
}