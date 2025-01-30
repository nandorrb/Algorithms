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
 * Random bag.
 * A random bag stores a collection of items and supports the following API:
 * isEmpty(), size(), add(Item item)
 * Write a class RandomBag that implements this API. Note that this API is the same as for Bag,
 * except for the adjective random, which indicates that the iteration should provide the items in
 * random order (all N! permutations equally likely, for each iterator). Hint: Put the items in an
 * array and randomize their order in the iterator’s constructor.
 */
public class RandomBag<Item> implements Iterable<Item> {

    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    // Iterator for array in reverse order
    private class RandomIterator implements Iterator<Item> {
        private int i = 0;
        private int[] orders = StdRandom.permutation(bagArray.length);

        public boolean hasNext() {
            return i < bagArray.length;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return bagArray[orders[i++]];
        }
    }

    Item[] bagArray;
    int tail;

    public RandomBag() {
        bagArray = (Item[]) new Object[1];
        tail = 0;
    }

    boolean isEmpty() {
        return tail == 0;
    }

    int size() {
        return tail;
    }

    void add(Item item) {
        if (tail == bagArray.length) {
            resizeArray(2 * bagArray.length);
        }
        bagArray[tail] = item;
        tail++;
    }

    private void resizeArray(int newSize) {
        Item[] newArray = (Item[]) new Object[newSize];
        for (int i = 0; i < tail; i++) {
            newArray[i] = bagArray[i];
        }
        bagArray = newArray;
    }

    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<>();
        randomBag.add(1);
        randomBag.add(2);
        randomBag.add(3);
        randomBag.add(4);

        for (int item : randomBag) {
            System.out.println(item);
        }

    }
}
