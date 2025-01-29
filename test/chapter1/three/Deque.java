/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.three;

/**
 * Deque. A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a
 * queue that supports adding and removing items from either the front or the back of the data
 * structure. Create a generic data type Deque that implements the following API:
 * <p>
 * isEmpty()
 * size()
 * pushLeft()
 * pushRight()
 * popLeft()
 * popRight()
 * Write a class Deque that uses a doubly-linked list to implement this API and a class
 * RezisingArrayDeque that uses a resizing array.
 */
public class Deque<Item> {
    private class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> previous;

        Node(Item item) {
            this.item = item;
        }
    }

    private Node<Item> first; // top of stack (most recently added node)

    boolean isEmpty() {
        return first == null;
    }

    int size() {
        int size = 0;
        Node<Item> current = first;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    void pushLeft(Item item) {
        Node<Item> newNode = new Node<>(item);
        if (first == null) {
            first = newNode;
        }
        else {
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
        }
    }

    void pushRight(Item item) {
        Node<Item> newNode = new Node<>(item);
        if (first == null) {
            first = newNode;
        }
        else {
            Node<Item> last = first;
            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
            newNode.previous = last;
        }
    }

    // popLeft()
    Item popLeft() {
        if (first == null) {
            return null;
        }
        else {
            Item item = first.item;
            first = first.next;
            return item;
        }
    }

    // popRight()
    Item popRight() {
        if (first == null) {
            return null;
        }
        else {
            Node<Item> last = first;
            while (last.next != null) {
                last = last.next;
            }
            Item item = last.item;
            last.previous.next = null;
            return item;
        }
    }


    public static void main(String[] args) {

    }
}
