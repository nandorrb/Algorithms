/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.three;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * Using readAllInts() on page 126 as a model, write a static method readAllDates() for Date that
 * reads dates from standard input in the format specified in the table on page 119 and returns an
 * array containing them.
 */
public class Sixteen {
    public static int[] readAllInts(String name) {
        In in = new In(name);
        Queue<Integer> q = new Queue<Integer>();
        while (!in.isEmpty())
            q.enqueue(in.readInt());
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue();
        return a;
    }

    // 5/22/1939
    static Date[] readAllDates(String name) {
        In in = new In(name);
        Queue<Date> q = new Queue<Date>();
        while (!in.isEmpty())
            q.enqueue(new Date(in.readString()));
        int N = q.size();
        Date[] a = new Date[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue();
        return a;
    }

    public static void main(String[] args) {


    }
}
