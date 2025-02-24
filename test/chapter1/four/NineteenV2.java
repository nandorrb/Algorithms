/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     23/02/2025
 **************************************************************************** */

package test.chapter1.four;

public class NineteenV2 {
    int[][] a;
    int n;

    public NineteenV2(int[][] a) {
        this.a = a;
        this.n = a.length;
    }

    public int localMinimum() {
        return findLocalMinimum(0, n - 1, 0, n - 1);
    }

    private int findLocalMinimum(int loX, int hiX, int loY, int hiY) {
        int midX = loX + (hiX - loX) / 2;
        int midY = loY + (hiY - loY) / 2;

        int minX = midX;
        int minY = midY;

        // Find the minimum in the middle row
        for (int j = loY; j <= hiY; j++) {
            if (a[midX][j] < a[minX][minY]) {
                minX = midX;
                minY = j;
            }
        }

        // Find the minimum in the middle column
        for (int i = loX; i <= hiX; i++) {
            if (a[i][midY] < a[minX][minY]) {
                minX = i;
                minY = midY;
            }
        }

        // Check if the found minimum is a local minimum
        if ((minX == 0 || a[minX][minY] < a[minX - 1][minY]) &&
                (minX == n - 1 || a[minX][minY] < a[minX + 1][minY]) &&
                (minY == 0 || a[minX][minY] < a[minX][minY - 1]) &&
                (minY == n - 1 || a[minX][minY] < a[minX][minY + 1])) {
            return a[minX][minY];
        }

        // Move to the quadrant with the smaller neighbor
        if (minX > 0 && a[minX - 1][minY] < a[minX][minY]) {
            return findLocalMinimum(loX, midX - 1, loY, hiY);
        }
        else if (minX < n - 1 && a[minX + 1][minY] < a[minX][minY]) {
            return findLocalMinimum(midX + 1, hiX, loY, hiY);
        }
        else if (minY > 0 && a[minX][minY - 1] < a[minX][minY]) {
            return findLocalMinimum(loX, hiX, loY, midY - 1);
        }
        else {
            return findLocalMinimum(loX, hiX, midY + 1, hiY);
        }
    }

    public static void main(String[] args) {
        int[][] testA = {
                { 9, 8, 4, 61, 9, 8, 3, 2, 1 },
                { 9, 8, 7, 62, 9, 8, 3, 2, 1 },
                { 9, 8, 7, 63, 9, 8, 3, 2, 1 },
                { 9, 8, 7, 64, 9, 8, 3, 2, 1 },
                { 9, 8, 7, 70, 71, 8, 3, 2, 1 },
                { 9, 8, 7, 69, 9, 8, 3, 2, 1 },
                { 9, 8, 7, 68, 9, 8, 3, 2, 1 },
                { 9, 8, 7, 67, 9, 8, 3, 0, 1 },
                { 9, 8, 4, 65, 9, 8, 3, 2, 1 }
        };

        Nineteen nineteen = new Nineteen(testA);
        System.out.println("Local minimum: " + nineteen.localMinimum());
    }
}