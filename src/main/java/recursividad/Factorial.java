package recursividad;
import java.util.Scanner;
public class Factorial {
    static Scanner teclado;
    public static int factorial (int num){
        if (num == 0) return 1;
        return num * factorial(num - 1);
    }
    public static void main (String [] args){
        teclado = new Scanner(System.in);
        System.out.println("Holi. Ingresá un número para descubrir su factorial!");
        int num = teclado.nextInt();
        System.out.println("El factorial del número " + num + " es " + factorial(num));
    }
}
