/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     2/02/2025
 **************************************************************************** */

package test.chapter1.three;

/**
 * 1.3.48
 * Two stacks with a deque. Implement two stacks with a single deque so that each operation takes a
 * constant number of deque operations (see Exercise 1.3.33).
 */
public class FortyEigth<Item> {
    private Deque<Item> deque = new Deque<>();

    StackWithDeque1 stack1 = new StackWithDeque1();

    StackWithDeque2 stack2 = new StackWithDeque2();

    public static void main(String[] args) {
        FortyEigth<Integer> fortyEigth = new FortyEigth<>();
        fortyEigth.stack1.push(1);
        fortyEigth.stack2.push(2);

        System.out.println(fortyEigth.stack1.pop());
        System.out.println(fortyEigth.stack2.pop());


    }

    private class StackWithDeque1 {
        void push(Item item) {
            deque.pushRight(item);
        }

        Item pop() {
            return deque.popRight();
        }
    }

    private class StackWithDeque2 {
        void push(Item item) {
            deque.pushLeft(item);
        }

        Item pop() {
            return deque.popLeft();
        }
    }
}
