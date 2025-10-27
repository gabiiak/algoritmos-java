package recursividad;
import java.util.Scanner;
public class Digitos {
    static Scanner teclado;
    public static int sumarDigitos(int num){
        if (num < 10) return num;
        else return num % 10 + sumarDigitos(num / 10);
    }
    public static void main (String [] args){
        teclado = new Scanner (System.in);
        System.out.println("Holi. Ingresa un num y se van a sumar sus digitos: ");
        int num = teclado.nextInt();
        System.out.println("La suma del num '" + num + "' es: " + sumarDigitos(num));
    }
}
