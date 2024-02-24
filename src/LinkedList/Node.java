package LinkedList;


public class Node<T> {

    /* Data item in the node */
    T item;

    /* Pointer to next node */
    Node<T> next;

    /* Pointer to previous node */
    Node<T> prev;

    /* Constructor to create a node */
    public Node(T item) {
        this.item = item;
    }

    /* toString implementation to print just the data */
    @Override
    public String toString() {
        return String.valueOf(item);
    }

}