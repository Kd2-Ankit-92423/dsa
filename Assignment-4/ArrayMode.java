// ===============================================================z============================
// 4. Calculate the mode of an array. The mode is the element occurred maximum time in the array.
// ===============================================================z============================

public class ArrayMode {
    public static int findMode(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int maxValue = 0;
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = arr[i];
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] data = {2, 5, 2, 8, 5, 2, 1, 9, 2};

        System.out.println("Array: {2, 5, 2, 8, 5, 2, 1, 9, 2}");

        int mode = findMode(data);
        System.out.println("The Mode is: " + mode);
    }
}
