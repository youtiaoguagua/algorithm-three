package leetcode.editor.cn;
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 425 👎 0


class FeiBoNaQiShuLieLcof {
    public static void main(String[] args) {
        Solution solution = new FeiBoNaQiShuLieLcof().new Solution();
        System.out.println(solution.fib(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int MOD = 1000000007;
        public int fib(int n) {
            if (n<2){
                return n;
            }
            long[][] q = {{1,1},
                    {1,0}};
            long[][] res = {{1,0},
                    {0,1}};

          int x = n-1;
          while (x>0){
              if ((x&1)==1){
                  res = pow(q,res);
              }
              q = pow(q,q);
              x>>=1;
          }
          return (int)res[0][0];
        }

        private long[][] pow(long[][] q, long[][] res) {
            long[][] r = new long[2][2];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                   r[i][j] = (q[i][0]*res[0][j]+q[i][1]*res[1][j])%MOD;
                }
            }

            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    static class Solution3 {
        public int fib(int n) {
            int a = 0, b = 1;
            if (n == 0) {
                return a;
            }
            if (n == 1) {
                return b;
            }

            //0 1 1 2 3 5

            for (int i = 2; i <= n; i++) {
                int t = b;
                b = (a + b) % 1000000007;
                a = t;
            }
            return b;
        }
    }

    static class Solution4 {
        static final int MOD = 1000000007;

        public int fib(int n) {
            if (n < 2) {
                return n;
            }
            int[][] q = {{1, 1}, {1, 0}};
            int[][] res = pow(q, n - 1);
            return res[0][0];
        }

        public int[][] pow(int[][] a, int n) {
            int[][] ret = {{1, 0}, {0, 1}};
            while (n > 0) {
                if ((n & 1) == 1) {
                    ret = multiply(ret, a);
                }
                n >>= 1;
                a = multiply(a, a);
            }
            return ret;
        }

        public int[][] multiply(int[][] a, int[][] b) {
            int[][] c = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
                }
            }
            return c;
        }
    }

    static class Solution2 {
        int mod = (int) 1e9 + 7;

        long[][] mul(long[][] a, long[][] b) {
            int r = a.length, c = b[0].length, z = b.length;
            long[][] ans = new long[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    for (int k = 0; k < z; k++) {
                        ans[i][j] += a[i][k] * b[k][j];
                        ans[i][j] %= mod;
                    }
                }
            }
            return ans;
        }

        public int fib(int n) {
            if (n <= 1) return n;
            long[][] mat = new long[][]{
                    {1, 1},
                    {1, 0}
            };
            long[][] ans = new long[][]{
                    {1},
                    {0}
            };
            int x = n - 1;
            while (x != 0) {
                if ((x & 1) != 0) ans = mul(mat, ans);
                mat = mul(mat, mat);
                x >>= 1;
            }
            return (int) (ans[0][0] % mod);
        }
    }

}