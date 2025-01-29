/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.three;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Develop a recursive solution to the previous question
 */
public class TwentyEigth<Item> implements Iterable<Item> {

    public Iterator<Item> iterator() {
        return new CustomIterator<Item>();
    }

    class CustomIterator<Item> implements Iterator<Item> {
        private Node<Item> current = (Node<Item>) first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node<Item> {
        Item item;
        Node<Item> next;

        Node(Item item) {
            this.item = item;
        }
    }

    private Node<Item> first; // top of stack (most recently added node)


    /**
     * Adds a new item to the beginning of the linked list.
     *
     * @param item the item to add
     */
    public void push(Item item) {
        Node<Item> newNode = new Node<>(item);
        newNode.next = first;
        first = newNode;
    }

    /**
     * Removes and returns the item from the beginning of the linked list.
     *
     * @return the removed item
     */
    public Item pop() {
        if (first == null) {
            throw new IllegalStateException("List is empty.");
        }

        Item item = first.item;
        first = first.next;
        return item;
    }

    public int max() {
        return max(first);
    }

    private int max(Node<Item> node) {
        if (node == null) {
            return 0;
        }
        int maxInRest = max(node.next);
        return Math.max((int) node.item, maxInRest);
    }

    public static void main(String[] args) {
        TwentyEigth<Integer> list = new TwentyEigth<>();

        // Add some nodes to the list
        list.push(1);
        list.push(11);
        list.push(7);
        list.push(9);

        // Test find
        System.out.println(list.max());


    }
}
