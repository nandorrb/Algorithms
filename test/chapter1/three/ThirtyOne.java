/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.three;

/**
 * Implement a nested class DoubleNode for building doubly-linked lists, where each node contains a
 * reference to the item preceding it and the item following it in the list (null if there is no
 * such item). Then implement static methods for the following tasks: insert at the beginning,
 * insert at the end, remove from the beginning, remove from the end, insert before a given node,
 * insert after a given node, and remove a given node.
 */
public class ThirtyOne<Item> {


    private class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> previous;

        Node(Item item) {
            this.item = item;
        }
    }

    private Node<Item> first; // top of stack (most recently added node)

    // Insert at the beginning
    void insertAtTheBeginning(Item item) {
        Node<Item> newNode = new Node<>(item);
        if (first == null) {
            first = newNode;
            first.previous = first;
            first.next = first;
        }
        else {
            newNode.next = first;
            newNode.previous = first.previous;
            first.previous = newNode;
            first = newNode;
        }
    }

    // Insert at the end
    void insertAtTheEnd(Item item) {
        Node<Item> newNode = new Node<>(item);
        if (first == null) {
            first = newNode;
            first.previous = first;
            first.next = first;
        }
        else {
            newNode.next = first;
            newNode.previous = first.previous;
            first.previous = newNode;
        }
    }

    // Remove from the beginning
    Item removeFromTheBeginning() {
        if (first == null) {
            return null;
        }
        else if (first.next == first) {
            Item item = first.item;
            first = null;
            return item;
        }
        else {
            Item item = first.item;
            Node<Item> previousObject = first.previous;
            Node<Item> nextObject = first.next;
            previousObject.next = nextObject;
            nextObject.previous = previousObject;
            first = first.next;
            return item;
        }
    }

    // Remove from the end
    Item removeFromTheEnd() {
        if (first == null) {
            return null;
        }
        else if (first.next == first) {
            Item item = first.item;
            first = null;
            return item;
        }
        else {
            Item item = first.item;
            Node<Item> previousObject = first.previous;
            Node<Item> nextObject = first.next;
            previousObject.next = nextObject;
            nextObject.previous = previousObject;
            first = first.next;
            return item;
        }
    }

    // Insert before a given node
    void insertBeforeGivenNode(Node<Item> node, Item item) {
        if (node == null) {
            return;
        }

        Node<Item> newNode = new Node<>(item);
        Node<Item> previousObject = node.previous;
        previousObject.next = newNode;
        newNode.previous = previousObject;
        newNode.next = node;
        node.previous = newNode;
    }

    // Insert after a given node
    void insertAfterGivenNode(Node<Item> node, Item item) {
        if (node == null) {
            return;
        }

        Node<Item> newNode = new Node<>(item);
        Node<Item> nextObject = node.next;
        node.next = newNode;
        newNode.previous = node;
        newNode.next = nextObject;
        nextObject.previous = newNode;
    }

    // Remove a given node
    Item removeGivenNode(Node<Item> node) {
        if (node == null) {
            return null;
        }

        Node<Item> previousObject = node.previous;
        Node<Item> nextObject = node.next;
        previousObject.next = nextObject;
        nextObject.previous = previousObject;
        return node.item;
    }

    public static void main(String[] args) {


    }
}
