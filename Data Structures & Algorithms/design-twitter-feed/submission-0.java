class Twitter {
    class Tweet{
        int tweetId;
        int time;
        public Tweet(int id, int t){
            this.tweetId = id;
            this.time = t;
        }
    }
    Map<Integer, List<Tweet>> posts;
    Map<Integer, Set<Integer>> following;
    int time;
    public Twitter() {
        posts = new HashMap<>();
        following = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        posts.computeIfAbsent(
            userId, x -> new ArrayList<>())
            .add(new Tweet(tweetId, time++)
            );
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        if(posts.containsKey(userId)){
            pq.addAll(posts.get(userId));
        }

        if (following.containsKey(userId)) {
            for(int followee : following.get(userId)){
                if(posts.containsKey(followee)){
                    pq.addAll(posts.get(followee));
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(!pq.isEmpty() && i < 10){
            list.add(pq.poll().tweetId);
            i++;
        }
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId)    return;
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)){
            following.get(followerId).remove(followeeId);
        }
    }
}