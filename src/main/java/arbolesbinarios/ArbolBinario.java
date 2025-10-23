package arbolesbinarios;

class ArbolBinario{
        Nodo raiz;
        public ArbolBinario(){
            raiz = null;
        }

        //GENERAR ALEATORIOS
        public int[] numAleatorio(int cantNodos){
            int[] vector = new int[cantNodos];

            for (int i = 0; i < cantNodos; i++){
                vector[i] = (int)(Math.random() * 100 + 1);
            }//insertar numeros aleatorios
            for (int i = 0; i < vector.length; i++){
                System.out.print(vector[i] + " "); //lista para copiar en el binary tree viewer y verificar el árbol
            }
            return vector;
        }

        //INSERTAR NODOS
        public void insertar(int dato){
            raiz = insertarRec(raiz,dato);
        }
        private Nodo insertarRec(Nodo raiz, int dato){
            if (raiz == null){
                raiz = new Nodo(dato);
                return raiz;
            }
            if (dato < raiz.dato){
                raiz.izquierda = insertarRec(raiz.izquierda, dato);
            }
            if (dato > raiz.dato){
                raiz.derecha = insertarRec(raiz.derecha, dato);
            }
            return raiz;
        }

        //MENOR VALOR EN EL SUB ARBOL DERECHO
        public void menorValorDerecha(){
            if (raiz != null){
                Nodo reco = raiz.derecha;
                if (raiz == null || raiz.derecha == null) {
                    System.out.println("No hay subárbol derecho.");
                    return;
                }
                while (reco.izquierda != null){
                    reco = reco.izquierda;
                }
                System.out.println("el valor más chico de la derecha es: " + reco.dato);
            }
        }

        //MAYOR VALOR EN EL SUB ARBOL IZQUIERDO
        public void mayorValorIzquierda(){
            if (raiz != null){
                Nodo reco = raiz.izquierda;
                if (raiz == null || raiz.izquierda == null) {
                    System.out.println("No hay subárbol derecho.");
                    return;
                }
                while(reco.derecha != null){
                    reco = reco.derecha;
                }
                System.out.println("el valor más grande de la izquierda es: " + reco.dato);
            }
        }

        //SI EL VALOR EXISTE EN EL NIVEL
        public void existeValorEnNivel (int dato){
            int nivel = 1;
            existeValor (raiz, nivel, dato);
        }
        private void existeValor (Nodo reco, int nivel, int dato){
            if (reco != null){
                existeValor(reco.izquierda, nivel + 1 , dato);
                if (reco.dato == dato){
                    System.out.println("el valor " + dato + " se encuentra en el nivel " + nivel);
                }
                existeValor(reco.derecha, nivel + 1, dato);

            }//si no existe el nodo (29), no se ejecuta
        }
        
        //ALTURA DEL ARBOL
        public int contarHojas (Nodo reco){
            if (reco == null) return 0;
            if (reco.izquierda == null && reco.derecha == null ) return 1;
            return contarHojas(reco.izquierda) + contarHojas(reco.derecha);
        }

        //ENTREORDEN DEL ARBOL
        //IZQUIERDA -> RAIZ -> DERECHA
        public void entreOrden(Nodo reco){
            if (reco != null){
                entreOrden(reco.izquierda);
                System.out.print(reco.dato + " - ");
                entreOrden(reco.derecha);
            }
        }

    }
