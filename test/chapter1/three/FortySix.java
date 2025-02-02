/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     2/02/2025
 **************************************************************************** */

package test.chapter1.three;

/**
 * 1.3.46
 * Forbidden triple for stack generality. Prove that a permutation can be generated by a
 * stack(as in the previous question) if and only if it has no forbidden triple(a,b,c) such that
 * a<b<c with
 * c  first, a second, and b third ( possibly with other intervening integers between c and a and
 * between a and b).
 * Partial solution: Suppose that a permutation has a forbidden triple (a, b, c) . Item c is popped
 * before a and b, but a and b are pushed  before c. Thus, when c is pushed, both  a and b are on
 * the stack. Therefore, a cannot be popped  before b.
 */
public class FortySix {

    boolean permutationCanBeGenerated(Integer[] permutation) {
        FortyTwo.Stack<Integer> stack = new FortyTwo.Stack<>();
        int counter = 0;
        for (int i : permutation) {
            if ((stack.isEmpty() || stack.peek() < i) && counter <= i) {
                {
                    while (counter <= i) {
                        stack.push(counter);
                        counter++;
                    }
                    stack.pop();
                }
            }
            else {
                if (stack.pop() != i) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // it just is impossiblle, second sentence explains it well

    }
}
