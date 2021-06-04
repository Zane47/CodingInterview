package CodingInterview;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 */

public class Q06ReversePrint {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);

        Solution solution = new Solution();
        solution.reversePrint(head);
    }

    /**
     * 能用栈，也能用递归
     * 但是注意层数过多可能会栈溢出
     *
     */
    static class Solution {
        ArrayList<Integer> arrayList = new ArrayList<>();

        public int[] reversePrint(ListNode head) {
            recur(head);

            int[] result = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                result[i] = arrayList.get(i);
            }

            return result;
        }
        private void recur(ListNode head) {
            if (head == null) {
                return;
            }
            recur(head.next);
            arrayList.add(head.val);
        }

    }


    /**
     * 遍历两次链表
     */
    static class Solution2 {
        public int[] reversePrint(ListNode head) {
            ListNode node = head;
            int count = 0;
            while (null != node) {
                count++;
                node = node.next;
            }
            int[] result = new int[count];

            for (int i = count - 1; i >= 0; i--) {
                result[i] = head.val;
                head = head.next;
            }

            return result;
        }
    }

    /**
     * 单链表倒序输出
     * 栈，先进后出
     */
    static class Solution1 {
        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }
            int[] result = new int[stack.size()];

            // 这里是result.length，不是stack.size(会变)
            for (int i = 0; i < result.length; i++) {
                result[i] = stack.pop();
            }

            return result;
        }

    }



}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
