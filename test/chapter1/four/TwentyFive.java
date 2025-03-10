/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     8/03/2025
 **************************************************************************** */

package test.chapter1.four;

/**
 * 1.4.25
 * Throwing two eggs from a building
 * Consider the previous question, but now suppose you only have two eggs and your cost model is
 * the
 * number of thrrows, devise a strategy to determine F such tgat thge nuymber of throwqs is at most
 * 2sqrt(N), then find a way to reduce the cost to ~c*sqrt(F) for some constant c. This is analogous
 * to a situation where search hits(egg intact) are much cheaper than search misses(egg broken)
 */
public class TwentyFive {

    int N;
    int F;

    int eggs = 2;

    public TwentyFive(int N, int F) {
        if (N < 0 || F < 0) throw new IllegalArgumentException("N and F must be positive integers");
        if (F > N) throw new IllegalArgumentException("F must be less than N");
        this.N = N;
        this.F = F;
    }

    public static void main(String[] args) {
        TwentyFive twentyFive = new TwentyFive(100, 10);
        System.out.println(twentyFive.findFloor());

    }

    public int findFloor() {
        int lo = 0;
        int hi = 0;
        int k = 1;
        while (hi < N && !throwEgg(hi)) {
            lo = hi;
            hi = 2 ^ k;
            k++;
        }

        int mid = lo + 1;
        while (lo <= hi) {
            mid = lo + 1;
            if (throwEgg(mid)) {
                return mid;

            }
            else {
                // Unbroken eggs
                lo++;
            }

        }
        return mid;
    }

    public boolean throwEgg(int floor) {
        if (stillHaveEggs()) {
            boolean eggHasBeenBroke = floor >= F;
            if (eggHasBeenBroke) {
                eggs--;
            }
            return eggHasBeenBroke;
        }
        throw new IndexOutOfBoundsException("No more eggs");
    }

    public boolean stillHaveEggs() {
        return eggs > 0;

    }
}
