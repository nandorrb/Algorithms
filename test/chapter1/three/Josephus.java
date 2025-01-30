/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     30/01/2025
 **************************************************************************** */

package test.chapter1.three;

import java.util.Iterator;

/**
 * Josephus problem.
 * In the Josephus problem from antiquity, <b>N</b> people are in dire straits and agree to the
 * following
 * strategy to reduce the population. They arrange themselves in a circle (at positions numbered
 * from 0 to N–1) and proceed around the circle, eliminating every <b>M</b>th  person until only one
 * person
 * is left. Legend has it that Josephus figured out where to sit to avoid being eliminated. Write a
 * Queue client Josephus that takes N and M from the command line and prints out the order in which
 * people are eliminated (and thus would show Josephus where to sit in the circle). that takes m
 * and
 * n from the command line and prints out the order in which people are eliminated (and thus would
 * show Josephus where to sit in the circle). and print out the order in which people are
 * eliminated
 * (and thus would show Josephus where to sit in the circle).
 */
public class Josephus<Item> implements Iterable<Item> {

    public Iterator<Item> iterator() {
        return new JosephusIterator();
    }

    private class Node {
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
        }
    }

    private Node first;
    private Node previousNode;
    private int m;


    public Josephus(int n, int m) {

        for (int i = 0; i < n; i++) {
            insert((Item) Integer.valueOf(i));
        }
        this.m = m;

    }

    private void insert(Item item) {
        Node newNode = new Node(item);
        if (first == null) {
            first = newNode;
            first.next = first;
        }
        else {
            newNode.next = first.next;
            first.next = newNode;
            first = newNode;
        }
    }

    private void eliminateNextNode() {
        if (first == null) {
            throw new IllegalStateException("List is empty.");
        }
        for (int i = 0; i < (m - 1); i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;
        Node nextNode = currentNode.next;

        previousNode.next = nextNode;
        System.out.print(" " + currentNode.item);


    }

    void play() {
        previousNode = first;
        while (previousNode.next != previousNode) {
            eliminateNextNode();
        }
        System.out.print(" " + first.item);
    }

    public static void main(String[] args) {
        int n = 7; //  Integer.parseInt(args[0]);
        int m = 2; // Integer.parseInt(args[1]);
        Josephus josephus = new Josephus(n, m);
        josephus.play();
    }

    private class JosephusIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current.next != first;
        }

        public Item next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more items to return.");
            }
            Node nextNode = current.next;
            current = nextNode;
            return nextNode.item;
        }
    }
}
