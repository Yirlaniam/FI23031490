import java.util.Arrays;
import java.util.Stack;

public class BinTreeIntArray {

    private Integer[] _tree;

    public BinTreeIntArray(int size) {
        _tree = new Integer[size];
    }

    public Integer[] getTree() {
        return _tree;
    }

    public void insert(int value) {

        // Actualizar
        int index = 0;

        while (index < _tree.length) {

            if (_tree[index] == null) { 
                _tree[index] = value;
                break;
            }

            if (value < _tree[index]) {
                index = 2 * index + 1;
            } else {
                index = 2 * index + 2;
            }
        }

        System.out.println(" ↳ insert: " + value + " → " + Arrays.toString(_tree));
    }

    public void inOrderTraversal() { // left -> root -> right
        System.out.print(" ↳ inOrderTraversal → ");
        var stack = new Stack<Integer>();
        var index = 0;
        while (!stack.isEmpty() || (index < _tree.length && _tree[index] != null)) {
            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
            }
            index = stack.pop();
            System.out.print(_tree[index] + " ");
            index = 2 * index + 2;
        }
        System.out.println();
    }

    public void preOrderTraversal() { // root -> left -> right
        System.out.print(" ↳ preOrderTraversal → ");

        // Actualizar
        if (_tree[0] == null) {
            System.out.println();
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (index >= _tree.length || _tree[index] == null) continue;

            System.out.print(_tree[index] + " ");

            int right = 2 * index + 2;
            int left = 2 * index + 1;

            if (right < _tree.length && _tree[right] != null) {
                stack.push(right);
            }
            if (left < _tree.length && _tree[left] != null) {
                stack.push(left);
            }
        }

        System.out.println();
    }

    public void postOrderTraversal() { // left -> right -> root
        System.out.print(" ↳ postOrderTraversal → ");

        // Actualizar
        if (_tree[0] == null) {
            System.out.println();
            return;
        }

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        s1.push(0);

        while (!s1.isEmpty()) {
            int index = s1.pop();
            if (index >= _tree.length || _tree[index] == null) continue;

            s2.push(index);

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < _tree.length && _tree[left] != null) {
                s1.push(left);
            }
            if (right < _tree.length && _tree[right] != null) {
                s1.push(right);
            }
        }

        while (!s2.isEmpty()) {
            System.out.print(_tree[s2.pop()] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        var tree = new BinTreeIntArray(7);
        System.out.println("Empty array → " + Arrays.toString(tree.getTree()));
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        System.out.println("\nFull array → " + Arrays.toString(tree.getTree()));
        tree.inOrderTraversal(); // 1 2 3 4 5 6 7
        tree.preOrderTraversal(); // 4 2 1 3 6 5 7
        tree.postOrderTraversal(); // 1 3 2 5 7 6 4
    }
}
