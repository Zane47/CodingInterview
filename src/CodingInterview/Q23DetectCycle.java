package CodingInterview;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/c32eOV/
 */
public class Q23DetectCycle {

    public static void main(String[] args) {


    }


    /**
     * 快慢指针的方法
     */
    public class Solution2 {

    }

    /**
     * HashSet的方法, 需要额外的空间
     */
    public class Solution1 {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            ListNode cur = head;
            while (cur != null) {
                if (set.contains(cur)) {
                    return cur;
                } else {
                    set.add(cur);
                }
                cur = cur.next;
            }

            return null;
        }
    }



    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

}
