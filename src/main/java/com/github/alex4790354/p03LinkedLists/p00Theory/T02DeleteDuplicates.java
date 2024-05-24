package com.github.alex4790354.p03LinkedLists.p00Theory;

//TODO: repeat
public class T02DeleteDuplicates {

    /*public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        head = deleteDuplicates(head);
        printList(head);
    }*/

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
