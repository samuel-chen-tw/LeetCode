package com.samuel.project.hard;

/**
 * MEDIUM
 * No.2
 * Add Two Numbers
 */
public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * complete the addTwoNumbers function
     */
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ans = new ListNode();
            ListNode tempAns = ans;
            int tempNum = 0;
            int temp1 = 0;
            int temp2 = 0;
            boolean over10 = false;
            while (l1 != null || l2 != null) {
                temp1 = l1 != null ? l1.val : 0;
                temp2 = l2 != null ? l2.val : 0;
                tempNum = over10 ? temp1 + temp2 + 1 : temp1 + temp2;

                over10 = tempNum >= 10;

                tempAns.val = tempNum % 10;
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
                if (l1 == null && l2 == null && over10) {
                    tempAns = tempAns.next = new ListNode();
                    tempAns.val = 1;
                    break;
                } else if (l1 != null || l2 != null || over10) {
                    tempAns = tempAns.next = new ListNode();
                }
            }
            System.gc();
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode ans = solution.addTwoNumbers(l1, l2);
        while (ans.next != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
