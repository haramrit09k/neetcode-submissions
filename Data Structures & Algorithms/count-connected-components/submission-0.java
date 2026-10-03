class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        int connected = 0;

        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                connected++;
                bfs(i, adjList, visited);
            }
        }

        return connected;

    }

    static void bfs(int node, List<List<Integer>> adjList, Set<Integer> visited){
        Queue<Integer> queue = new LinkedList<>();
        visited.add(node);
        queue.offer(node);

        while(!queue.isEmpty()){
            int elem = queue.poll();
            for(int nei: adjList.get(elem)){
                if(!visited.contains(nei)){
                    visited.add(nei);
                    queue.offer(nei);
                }
            }
        }
    }
}
