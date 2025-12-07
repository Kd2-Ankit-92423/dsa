// ===========================================================================================
// 2. Implement following algorithms for multi digit operands (use space to seperate operands)
// postfix evaluation
// ===========================================================================================


import java.util.Stack;

public class PostfixEval {
    
    public static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();
        
        // Split string by space to get multi-digit numbers
        String[] tokens = exp.split(" ");
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int val2 = stack.pop(); 
                int val1 = stack.pop(); 
                
                int result = applyOp(token, val1, val2);
                stack.push(result);
            } 
            else {
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
        // "100 + 200 / 2" -> 100 200 + 2 / 
        // Logic: (100 + 200) / 2 = 150
        String expression = "100 200 + 2 /";
        System.out.println("Postfix Result: " + evaluatePostfix(expression));
    }
}