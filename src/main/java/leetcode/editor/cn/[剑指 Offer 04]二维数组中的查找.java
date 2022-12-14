package leetcode.editor.cn;

class ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].length==0){
                    return false;
                }
                if (matrix[i][0] > target) {
                    return false;
                }
                if (matrix[i][matrix[i].length-1]<target){
                    continue;
                }
                for (int j = 0; j < matrix[0].length; j++) {
                    int t = matrix[i][j];
                    if (t==target){
                        return true;
                    }
                    if (t>target){
                        break;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}