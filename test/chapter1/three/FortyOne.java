/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     31/01/2025
 **************************************************************************** */

package test.chapter1.three;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.41
 * Copy a Queue. Create a new constructor  so that
 * Queue<Item> copy = new Queue<Item>(queue); makes copy a reference to a new and independent copy
 * of the
 * queue queue. You should be able to push and pop from either <b>queue</b> or <b>copy</b> without
 * influencing the other.
 * Hint: Delete all of the elements from <b>queue</b> and add these elements to both <b>queue</b>
 * and <b>copy</b>.
 */

public class FortyOne {

    public static class Queue<Item> implements Iterable<Item> {
        private Node<Item> first;    // beginning of queue
        private Node<Item> last;     // end of queue
        private int n;               // number of elements on queue


        // helper linked list class
        private static class Node<Item> {
            private Item item;
            private Node<Item> next;
        }

        /**
         * Initializes an empty queue.
         */
        public Queue() {
            first = null;
            last = null;
            n = 0;
        }

        /**
         * Copies another queue.
         */
        public Queue(Queue<Item> queue) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Item item = queue.dequeue();
                enqueue(item);
                queue.enqueue(item);
            }
        }

        /**
         * Returns true if this queue is empty.
         *
         * @return {@code true} if this queue is empty; {@code false} otherwise
         */
        public boolean isEmpty() {
            return first == null;
        }

        /**
         * Returns the number of items in this queue.
         *
         * @return the number of items in this queue
         */
        public int size() {
            return n;
        }

        /**
         * Returns the item least recently added to this queue.
         *
         * @return the item least recently added to this queue
         * @throws NoSuchElementException if this queue is empty
         */
        public Item peek() {
            if (isEmpty()) throw new NoSuchElementException("Queue underflow");
            return first.item;
        }

        /**
         * Adds the item to this queue.
         *
         * @param item the item to add
         */
        public void enqueue(Item item) {
            Node<Item> oldlast = last;
            last = new Node<Item>();
            last.item = item;
            last.next = null;
            if (isEmpty()) first = last;
            else oldlast.next = last;
            n++;
        }

        /**
         * Removes and returns the item on this queue that was least recently added.
         *
         * @return the item on this queue that was least recently added
         * @throws NoSuchElementException if this queue is empty
         */
        public Item dequeue() {
            if (isEmpty()) throw new NoSuchElementException("Queue underflow");
            Item item = first.item;
            first = first.next;
            n--;
            if (isEmpty()) last = null;   // to avoid loitering
            return item;
        }

        /**
         * Returns a string representation of this queue.
         *
         * @return the sequence of items in FIFO order, separated by spaces
         */
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (Item item : this) {
                s.append(item);
                s.append(' ');
            }
            return s.toString();
        }

        /**
         * Returns an iterator that iterates over the items in this queue in FIFO order.
         *
         * @return an iterator that iterates over the items in this queue in FIFO order
         */
        public Iterator<Item> iterator() {
            return new LinkedIterator(first);
        }

        // a linked-list iterator
        private class LinkedIterator implements Iterator<Item> {
            private Node<Item> current;

            public LinkedIterator(Node<Item> first) {
                current = first;
            }

            public boolean hasNext() {
                return current != null;
            }

            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
        }


        /**
         * Unit tests the {@code Queue} data type.
         *
         * @param args the command-line arguments
         */
        public static void main(String[] args) {
            edu.princeton.cs.algs4.Queue<String> queue = new edu.princeton.cs.algs4.Queue<String>();
            while (!StdIn.isEmpty()) {
                String item = StdIn.readString();
                if (!item.equals("-"))
                    queue.enqueue(item);
                else if (!queue.isEmpty())
                    StdOut.print(queue.dequeue() + " ");
            }
            StdOut.println("(" + queue.size() + " left on queue)");
        }

    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        Queue<String> copy = new Queue<String>(queue);
        for (String item : copy) {
            StdOut.print(item + " ");
        }
    }
}
