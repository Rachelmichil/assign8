package assign8;
import java.util.Scanner;

public class Fibonacci {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        } else {
            int fib = 0;
            int prev1 = 1;
            int prev2 = 0;

            for (int i = 2; i <= n; i++) {
                fib = prev1 + prev2;
                prev2 = prev1;
                prev1 = fib;
            }

            return fib;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n to compute the nth Fibonacci number: ");
        int n = scanner.nextInt();

        // Using recursive approach
        System.out.println("Using Recursive Approach:");
        long startTimeRecursive = System.nanoTime();
        int fibRecursive = fibonacciRecursive(n);
        long endTimeRecursive = System.nanoTime();
        System.out.println("Fibonacci(" + n + ") = " + fibRecursive);
        System.out.println("Time taken (Recursive): " + (endTimeRecursive - startTimeRecursive) + " nanoseconds");

        // Using iterative approach
        System.out.println("\nUsing Iterative Approach:");
        long startTimeIterative = System.nanoTime();
        int fibIterative = fibonacciIterative(n);
        long endTimeIterative = System.nanoTime();
        System.out.println("Fibonacci(" + n + ") = " + fibIterative);
        System.out.println("Time taken (Iterative): " + (endTimeIterative - startTimeIterative) + " nanoseconds");

        scanner.close();
    }
}

    

