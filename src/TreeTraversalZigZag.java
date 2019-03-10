import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeTraversalZigZag {
    public class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
    }

    public List<List<Integer>> zigzagPrint(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        int layer = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> currentLayer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (layer == 0) {
                    // At even layer, from right to left
                    TreeNode temp = deque.pollLast();
                }
            }

        }
        return res;
    }
}

