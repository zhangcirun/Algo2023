package Go2023;
/**
 * All Node.val are unique.
 * p != q
 * p and q will exist in the BST.
 */
public class LowestCommonAncestorBinarySearchTree235 {

    class ResultType {
        TreeNode lca;
        boolean hasPChild;
        boolean hasQChild;

        public ResultType(TreeNode lca, boolean hasPChild, boolean hasQChild) {
            this.lca = lca;
            this.hasPChild = hasPChild;
            this.hasQChild = hasQChild;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q).lca;
    }

    private ResultType dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new ResultType(null, false, false);
        }

        ResultType leftResult = dfs(root.left, p, q);
        ResultType rightResult = dfs(root.right, p, q);

        if (leftResult.lca != null) {
            return leftResult;
        }

        if (rightResult.lca != null) {
            return rightResult;
        }

        boolean hasP = leftResult.hasPChild || rightResult.hasPChild || root.val == p.val;
        boolean hasQ = leftResult.hasQChild || rightResult.hasQChild || root.val == q.val;
        TreeNode lca = hasP && hasQ ? root : null;

        return new ResultType(lca, hasP, hasQ);
    }
}
