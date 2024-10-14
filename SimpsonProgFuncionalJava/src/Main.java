import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Random aleatorio = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static int MAX_VIDAS = 3;
    public static char [][] tablero;
    private static int[] posicionBart = new int[2];
    public static void main(String[] args) {
        //InicializarTablero
        inicializarTablero();
        while (true){
            if (MAX_VIDAS == 0) {
                System.out.println("Game Over!");
                break;
            }
            System.out.println("Use W (arriba), A (izquierda), S (abajo), D (derecha) para mover a Bart. Digite 'S' para terminar.");
            char movimiento = scanner.nextLine().toUpperCase().charAt(0);
            if (movimiento == 'S') {
                break;
            }

            moverBart(movimiento);
            imprimirTablero();
        }


    }
    private static void inicializarTablero(){
        //Inicializar la matriz del tablero
        tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

        //Rellenar el talbero ´L´
        for (int i = 0; i < MAX_FILA_TABLERO; i++){
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++){
                tablero[i][j] = 'L';
            }
        }

        //Asignar a Bart a posición inicial
        asignarBart();

        //Repartir 10 Homer en el tablero
        generarHomer();

        //Imprimir Muro
        generarMuro();


        //Asignar final
        tablero[MAX_FILA_TABLERO -1][MAX_COLUMNA_TABLERO -1] = 'F';
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
    private static void generarHomer(){
        for (int i = 0; i < 10; i++){
            int filaAleatorioHomer = aleatorio.nextInt(MAX_FILA_TABLERO);
            int columnaAleatorioHomer = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
            char valor = tablero[filaAleatorioHomer][columnaAleatorioHomer];
            if (valor == 'L')
            {
                tablero[filaAleatorioHomer][columnaAleatorioHomer] = 'H';
            }
        }
    }

    private static void asignarBart(){
        int filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO);
        int columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
        tablero[filaAleatorio][columnaAleatorio] = 'B';
        posicionBart[0] = filaAleatorio;
        posicionBart[1] = columnaAleatorio;
    }
    private static void generarMuro(){
        for (int i = 0; i < 10; i++){
            int filaAleatorioMuro = aleatorio.nextInt(MAX_FILA_TABLERO);
            int columnaAleatorioMuro = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
            char valor = tablero[filaAleatorioMuro][columnaAleatorioMuro];
            if (valor == 'L')
            {
                tablero[filaAleatorioMuro][columnaAleatorioMuro] = 'M';
            }
        }
    }

    private static void moverBart(char movimiento){
        int fila = posicionBart[0];
        int columna = posicionBart[1];
        tablero[fila][columna] = 'L';

        switch (movimiento){
            case 'D':
                if (columna < MAX_COLUMNA_TABLERO - 1) {
                    if (tablero[fila][columna+1] == 'H') {
                        System.out.println("Te has chocado con Homer");
                        MAX_VIDAS --;
                        break;
                    } else if (tablero[fila][columna+1] == 'M') {
                        System.out.println("Te has chocado con un muro, movimiento inválido");
                        break;
                    }
                    columna++;
                }else{
                    System.out.println("Fuera del limite");
                }
            default:
                System.out.println("Movimiento no válido. Usa W, A, S, D.");
                break;
        }
        posicionBart[0] = fila;
        posicionBart[1] = columna;
        tablero[fila][columna] = 'B';
    }
}