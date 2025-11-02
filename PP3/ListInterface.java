public interface ListInterface<T> {

    void addFirst(T data);

    void addLast(T data);

    T removeFirst();

    T removeLast();

    int size();

    boolean isEmpty();

    T getFirst();

    T getLast();

    void print();

    void printReverse();
}
