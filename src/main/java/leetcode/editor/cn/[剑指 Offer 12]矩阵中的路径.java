package leetcode.editor.cn;
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
//
// Related Topics 数组 回溯 矩阵 👍 717 👎 0


class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        boolean res = solution.exist(new char[][]{{'a'}}, "a");
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private char[] chars;
        private char[][] board;

        public boolean exist(char[][] board, String word) {
            chars = word.toCharArray();
            this.board = board;


            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(i, j, 0)){
                        return true;
                    }
                }
            }

            return false;
        }

        int[] a= {1,-1,0,0},b={0,0,1,-1};


        private boolean dfs(int i, int j,int index) {
            if(i<0 || i>=board.length || j<0 || j>=board[0].length||index>=chars.length||board[i][j]!=chars[index]){
                return false;
            }

            if (index==chars.length-1){
                return true;
            }


            char c = board[i][j];
            board[i][j] = '/';
            boolean dfs= false;
            for (int k = 0; k < 4; k++) {
                int x = i + a[k];
                int y = j + b[k];
                if (dfs(x, y, index+1)){
                    dfs=true;
                }
            }
            board[i][j] = c;

            return dfs;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}