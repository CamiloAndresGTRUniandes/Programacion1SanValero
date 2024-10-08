import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;

    public static char [][] tablero;

    public static void main(String[] args) {
        //Inicializar la matriz del tablero
        tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

        //Rellenar el talbero ´L´
        for (int i = 0; i < MAX_FILA_TABLERO; i++){
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++){
                tablero[i][j] = 'L';
            }
        }
        //Imprimir el tablero
       imprimirTablero();

        //Asignar a Bart
        Random aleatorio = new Random();
        int filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO);
        int columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
        tablero[filaAleatorio][columnaAleatorio] = 'B';

        imprimirTablero();
    }
    private static void imprimirTablero(){
        for (int i = 0; i < MAX_FILA_TABLERO; i++){
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++){
                System.out.print(tablero[i][j] + " ");
            }
            //Agregar salto de linea al terminar cada fila
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }
}