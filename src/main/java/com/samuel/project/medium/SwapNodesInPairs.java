package com.samuel.project.medium;

import java.util.List;

public class SwapNodesInPairs {

    public static class ListNode {
        int val;
        SwapNodesInPairs.ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, SwapNodesInPairs.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            // A B C D...
            ListNode first = current.next; // A...
            ListNode second = current.next.next; // B...
            // 1. A... 被 B... 取代
            current.next = second; // dummy B C D...
            // 2. A的下一個B... 被 B的下一個C... 取代
            first.next = second.next; // A C D...
            // 3. B的下一個C... 被 A 取代
            second.next = first; // dummy B A C D...
            current = current.next.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs.ListNode head = new SwapNodesInPairs.ListNode(1, new SwapNodesInPairs.ListNode(2, new SwapNodesInPairs.ListNode(3, new SwapNodesInPairs.ListNode(4, new SwapNodesInPairs.ListNode(5)))));
        SwapNodesInPairs.ListNode result = swapPairs(head);
        System.out.println("=====");
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
