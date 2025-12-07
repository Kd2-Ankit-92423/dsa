// ===========================================================================================
// 8. find the first non-repeating element: Input: { 1, 2, 3, -1, 2, 1, 0, 4, -1, 7, 8 } Ouput: 3
// ===========================================================================================

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {

    public static int findFirstUnique(int[] arr) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        for (int num : arr) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, -1, 2, 1, 0, 4, -1, 7, 8};

        System.out.println("Input Array: { 1, 2, 3, -1, 2, 1, 0, 4, -1, 7, 8 }");

        int result = findFirstUnique(data);

        if (result != Integer.MIN_VALUE) {
            System.out.println("First non-repeating element is: " + result);
        } else {
            System.out.println("No unique elements found.");
        }
    }
}
