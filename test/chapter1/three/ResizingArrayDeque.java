/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.three;

public class ResizingArrayDeque<Item> {
    private Item[] array;
    private int head;
    private int tail;
    private int size;

    public ResizingArrayDeque() {
        array = (Item[]) new Object[1];
        head = 0;
        tail = 0;
        size = 0;
    }

    // isEmpty()
    public boolean isEmpty() {
        return size == 0;
    }

    // size()
    public int size() {
        return size;
    }

    // pushLeft()
    public void pushLeft(Item item) {
        if (size == array.length) {
            resizeArray(2 * array.length);
        }
        head = (head - 1 + array.length) % array.length;
        array[head] = item;
        size++;
    }

    // pushRight()
    public void pushRight(Item item) {
        if (size == array.length) {
            resizeArray(2 * array.length);
        }
        array[tail] = item;
        tail = (tail + 1) % array.length;
        size++;
    }

    // popLeft()
    public Item popLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        Item item = array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        size--;
        if (size > 0 && size == array.length / 4) {
            resizeArray(array.length / 2);
        }
        return item;
    }

    // popRight()
    public Item popRight() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        tail = (tail - 1 + array.length) % array.length;
        Item item = array[tail];
        array[tail] = null;
        size--;
        if (size > 0 && size == array.length / 4) {
            resizeArray(array.length / 2);
        }
        return item;
    }

    // resizeArray()
    private void resizeArray(int newSize) {
        Item[] newArray = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(head + i) % array.length];
        }
        array = newArray;
        head = 0;
        tail = size;
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();
        deque.pushLeft(1);
        deque.pushRight(2);
        deque.pushLeft(0);
        System.out.println(deque.popLeft()); // 0
        System.out.println(deque.popRight()); // 2
        System.out.println(deque.popLeft()); // 1
    }
}