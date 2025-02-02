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
 * 1.3.42
 * Copy a stack. Create a new constructor for the linked-list implementation of Stack so that
 * Stack<Item> t = new Stack<Item>(s); makes t a reference to a new and independent copy of the
 * stack s.
 */
public class FortyTwo {
    public static class Stack<Item> implements Iterable<Item> {
        private Node<Item> first;     // top of stack
        private int n;                // size of the stack


        // helper linked list class
        private static class Node<Item> {
            private Item item;
            private Node<Item> next;
        }

        /**
         * Initializes an empty stack.
         */
        public Stack() {
            first = null;
            n = 0;
        }

        /**
         * Initializes the stack as a copy of the specified stack.
         */
        public Stack(Stack<Item> stack1) {
            Stack<Item> temp = new Stack<Item>();
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                temp.push(stack1.pop());
            }

            for (int i = 0; i < size; i++) {
                Item item = temp.pop();
                stack1.push(item);
                push(item);
            }
        }

        /**
         * Returns true if this stack is empty.
         *
         * @return true if this stack is empty; false otherwise
         */
        public boolean isEmpty() {
            return first == null;
        }

        /**
         * Returns the number of items in this stack.
         *
         * @return the number of items in this stack
         */
        public int size() {
            return n;
        }

        /**
         * Adds the item to this stack.
         *
         * @param item the item to add
         */
        public void push(Item item) {
            Node<Item> oldfirst = first;
            first = new Node<Item>();
            first.item = item;
            first.next = oldfirst;
            n++;
        }

        /**
         * Removes and returns the item most recently added to this stack.
         *
         * @return the item most recently added
         * @throws NoSuchElementException if this stack is empty
         */
        public Item pop() {
            if (isEmpty()) throw new NoSuchElementException("Stack underflow");
            Item item = first.item;        // save item to return
            first = first.next;            // delete first node
            n--;
            return item;                   // return the saved item
        }


        /**
         * Returns (but does not remove) the item most recently added to this stack.
         *
         * @return the item most recently added to this stack
         * @throws NoSuchElementException if this stack is empty
         */
        public Item peek() {
            if (isEmpty()) throw new NoSuchElementException("Stack underflow");
            return first.item;
        }

        /**
         * Returns a string representation of this stack.
         *
         * @return the sequence of items in this stack in LIFO order, separated by spaces
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
         * Returns an iterator to this stack that iterates through the items in LIFO order.
         *
         * @return an iterator to this stack that iterates through the items in LIFO order
         */
        public Iterator<Item> iterator() {
            return new LinkedIterator(first);
        }

        // the iterator
        private class LinkedIterator implements Iterator<Item> {
            private Node<Item> current;

            public LinkedIterator(Node<Item> first) {
                current = first;
            }

            // is there a next item?
            public boolean hasNext() {
                return current != null;
            }

            // returns the next item
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
        }


        /**
         * Unit tests the {@code Stack} data type.
         *
         * @param args the command-line arguments
         */
        public static void main(String[] args) {
            Stack<String> stack = new Stack<String>();
            while (!StdIn.isEmpty()) {
                String item = StdIn.readString();
                if (!item.equals("-"))
                    stack.push(item);
                else if (!stack.isEmpty())
                    StdOut.print(stack.pop() + " ");
            }
            StdOut.println("(" + stack.size() + " left on stack)");
        }
    }

    public static void main(String[] args) {
        Stack<String> stack1 = new Stack<String>();
        stack1.push("first");
        stack1.push("second");
        Stack<String> stack2 = new Stack<String>(stack1);

        for (String item : stack1) {
            System.out.println(item);
        }

        for (String item : stack2) {
            System.out.println(item);
        }
    }
}
