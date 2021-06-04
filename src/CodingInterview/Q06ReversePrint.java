package CodingInterview;

import java.util.List;
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

        int a = 0;
    }

    /**
     * 单链表倒序输出
     * 栈，先进后出
     */
    static class Solution {
        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }
            int[] result = new int[stack.size()];

            for (int i = 0; i < stack.size(); i++) {
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
