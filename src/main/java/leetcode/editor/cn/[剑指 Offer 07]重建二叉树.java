package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        private int[] preorder;
        private int[] inorder;
        private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;

            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return dfs(0, preorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode dfs(int i, int j, int x, int y) {
            if (i > j) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[i]);
            Integer t = map.get(preorder[i]);

            root.left = dfs(i + 1, t - x + i, x, t - 1);
            root.right = dfs(t - x + i + 1, j, t + 1, y);


            return root;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}