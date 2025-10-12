package PP2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Revert {
    public static void main(String[] args) {
        String inputFile = "PP2/input.txt";
        String outputFile = "PP2/output.txt";

        // Crear una pila de caracteres
        Stack<Character> stack = new Stack<>();

        try {
            // Leer archivo de entrada
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);

            int c;
            while ((c = br.read()) != -1) { // Leer caracter por caracter
                stack.push((char) c);
            }

            br.close();
            fr.close();

            // Escribir archivo de salida
            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);

            while (!stack.isEmpty()) { // Vaciar la pila (invertir)
                bw.write(stack.pop());
            }

            bw.close();
            fw.close();

            System.out.println("El archivo se ha invertido correctamente.");

        } catch (IOException e) {
            System.err.println("Error al procesar los archivos: " + e.getMessage());
        }
    }
}
    

