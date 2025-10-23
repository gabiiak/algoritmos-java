package arbolesbinarios;
import java.util.Scanner;
public class Arbol {
    static Scanner teclado;
    public static void main(String[] args) {
        ArbolBinario arbolito = new ArbolBinario();
        
        teclado = new Scanner(System.in);
        System.out.print("Holi. Insertá la cantidad de nodos que querés para el arbol y el valor no te preocupes, se genera aleatoriamente: ");
        int cantNodos = teclado.nextInt();
        int[] vector = arbolito.numAleatorio(cantNodos);
        //int[] vector = {30, 60 , 50, 29, 100, 213}; para comprobar que el método existevalor funciona
        
        for (int i = 0; i < vector.length; i++){
            arbolito.insertar(vector[i]);
        }

        System.out.println("\nLos nodos fueron insertados correctamente.");
        
        arbolito.menorValorDerecha();
        arbolito.mayorValorIzquierda();
        
        int nivel = arbolito.existeValorEnNivel(29);
        if (nivel != -1) System.out.println("El valor se encuentra en el nivel " + nivel);
        else System.out.println("El num 29 no existe en el arbol");
        /*CORRECCIÓN POR TARS 
        arbolito.existeValorEnNivel(29); //al ser valores aleatorios, el 29 puede existir... o no...
        */
        
        System.out.println("Cantidad de hojas del arbol: " + arbolito.contarHojas(arbolito.raiz));
        System.out.println("Cantidad de ramas del arbol: " + arbolito.contarNodosInternos(arbolito.raiz));
        System.out.println("Altura del arbol: " + arbolito.alturaArbol(arbolito.raiz));
        
        System.out.println("\nArbol ordenado por preorden");
        arbolito.preOrden(arbolito.raiz);

        System.out.println("\nArbol ordenado por entreorden");
        arbolito.entreOrden(arbolito.raiz);

        System.out.println("\nArbol ordenado por postorden");
        arbolito.postOrden(arbolito.raiz);
        
        teclado.close();
    }
    
}
