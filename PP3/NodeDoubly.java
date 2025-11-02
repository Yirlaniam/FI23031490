public class NodeDoubly<T> {

    T data;
    NodeDoubly<T> prev;
    NodeDoubly<T> next;

    public NodeDoubly(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public NodeDoubly<T> getPrev() {
        return prev;
    }

    public NodeDoubly<T> getNext() {
        return next;
    }
}
