/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package test.chapter1.three;

import java.util.Iterator;
import java.util.NoSuchElementException;

// This Queue forgets the first element when it is full
public class FixedCapacityQueue<T> implements Iterable<T> {

    private T[] items;
    private int positionHead = 0;
    private int positionTail = 0;

    public FixedCapacityQueue(int capacity) {
        items = (T[]) new Object[capacity];
    }

    public void enqueue(T item) {
        items[positionTail] = item;
        positionTail++;

        if (positionTail == items.length) {
            positionTail = 0;
        }
        if (positionTail == positionHead) {
            positionHead++;
        }

        if (positionHead == items.length) {
            positionHead = 0;
        }
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
        FixedCapacityQueue<String>
                queue = new FixedCapacityQueue<>(2);

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
