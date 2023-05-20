// printing pascal triangle using iterations

import java.util.Scanner;

class PascalTriangleIterations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: "); // enter required no.of rows
        int n = scanner.nextInt();

        printPascal(n);

        scanner.close();
    }

    // Pascal function which prints the required triangle
    public static void printPascal(int n) {
        for (int line = 1; line <= n; line++) {
            for (int j = 0; j <= n - line; j++) {
                // for left spacing along the triangle
                System.out.print(" ");
            }

            int C = 1; // Initialize C to 1

            for (int i = 1; i <= line; i++) {
                System.out.print(C + " "); // Print current value of C (combination value)
                C = C * (line - i) / i; // Calculate the next value of C based on the previous value
            }

            System.out.println();
        }
    }
}

