// ===========================================================================================
// 2. Implement following algorithms for multi digit operands (use space to seperate operands)
// prefix evaluation
// ===========================================================================================


import java.util.Stack;

public class PrefixEval {

    public static int evaluatePrefix(String exp) {
        Stack<Integer> stack = new Stack<>();
        
        //  Split string into tokens
        String[] tokens = exp.split(" ");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isOperator(token)) {
                int val1 = stack.pop(); 
                int val2 = stack.pop();
                
                int result = applyOp(token, val1, val2);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static int applyOp(String op, int a, int b) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        // "- + 10 20 5"
        // Logic: (10 + 20) - 5 = 25
        String expression = "- + 10 20 5";
        System.out.println("Prefix Result: " + evaluatePrefix(expression));
    }
}