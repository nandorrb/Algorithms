/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.three;

/**
 * Thirty-two 1.2.32 Steque
 * A stack-ended queue or steque is a data type that supports push, pop, and enqueue. Articulate an
 * API for this ADT. Develop a linked-list-based implementation.
 */
public class Steque<Item> {

    private class Node<Item> {
        Item item;
        Node<Item> next;

        Node(Item item) {
            this.item = item;
        }
    }

    private Node<Item> first; // top of stack (most recently added node)

    // push
    void push(Item item) {
        Node<Item> newNode = new Node<>(item);
        if (first == null) {
            first = newNode;
        }
        else {
            newNode.next = first;
            first = newNode;
        }
    }

    // pop
    Item pop() {
        if (first == null) {
            return null;
        }
        Item item = first.item;
        first = first.next;
        return item;
    }

    // enqueue
    void enqueue(Item item) {
        Node<Item> newNode = new Node<>(item);
        if (first == null) {
            first = newNode;
        }
        else {
            Node<Item> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }


    public static void main(String[] args) {

    }
}
