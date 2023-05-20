// printing pascal triangle using Recursion concept
import java.util.Scanner;

public class PascalTriangleRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		// To take no.of rows as input from user
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        printPascalTriangle(rows);
        scanner.close();
    }

    public static void printPascalTriangle(int rows) {
        for (int i = 0; i < rows; i++) {
            // Print spaces for left-aligning the triangle
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }
            // Print each number in the row
            for (int j = 0; j <= i; j++) {
                System.out.print(pascalValue(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static int pascalValue(int row, int col) {
        if (col == 0 || col == row) {
            return 1; // The first and last element in each row is 1
        } else {
            // Recursively calculate the value using the previous row
            return pascalValue(row - 1, col - 1) + pascalValue(row - 1, col);
        }
    }
}
