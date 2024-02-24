package LinkedList;

/* Clase para representar un nodo en una lista doblemente enlazada

    @param <E> Tipo de dato que se almacenará en el nodo

    *<br> Operaciones soportadas:
    * 1. Insertar al inicio
    * 2. Insertar al final
    * 3. Insertar en una posición específica
    * 4. Recorrer hacia adelante
    * 5. Recorrer hacia atrás
    * 6. Mostrar tamaño de la lista
    * 7. Mostrar si la lista está vacía
    * 8. Buscar elemento por índice
    * 9. Buscar elemento por valor
    * 10. Borrar el primer elemento
    * 11. Borrar el último elemento
    * 12. Borrar un elemento por índice
    * 13. Borrar un elemento por valor
    * 14. Convertir la lista a un arreglo
*/

public class ListaDoblementeEnlazada<E> {

    /* Nodo inicial de la lista */
    private Nodo<E> head;

    /* Nodo final de la lista */
    private Nodo<E> tail;

    /* Tamaño de la lista */
    private int size = 0;

    public void insertAtHead(E value) {
        Nodo<E> nuevoNodo = new Nodo<>(value);
        if (null == head) {
            /* Si la lista está vacía */
            nuevoNodo.next = null;
            nuevoNodo.prev = null;
            head = nuevoNodo;
            tail = nuevoNodo;
        } else {
            nuevoNodo.next = head;
            nuevoNodo.prev = null;
            head.prev = nuevoNodo;
            head = nuevoNodo;
        }
        size++;
    }

    public void insertAtTail(E value) {
        Nodo<E> newNodo = new Nodo<>(value);
        if (null == tail) {
            newNodo.next = null;
            newNodo.prev = null;
            head = newNodo;
            tail = newNodo;
        } else {
            newNodo.next = null;
            newNodo.prev = tail;
            tail.next = newNodo;
            tail = newNodo;
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
        Nodo<E> currentNodo = head;
        for (int i = 0; i < position; i++) {
            currentNodo = currentNodo.next;
        }
        Nodo<E> previousNodo = currentNodo.prev;
        Nodo<E> newNodo = new Nodo<E>(value);
        newNodo.next = currentNodo;
        newNodo.prev = previousNodo;
        previousNodo.next = newNodo;
        currentNodo.prev = newNodo;
        size++;
    }

    public void traverseForward() {
        Nodo<E> temp = head;
        while (temp != null) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
    }

    public void traverseBackward() {
        Nodo<E> temp = tail;
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

    public Nodo<E> searchByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Invalid index passed while searching for a value"
            );
        }
        Nodo<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Nodo<E> searchByValue(E value) {
        Nodo<E> temp = head;
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
        Nodo<E> temp = head;
        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteFromTail() {
        if (null == tail) return;
        Nodo<E> temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void deleteFromPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Invalid position");
        }
        Nodo<E> nodoToBeDeleted = head;
        for (int i = 0; i < position; i++) {
            nodoToBeDeleted = nodoToBeDeleted.next;
        }
        Nodo<E> previousNodo = nodoToBeDeleted.prev;
        Nodo<E> nextNodo = nodoToBeDeleted.next;
        previousNodo.next = nextNodo;
        nextNodo.prev = previousNodo;
        size--;
    }

    public void deleteFromValue(E value) {
        Nodo<E> temp = head;
        while (temp != null && temp.item != value) {
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        Nodo<E> previousNodo = temp.prev;
        Nodo<E> nextNodo = temp.next;
        previousNodo.next = nextNodo;
        nextNodo.prev = previousNodo;
        size--;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Nodo<E> temp = head;
        for (int i = 0; i < size; i++) {
            array[i] = temp.item;
            temp = temp.next;
        }
        return array;
    }
}