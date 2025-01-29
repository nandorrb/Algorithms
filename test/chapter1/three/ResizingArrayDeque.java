/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.three;

public class ResizingArrayDeque<Item> {
    Item[] array = (Item[]) new Object[1];

    int head = 0;
    int tail = 0;


    // isEmpty()
    boolean isEmpty() {
        return head == tail;
    }

    // size()
    int size() {
        return tail - head;
    }

    // pushLeft()
    void pushLeft(Item item) {
        if (tail == (array.length - 1)) {
            resizeArray(2 * array.length);
        }

        // move all array one position
        for (int i = tail; i >= head; i--) {
            array[i + 1] = array[i];
        }
        array[head] = item;
        tail++;

    }

    // pushRight()
    void pushRight(Item item) {
        if (tail == (array.length - 1)) {
            resizeArray(2 * array.length);
        }

        // move all array one position
        for (int i = tail; i >= head; i--) {
            array[i + 1] = array[i];
        }
        array[head] = item;
        tail++;

    }

    // popLeft()
    Item popLeft() {
        Item item = array[head];
        head++;
        return item;
    }

    // popRight()
    Item popRight() {
        Item item = array[tail];
        tail--;
        return item;
    }

    // resizeArray()
    private void resizeArray(int newSize) {
        Item[] newArray = (Item[]) new Object[newSize];

        for (int i = head; i < tail; i++) {
            newArray[i] = array[i];
        }

        array = newArray;

    }

    public static void main(String[] args) {

    }
}
