/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     31/01/2025
 **************************************************************************** */

package test.chapter1.three;

/**
 * 1.3.39
 * Ring buffer. A ring buffer, or circular queue, is a FIFO data structure of a fixed size N. It is
 * useful for transferring data between asynchronous processes or for storing log files. When the
 * buffer is empty, the consumer waits until data is deposited; when the buffer is full, the
 * producer waits to deposit data. Develop an API for a RingBuffer and an implementation that uses
 * an array representation (with circular wrap-around).
 */
public class RingBuffer<Item> {

    private Item array[];

    private int head;
    private int tail;

    public RingBuffer(int capacity) {
        array = (Item[]) new Object[capacity];
        head = 0;
        tail = 0;
    }

    public boolean isEmtpy() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    public void enqueue(Item item) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer is full");
        }
        array[tail] = item;
        tail = (tail + 1) % array.length;
    }

    public Item dequeue() {
        if (isEmtpy()) {
            throw new RuntimeException("Ring buffer is empty");
        }
        Item item = array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        return item;
    }

    public static void main(String[] args) {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(5);
        ringBuffer.enqueue(1);
        ringBuffer.enqueue(2);
        ringBuffer.enqueue(3);
        ringBuffer.enqueue(4);

        System.out.println(ringBuffer.dequeue());
        System.out.println(ringBuffer.dequeue());
        System.out.println(ringBuffer.dequeue());
        

    }
}
