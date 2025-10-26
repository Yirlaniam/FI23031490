import java.util.Random;
import java.util.Stack;

public class TheStack<Type> implements TheStackInterface<Type> {

    private Stack<Type> _stack;
    private int _capacity;

    public TheStack(int capacity) {
        _stack = new Stack<>();
        _capacity = capacity;
    }

    @Override
    public Boolean push(Type item) {
        boolean available = _stack.size() < _capacity;
        if (available) {
            _stack.push(item); // ✅ CORREGIDO: antes llamaba recursivamente a push()
        }
        return available;
    }

    @Override
    public Type pop() {
        if (!_stack.isEmpty()) {
            return _stack.pop();
        }
        return null; // Evita EmptyStackException
    }

    @Override
    public Type peek() {
        if (!_stack.isEmpty()) {
            return _stack.peek();
        }
        return null; // Evita EmptyStackException
    }

    @Override
    public boolean empty() {
        return _stack.isEmpty();
    }

    @Override
    public int size() {
        return _stack.size();
    }

    @Override
    public String print() {
        return _stack.toString();
    }

    public static void main(String[] args) {
        // Si no se pasa argumento, asigna capacidad por defecto
        int capacity = (args.length > 0) ? Integer.parseInt(args[0]) : 5;

        TheStackInterface<Double> stack = new TheStack<>(capacity);

        System.out.println("Pushing {" + (capacity + 1) + "}");
        Random random = new Random();

        for (int n = 0; n <= capacity; n++) {
            double number = random.nextDouble();
            boolean pushed = stack.push(number);
            System.out.println(" ↳ push(" + number + ") → " + pushed);
        }

        System.out.println();
        System.out.println("Pushed {full}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("   ↳ peek() → " + stack.peek());
        System.out.println("   ↳ size() → " + stack.size());
        System.out.println("   ↳ empty() → " + stack.empty());

        System.out.println();
        System.out.println("Popping {" + (capacity + 1) + "}");
        for (int n = 0; n <= capacity; n++) {
            Double popped = stack.pop();
            System.out.println(" ↳ pop() → " + popped);
        }

        System.out.println();
        System.out.println("Popped {empty}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("   ↳ peek() → " + stack.peek());
        System.out.println("   ↳ size() → " + stack.size());
        System.out.println("   ↳ empty() → " + stack.empty());
    }
}
