/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        Node clone = new Node(node.val);
        map.put(node, clone);

        while(!q.isEmpty()){
            Node n = q.poll();

            for(Node neighbor: n.neighbors){
                if(!map.containsKey(neighbor)){
                    Node clonedNeighbor = new Node(neighbor.val);
                    map.put(neighbor, clonedNeighbor);
                    q.add(neighbor);
                }
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }

        return clone;
    }
}