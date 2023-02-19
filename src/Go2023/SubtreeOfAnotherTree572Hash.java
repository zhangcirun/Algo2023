package Go2023;

//    4
//  1   #
//#  2

//    1
//  #   4
//     2

//inorder + preorder + '#" 确定二叉树的唯一结构
public class SubtreeOfAnotherTree572Hash {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder sb1 = new StringBuilder();
        getPreorderStr(root, sb1);

        StringBuilder sb2 = new StringBuilder();
        getPreorderStr(subRoot, sb2);

        return sb1.toString().contains(sb2.toString());
    }

    private void getPreorderStr(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            return;
        }

        sb.append(" ");
        sb.append(root.val);
        getPreorderStr(root.left, sb);
        getPreorderStr(root.right, sb);
    }

}
