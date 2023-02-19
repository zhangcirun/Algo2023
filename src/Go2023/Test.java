package Go2023;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Node1 {
    public String name;
    public Node1 parent;
    public List<Node1> children;
    public Set<String> hasAccess;
}

public class Test {
    public void grant_access(Node1 node1, String username) {
        grant_or_revoke(node1, username, true);
    }

    public void revoke_access(Node1 node1, String username) {
        grant_or_revoke(node1, username, false);
    }

    public boolean has_access(Node1 node1, String username) {
        return node1.hasAccess.contains(username);
    }

    private void grant_or_revoke(Node1 node1, String username, boolean isGrantAccess) {
        Queue<Node1> queue = new LinkedList<>();
        queue.offer(node1);
        while (!queue.isEmpty()) {
            Node1 curr = queue.poll();
            if (isGrantAccess) {
                curr.hasAccess.add(username);
            } else {
                curr.hasAccess.remove(username);
            }
            for (Node1 child : node1.children) {
                queue.offer(child);
            }
        }
    }
}
