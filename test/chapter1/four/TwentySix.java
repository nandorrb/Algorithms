/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     9/03/2025
 **************************************************************************** */

package test.chapter1.four;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1.4.26
 * 3-colinearity
 * Suppose that you have an algorithm that takes as input N distinct points in the plane and can
 * return the number of triples that fall on the same line. Show that you can use this algorithm to
 * solve the 3-sum problem.
 * Strong hint: Use algebra to show that (a,a^3), (b,b^3), and (c,c^3) are collinear if and only if
 * a+b+c=0.
 */
public class TwentySix {
    Point2D[] points;

    public TwentySix(Point2D[] points) {
        this.points = Arrays.stream(points).sorted(Point2D::compareTo).toArray(Point2D[]::new);
    }

    private double angleTo(Point2D a, Point2D b) {
        double dx = a.x() - b.x();
        double dy = a.y() - b.y();
        return Math.atan2(dy, dx);
    }

    private double angleAbsTo(Point2D a, Point2D b) {
        return Math.abs(angleTo(a, b));
    }

    public int numberOfPointsInALineBruteForce() {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            Point2D point1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point2D point2 = points[j];
                for (int k = j + 1; k < points.length; k++) {
                    Point2D point3 = points[k];
                    if (angleAbsTo(point1, point2) == angleAbsTo(point2, point3)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int numberOfPointsInALine() {
        int count = 0;

        for (int i = 0; i < points.length; i++) {
            Point2D a = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point2D b = points[j];
                double x = (-a.x() - b.x());
                double y = Math.pow(x, 3);
                Point2D c = new Point2D(x, y);
                if (Arrays.binarySearch(points, c, Point2D::compareTo) >= 0) {
                    count++;
                }
            }
        }

        return count;

    }

    public Point2D[] getPoints() {
        return points;
    }

    public static void main(String[] args) {
        int N = 5;
        int x0 = -100;
        int x1 = 100;
        int y0 = -100;
        int y1 = 100;

        List<Point2D> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Point2D point2D = new Point2D(StdRandom.uniformInt(x0, x1),
                                          StdRandom.uniformInt(y0, y1));
            list.add(point2D);
        }

        list.add(new Point2D(1, 1));
        list.add(new Point2D(0, 0));

        list.add(new Point2D(3, 3));
        list.add(new Point2D(4, 4));
        list.add(new Point2D(2, 2));
        list.add(new Point2D(-1, -1));


        TwentySix twentySix = new TwentySix(list.toArray(Point2D[]::new));

        System.out.println(twentySix.numberOfPointsInALineBruteForce());
        System.out.println(twentySix.numberOfPointsInALine());
        // System.out.println("Before sorting");
        // for (Point2D point : list) {
        //     System.out.println(point);
        // }
        // System.out.println("After sorting");
        // for (Point2D point : twentySix.getPoints()) {
        //     System.out.println(point);
        // }

        // System.out.println(twentySix.numberOfPointsInALine());

    }
}
