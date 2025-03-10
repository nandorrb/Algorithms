package test.chapter1.four;

import java.util.stream.IntStream;

/**
 * Binary search for a fraction. Devise a methid that uses a logarithmic number of queries of the
 * form
 * <p>Is the number less than x?< /p>
 * to find a rational number p/q such that 0<p<q<N .
 * Hint : Two fractions with denominations less than N cannot differ by more than 1/N^2.
 */
public class TwentyThree {
    record SolutionObject(
            int p,
            int q
    ) {
    }

    // public static int indexOf(int[] a, int key) {
    //     int lo = 0;
    //     int hi = a.length - 1;
    //     while (lo <= hi) {
    //         int mid = lo + (hi - lo) / 2;
    //         if (key < a[mid]) hi = mid - 1;
    //         else if (key > a[mid]) lo = mid + 1;
    //         else return mid;
    //     }
    //     return -1;
    // }

    public static SolutionObject findClosesFraction(float x, int N) {
        int[] pool = IntStream.range(1, N).toArray();
        int n1;
        int n2;
        int p = 0;
        int q = 0;
        int lo1 = 0;
        int hi1 = pool.length - 1;
        int lo2 = 0;
        int hi2 = pool.length - 1;

        while (lo1 <= hi1 && lo2 <= hi2) {
            n1 = lo1 + (hi1 - lo1) / 2;
            n2 = lo2 + (hi2 - lo2) / 2;

            p = pool[n1];
            q = pool[n2];

            double currentValue = ((double) p) / ((double) q);

            // Add logic to adjust n1 and n2 based on currentValue and x
            // For example:
            if (currentValue < x) {
                // increase numerator and reduce denominator
                lo1 = n1 + 1;
                hi2 = n2 - 1;
            }
            else if (currentValue > x) {
                // reduce numerator increase denominator
                hi1 = n1 - 1;
                lo2 = n2 + 1;
            }
            else {
                break;
            }
        }


        SolutionObject solutionObject = new SolutionObject(p, q);
        return solutionObject;
    }

    public static void main(String[] args) {
        System.out.println(findClosesFraction(0.423F, 50000));
    }
}
