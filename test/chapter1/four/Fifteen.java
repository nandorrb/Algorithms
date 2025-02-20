/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     16/02/2025
 **************************************************************************** */

package test.chapter1.four;


import edu.princeton.cs.algs4.BinarySearch;

/**
 * 1.4.15
 * Faster 3-sum. As a warmup, develop an implementation TwoSumFaster that uses a linear algorithm to
 * count the pairs that sum to zero after the array is sorted (instead of the binary-search-based
 * linearithmic algorithm). Then apply a similar idea to develop a quadratic algorithm for the 3-sum
 * problem.
 */
public class Fifteen {
    public class TwoSumFaster {
        public static int countTwoSumLinearitmic(int[] a) {
            int n = a.length;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (BinarySearch.rank(-a[i], a) > i) {
                    count++;
                }
            }
            return count;
        }

        public static int countTwoSumLinear(int[] a) {
            int cnt = 0;
            int len = a.length;
            for (int j = 0, k = len - 1; j < k; ) {
                if (a[j] + a[k] < 0) {
                    j++;
                }
                else if (a[j] + a[k] > 0) {
                    k--;
                }
                else {
                    j++;
                    k--;
                    ++cnt;
                }
            }
            return cnt;
        }

        public static int threeSumQuadratic(int[] a) {
            int n = a.length;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0, k = n - 1; j < k; ) {
                    if (a[j] + a[k] < 0) {
                        j++;
                    }
                    else if (a[j] + a[k] > 0) {
                        k--;
                    }
                    else {
                        j++;
                        k--;
                        ++cnt;
                    }
                }
            }
            return cnt;
        }

    }

    public static void main(String[] args) {
        int[] a = { -40, -20, -10, 0, 5, 10, 30, 40 };

        System.out.println(
                "Number of pairs that sum to zero countLinear: " + TwoSumFaster.countTwoSumLinear(
                        a));
        System.out.println("Number of pairs that sum to zero countLinearitmic: "
                                   + TwoSumFaster.countTwoSumLinearitmic(a));
        System.out.println("Number of pairs that sum to zero threeSumQuadratic: "
                                   + TwoSumFaster.threeSumQuadratic(a));

    }
}
