import LinkedList.ListaDoblementeEnlazada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDoblementeEnlazada<Integer> list = new ListaDoblementeEnlazada<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLista Doblemente Enlazada");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Recorrer hacia adelante");
            System.out.println("4. Recorrer hacia atrás");
            System.out.println("5. Mostrar tamaño de la lista");
            System.out.println("6. Mostrar si la lista está vacía");
            System.out.println("7. Buscar elemento por valor");
            System.out.println("8. Buscar elemento por índice");
            System.out.println("9. Borrar un Elemento");
            System.out.println("10. Salir");
            System.out.print("\nOpción: ");
            try {
                int option = scanner.nextInt();
                processOption(option, list, scanner);
            } catch (Exception e) {
                System.out.println("Opción no válida");
                scanner.next();
            }
        }
    }

    private static void processOption(int option, ListaDoblementeEnlazada<Integer> list, Scanner scanner) {
        int number;
        switch (option) {
            case 1:
                System.out.print("Ingrese un número para insertar: ");
                number = scanner.nextInt();
                list.insertAtHead(number);
                break;
            case 2:
                System.out.print("Ingrese un número para insertar: ");
                number = scanner.nextInt();
                list.insertAtTail(number);
                break;
            case 3:
                list.traverseForward();
                break;
            case 4:
                list.traverseBackward();
                break;
            case 5:
                System.out.println("Tamaño de la lista: " + list.size());
                break;
            case 6:
                System.out.println("La lista está vacía: " + list.isEmpty());
                break;
            case 7:
                System.out.print("Ingrese un número para buscar: ");
                number = scanner.nextInt();
                System.out.println("El número " + number + " está en la lista: " + list.searchByValue(number).toString());
                break;
            case 8:
                System.out.print("Ingrese un índice para buscar: ");
                number = scanner.nextInt();
                System.out.println("El número en el índice " + number + " es: " + list.searchByIndex(number).toString());
                break;
            case 9:
                System.out.print("Ingrese un número para borrar: ");
                number = scanner.nextInt();
                list.deleteFromValue(number);
                break;
            case 10:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}