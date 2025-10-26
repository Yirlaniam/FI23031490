public class Numbers {

    private static final int N = 25;

    public static double formula(double z) {
        return round((z + Math.sqrt(4 + Math.pow(z, 2))) / 2);
    }

    public static double recursive(double z) {
        return round(recursive(z, N) / recursive(z, N - 1));
    }

    public static double iterative(double z) {
        return round(iterativeCalc(z, N) / iterativeCalc(z, N - 1));
    }

    // Método recursivo tipo Fibonacci
    private static double recursive(double z, int n) {
        if (n == 0 || n == 1) {
            return z;
        } else {
            return recursive(z, n - 1) + recursive(z, n - 2);
        }
    }

    // Método iterativo tipo Fibonacci
    private static double iterativeCalc(double z, int n) {
        if (n == 0 || n == 1) {
            return z;
        }
        double prev = z, curr = z, next = 0;
        for (int i = 2; i <= n; i++) {
            next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    // Método para redondear
    private static double round(double value) {
        double ROUND = 10000000000.0;
        return Math.round(value * ROUND) / ROUND;
    }

    public static void main(String[] args) {
        String[] metallics = {
                "Platinum",  // [0]
                "Golden",    // [1]
                "Silver",    // [2]
                "Bronze",    // [3]
                "Copper",    // [4]
                "Nickel",    // [5]
                "Aluminum",  // [6]
                "Iron",      // [7]
                "Tin",       // [8]
                "Lead"       // [9]
        };

        for (int z = 0; z < metallics.length; z++) {
            System.out.println("\n[" + z + "] " + metallics[z]);
            System.out.println(" ↳ formula(" + z + ")   ≈ " + formula(z));
            System.out.println(" ↳ recursive(" + z + ") ≈ " + recursive(z));
            System.out.println(" ↳ iterative(" + z + ") ≈ " + iterative(z));
        }
    }
}
