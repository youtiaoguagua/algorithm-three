package leetcode.editor.cn;

import java.util.Arrays;

class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();


        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        //a.next = b;
        //b.next = c;
        int[] ints = solution.reversePrint(a);
        System.out.println(Arrays.toString(ints));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            if (head==null){
                return new int[0];
            }


            ListNode a = head;
            ListNode b = head.next;
            a.next = null;

            int count = 1;
            while (b != null) {
                count++;
                ListNode t = b.next;
                b.next = a;
                a = b;
                b = t;
            }

            int[] res = new int[count];
            while (a!=null&&count>=0){
                res[res.length-count] = a.val;
                count--;
                a =a.next;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}