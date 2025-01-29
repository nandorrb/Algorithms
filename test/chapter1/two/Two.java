/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.two;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Two {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        intersectionCalculator(n);
    }

    static void intersectionCalculator(int n) {
        Interval1D[] interval1DS = new Interval1D[n];
        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniformDouble(0, 10);
            double y = x + StdRandom.uniformDouble(0, 10);
            interval1DS[i] = new Interval1D(x, y);
        }

        // Print all pairs that intersect

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    if (interval1DS[i].intersects(interval1DS[j])) {
                        StdOut.println("Intersectinng intervals: " + interval1DS[i] + " <-> "
                                               + interval1DS[j]);
                    }
                    else {
                        StdOut.println("NOT Intersectinng intervals: " + interval1DS[i] + " <-> "
                                               + interval1DS[j]);
                    }
                }
            }
        }
    }
}
