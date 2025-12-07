
// ===========================================================================================
// 5. Write a linear search algorithm to return index of last occurance of key
// ===========================================================================================
public class LastOccurrenceSearch {

    public static int findLastOccurrence(int[] arr, int key) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 30, 20, 40, 20, 50};
        int target = 20;

        System.out.println("Array: {10, 20, 30, 20, 40, 20, 50}");
        System.out.println("Target: " + target);

        int index = findLastOccurrence(data, target);

        if (index != -1) {
            System.out.println("Last occurrence is at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }
}
