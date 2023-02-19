package Go2023;

import java.util.List;
import java.util.Map;

class FileNode {
    public String name;
    public FileNode parent;
    public List<FileNode> children;
    //
    public Map<String, Permission> userToPermission;
}

enum Operation {
    GRANT, REVOKE
}

class Permission {
    Operation operation;
    int timestamp;

    public Permission(Operation operation, int timestamp) {
        this.timestamp = timestamp;
        this.operation = operation;
    }
}

public class Test2 {
    static int time = 0;

    public void grant_access(FileNode node, String username) {
        node.userToPermission.put(username, new Permission(Operation.GRANT, time));
        time++;
    }

    public void revoke_access(FileNode node, String username) {
        node.userToPermission.put(username, new Permission(Operation.REVOKE, time));
        time++;
    }

    public boolean has_access(FileNode node, String username) {
        boolean hasAccess = false;
        int timeStamp = Integer.MIN_VALUE;
        while (node != null) {
            if (node.userToPermission.containsKey(username) && node.userToPermission.get(username).timestamp > timeStamp) {
                hasAccess = node.userToPermission.get(username).operation == Operation.GRANT;
            }
            node = node.parent;
        }

        return hasAccess;
    }


}
