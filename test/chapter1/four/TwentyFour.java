/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     8/03/2025
 **************************************************************************** */

package test.chapter1.four;

/**
 * 1.4.24
 * Throwing eggs from a building
 * Suppose that  you have an n story building and plenty of eggs suppose also that an egg is broken
 * if it is thrown off floor f or higher and unbroken otherwise. First devise a strategy to
 * determine the value if f such that the number of broken eggs is lgn when suing lg n  throws then
 * find a way to reduce  the cost to 2 log F when n us much larger than F
 */
public class TwentyFour {

    int N;
    int F;


    public TwentyFour(int N, int F) {
        if (N < 0 || F < 0) throw new IllegalArgumentException("N and F must be positive integers");
        if (F > N) throw new IllegalArgumentException("F must be less than N");
        this.N = N;
        this.F = F;
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

    private boolean isBroken(int floor) {
        return floor >= F;
    }

    public int findFloor() {
        int lo = 0;
        int hi = N;
        int mid = -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (isBroken(mid)) {
                // Broken eggs
                if (!isBroken(mid - 1)) {
                    return mid;
                }
                else {
                    hi = mid - 1;
                }
            }
            else {
                // Unbroken eggs
                lo = mid + 1;
            }

        }
        return mid;

    }

    public int findFloor2() {
        int eggPoint = 0;
        int k = 1;
        while (eggPoint < N && !isBroken(eggPoint)) {
            eggPoint = 2 ^ k;
            k++;
        }


        int lo = 0;
        int hi = eggPoint;
        int mid = -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (isBroken(mid)) {
                // Broken eggs
                if (!isBroken(mid - 1)) {
                    return mid;
                }
                else {
                    hi = mid - 1;
                }
            }
            else {
                // Unbroken eggs
                lo = mid + 1;
            }

        }
        return mid;

    }


    public static void main(String[] args) {
        TwentyFour twentyFour = new TwentyFour(10000, 37);
        System.out.println(twentyFour.findFloor());
        System.out.println(twentyFour.findFloor2());


    }
}
