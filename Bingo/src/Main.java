import java.util.*;

// Bingo
/*
* 1. Generar un Set para almacenar los números únicos.
* 2. Almacenar los números aleatorios en el Set.
* 3. Convertir el Set en un array para asignarlo de forma fácil a la matriz (Recorriendo el array).
* 4. Rellenar la matriz.
* 5. Ordenar la matriz (Paso a paso para ordenar las columnas en el procedimiento).
*  */
public class Main {
    private static final Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static Set<Integer> numerosUnicos = new HashSet<>();
    private static final int MAX_DIMENSION_FILA = 3;
    private static final int MAX_DIMENSION_COLUMNA = 10;
    private static int[][] miMatriz = new int[MAX_DIMENSION_FILA][MAX_DIMENSION_COLUMNA];

    //matriz tipo bingo con números aleatorios
    public static void main(String[] args) {

        while (numerosUnicos.size() < 27) {
            numerosUnicos.add(rand.nextInt(100) + 1);
        }

        Integer[] numerosArray = numerosUnicos.toArray(new Integer[0]);
        //generarMatriz();
        generarMatrizUnicos();
        imprimirMatriz();
        System.out.println("############### BINGO ORDENADO ###############");
        ordenarColumnas();
        imprimirMatriz();
    }

    private static void imprimirMatriz() {
        for (int i = 0; i < MAX_DIMENSION_FILA; i++) {
            for (int j = 0; j < MAX_DIMENSION_COLUMNA -1; j++) {
                System.out.print(miMatriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void generarMatriz(){
        for (int i = 0; i < MAX_DIMENSION_FILA; i++) {
            for (int j = 1; j < MAX_DIMENSION_COLUMNA; j++) {
                int origen = j * 10;
                miMatriz[i][j] = rand.nextInt(origen, origen + 9);
            }
        }
    }

    private static void generarMatrizUnicos(){
        for (int col = 0; col < 9; col++) {
            // Crear una lista de números para el rango de cada columna
            List<Integer> numeros = new ArrayList<>();

            // Rango de números para cada columna (col * 10 + 10 da el rango adecuado)
            int inicio = 10 + col * 10;
            int fin = inicio + 9;

            // Llenar la lista con los números correspondientes
            for (int i = inicio; i <= fin; i++) {
                numeros.add(i);
            }

            // Barajar la lista para que los números estén en orden aleatorio
            Collections.shuffle(numeros);

            // Asignar los números aleatorios de la lista a la columna correspondiente
            for (int fila = 0; fila < miMatriz.length; fila++) {
                miMatriz[fila][col] = numeros.get(fila);
            }
        }
    }

    //Ordenar Columnas del Bingo
    private static void ordenarColumnas(){
        //Recorrer todas las columnas de la matriz (0 a 8) para ordenarlas
        for (int col = 0; col < miMatriz[0].length; col++) { // miMatriz[0].length es 9 (número de columnas)

            // Crear un arreglo temporal para almacenar los valores de la columna actual
            int[] tempCol = new int[miMatriz.length]; // miMatriz.length es 3 (número de filas)

            // Extraer los valores de la columna actual
            for (int fila = 0; fila < miMatriz.length; fila++) {
                tempCol[fila] = miMatriz[fila][col]; // Asigna los valores de la columna 'col' en el arreglo temporal
            }

            // Ordenar los valores de la columna (el arreglo temporal)
            Arrays.sort(tempCol); // Ordena el arreglo tempCol de forma ascendente

            // Reemplazar los valores ordenados en la matriz original
            for (int fila = 0; fila < miMatriz.length; fila++) {
                miMatriz[fila][col] = tempCol[fila]; // Coloca los valores ordenados de vuelta en la matriz
            }
        }
    }
}
