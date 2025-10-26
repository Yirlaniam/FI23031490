public interface TheStackInterface<Type> {

    Boolean push(Type item);

    Type pop();

    Type peek();

    boolean empty();   
    int size();        

    String print();
}
