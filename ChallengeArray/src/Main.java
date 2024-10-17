import java.util.Random;
import java.util.Scanner;
// Bingo
public class Main {
    private static final Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_DIMENSION_FILA = 3;
    private static final int MAX_DIMENSION_COLUMNA = 10;
    private static int[][] miMatriz = new int[MAX_DIMENSION_FILA][MAX_DIMENSION_COLUMNA];

    //matriz tipo bingo con números aleatorios
    public static void main(String[] args) {
     generarMatriz();
     imprimirMatriz();
    }

    private static void imprimirMatriz() {
        for (int i = 0; i < MAX_DIMENSION_FILA; i++) {
            for (int j = 1; j < MAX_DIMENSION_COLUMNA; j++) {
                System.out.print(miMatriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void generarMatriz(){
        for (int i = 0; i < MAX_DIMENSION_FILA; i++) {
            for (int j = 0; j < MAX_DIMENSION_COLUMNA; j++) {
                int origen = j * 10;
                miMatriz[i][j] = rand.nextInt(origen, origen + 9);
            }
        }
    }
}