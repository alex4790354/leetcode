package com.github.alex4790354.p03LinkedLists.p00Theory;

public class T03ReverseLinkedList3 {

    public static void main(String[] args) {
        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        LinkedNode node4 = new LinkedNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        /*node4.prev = node3;
        node3.prev = node2;
        node2.prev = node1;*/

        LinkedNode dummy = node1;
        while(dummy != null) {
            System.out.println(dummy.val);
            dummy = dummy.next;
        }

        System.out.println("##25");
        LinkedNode dummy2 = reverse(node1);
        while(dummy2 != null) {
            System.out.println(dummy2.val);
            dummy2 = dummy2.next;
        }

    }

    public static LinkedNode reverse(LinkedNode given) {
        LinkedNode prevNode = null;
        LinkedNode currentNode = given;
        LinkedNode nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        return prevNode;
    }
}
