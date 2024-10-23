import java.util.Random;
import java.util.Scanner;

public class Main {
    //Instancias librerías
    private static final Random rand = new Random();
    private static final Scanner sc = new Scanner(System.in);

    //Definir dimensiones
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;

    //5. las vidas disponibles son 5
    private static int MAX_VIDAS = 5;

    //Definir tablero inicial
    private static char[][] tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

    //Almacenar la posición de Bart
    private static int[] posicionBart = new int[2];

    //Variable para salir del juego\
    private static boolean continuar = true;

    public static void main(String[] args) {

        //1. Crear un tablero de 10x10 y rellenarlo con 'L'
        inicializarTablero();

        //Crear Menú para iniciar el juego
        while (continuar) {
            if (MAX_VIDAS == 0){
                System.out.println(GAME_OVER);
                continuar = false;
                break;
            }
            System.out.println(MENU_INICIAL);
            char movimiento = sc.next().toUpperCase().charAt(0);
            if (movimiento == 'E') {
                continuar = false;
                break;
            }
            moverBart(movimiento);
            //Imprimir tablero luego de un movimiento
            imprimirTablero();
        }

    }

    //Procedimientos y funciones
    private static void inicializarTablero() {
        //Rellenar tablero con 'L'
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                tablero[i][j] = 'L';
            }
        }

        tablero[MAX_FILA_TABLERO - 1][MAX_COLUMNA_TABLERO - 1] = 'F';

        //2. Asignar 10 Homer de forma aleatoria en Casillas dentro del tablero
        asignarPersonajeACasillaLibre('H', 10);

        //3. Asignar 10 muros
        asignarPersonajeACasillaLibre('M', 10);

        //4. asignar a Bart a una casilla libre
        asignarPersonajeACasillaLibre('B', 1);

        //Imprimir tablero antes de iniciar los movimientos
        imprimirTablero();
    }

    //Imprimir el tablero por pantalla
    private static void imprimirTablero(){
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Asignar un personaje a casillas libres
    private static void asignarPersonajeACasillaLibre(char personaje, int cantidad){
        for (int i = 0; i < cantidad; i++) {
            int filaAleatorio = rand.nextInt(MAX_COLUMNA_TABLERO);
            int columnaAleatorio = rand.nextInt(MAX_COLUMNA_TABLERO);
            char valor = tablero[filaAleatorio][columnaAleatorio];
            if (valor == 'L') {
                tablero[filaAleatorio][columnaAleatorio] = personaje;
            }else {
                i--;
            }
            if (personaje == 'B') {
                posicionBart[0] = filaAleatorio;
                posicionBart[1] = columnaAleatorio;
            }
        }
    }

    //Mover a Bart
    private static void moverBart(char direccion){
        //7. para mover a Bart se debe usar WASD
        //Posicion Bart antes del movimiento
        int filaBart = posicionBart[0];
        int columnaBart = posicionBart[1];

        tablero[filaBart][columnaBart] = 'L';

        switch (direccion){
            case 'A':
                if (columnaBart - 1 >= 0) {
                    if (tablero[filaBart][columnaBart - 1] == 'H') {
                        MAX_VIDAS--;
                        System.out.println(CHOQUE_HOMMER + MAX_VIDAS);
                        break;
                    } else if (tablero[filaBart][columnaBart -1] == 'M') {
                        System.out.println(CHOQUE_MURO);
                        break;
                    }
                    columnaBart--;
                }else {
                    System.out.println(FUERA_LIMITE);
                }
                break;
            case 'D':
                if (columnaBart + 1 < MAX_COLUMNA_TABLERO) {
                    if (tablero[filaBart][columnaBart + 1] == 'F') {
                        System.out.println(GANADOR);
                        continuar = false;
                    }
                    if (tablero[filaBart][columnaBart + 1] == 'H') {
                        MAX_VIDAS--;
                        System.out.println(CHOQUE_HOMMER + MAX_VIDAS);
                        break;
                    }else if (tablero[filaBart][columnaBart + 1] == 'M') {
                        System.out.println(CHOQUE_MURO);
                        break;
                    }
                    columnaBart++;
                }else{
                    System.out.println(FUERA_LIMITE);
                }
                break;
            case 'W':
                if (filaBart - 1 >= 0) {
                    if (tablero[filaBart - 1][columnaBart] == 'H') {
                        MAX_VIDAS--;
                        System.out.println(CHOQUE_HOMMER + MAX_VIDAS);
                        break;
                    } else if (tablero[filaBart - 1][columnaBart] == 'M') {
                        System.out.println(CHOQUE_MURO);
                        break;
                    }
                    filaBart--;
                }else{
                    System.out.println(FUERA_LIMITE);
                }
                break;
            case 'S':
                if (filaBart + 1 < MAX_FILA_TABLERO) {
                    if (tablero[filaBart + 1][columnaBart] == 'F'){
                        System.out.println(GANADOR);
                        continuar = false;
                    }
                    if (tablero[filaBart + 1][columnaBart] == 'H') {
                        MAX_VIDAS--;
                        System.out.println(CHOQUE_HOMMER + MAX_VIDAS);
                        break;
                    } else if (tablero[filaBart + 1][columnaBart] == 'M') {
                        System.out.println(CHOQUE_MURO);
                        break;
                    }
                    filaBart++;
                }else  {
                    System.out.println(FUERA_LIMITE);
                }
                break;
            default:
                System.out.println(MOVIMIENTO_INVALIDO);
                break;
        }
        posicionBart[0] = filaBart;
        posicionBart[1] = columnaBart;
        tablero[filaBart][columnaBart] = 'B';
    }

    //Mensajes que se imprimen por pantalla
    private static final String CHOQUE_HOMMER = "Te has chocado con un Homer, pierdes una vida, te quedan: ";
    private static final String MENU_INICIAL = "Juego de los simpson, para mover a Bart, usa los caracteres:\n A -> Izquierda \n" +
            " D -> Derecha\n W -> Arriba\n S -> Abajo\n Para salir presiona E";
    private static final String CHOQUE_MURO = "Te has chocado con un muro, vuelve a intentar.";
    private static final String FUERA_LIMITE = "Movimiento fuera del limite, vuelve a intentar.";
    private static final String MOVIMIENTO_INVALIDO = "Movimiento inválido, vuelve a intentar.";
    private static final String GANADOR = "Has ganado!.";
    private static final String GAME_OVER = "Game over!.";

}