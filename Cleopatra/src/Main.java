import java.util.Scanner;

public class Main {
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        int numCasos=leer.nextInt();
        for (int i = 0; i < numCasos; i++) {
            int a = leer.nextInt();
            int b = leer.nextInt();
            int c = leer.nextInt();

            int distanciaA;
            if(a>b){
                distanciaA = a-b;
            }else{
                distanciaA = b-a;
            }
            int distanciaC;
            if(c>b){
                distanciaC = c-b;
            }else{
                distanciaC = b-c;
            }
            if (distanciaA > distanciaC){
                System.out.println("A");
            } else if (distanciaC > distanciaA) {
                System.out.println("C");
            }else{
                System.out.println("Empate");
            }
            leer.close();
        }
    }
}