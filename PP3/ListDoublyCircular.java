import java.util.ArrayDeque;
import java.util.Random;

public class ListDoublyCircular<T> implements ListInterface<T> {

    private NodeDoubly<T> head;
    private NodeDoubly<T> tail;
    private int size;

    public ListDoublyCircular() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void addFirst(T data) {
        NodeDoubly<T> nuevo = new NodeDoubly<>(data);
        if (isEmpty()) {
            head = tail = nuevo;
            head.next = head;
            head.prev = head;
        } else {
            nuevo.next = head;
            nuevo.prev = tail;
            tail.next = nuevo;
            head.prev = nuevo;
            head = nuevo;
        }
        size++;
    }

    @Override
    public void addLast(T data) {
        NodeDoubly<T> nuevo = new NodeDoubly<>(data);
        if (isEmpty()) {
            head = tail = nuevo;
            head.next = head;
            head.prev = head;
        } else {
            nuevo.prev = tail;
            nuevo.next = head;
            tail.next = nuevo;
            head.prev = nuevo;
            tail = nuevo;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T valor = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
        return valor;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T valor = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        size--;
        return valor;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T getFirst() {
        return (head != null) ? head.data : null;
    }

    @Override
    public T getLast() {
        return (tail != null) ? tail.data : null;
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("↳ Print:");
            return;
        }
        System.out.println("↳ Print:");
        NodeDoubly<T> actual = head;
        do {
            System.out.println("    " + actual.prev.data + " ⇄ | " + actual.data + " | ⇄ " + actual.next.data);
            actual = actual.next;
        } while (actual != head);
    }

    @Override
    public void printReverse() {
        System.out.print("↳ Reverse: ");
        if (!isEmpty()) {
            NodeDoubly<T> actual = tail;
            do {
                System.out.print("| " + actual.data + " | ");
                actual = actual.prev;
            } while (actual != tail);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Debe indicar un número natural como parámetro.");
            return;
        }

        int n = Integer.parseInt(args[0]);
        ListDoublyCircular<Integer> lista = new ListDoublyCircular<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Random random = new Random();

        // Agregar n * 4 elementos
        for (int i = 0; i < n * 2; i++) {
            int valor = random.nextInt(10);
            lista.addFirst(valor);
            deque.addFirst(valor);
        }
        for (int i = 0; i < n * 2; i++) {
            int valor = random.nextInt(10);
            lista.addLast(valor);
            deque.addLast(valor);
        }

        System.out.println("\nList {added: n * 4}: " + deque);
        System.out.println(" ↳ Size: " + lista.size());
        System.out.println(" ↳ Empty: " + lista.isEmpty());
        System.out.println(" ↳ First: " + lista.getFirst());
        System.out.println(" ↳ Last: " + lista.getLast());
        lista.printReverse();
        lista.print();

        // Eliminar n * 2 elementos
        for (int i = 0; i < n; i++) {
            lista.removeFirst();
            deque.pollFirst();
        }
        for (int i = 0; i < n; i++) {
            lista.removeLast();
            deque.pollLast();
        }

        System.out.println("\nList {removed: n * 2}: " + deque);
        System.out.println(" ↳ Size: " + lista.size());
        System.out.println(" ↳ Empty: " + lista.isEmpty());
        System.out.println(" ↳ First: " + lista.getFirst());
        System.out.println(" ↳ Last: " + lista.getLast());
        lista.printReverse();
        lista.print();

        // Vaciar completamente
        while (!lista.isEmpty()) {
            lista.removeFirst();
        }

        System.out.println("\nList {empty}: []");
        System.out.println(" ↳ Size: " + lista.size());
        System.out.println(" ↳ Empty: " + lista.isEmpty());
        System.out.println(" ↳ First: " + lista.getFirst());
        System.out.println(" ↳ Last: " + lista.getLast());
        lista.printReverse();
        lista.print();
    }
}
