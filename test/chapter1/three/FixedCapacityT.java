/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package test.chapter1.three;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityT<T> implements Iterable<T> {
    private T[] a;    // holds the items
    private int n;    // number of items in stack

    // Create an empty stack with a given capacity
    public FixedCapacityT(int capacity) {
        a = (T[]) new Object[capacity];   // no generic array creation
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(T item) {
        a[n++] = item;
    }

    public T pop() {
        return a[--n];
    }

    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    // Iterator for array in reverse order
    private class ReverseArrayIterator implements Iterator<T> {
        private int i = n - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(10);
        stack.push("Hello");
        stack.push("World");
        System.out.println("Popped: " + stack.pop());
        System.out.print("Remaining on stack: ");
        for (String s : stack) {
            System.out.print(s + " ");
        }
    }
}
