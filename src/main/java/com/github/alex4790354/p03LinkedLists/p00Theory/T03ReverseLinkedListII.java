package com.github.alex4790354.p03LinkedLists.p00Theory;

//TODO: repeat
public class T03ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null) return null;

        // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node just before the left-th node
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // `start` will point to the first node in the range to be reversed
        ListNode start = prev.next;
        // `then` will point to the node that will be reversed
        ListNode then = start.next;

        // Perform the reverse operation
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }

    private ListNode reverseBetweenMyWithError(ListNode head, int left, int right) {
        ListNode current = head;
        int counter = 0;
        ListNode leftNode = head;
        ListNode leftNodePrev = head;
        ListNode rightNode = null;
        ListNode rightNodePrev = null;

        for (int i = 1; i < right + 1; i++) {
            if (i == left - 1)
                leftNodePrev = current;
            if (i == left)
                leftNode = current;
            if (i == right - 1)
                rightNodePrev = current;
            if (i == right)
                rightNode = current;

            current = current.next;
            if (current == null)
                return null;
        }

        ListNode temp = rightNode;

        leftNodePrev.next = rightNode;
        rightNode.next = leftNode.next;

        rightNodePrev.next = leftNode;
        leftNode.next = temp.next;

        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


