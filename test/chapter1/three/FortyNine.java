/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     2/02/2025
 **************************************************************************** */

package test.chapter1.three;

/**
 * 1.3.49
 * Queue with a constant number of stacks. Implement a queue with a constant number of stacks so
 * that each queue operation takes a constant (worst-case) number of stack operations.
 * Warning: high degree of difficulty.
 */
public class FortyNine<Item> {
    private Stack<Item> stack1 = new Stack<>();
    private Stack<Item> stack2 = new Stack<>();
    private Stack<Item> stack3 = new Stack<>();

    public void enqueue(Item item) {
        stack1.push(item);
        while (!stack3.isEmpty()) {
            stack2.push(stack3.pop());
        }
        stack3.push(stack1.pop());
        while (!stack2.isEmpty()) {
            stack3.push(stack2.pop());
        }
    }

    public Item dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stack3.pop();
    }

    public static void main(String[] args) {
        FortyNine<Integer> queue = new FortyNine<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
