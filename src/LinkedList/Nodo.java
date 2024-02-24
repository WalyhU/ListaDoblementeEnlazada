package LinkedList;


public class Nodo<T> {

    /* Data item en el nodo */
    T item;

    /* Puntero para el siguiente nodo */
    Nodo<T> next;

    /* Puntero para el nodo anterior */
    Nodo<T> prev;

    /* Constructor para crear un nodo con un dato específico */
    public Nodo(T item) {
        this.item = item;
    }

    /* Método para imprimir el dato del nodo */
    @Override
    public String toString() {
        return String.valueOf(item);
    }

}