import java.util.Random;

public class Old {
    private static final Random rand = new Random();
    private static final int MAX_DIMENSION = 10;
    private static int[][] miMatriz = new int[MAX_DIMENSION][MAX_DIMENSION];

    private static void imprimirMatriz(){
        for (int i = 0; i < miMatriz.length; i++) {
            for (int j = 0; j < miMatriz[i].length; j++) {
                System.out.print(miMatriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void generarMatriz(){
        for (int i = 0; i < miMatriz.length; i++) {
            for (int j = 0; j < miMatriz[i].length; j++) {
                miMatriz[i][j] = rand.nextInt(100);
            }

        }
    }
    //matriz de 10 X 10 con números aleatorios
    public static void main(String[] args) {
        generarMatriz();
        imprimirMatriz();
    }
}