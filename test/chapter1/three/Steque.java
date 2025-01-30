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

    private class Node {
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
        }
    }

    private Node head; // top of stack (most recently added node)
    private Node tail; // end of queue (most recently added node)

    public Steque() {
        head = null;
        tail = null;
    }

    // push
    void push(Item item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    // pop
    Item pop() {
        if (head == null) {
            return null;
        }
        Item item = head.item;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return item;
    }

    // enqueue
    void enqueue(Item item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // check if the steque is empty
    boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        steque.push(1);
        steque.push(2);
        steque.enqueue(3);
        System.out.println(steque.pop()); // 2
        System.out.println(steque.pop()); // 1
        System.out.println(steque.pop()); // 3
    }
}