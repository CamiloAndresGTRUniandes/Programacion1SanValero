import java.util.Random;
import java.util.Scanner;

/* Ejercicio
2 Tableros 10 x 10
//uno debe rellenarse con números aleatorios 10 - 99 y el otro lo relleno con X
//El usuario puede insertar 10 números y donde tenga aciertos reemplazo el número en el tablero de X//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
*/
public class Main {
    private static final Random rand = new Random();
    private static final Scanner sc = new Scanner(System.in);

    private static final int cantidadNumerosARecibir = 10;
    private static final int MAX_FILAS = 10;
    private static final int MAX_COLUMNAS = 10;
    private static final int MIN_ALEATORIO = 10;
    private static final int MAX_ALEATORIO = 99;
    private static int[][] tableroEnteros = new int[MAX_FILAS][MAX_COLUMNAS];
    private static String[][] tableroX = new String[MAX_FILAS][MAX_COLUMNAS];
    private static final String nombreTableroEnteros = "tableroEnteros";
    private static final String nombreTableroX = "tableroX";
    private static boolean encontrado = false;
    private static int aciertos = 0;

    public static void main(String[] args) {
        //Inicializar los tableros tanto de enteros como de X
        inicializarTableros();

        //Ejecutar 10 veces la opción de preguntar un número al usuario y luego buscarlo en la matriz de enteros.
        for (int i = 0; i < cantidadNumerosARecibir; i++) {
            System.out.println("Ingresa un número entero a buscar en el tablero entre 10 y 99");

            int numero = sc.nextInt();
            if (numero >= MIN_ALEATORIO && numero <= MAX_ALEATORIO) {
                if (buscarNumero(numero)) {
                    System.out.println("Felicidades, el número: " + numero + " existe en el tablero!");
                    imprimirTablero(nombreTableroX);
                }else{
                    System.out.println("Número no encontrado.");
                }
            }else {
                System.out.println("Número fuera del rango.");
                i--;
            }
        }
        System.out.println("Ejecución finalizada, aciertos: " + aciertos);
    }

    private static void inicializarTableros() {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tableroEnteros[i][j] = rand.nextInt(MIN_ALEATORIO, MAX_ALEATORIO);
                tableroX[i][j] = "X ";
            }
        }
    }

    //Imprimir el tablero ingresado
    private static void imprimirTablero(String tableroAImprimir) {
        switch (tableroAImprimir){
            case nombreTableroEnteros:
                for (int i = 0; i < MAX_FILAS; i++) {
                    for (int j = 0; j < MAX_COLUMNAS; j++) {
                        System.out.print(tableroEnteros[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case nombreTableroX:
                for (int i = 0; i < MAX_FILAS; i++) {
                    for (int j = 0; j < MAX_COLUMNAS; j++) {
                        System.out.print(tableroX[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            default:
                    break;
        }

    }

    //Buscar el número y reemplazarlo en la matriz de X
    private static boolean buscarNumero(int numeroABuscar){
        boolean encontradoIteracion = false;
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                if (tableroEnteros[i][j] == numeroABuscar) {
                    tableroX[i][j] = numeroABuscar + "";
                    aciertos++;
                    encontrado = true;
                    encontradoIteracion = true;
                }
            }
        }
        return encontradoIteracion;
    }
}