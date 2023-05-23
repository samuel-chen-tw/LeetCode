package com.samuel.project.medium;

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

    static class MostVotesSolution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0); // creating an dummy list
            ListNode curr = dummy; // intialising an pointer
            int carry = 0; // intialising our carry with 0 intiall
            // while loop will run, until l1 OR l2 not reaches null OR if they both reaches null. But our carry has some value in it.
            // We will add that as well into our list
            while(l1 != null || l2 != null || carry == 1){
                int sum = 0; // intialising our sum
                if(l1 != null){ // adding l1 to our sum & moving l1
                    sum += l1.val;
                    l1 = l1.next;
                }
                if(l2 != null){ // adding l2 to our sum & moving l2
                    sum += l2.val;
                    l2 = l2.next;
                }
                sum += carry; // if we have carry then add it into our sum
                carry = sum/10; // if we get carry, then divide it by 10 to get the carry
                ListNode node = new ListNode(sum % 10); // the value we'll get by moduloing it, will become as new node so. add it to our list
                curr.next = node; // curr will point to that new node if we get
                curr = curr.next; // update the current every time
            }
            return dummy.next; // return dummy.next bcz, we don't want the value we have consider in it intially!!
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
