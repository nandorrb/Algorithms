/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     22/02/2025
 **************************************************************************** */

package test.chapter1.four;

/**
 * 1.4.19 Local minimum of a matrix. Given an N-by-N array a[] of N^2 distinct integers, design an
 * algorithm that finds a strict local minimum: an entry a[i][j] that is strictly less than its
 * neighbors. Internal entries have 4 neighbors; entries on an edge have 3 neighbors; entries at a
 * corner have 2 neighbors.
 * The running time of your program should be proportional to N in the worst case, which means that
 * you cannot afford to examine all n^2 entries.
 */
public class Nineteen {
    int n;
    int loX = 0;
    int hiX;
    int loY = 0;
    int hiY;

    int min = Integer.MAX_VALUE;
    int midX;
    int midY;

    int[][] a;

    public Nineteen(int[][] a) {
        this.a = a;
        n = a.length;
        hiX = n - 1;
        hiY = n - 1;
    }

    public int localMinimum() {

        while (loX <= hiX && loY <= hiY) {
            midX = loX + (hiX - loX) / 2;
            midY = loY + (hiY - loY) / 2;

            if (a[midX][midY] < min) {
                min = a[midX][midY];
            }

            // corners
            if ((midX == 0 && midY == 0) ||
                    (midX == 0 && midY == n - 1) ||
                    (midX == n - 1 && midY == 0) ||
                    (midX == n - 1 && midY == n - 1)) {
                return min;

            }
            else if (midX == 0 || midY == 0
                    || midY == n - 1 ||
                    midX == n - 1) // edge
            {
                if (midX == 0 || midX == n - 1) {
                    if (midX == 0 && (a[midX][midY] < a[midX + 1][midY] &&
                            a[midX][midY] < a[midX][midY + 1] &&
                            a[midX][midY] < a[midX][midY - 1])
                    ) {
                        return min;
                    }
                    else if (midX == n - 1 && (a[midX][midY] < a[midX - 1][midY] &&
                            a[midX][midY] < a[midX][midY + 1] &&
                            a[midX][midY] < a[midX][midY - 1])) {
                        return min;
                    }
                    else {
                        moveInY();
                    }
                }
                else {
                    if (midY == 0 && (a[midX][midY] < a[midX][midY + 1] &&
                            a[midX][midY] < a[midX + 1][midY] &&
                            a[midX][midY] < a[midX - 1][midY])
                    ) {
                        return min;
                    }
                    else if (midY == n - 1 && (a[midX][midY] < a[midX][midY - 1] &&
                            a[midX][midY] < a[midX + 1][midY] &&
                            a[midX][midY] < a[midX - 1][midY])) {
                        return min;
                    }
                    else {
                        moveInX();
                    }

                }
            }
            else {
                if (a[midX][midY] < a[midX - 1][midY] &&
                        a[midX][midY] < a[midX + 1][midY] &&
                        a[midX][midY] < a[midX][midY - 1] &&
                        a[midX][midY] < a[midX][midY + 1]) {
                    return min;
                }
                else {
                    moveInY();
                    moveInX();
                }
            }
        }

        return min;
    }

    private void moveInX() {
        if (a[midX - 1][midY] < a[midX][midY]) {
            hiX = midX - 1;
        }
        else {
            loX = midX + 1;
        }
    }

    private void moveInY() {
        if (a[midX][midY - 1] < a[midX][midY]) {
            hiY = midY - 1;
        }
        else {
            loY = midY + 1;
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
