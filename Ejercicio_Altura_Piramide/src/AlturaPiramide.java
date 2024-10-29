import java.util.Scanner;

public class AlturaPiramide {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bloquesUsuario = scanner.nextInt();
        int bloquesAcumulados = 1;
        int nivel = 1;
        int multiplicadorBloques = 1;
        while (bloquesUsuario > bloquesAcumulados) {
            nivel++;
            multiplicadorBloques += 2;
            bloquesAcumulados = bloquesAcumulados + (multiplicadorBloques*multiplicadorBloques);

        }
        System.out.println(nivel);
    }
}
