// ===========================================================================================
// 7. Implement binary search algorithm if array is sorted in descending order
// ===========================================================================================

public class BinarySearchDescending {

    public static int binarySearchDesc(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target < arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] data = {100, 80, 60, 40, 20, 0};
        int target = 80;

        System.out.println("Array: {100, 80, 60, 40, 20, 0}");
        System.out.println("Target: " + target);

        int index = binarySearchDesc(data, target);

        if (index != -1) {
            System.out.println("Found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }
}
