/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.one;

public class RelativePrimes {


    private static boolean[] factors(int target, int n) {
        boolean[] results = new boolean[n];
        for (int i = 1; i <= target; i++) {
            // we start from 2
            // int mask = i + 2;
            if (target % i == 0) {
                results[i - 1] = true;
            }
            else {
                results[i - 1] = false;
            }
        }
        return results;
    }


    // XOR operation for two boolean arrays
    private static boolean[] xor(boolean[] factors1, boolean[] factors2) {
        if (factors1.length != factors2.length) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }

        boolean[] result = new boolean[factors1.length];
        for (int i = 0; i < factors1.length; i++) {
            result[i] = factors1[i] ^ factors2[i]; // Perform XOR on each element
        }
        return result;
    }


    // XOR operation for two boolean arrays
    private static boolean[] or(boolean[] factors1, boolean[] factors2) {
        if (factors1.length != factors2.length) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }

        boolean[] result = new boolean[factors1.length];
        for (int i = 0; i < factors1.length; i++) {
            result[i] = factors1[i] || factors2[i]; // Perform OR on each element
        }
        return result;
    }


    private static boolean areRelativePrime(int target1, int target2, int n) {
        boolean[] factors1 = factors(target1, n);
        boolean[] factors2 = factors(target2, n);

        // exclude 1
        boolean[] solution = or(factors1, factors2);

        int cunt1 = 0;
        int cunt2 = 0;
        int cunt3 = 0;
        for (int i = 1; i < n; i++) {
            if (solution[i]) {
                cunt1++;
            }
            if (factors1[i]) {
                cunt2++;
            }
            if (factors2[i]) {
                cunt3++;
            }

        }

        return cunt1 == cunt2 + cunt3;
    }

    private static boolean[][] getMatrix(int n) {
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = areRelativePrime(i, j, n);
            }

        }
        return matrix;
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        boolean[][] matrix = getMatrix(n);


        printMatrix(matrix); // Print the matrix nicely
    }

    // Function to print the 2D boolean array in a readable format
    private static void printMatrix(boolean[][] matrix) {
        for (boolean[] row : matrix) {
            for (boolean value : row) {
                // Print "1" for true and "0" for false, separated by spaces
                System.out.print(value ? "1 " : "0 ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }


}
