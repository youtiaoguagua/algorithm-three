package leetcode.editor.cn;
//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
//[[],[3],[],[],[]]
//输出：[null,null,3,-1,-1]
// 
//
// 示例 2： 
//
// 
//输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
//
// Related Topics 栈 设计 队列 👍 639 👎 0


import java.util.Stack;

class YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {
        Solution solution = new YongLiangGeZhanShiXianDuiLieLcof().new Solution();
    }

    class Solution {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {

        private Stack<Integer> a = new Stack<Integer>();
        private Stack<Integer> b = new Stack<Integer>();

        public CQueue() {

        }

        public void appendTail(int value) {
            a.push(value);
        }

        public int deleteHead() {
            if (a.isEmpty() && b.isEmpty()) {
                return -1;
            }

            if (b.isEmpty()) {
                while (!a.isEmpty()) {
                    b.push(a.pop());
                }
            }
            return b.pop();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}