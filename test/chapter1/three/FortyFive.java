/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     1/02/2025
 **************************************************************************** */

package test.chapter1.three;

/**
 * 1.3.45
 * Stack generability. Suppose that we have a sequence of intermixed push and pop operations as with
 * our test stack client, where the integers 0, 1, ..., N-1 in that order (push directives) are
 * intermixed with N minus signs (pop directives). Devise an algorithm that determines whether the
 * intermixed sequence causes the stack to underflow. (You may use only an amount of space
 * independent of N—-you cannot store the integers in a data structure.) Devise a linear-time
 * algorithm that determines whether a given permutation can be generated as output by our test
 * client (depending on where the pop directives occur).
 */
public class FortyFive {

    boolean doesSequenceUnderflow(String sequence) {
        String[] sequenceArray = sequence.split(" ");
        int n = sequenceArray.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sequenceArray[i].equals("-")) {
                count--;
            }
            else {
                count++;
            }
            if (count < 0) {
                return true;
            }
        }
        return false;
    }

    boolean doesGivenPermutationMatch(Integer[] permutation) {

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
        FortyFive fortyFive = new FortyFive();
        System.out.println(fortyFive.doesSequenceUnderflow("0 1 2 3 - 4 - - 5 6 7 8 9"));

        Integer[][] permutations = {
                { 0, 1, 2, 3, 4 }, { 4, 3, 2, 1, 0 }, { 1, 0, 3, 2, 4 }, { 2, 3, 1, 4, 0 },
                { 3, 4, 0, 2, 1 }
        };

        for (Integer[] permutation : permutations) {
            System.out.println(fortyFive.doesGivenPermutationMatch(permutation));
        }
    }
}
