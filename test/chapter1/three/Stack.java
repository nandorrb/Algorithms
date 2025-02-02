/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.three;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {


    Node<Item> first; // top of stack (most recently added node)
    private int n; // number of items

    // helper linked list class
    static class Node<Item> {
        Item item;
        Node<Item> next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item; // save item to return
        first = first.next; // delete first node
        n--;
        return item; // return the saved item
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * Write an iterable Stack client that has a static method copy() that takes a stack of strings
     * as argument and returns a copy of the stack. Note: this ability is a prime example of the
     * value of having an  iterator, because it allows development of such functionality without
     * changing the basis API.
     *
     * @param target
     * @return
     */

    public static Stack<String> copy(Stack<String> target) {
        Stack<String> temp = new Stack<>();
        Stack<String> result = new Stack<>();

        for (String item : target) {
            temp.push(item);
        }

        for (String item : temp) {
            result.push(item);
        }

        return result;
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
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

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");

        Stack<String> copiedStack = Stack.copy(stack);

        for (String item : copiedStack) {
            System.out.println(item);
        }
    }
}