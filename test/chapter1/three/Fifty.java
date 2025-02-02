/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     2/02/2025
 **************************************************************************** */

package test.chapter1.three;

import java.util.Iterator;

/**
 * 1.3.50
 * Fail-fast iterator. Modify the iterator code in Stack to immediately throw a
 * java.util.ConcurrentModificationException
 * if the client modifies the collection (via push() or pop()) during iteration.
 * <p>
 * Solution: Maintain a counter that counts the number of push() and pop() operations. When creating
 * an iterator, store this value as an Iterator instance variable. Before each call to hasNext() or
 * next(), check that this value has not changed since construction of the iterator; if it has,
 * throw the exception.
 */
public class Fifty<Item> extends Stack<Item> {
    private int pushCounter = 0;
    private int popCounter = 0;

    @Override
    public void push(Item item) {
        super.push(item);
        pushCounter++;
    }

    @Override
    public Item pop() {
        popCounter++;
        return super.pop();
    }

    @Override
    public Iterator<Item> iterator() {
        return new FailfastIterator();
    }

    public static void main(String[] args) {

    }

    private class FailfastIterator implements Iterator<Item> {
        private int pushCounterIterator = pushCounter;
        private int popCounterIterator = popCounter;
        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            if (pushCounterIterator != pushCounter || popCounterIterator != popCounter) {
                throw new java.util.ConcurrentModificationException();
            }
            return current != null;
        }

        @Override
        public Item next() {
            if (pushCounterIterator != pushCounter || popCounterIterator != popCounter) {
                throw new java.util.ConcurrentModificationException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
