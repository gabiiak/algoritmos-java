package arbolesbinarios;
import java.util.Scanner;
public class Arbol {
    static Scanner teclado;
    public static void main(String[] args) {
        ArbolBinario arbolito = new ArbolBinario();
        
        teclado = new Scanner(System.in);
        System.out.print("holi. insertá la cantidad de nodos que querés para el arbol y el valor no te preocupes, se genera aleatoriamente: ");
        int cantNodos = teclado.nextInt();
        int[] vector = arbolito.numAleatorio(cantNodos);
        //int[] vector = {30, 60 , 50, 29, 100, 213}; para comprobar que el método existevalor funciona
        
        for (int i = 0; i < vector.length; i++){
            arbolito.insertar(vector[i]);
        }

        System.out.println("\nlos nodos fueron insertados correctamente.");
        
        arbolito.menorValorDerecha();
        arbolito.mayorValorIzquierda();
        arbolito.existeValorEnNivel(29); //al ser valores aleatorios, el 29 puede existir... o no...
        System.out.println("cantidad de hojas del arbol: " + arbolito.contarHojas(arbolito.raiz));
        System.out.println("arbol ordenado por entreorden");
        arbolito.entreOrden(arbolito.raiz);
        teclado.close();
    }
    
}
