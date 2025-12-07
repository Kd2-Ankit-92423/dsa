// ===========================================================================================
// 3. Implement linear search algorithm to find the nth occurence of the given element. If nth occurrence is not found, return -1
// ===========================================================================================

import java.util.Scanner;

public class NthOccurrenceSearch {

    public static int searchNthOccurrence(int[] arr, int target, int n) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;

                if (count == n) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {10, 20, 10, 30, 20, 10, 40, 10};
        System.out.println("Array: {10, 20, 10, 30, 20, 10, 40, 10}");

        System.out.print("Enter element to find: ");
        int target = sc.nextInt();

        System.out.print("Enter which occurrence (n): ");
        int n = sc.nextInt();

        int index = searchNthOccurrence(arr, target, n);

        if (index != -1) {
            System.out.println("The " + n + "th occurrence of " + target + " is at index: " + index);
        } else {
            System.out.println("The element " + target + " does not appear " + n + " times.");
        }

        sc.close();
    }
}
