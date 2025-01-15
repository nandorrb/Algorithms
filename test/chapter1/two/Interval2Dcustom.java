/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
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
