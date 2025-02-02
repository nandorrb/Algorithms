/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     1/02/2025
 **************************************************************************** */

package test.chapter1.three;

import edu.princeton.cs.algs4.Stack;

/**
 * Text editor buffer. Develop a data type for a buffer in a text editor that implements the
 * following API:
 * Buffer() create an empty buffer
 * void insert(char c) insert c at the cursor position
 * char get() character at the cursor position
 * char delete() delete and return the character at the cursor
 * void left(int k) move the cursor k positions to the left
 * void right(int k) move the cursor k positions to the right
 * int size() number of characters in the buffer
 * Hint: Use two stacks.
 */
public class FortyFour {
    class Buffer {
        private Stack<Character> left;
        private Stack<Character> right;

        public Buffer() {
            left = new Stack<>();
            right = new Stack<>();
        }

        void insert(char c) {
            left.push(c);
        }

        char get() {
            return left.peek();
        }

        char delete() {
            return left.pop();
        }

        void left(int k) {
            for (int i = 0; i < k; i++) {
                right.push(left.pop());
            }
        }

        void right(int k) {
            for (int i = 0; i < k; i++) {
                left.push(right.pop());
            }
        }

        int size() {
            return left.size() + right.size();
        }
    }

    public static void main(String[] args) {
        Buffer buffer = new FortyFour().new Buffer();

        // Test insert and size
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        System.out.println(buffer.size()); // Expected: 3

        // Test get
        System.out.println(buffer.get()); // Expected: c

        // Test delete
        System.out.println(buffer.delete()); // Expected: c
        System.out.println(buffer.size()); // Expected: 2

        // Test left and right
        buffer.left(1);
        System.out.println(buffer.get()); // Expected: b
        buffer.right(1);
        System.out.println(buffer.get()); // Expected: a


    }
}
