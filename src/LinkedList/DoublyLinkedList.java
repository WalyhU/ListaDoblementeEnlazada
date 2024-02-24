package LinkedList;

public class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public void insertAtHead(E value) {
        Node<E> newNode = new Node<>(value);
        if (null == head) {
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertAtTail(E value) {
        Node<E> newNode = new Node<>(value);
        if (null == tail) {
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = null;
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void insertAtPosition(E value, int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 0) {
            insertAtHead(value);
            return;
        }
        if (position == size - 1) {
            insertAtTail(value);
            return;
        }
        Node<E> currentNode = head;
        for (int i = 0; i < position; i++) {
            currentNode = currentNode.next;
        }
        Node<E> previousNode = currentNode.prev;
        Node<E> newNode = new Node<E>(value);
        newNode.next = currentNode;
        newNode.prev = previousNode;
        previousNode.next = newNode;
        currentNode.prev = newNode;
        size++;
    }

    public void traverseForward() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
    }

    public void traverseBackward() {
        Node<E> temp = tail;
        while (temp != null) {
            System.out.print(temp.item + " ");
            temp = temp.prev;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<E> searchByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Invalid index passed while searching for a value"
            );
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node<E> searchByValue(E value) {
        Node<E> temp = head;
        while (null != temp.next && temp.item != value) {
            temp = temp.next;
        }
        if (temp.item == value) {
            return temp;
        }
        return null;
    }

    public void deleteFromHead() {
        if (null == head) return;
        Node<E> temp = head;
        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteFromTail() {
        if (null == tail) return;
        Node<E> temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void deleteFromPosition(int position) {
        if(position < 0 || position >= size) {
            throw new IllegalArgumentException("Invalid position");
        }
        Node<E> nodeToBeDeleted = head;
        for (int i = 0; i < position; i++) {
            nodeToBeDeleted = nodeToBeDeleted.next;
        }
        Node<E> previousNode = nodeToBeDeleted.prev;
        Node<E> nextNode = nodeToBeDeleted.next;
        previousNode.next = nextNode;
        nextNode.prev = previousNode;
        size--;
    }

    public void deleteFromValue(E value) {
        Node<E> temp = head;
        while (temp != null && temp.item != value) {
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        Node<E> previousNode = temp.prev;
        Node<E> nextNode = temp.next;
        previousNode.next = nextNode;
        nextNode.prev = previousNode;
        size--;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            array[i] = temp.item;
            temp = temp.next;
        }
        return array;
    }
}