/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     30/01/2025
 **************************************************************************** */

package test.chapter1.three;

import java.util.Iterator;

/**
 * 1.3.38
 * Delete kth element. Implement a class that supports the following API:
 * GeneralizedQueue() create an empty queue
 * <p>
 * boolean isEmpty() is the queue empty?
 * void insert(Item x) add an item
 * Item delete(int k) delete and return the kth least recently inserted item
 * <p>
 * First, develop an implementation that uses an array implementation, and then develop one that
 * uses a linked-list implementation. Note: the algorithms and data structures that we introduce in
 * CHAPTER 3 make it possible to develop an implementation that can guarantee that both insert() and
 * delete() take time proportional to the logarithm of the number of items in the queue—see EXERCISE
 * 3.5.27.
 */
public class GeneralizedQueue {

    interface GeneralizedQueueInterface<Item> {
        boolean isEmpty();

        void insert(Item x);

        Item delete(int k);
    }

    class LinkedListImplementation<Item>
            implements GeneralizedQueueInterface<Item>, Iterable<Item> {
        public Iterator<Item> iterator() {
            return new LinkedListImplementationIterator();

        }

        class Node {
            Item item;
            Node next;
        }

        Node first;
        int size;

        public boolean isEmpty() {
            return size == 0;
        }

        public void insert(Item x) {
            Node newNode = new Node();
            newNode.item = x;
            if (first == null) {
                first = newNode;
                first.next = first;
            }
            else {
                newNode.next = first.next;
                first.next = newNode;
            }
            size++;

        }

        public Item delete(int k) {
            if (k > size) {
                return null;
            }
            else {
                Node previous = first;
                for (int i = 0; i < k; i++) {
                    previous = previous.next;

                }
                Node current = previous.next;

                previous.next = current.next;
                size--;
                return current.item;
            }
        }

        private class LinkedListImplementationIterator implements Iterator<Item> {
            Node current = first;
            boolean firstIteration = true;

            public boolean hasNext() {
                return firstIteration || current != first;
            }

            public Item next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more items to return.");
                }
                current = current.next;
                Item item = current.item;
                firstIteration = false;
                return item;

            }
        }
    }

    class ArrayImplementation<Item> implements GeneralizedQueueInterface<Item>, Iterable<Item> {
        Item[] array = (Item[]) new Object[1];
        int head = 0;
        int tail = 0;
        int size = 0;

        public boolean isEmpty() {
            return head == tail;
        }

        public void insert(Item x) {
            if (size == array.length) {
                resizeArray(2 * array.length);
            }
            array[tail] = x;
            tail = (tail + 1) % array.length;
            size++;
        }

        private void resizeArray(int newSize) {
            Item[] newArray = (Item[]) new Object[newSize];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[(head + i) % array.length];
            }
            array = newArray;
            head = 0;
            tail = size;

        }

        public Item delete(int k) {
            if (k > size) {
                return null;
            }
            Item item = array[(tail - 1 - k + array.length) % array.length];
            for (int i = k; i < size - 1; i++) {
                array[(head + i) % array.length] = array[(head + i + 1) % array.length];
            }
            return item;
        }

        public Iterator<Item> iterator() {
            return new ArrayImplementationIterator();
        }

        private class ArrayImplementationIterator implements Iterator<Item> {
            int position = head;

            public boolean hasNext() {
                return position != tail;
            }

            public Item next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more items to return.");
                }
                Item item = array[position];
                position = (position + 1) % array.length;
                return item;
            }
        }
    }

    public static void main(String[] args) {
        GeneralizedQueue generalizedQueue = new GeneralizedQueue();
        GeneralizedQueue.LinkedListImplementation<Integer> linkedListImplementation
                = generalizedQueue.new LinkedListImplementation<>();


        linkedListImplementation.insert(1);
        linkedListImplementation.insert(2);
        linkedListImplementation.insert(3);


        System.out.println(linkedListImplementation.delete(0));

        GeneralizedQueue.ArrayImplementation<Integer> arrayImplementation
                = generalizedQueue.new ArrayImplementation<>();


        arrayImplementation.insert(1);
        arrayImplementation.insert(2);
        arrayImplementation.insert(3);

        System.out.println(arrayImplementation.delete(0));

    }
}
