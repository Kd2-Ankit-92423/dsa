// ===========================================================================================
// 1047. Remove All Adjacent Duplicates In String (LEETCODE)
// You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
// We repeatedly make duplicate removals on s until we no longer can.
// Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
// ===========================================================================================

public class RemoveDuplicates {

    public static String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = stack.length();

            if (len > 0 && stack.charAt(len - 1) == c) {
                stack.deleteCharAt(len - 1);
            } else {
                stack.append(c);
            }
        }

        return stack.toString();
    }

    public static void main(String[] args) {
        String input = "abbaca";
        System.out.println("Input: " + input);
        System.out.println("Output: " + removeDuplicates(input));
    }
}
