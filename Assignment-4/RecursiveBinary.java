// ===========================================================================================
// 1. Write a recursive method to print binary of decimal.
// ===========================================================================================

import java.util.Scanner;

public class RecursiveBinary {

    public static void printBinary(int n) {
        if (n == 0) {
            return;
        }
        printBinary(n / 2);
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter decimal number: ");
        int num = sc.nextInt();

        System.out.print("Binary of " + num + " is: ");

        if (num == 0) {
            System.out.print("0");
        } else {
            printBinary(num);
        }

        System.out.println();
        sc.close();
    }
}
