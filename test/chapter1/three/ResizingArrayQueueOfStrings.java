/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package test.chapter1.three;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueueOfStrings<T> implements Iterable<T> {

    private int initialCapacity = 1;
    private T[] items = (T[]) new Object[initialCapacity];
    private int positionHead = 0;
    private int positionTail = 0;

    public void enqueue(T item) {
        if (((positionTail + 1) == positionHead) || ((positionTail + 1 - items.length)
                == positionHead)) {
            resize(2 * items.length);
        }

        items[positionTail] = item;
        positionTail++;

        if (positionTail == items.length) {
            positionTail = 0;
        }
    }

    private void resize(int i) {
        T[] copy = (T[]) new Object[i];
        for (int j = 0; j < items.length; j++) {
            copy[j] = items[j];
        }
        items = copy;
    }

    public T dequeue() {
        if (positionTail == positionHead) {
            throw new NoSuchElementException("Queue is empty");
        }

        T result = items[positionHead];
        items[positionHead] = null;
        positionHead++;

        if (positionHead == items.length) {
            positionHead = 0;
        }

        return result;
    }


    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private int current;

        public ListIterator() {
            current = positionHead;
        }


        public boolean hasNext() {
            return current != positionTail;
        }


        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T item = items[current];
            current = (current + 1) % items.length;
            return item;
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings<String> queue = new ResizingArrayQueueOfStrings<>();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");


        System.out.println("Dequeue: " + queue.dequeue());
        queue.enqueue("D");

        for (String item : queue) {
            System.out.println(item);
        }
    }
}
