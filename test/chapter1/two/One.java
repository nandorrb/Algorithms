/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.two;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class One {
    static double distanceCalculator(int n) {
        // Generate n random points
        Point2D[] randomPoints = new Point2D[n];
        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniformDouble();
            double y = StdRandom.uniformDouble();

            randomPoints[i] = new Point2D(x, y);

        }

        // Print the closest points and distance between them
        double distanceMin = 5;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double distance = randomPoints[i].distanceTo(randomPoints[j]);
                if (distance < distanceMin && i != j) {
                    distanceMin = distance;
                }
            }
        }
        return distanceMin;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        double distanceMin = distanceCalculator(n);
        StdOut.printf("Min Distance  = %f,  %n", distanceMin);
    }
}
