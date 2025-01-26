/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package test.chapter1.three;


public class LinkedList<Item> {

    private class Node<Item> {
        Item item;
        Node<Item> next;

        Node(Item item) {
            this.item = item;
        }
    }

    private Node<Item> first; // top of stack (most recently added node)

    /**
     * Finds the first node containing the given key.
     *
     * @param key the key to find
     * @return the node containing the key, or null if not found
     */
    public Node<Item> find(Item key) {
        Node<Item> current = first;
        while (current != null) {
            if (current.item.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null; // key not found
    }

    /**
     * Deletes the kth element in the linked list.
     *
     * @param k the index (1-based) of the element to delete
     */
    public void delete(int k) {
        if (k <= 0 || first == null) {
            throw new IllegalArgumentException("Invalid index or empty list.");
        }

        if (k == 1) { // Delete the first node
            first = first.next;
            return;
        }

        Node<Item> current = first;
        for (int i = 1; current != null && i < k - 1; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            throw new IllegalArgumentException("Index out of bounds.");
        }

        current.next = current.next.next; // Remove the kth node
    }

    /**
     * Removes the node immediately following the given node.
     *
     * @param node the node after which to remove
     */
    public void removeAfter(Node<Item> node) {
        if (node != null && node.next != null) {
            node.next = node.next.next;
        }
    }

    /**
     * Inserts a new node after the given node.
     *
     * @param node    the node after which to insert
     * @param newNode the new node to insert
     */
    public void insertAfter(Node<Item> node, Node<Item> newNode) {
        if (node != null && newNode != null) {
            newNode.next = node.next;
            node.next = newNode;
        }
    }

    /**
     * Removes all nodes containing the specified key.
     *
     * @param key the key to remove
     */
    public void remove(Item key) {
        // Remove all nodes at the beginning with the key
        while (first != null && first.item.equals(key)) {
            first = first.next;
        }

        Node<Item> current = first;
        while (current != null && current.next != null) {
            if (current.next.item.equals(key)) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
    }

    /**
     * Adds a new item to the beginning of the linked list.
     *
     * @param item the item to add
     */
    public void push(Item item) {
        Node<Item> newNode = new Node<>(item);
        newNode.next = first;
        first = newNode;
    }

    /**
     * Removes and returns the item from the beginning of the linked list.
     *
     * @return the removed item
     */
    public Item pop() {
        if (first == null) {
            throw new IllegalStateException("List is empty.");
        }

        Item item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // Add some nodes to the list
        list.push("A");
        list.push("B");
        list.push("C");
        list.push("D");

        // Test find
        System.out.println("Find 'B': " + (list.find("B") != null ? "Found" : "Not found"));

        // Test delete
        // list.delete(2);
        // System.out.println("After deleting 2nd element:");
        // printList(list);
        //
        // // Test removeAfter
        // Node<String> firstNode = list.find("D");
        // if (firstNode != null) {
        //     list.removeAfter(firstNode);
        // }
        // System.out.println("After removing after 'D':");
        // printList(list);
        //
        // // Test insertAfter
        // Node<String> nodeA = list.find("A");
        // if (nodeA != null) {
        //     list.insertAfter(nodeA, list.new Node<>("E"));
        // }
        // System.out.println("After inserting 'E' after 'A':");
        // printList(list);
        //
        // // Test remove
        // list.remove("E");
        // System.out.println("After removing 'E':");
        // printList(list);
    }


}
