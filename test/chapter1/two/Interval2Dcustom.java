/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.two;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;

public class Interval2Dcustom {
    public Interval1D x;
    public Interval1D y;
    public Interval2D r;

    Interval2Dcustom(Interval1D px, Interval1D py) {
        x = px;
        y = py;
        r = new Interval2D(px, py);
    }

    public boolean contains(Interval2Dcustom that) {
        if (!this.r.contains(new Point2D(that.x.min(), that.y.min()))) return false;
        if (!this.r.contains(new Point2D(that.x.max(), that.y.max()))) return false;
        return true;
    }

    public void draw() {
        r.draw();
    }

    public boolean intersects(Interval2Dcustom interval2D) {
        return r.intersects(interval2D.r);
    }
}
