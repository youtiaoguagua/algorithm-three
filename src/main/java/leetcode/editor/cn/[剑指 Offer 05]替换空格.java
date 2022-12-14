package leetcode.editor.cn;
class TiHuanKongGeLcof{
  public static void main(String[] args) {
       Solution solution = new TiHuanKongGeLcof().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {

        char[] chars = s.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            if (aChar==' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(aChar);
            }

        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}