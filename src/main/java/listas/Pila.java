package listas;

public class Pila {
    private Nodo raiz;
    public Pila(){
        raiz = null; //raiz es nuestro primer nodo de la lista
    }
    public void insertar(int x){
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        if(raiz == null){ // si el primer nodo es vacío
            nuevo.sig = null;
            raiz = nuevo; //el nuevo nodo pasa a ser la raíz
        }else{
            nuevo.sig = raiz;
            raiz = nuevo;
        }
    } 
    public void imprimir(){
        Nodo reco = raiz;
        System.out.println("------Listado de todos los elementos de la pila------");//ctrl f2 para cambiar todas las referencias 
        while(reco != null){
            System.out.print(reco.info + " - ");
            reco = reco.sig;
        }
        System.out.println();
    }
    public int extraer(){
        if (raiz != null){
            int informacion = raiz.info;
            raiz = raiz.sig;
            return informacion;
        }else return Integer.MAX_VALUE;
    }
    public int retornar(){
        if (raiz != null){
            int informacion = raiz.info;
            return informacion;
        }else return Integer.MAX_VALUE;
    }
    public static void main (String[] args){
        Pila pila = new Pila();
        pila.insertar(13);
        pila.insertar(28);
        pila.insertar(97);
        pila.insertar(29);
        pila.insertar(61);
        pila.imprimir();
        System.out.println("extraemos de la pila: " + pila.extraer());
        pila.imprimir();
        System.out.println("retornamos el primero de la pila: " + pila.retornar());
        pila.imprimir();
        
    }
}
