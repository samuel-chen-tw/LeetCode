package com.samuel.project.medium;

import java.util.List;

public class RemoveNthNodeFromEndOfList {

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

    public static ListNode removeNthFromEnd (ListNode head, int n){
        // 使用虛擬頭節點，以處理可能的頭部刪除情況
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 快慢指針法
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 同時移動fast和slow，直到fast末端
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow.next為要被刪除的節點，用slow.next.next把後面的接上
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        ListNode result = removeNthFromEnd(head, n);
        System.out.println("=====");
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
