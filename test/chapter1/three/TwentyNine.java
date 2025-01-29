/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.chapter1.three;

/**
 * Write a Queue implementation that uses a circular linked list, which is the same as a linked list
 * except that no links are null and the value of last.next is first whenever the list is not empty.
 * Keep only one Node instance variable (last).
 */
public class TwentyNine<Item> {

    private class Node<Item> {
        Item item;
        Node<Item> next;

        Node(Item item) {
            this.item = item;
        }
    }

    private Node<Item> last; // tail of stack

    /**
     * Adds a new item to the beginning of the linked list.
     *
     * @param item the item to add
     */
    public void push(Item item) {
        Node<Item> newNode = new Node<>(item);
        if (last == null) {
            last = newNode;
            last.next = last;
        }
        else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    /**
     * Removes and returns the item from the beginning of the linked list.
     *
     * @return the removed item
     */
    public Item pop() {
        if (last == null) {
            throw new IllegalStateException("List is empty.");
        }

        Node<Item> first = last.next;

        if (last == first) {
            // Only one element in the list
            Item item = first.item;
            last = null;
            return item;
        }

        // More than one element in the list
        Item item = first.item;
        last.next = first.next; // Bypass the first node
        return item;
    }


    public static void main(String[] args) {
        TwentyNine<Integer> list = new TwentyNine<>();

        // Add some nodes to the list
        list.push(1);
        list.push(11);
        list.push(7);
        list.push(9);

        // Test find
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
        // System.out.println(list.pop());
        // System.out.println(list.pop());


    }
}