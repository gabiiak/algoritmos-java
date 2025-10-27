package recursividad;
import java.util.Scanner;
public class Fibonacci {
    static Scanner teclado;
    public static int fibonacci(int num){
        //CASOS BASE
        if (num <= 0) return 0;
        if (num == 1) return 1;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
    public static void main (String[] args){
        teclado = new Scanner (System.in);
        System.out.println("Holi. Ingresa hasta un num para ver la sucesion de fibonacci hasta ese num: ");
        int num = teclado.nextInt();
        System.out.println("La sucesion de fibonacci se ejecuto hasta el numero " + num);
        for (int i = 1; i < num; i++){
            System.out.print(fibonacci(i) + " - ");
        }
    }
}
