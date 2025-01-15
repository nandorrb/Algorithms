/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package test.chapter1.two;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Three {
    public static void main(String[] args) {
        // n,min,max
        int n = StdIn.readInt();
        int min = StdIn.readInt();
        int max = StdIn.readInt();
        // n random Interval2D
        Interval2Dcustom[] interval2DS = new Interval2Dcustom[n];

        for (int i = 0; i < n; i++) {

            Interval1D x = getInterval(min, max);
            Interval1D y = getInterval(min, max);
            interval2DS[i] = new Interval2Dcustom(x, y);
            // draw then std draw
            interval2DS[i].draw();
        }


        // number of intersected pairs, number of contained
        int intercepted = 0;
        int contained = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (interval2DS[i].intersects(interval2DS[j])) {
                    intercepted++;
                }

                if (interval2DS[i].contains(interval2DS[j])) {
                    contained++;
                }


            }
        }
        // draw then std draw
        StdOut.printf(" intercepted = %d , contained =  %d %n", intercepted, contained);
    }

    private static Interval1D getInterval(double min, double max) {
        double media = (max - min) / 2;
        double x1 = StdRandom.uniformDouble(min, media);
        double x2 = StdRandom.uniformDouble(media, max);
        return new Interval1D(x1, x2);

    }
}
