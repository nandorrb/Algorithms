/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.multithreading;

// ProducerConsumer.java

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static final int BUFFER_SIZE = 5;
    private static final Queue<Integer> buffer = new LinkedList<>();

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {
        public void run() {
            int value = 0;
            while (true) {
                synchronized (buffer) {
                    // Wait if the buffer is full
                    while (buffer.size() == BUFFER_SIZE) {
                        try {
                            buffer.wait();
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.printf("Producer produced: %d , buffer = %d %n", value,
                                      buffer.size());
                    buffer.add(value++);

                    // Notify the consumer that an item is produced
                    buffer.notify();

                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            while (true) {
                synchronized (buffer) {
                    // Wait if the buffer is empty
                    while (buffer.isEmpty()) {
                        try {
                            buffer.wait();
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    int value = buffer.poll();
                    System.out.printf("Consumer consumed: %d , buffer = %d %n", value,
                                      buffer.size());


                    // Notify the producer that an item is consumed
                    buffer.notify();

                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
