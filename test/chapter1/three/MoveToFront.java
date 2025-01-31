/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     31/01/2025
 **************************************************************************** */

package test.chapter1.three;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3.40
 * Move-to-front. Read in a sequence of characters from standard input and maintain the characters
 * in a linked list with no duplicates. When you read in a previously unseen character, insert it at
 * the front of the list. When you read in a duplicate character, delete it from the list and
 * reinsert it at the beginning. Name your program MoveToFront: it implements the well-known
 * move-to-front strategy, which is useful for caching, data compression, and many other
 * applications where items that have been recently accessed are more likely to be reaccessed.
 */
public class MoveToFront implements Iterable<Character> {

    private class Node {
        char item;
        Node next;
        Node previous;
    }

    Node first;
    int size = 0;

    public void insert(char item) {
        delete(item);

        Node newNode = new Node();
        newNode.item = item;

        if (first == null) {
            first = newNode;
            first.next = first;
            first.previous = first;
        }
        else {
            newNode.next = first;
            newNode.previous = first.previous;
            first.previous.next = newNode;
            first.previous = newNode;
        }
        first = newNode;
        size++;
    }

    private void delete(char item) {
        if (first == null) {
            return;
        }

        Node current = first;
        do {
            if (current.item == item) {
                if (current == first && current.next == first) {
                    first = null;
                }
                else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    if (current == first) {
                        first = current.next;
                    }
                }
                size--;
                return;
            }
            current = current.next;
        } while (current != first);
    }

    public Iterator<Character> iterator() {
        return new MoveToFrontIterator();
    }

    private class MoveToFrontIterator implements Iterator<Character> {
        private Node current = first;
        private int count = 0;

        public boolean hasNext() {
            return count < size;
        }

        public Character next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Character item = current.item;
            current = current.next;
            count++;
            return item;
        }
    }

    public static void main(String[] args) {
        MoveToFront moveToFront = new MoveToFront();
        moveToFront.insert('a');
        moveToFront.insert('b');
        moveToFront.insert('c');
        moveToFront.insert('d');
        moveToFront.insert('a');
        moveToFront.insert('b');
        moveToFront.insert('c');
        moveToFront.insert('d');
        moveToFront.insert('e');
        moveToFront.insert('f');
        moveToFront.insert('g');
        moveToFront.insert('h');
        moveToFront.insert('a');
        moveToFront.insert('a');
        moveToFront.insert('a');
        moveToFront.insert('b');

        for (Character c : moveToFront) {
            System.out.println(c);
        }
    }
}

