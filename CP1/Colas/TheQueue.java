import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

public class TheQueue<Type> implements TheQueueInterface<Type> {

    private Deque<Type> _queue;

    public TheQueue() {
        _queue = new ArrayDeque<>();
    }

    @Override
    public void enqueue(Type item) {
        _queue.add(item); // Agrega al final de la cola
    }

    @Override
    public Type dequeue() {
        return _queue.poll(); // Retorna y elimina el primer elemento, retorna null si está vacía
    }

    @Override
    public Type getFront() {
        return _queue.peek(); // Retorna el primer elemento sin eliminar, retorna null si está vacía
    }

    @Override
    public boolean isEmpty() {
        return _queue.isEmpty();
    }

    @Override
    public int getSize() {
        return _queue.size();
    }

    @Override
    public String[] getCodons() {
        int codonCount = _queue.size() / 3;
        String[] codons = new String[codonCount];

        for (int i = 0; i < codonCount; i++) {
            String codon = "";
            for (int j = 0; j < 3; j++) {
                codon += _queue.poll(); // Va eliminando cada elemento de la cola
            }
            codons[i] = codon;
        }

        return codons;
    }

    @Override
    public String print() {
        return _queue.toString();
    }

    public static void main(String[] args) {
        int amount = Integer.parseInt(args[0]);
        String[] nucleotides = { "A", "C", "G", "T" };
        TheQueueInterface<String> queue = new TheQueue<>();
        Random random = new Random();

        for (; amount > 0; amount--) {
            int index = random.nextInt(4);
            queue.enqueue(nucleotides[index]);
        }

        System.out.println("Filled {full}");
        System.out.println(" ↳ print() → " + queue.print());
        System.out.println("   ↳ getFront() → " + queue.getFront());
        System.out.println("   ↳ getSize() → " + queue.getSize());
        System.out.println("   ↳ isEmpty() → " + queue.isEmpty());

        System.out.println("\ngetCodons() → " + Arrays.toString(queue.getCodons()));

        System.out.println("\nEnd {empty}");
        System.out.println(" ↳ print() → " + queue.print());
        System.out.println("   ↳ getFront() → " + queue.getFront());
        System.out.println("   ↳ getSize() → " + queue.getSize());
        System.out.println("   ↳ isEmpty() → " + queue.isEmpty());
    }
}
