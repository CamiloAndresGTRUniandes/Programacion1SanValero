import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Random aleatorio = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    //Máximo de vidas disponibles
    private static int MAX_VIDAS = 5;
    public static char [][] tablero;
    private static int[] posicionBart = new int[2];
    private static boolean continuar = true;
    public static void main(String[] args) {
        //InicializarTablero
        inicializarTablero();

        //Crear un menú para la interacción del jugador
        while (continuar){
            if (MAX_VIDAS == 0) {
                generarMensaje(3);
                break;
            }
            generarMensaje(7);
            char movimiento = scanner.nextLine().toUpperCase().charAt(0);
            if (movimiento == 'E') {
                break;
            }
            //Mover a Bart según la letra ingresada
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
        //Asignar final
        tablero[MAX_FILA_TABLERO -1][MAX_COLUMNA_TABLERO -1] = 'F';

        //Asignar a Bart a posición inicial
        asignarPersonajeACasillaLibre('B', 1);

        //Repartir 10 Homer en el tablero
        asignarPersonajeACasillaLibre('H', 10);

        //Generar Muro
        asignarPersonajeACasillaLibre('M', 10);

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

    private static void asignarPersonajeACasillaLibre(char personaje, int cantidad){
        for (int i = 0; i < cantidad; i++){
            int filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO);
            int columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);
            char valor = tablero[filaAleatorio][columnaAleatorio];
            if (valor == 'L')
            {
                tablero[filaAleatorio][columnaAleatorio] = personaje;
            }
            if (personaje == 'B') {
                posicionBart[0] = filaAleatorio;
                posicionBart[1] = columnaAleatorio;
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
                    if (tablero[fila][columna+1] == 'F') {
                        generarMensaje(4);
                        continuar = false;
                        break;
                    }
                    if (tablero[fila][columna+1] == 'H') {
                        generarMensaje(1);
                        break;
                    } else if (tablero[fila][columna+1] == 'M') {
                        generarMensaje(2);
                        break;
                    }
                    columna++;
                }else{
                    generarMensaje(5);
                    break;
                }
                break;
            case 'A':
                if (columna - 1 >= 0) {
                    if (tablero[fila][columna-1] == 'H') {
                        generarMensaje(1);
                        break;
                    } else if (tablero[fila][columna-1] == 'M') {
                        generarMensaje(2);
                        break;
                    }
                    columna--;
                }else{
                    generarMensaje(5);
                    break;
                }
                break;
            case 'W':
                if (fila -1 >= 0) {
                    if (tablero[fila - 1][columna] == 'H') {
                        generarMensaje(1);
                        break;
                    } else if (tablero[fila - 1][columna] == 'M') {
                        generarMensaje(2);
                        break;
                    }
                    fila--;
                }else{
                    generarMensaje(5);
                    break;
                }
                break;
            case 'S':
                if (fila < MAX_FILA_TABLERO - 1) {
                    if (tablero[fila + 1][columna] == 'F') {
                        generarMensaje(4);
                        continuar = false;
                    }
                    if (tablero[fila + 1][columna] == 'H') {
                        generarMensaje(1);
                        break;
                    } else if (tablero[fila + 1][columna] == 'M') {
                        generarMensaje(2);
                        break;
                    }
                    fila++;
                }else{
                    generarMensaje(5);
                    break;
                }
                break;
            default:
                generarMensaje(6);
                break;
        }
        posicionBart[0] = fila;
        posicionBart[1] = columna;
        tablero[fila][columna] = 'B';
    }

    //Procedimiento para la impresión de mensajes al jugador y disminuir vidas
    private static void generarMensaje(int mensaje){
        /*
        1. Choque con Homer
        2. Choque con muro
        3. Game Over
        4. Ganador
        5. Fuera del limite
        6. Movimiento invalido
        7. Inicial
        * */
        switch (mensaje){

            case 1:
                MAX_VIDAS --;
                System.out.println("Te has chocado con Homer, pierdes una vida, te quedan: " + MAX_VIDAS);
                break;
            case 2:
                System.out.println("Te has chocado con un muro, movimiento inválido");
                break;
            case 3:
                System.out.println("Game Over!");
                break;
            case 4:
                System.out.println("Has ganado!!!");
                break;
            case 5:
                System.out.println("Fuera del limite, movimiento invalido");
                break;
            case 6:
                System.out.println("Movimiento no válido. Usa W, A, S, D. Para mover a Bart");
                break;
            case 7:
                System.out.println("Use W (arriba), A (izquierda), S (abajo), D (derecha) para desplazar a Bart. Digite 'E' para terminar.");
                break;
            default:
                System.out.println("Código de mensaje invalido, contacte al desarrollador!");
        }
    }
}