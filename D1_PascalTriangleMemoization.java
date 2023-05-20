// printing pascal triangle using memoization concept

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PascalTriangleMemoization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: "); // enter required no.of rows (by user)
        int rows = scanner.nextInt();

        printPascalTriangle(rows);

        scanner.close();
    }

    public static void printPascalTriangle(int rows) {
        Map<String, Integer> memo = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            // Print spaces for left-aligning the triangle
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }
            // Print each number in the row
            for (int j = 0; j <= i; j++) {
                int value = pascalValue(i, j, memo);
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    // method to get the values for pascals triangle
    public static int pascalValue(int row, int col, Map<String, Integer> memo) {
        String key = row + "," + col;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (col == 0 || col == row) {
            return 1; // The first and last element in each row is 1
        } else {
            // Recursively calculate the value using the previous row
            int value = pascalValue(row - 1, col - 1, memo) + pascalValue(row - 1, col, memo);
            memo.put(key, value);	// storing generated values which can be reusable if required again
            return value;
        }
    }
}
