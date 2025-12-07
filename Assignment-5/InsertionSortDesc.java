// ===========================================================================================
// 1. Modify the insertion sort algorithm to sort the array in descending order
// ===========================================================================================

public class InsertionSortDesc {

    public static void insertionSortDescending(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6};

        System.out.println("Original Array:");
        printArray(data);

        insertionSortDescending(data);

        System.out.println("Sorted Array (Descending):");
        printArray(data);
    }
}
