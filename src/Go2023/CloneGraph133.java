package Go2023;

import java.util.*;

public class CloneGraph133 {
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

    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();

        if(node == null){
            return null;
        }

        Queue<Node> q = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();

        q.offer(node);
        visited.add(node);

        while(!q.isEmpty()){
            Node cur = q.poll();
            Node newNode;
            if (oldToNew.containsKey(cur)) {
                newNode = oldToNew.get(cur);
            } else {
                newNode = new Node(cur.val);
                oldToNew.put(cur, newNode);
            }
            cloneNode(cur, newNode, oldToNew);

            for (Node neighbor : cur.neighbors) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                visited.add(neighbor);
                q.offer(neighbor);
            }

        }
        return oldToNew.get(node);
    }

    public void cloneNode(Node oldNode, Node newNode, Map<Node, Node> oldToNew) {
        for (Node oldNeighbor : oldNode.neighbors) {
            if (oldToNew.containsKey(oldNeighbor)) {
                newNode.neighbors.add(oldToNew.get(oldNeighbor));
            } else {
                Node newNeighbor = new Node(oldNeighbor.val);
                oldToNew.put(oldNeighbor, newNeighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
    }
}
