class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        int[] tuple = new int[]{0, -1}; // [node, parent]
        queue.offer(tuple);
        visited.add(0);

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];

            for(int nei: adjList.get(node)){
                if(nei == parent){
                    continue;
                }
                if(visited.contains(nei)){
                    return false; //cycle
                }
                visited.add(nei);
                queue.offer(new int[]{nei, node});
            }
        }

        return visited.size() == n;
    }
}
