// ===========================================================================================
// 234. Palindrome Linked List (LEETCODE )
// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
// ===========================================================================================

public class PalindromeList {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfHead = reverse(slow);
        ListNode firstHalfHead = head;

        ListNode copySecond = secondHalfHead;
        boolean isPalin = true;

        while (copySecond != null) {
            if (firstHalfHead.val != copySecond.val) {
                return false; // Mismatch found
            }
            firstHalfHead = firstHalfHead.next;
            copySecond = copySecond.next;
        }

        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Test: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println("Is Palindrome? " + isPalindrome(head));

        // Test: 1 -> 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("Is Palindrome? " + isPalindrome(head2));
    }
}
