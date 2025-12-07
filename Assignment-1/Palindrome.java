
// ===========================================================================================
//  1. Write all possibilites to check palindrome(number, array, string, linked list, tree) on paper. Also do time and space complexity analysis of all and compare
 // ===========================================================================================

/*
 * ==================================================================================
 * PALINDROME ALGORITHMS
 * ==================================================================================
 * * | Data Structure | Approach                  | Time Complexity | Space Complexity|
 * |----------------|---------------------------|-----------------|------------------|
 * | Number         | Math (Reverse int)        | O(log n)        | O(1)             | 
 * | Array          | Two Pointers              | O(n)            | O(1)             |
 * | String         | Two Pointers              | O(n)            | O(1)             | 
 * | Linked List    | Find Mid + Reverse Half   | O(n)            | O(1)             | 
 * | Tree           | Recursion                 | O(n)            | O(h)* | Medium   |
 * * ==================================================================================
 * *NOTE ON TREE SPACE: 
 * O(h) refers to the height of the tree (stack memory used by recursion). 
 * - Best Case (Balanced Tree): O(log n)
 * - Worst Case (Skewed Tree): O(n)
 * ==================================================================================
 */

public class Palindrome {
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    // --- A. Number Palindrome ---
    public static boolean isNumberPalindrome(int x) {
        if (x < 0) return false;
        int original = x;
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return original == reversed;
    }

    // --- B. Array Palindrome ---
    public static boolean isArrayPalindrome(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
            return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // --- C. String Palindrome ---
    public static boolean isStringPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)){
               return false; 
            } 
            left++;
            right--;
        }
        return true;
    }

    // --- D. Linked List Palindrome ---
    public static boolean isLinkedListPalindrome(ListNode head) {
        if (head == null || head.next == null) {
        return true;
        }

        // 1. Find Middle (Slow/Fast)
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse Second Half
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        // 3. Compare Both Halves
        ListNode left = head;
        ListNode right = prev; 
        while (right != null) {
            if (left.val != right.val){
             return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // --- E. Tree---
    public static boolean isTreeSymmetric(TreeNode root) {
        if (root == null) {
        return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }


    public static void main(String[] args) {
        System.out.println("===Palindrome===\n");

        int num1 = 121;
        int num2 = 123;
        System.out.println("1. Number Check:");
        System.out.println("   Is " + num1 + " a palindrome? " + isNumberPalindrome(num1));
        System.out.println("   Is " + num2 + " a palindrome? " + isNumberPalindrome(num2));
        System.out.println("-----------------------------");

        int[] arr1 = {1, 2, 3, 2, 1};
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("2. Array Check:");
        System.out.println("   Is {1,2,3,2,1} a palindrome? " + isArrayPalindrome(arr1));
        System.out.println("   Is {1,2,3,4,5} a palindrome? " + isArrayPalindrome(arr2));
        System.out.println("-----------------------------");

        String str1 = "racecar";
        String str2 = "hello";
        System.out.println("3. String Check:");
        System.out.println("   Is '" + str1 + "' a palindrome? " + isStringPalindrome(str1));
        System.out.println("   Is '" + str2 + "' a palindrome? " + isStringPalindrome(str2));
        System.out.println("-----------------------------");

        // List: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        
        System.out.println("4. Linked List Check:");
        System.out.print("   List: 1 -> 2 -> 2 -> 1 | Result: ");
        System.out.println(isLinkedListPalindrome(head));
        System.out.println("-----------------------------");

        // 5. Test Tree
        //  Symmetric Tree:
        //      1
        //     / \
        //    2   2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        
        System.out.println("5. Tree Symmetry Check:");
        System.out.print("   Tree: 1 -> (L:2, R:2) | Result: ");
        System.out.println(isTreeSymmetric(root));
    }
}