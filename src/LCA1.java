import java.util.List;

public class LCA1 {
    class TreeNode {
        int val;
        List<TreeNode> children;
    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        int[] countFind = {0};
        TreeNode result = helper(root, p, q, countFind);
        return countFind[0] == 2 ? result : null;
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q, int[] countFind) {
        if (root == null) {
            return null;
        }
        int count = 0;
        TreeNode temp = null;
        for (TreeNode child : root.children) {
            temp = helper(child, p, q, countFind);
            if (temp != null) {
                count++;
            }
            if (count == 2) {
                return root;
            }
        }
        if (root == p || root == q) {
            countFind[0]++;
            return root;
        }
        if (count == 1) {
            return temp;
        }
        return null;
    }

}
