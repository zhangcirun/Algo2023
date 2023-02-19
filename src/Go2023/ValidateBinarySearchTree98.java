package Go2023;

public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, Long lowerBound, Long higherBound) {
        if (root == null) {
            return true;
        }

        if (root.val <= lowerBound || root.val >= higherBound) {
            return false;
        }

        return isValid(root.left, lowerBound, (long)root.val) &&
                isValid(root.right, (long)root.val, higherBound);
    }
}
