/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     2/02/2025
 **************************************************************************** */

package test.chapter1.three;

/**
 * 1.3.47
 * Catenable queues, stacks, or steques. Add an extra operation catenation that (destructively)
 * concatenates two queues, stacks or steques (see Exercise 1.3.32).
 */
public class FortySeven<Item> {
    /**
     * This method concatenates two stacks.
     *
     * @param stack1 first stack
     * @param stack2 second stack
     * @return a new stack with the elements of the two stacks
     */
    Stack<Item> catenation(Stack<Item> stack1, Stack<Item> stack2) {
        Stack<Item> temp = new Stack<>();
        Stack<Item> solution = new Stack<>();
        while (!stack1.isEmpty()) {
            temp.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            temp.push(stack2.pop());
        }
        while (!temp.isEmpty()) {
            solution.push(temp.pop());
        }
        return solution;
    }

    public static void main(String[] args) {

    }
}
