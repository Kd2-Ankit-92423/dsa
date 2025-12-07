// ===========================================================================================
// 2095 . Delete the Middle Node of a Linked List
// You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

// The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

// For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
// ===========================================================================================

public class DeleteMiddleNode {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[] (Empty)");
            return;
        }
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test 1: Odd List (1 -> 2 -> 3 -> 4 -> 5)
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.println("Original Odd List:");
        printList(head1);
        head1 = deleteMiddle(head1);
        System.out.println("After Deleting Middle:");
        printList(head1);
        System.out.println("-------------------");

        // Test 2: Even List (1 -> 2 -> 3 -> 4)
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);

        System.out.println("Original Even List:");
        printList(head2);
        head2 = deleteMiddle(head2);
        System.out.println("After Deleting Middle:");
        printList(head2);
    }
}
