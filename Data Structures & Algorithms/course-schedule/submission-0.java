class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // form adjacency list and indegree
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            indegree[pre[1]]++;
            adjList.get(pre[0]).add(pre[1]);
        }

        // add all indegree=0 courses to queue
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        // visit each course in queue - reduce indegree of neighbors by 1 - if indegree of neighbor becomes 0, add it to Queue
        // do so until queue is empty
        // maintain a count of courses that we remove from queue
        int count = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            count++;
            for(int nei: adjList.get(course)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }

        // if count of courses == numCourses -> can finish (true), else can't (false)
        return count == numCourses;
    }
}
