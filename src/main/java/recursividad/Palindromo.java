package recursividad;
import java.util.Scanner;
public class Palindromo {
    static Scanner teclado;
    public static boolean esPalindromo (String palabra){
        if (palabra.length() <= 1) return true;
        if (palabra.charAt(0) != palabra.charAt(palabra.length() - 1)) return false;
        return esPalindromo(palabra.substring(1,(palabra.length() - 1)));
        /*substring: toma el segundo caracter y el penúltimo. la recursión va recortando esa palabra */
    }
    public static void main (String [] args){
        teclado = new Scanner (System.in);
        System.out.println("Holi. Ingresá una palabra para ver si es palindromo o no: ");
        String palabra = teclado.next();
        System.out.println("La palabra '" + palabra + "' es palindromo? : " + esPalindromo(palabra));
    }
}
