package leetcode.editor.cn;
//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 348 👎 0


class QingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
        System.out.println(solution.numWays(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * f1 =1 f2 = 2 f3=3 f4=5
         * f(n)=f(n-1)+f(n-2)
         * <p>
         * <p>
         * 111,12,21
         * 1111 121 22 211  112
         * 11111  2111 221  1211 122
         * 111111  1
         * 0  1 2 3 4 5 6
         * 0  1 2 3 4 5
         */

         int mod = (int) 1e9+7;
        public int numWays(int n) {
            int a = 1, b = 2;
            if (n==0){
                return 1;
            }
            if (n < 3) {
                return n;
            }

            for (int i = 3; i <= n; i++) {
                int t = b;
                b = (a + t)%mod;
                a = t;
            }
            return b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}