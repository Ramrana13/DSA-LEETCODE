class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            int u=flight[0];
            int v=flight[1];
            int cost=flight[2];
            graph.get(u).add(new int[]{v,cost});
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{src,0,0});
        
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int city=curr[0];
            int cost=curr[1];
            int stop=curr[2];

            if(stop>k){
                continue;
            }
            for(int[] nei:graph.get(city)){
                int nextcity=nei[0];
                int price=nei[1];

                if(cost+price<dist[nextcity]){
                    dist[nextcity]=cost+price;
                    q.offer(new int[]{nextcity,dist[nextcity],stop+1});
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}