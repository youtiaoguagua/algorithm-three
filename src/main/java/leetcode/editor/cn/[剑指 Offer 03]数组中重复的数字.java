package leetcode.editor.cn;
class ShuZuZhongZhongFuDeShuZiLcof{
  public static void main(String[] args) {
       Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]!=i){
                int t = nums[i];
                int a = nums[t];
                if (t==a){
                    return t;
                }
                nums[t] = t;
                nums[i] =a;

            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}