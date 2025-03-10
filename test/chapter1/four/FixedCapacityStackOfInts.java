/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     9/03/2025
 **************************************************************************** */

package test.chapter1.four;

public class FixedCapacityStackOfInts {
    private int[] a;    // holds the items
    private int n;       // number of items in stack

    // create an empty stack with given capacity
    public FixedCapacityStackOfInts(int capacity) {
        a = new int[capacity];   // no generic array creation
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(int item) {
        a[n++] = item;
    }

    public int pop() {
        return a[--n];
    }

    public static void main(String[] args) {
        FixedCapacityStackOfInts stack = new FixedCapacityStackOfInts(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}