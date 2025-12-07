// ===========================================================================================
// 2. Write a recursive method to find nth term of fibbonacci series
// ===========================================================================================

import java.util.Scanner;

public class RecursiveFibonacci {

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            System.out.println("The " + n + "th Fibonacci term is: " + fib(n));
        }

        sc.close();
    }
}
