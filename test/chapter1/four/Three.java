/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     7/02/2025
 **************************************************************************** */

package test.chapter1.four;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.awt.Color;

/**
 * 1.4.3 Modify DoublingTest to use StdDraw to produce plots like the standard and log-log plots in
 * the text, rescaling as necessary so that the plot always fills a substantial portion of the
 * window.
 */
public class Three {
    private static final int MAXIMUM_INTEGER = 1000000;

    // This class should not be instantiated.
    private Three() {
    }

    /**
     * Returns the amount of time to call {@code ThreeSum.count()} with <em>n</em>
     * random 6-digit integers.
     *
     * @param n the number of integers
     * @return amount of time (in seconds) to call {@code ThreeSum.count()}
     * with <em>n</em> random 6-digit integers
     */
    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        int ignore = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void drawLogLog(int N) {
        StdDraw.setCanvasSize(200, 600);
        StdDraw.setXscale(Math.log(128), Math.log(N));
        StdDraw.setYscale(-10, 10);
        double x0 = 0;
        double y0 = 0;
        for (int n = 250; n <= N; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %5.1f\n", n, time);
            double x1 = Math.log(n);
            double y1 = Math.log(time);
            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(x1, y1);
            if (x0 == 0 && y0 == 0) {

            }
            else {
                StdDraw.setPenRadius(0.001);
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.line(x0, y0, x1, y1);
            }
            x0 = x1;
            y0 = y1;
        }
    }

    public static void drawStandard(int N) {
        StdDraw.setCanvasSize(400, 400);
        StdDraw.setXscale(0, 10000);
        StdDraw.setYscale(0, 100);
        double x0 = 0;
        double y0 = 0;
        for (int n = 250; n <= N; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %5.1f\n", n, time);
            double x1 = n;
            double y1 = time;
            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(x1, y1);
            if (x0 == 0 && y0 == 0) {

            }
            else {
                StdDraw.setPenRadius(0.001);
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.line(x0, y0, x1, y1);
            }
            x0 = x1;
            y0 = y1;
        }
    }

    /**
     * Prints table of running times to call {@code ThreeSum.count()}
     * for arrays of size 250, 500, 1000, 2000, and so forth.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int N = 100000;
        // drawLogLog(N);
        drawStandard(N);
    }
}
