import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Old2 {
    private static final Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_DIMENSION = 10;
    private static String[] miArray = new String[MAX_DIMENSION];
    private static String[] arrayBuscar = new String[3];

    //matriz de 10 X 10 con números aleatorios
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Digite un número");
            arrayBuscar[i] = scanner.nextInt()+"";
        }
        generarArray();
        buscarEnArray();
        imprimirArray();
    }
    private static void buscarEnArray() {
        int ocurrencias = 0;
        for (int i = 0; i < miArray.length; i++) {
            for (int j = 0; j < arrayBuscar.length; j++) {
                if (Objects.equals(miArray[i], arrayBuscar[j])) {
                    miArray[i] = "XX";
                    ocurrencias++;
                }
            }
        }
        if (ocurrencias == 0) {
            System.out.println("Eres un paquete!");
        }
    }
    private static void imprimirArray() {
        for (int i = 0; i < miArray.length; i++) {
            System.out.print(miArray[i] + " ");
        }
    }
    private static void generarArray(){
        for (int i = 0; i < miArray.length; i++) {
            miArray[i] = rand.nextInt(100)+"";
        }
    }
}