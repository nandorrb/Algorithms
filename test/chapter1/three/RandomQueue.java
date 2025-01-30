/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     30/01/2025
 **************************************************************************** */

package test.chapter1.three;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Random queue.
 * A random queue stores a collection of items and supports the following API:
 * isEmpty(), enqueue(Item item), Item dequeue(), Item sample()
 * Write a class RandomQueue that implements this API. Hint: Use an array representation
 * (with resizing). To remove an item, swap one at a random position (indexed 0 through N-1) with
 * the one at the last position (index N-1). Then delete and return the last object, as in
 * ResizingArrayStack. Write a client that deals bridge hands (13 cards each) using
 * RandomQueue<Card>.
 */
public class RandomQueue<Item> implements Iterable<Item> {

    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {
        private int i = 0;
        private int[] orders = StdRandom.permutation(array.length);

        public boolean hasNext() {
            return i < array.length;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return array[(orders[i++] + head) % array.length];
        }
    }

    private Item[] array;
    private int head;
    private int tail;
    private int size;

    public RandomQueue() {
        array = (Item[]) new Object[1];
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Item item) {
        if (size == array.length) {
            resizeArray(2 * array.length);
        }
        head = (head - 1 + array.length) % array.length;
        array[head] = item;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            return null;
        }
        int randomIndex = (StdRandom.uniformInt(size) + head) % array.length;

        swap(randomIndex, tail);
        Item item = array[tail];
        array[tail] = null;
        tail = (tail - 1 + array.length) % array.length;
        size--;
        return item;
    }

    private void swap(int randomIndex, int tail) {
        Item item = array[tail];
        array[tail] = array[randomIndex];
        array[randomIndex] = item;
    }

    public Item sample() {
        if (isEmpty()) {
            return null;
        }
        int randomIndex = (StdRandom.uniformInt(size) + head) % array.length;
        return array[randomIndex];
    }

    // resizeArray()
    private void resizeArray(int newSize) {
        Item[] newArray = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(head + i) % array.length];
        }
        array = newArray;
        head = 0;
        tail = size - 1;
    }

    public static void main(String[] args) {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

        RandomQueue<Card> deck = new RandomQueue<>();

        // Create a deck of 52 cards
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.enqueue(new Card(suit, rank));
            }
        }

        // Deal 4 hands of 13 cards each
        for (int i = 0; i < 4; i++) {
            System.out.println("Hand " + (i + 1) + ":");
            for (int j = 0; j < 13; j++) {
                System.out.println(deck.dequeue());
            }
            System.out.println();
        }
    }
}