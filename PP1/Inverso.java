public class Inverso {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Por favor escriba: java Inverso <numero>");
            return;
        }

        try {
            int numero = Integer.parseInt(args[0]);

            if (numero < 0) {
                System.out.println("Debe ser un número mayor o igual a cero.");
                return;
            }

            int inverso = invertir(numero);

            System.out.println(numero + " → " + inverso);

        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese solo números naturales.");
        }
    }

   
    public static int invertir(int numero) {
        return invertirRecursivo(numero, 0);
    }


    private static int invertirRecursivo(int numero, int acumulador) {
        if (numero == 0) {
            return acumulador;
        }

        int residuo = numero % 10;

        int cociente = numero / 10;

        return invertirRecursivo(cociente, acumulador * 10 + residuo);
    }


    public static int invertirIterativo(int numero) {
        int inverso = 0;


        while (numero > 0) {
            int residuo = numero % 10;   
            numero = numero / 10;        
            inverso = inverso * 10 + residuo; 
        }

        return inverso;
    }
}
