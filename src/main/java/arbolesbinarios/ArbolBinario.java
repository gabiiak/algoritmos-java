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

        //MAYOR VALOR EN EL SUB ARBOL IZQUIERDO
        public void mayorValorIzquierda(){
            Nodo reco = raiz.izquierda;
            if (raiz == null || raiz.izquierda == null) {
                System.out.println("No hay subárbol izquierdo.");
                return;
            }
            while(reco.derecha != null){
                reco = reco.derecha;
            }
            System.out.println("el valor más grande de la izquierda es: " + reco.dato);
        }

        //SI EL VALOR EXISTE EN EL NIVEL
        //* CORRECCIÓN POR TARS
        public int existeValorEnNivel (int dato){
            return existeValor(raiz, 1, dato);
        }
        private int existeValor (Nodo reco, int nivel, int dato){
            if (reco == null) return -1;
            if (reco.dato == dato) return nivel;
            int nivelizq = existeValor(reco.izquierda, nivel + 1, dato);
            if (nivelizq != -1) return nivelizq;
            return existeValor(reco.derecha, nivel + 1, dato);

            /*if (reco != null){
                existeValor(reco.izquierda, nivel + 1 , dato);
                if (reco.dato == dato){
                    System.out.println("el valor " + dato + " se encuentra en el nivel " + nivel);
                }
                existeValor(reco.derecha, nivel + 1, dato);

            }//si no existe el nodo (29), no se ejecuta
            */
        }
        
        //CANTIDAD DE NODOS HOJAS
        public int contarHojas (Nodo reco){
            if (reco == null) return 0;
            if (reco.izquierda == null && reco.derecha == null ) return 1;
            return contarHojas(reco.izquierda) + contarHojas(reco.derecha);
        }

        //CANTIDAD DE NODOS RAMA (internos)
        public int contarNodosInternos(Nodo reco){
            if (reco == null || reco.izquierda == null && reco.derecha == null) return 0;
            return 1 + contarNodosInternos(reco.izquierda) + contarNodosInternos(reco.derecha);
        }

        //ALTURA DEL ARBOL
        public int alturaArbol(Nodo reco){
            if (reco == null) return 0;
            int altizq = alturaArbol(reco.izquierda);
            int altder = alturaArbol(reco.derecha);
            if (altizq > altder) return altizq + 1;
            else return altder + 1;
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

        //PREORDEN DEL ARBOL
        // RAIZ -> IZQUIERDA -> DERECHA
        public void preOrden(Nodo reco){
            if (reco != null){
                System.out.print(reco.dato  + " - ");
                preOrden(reco.izquierda);
                preOrden(reco.derecha);
            }
        }

        //POSTORDEN DEL ARBOL
        //IZQUIERDA -> DERECHA -> RAIZ
        public void postOrden(Nodo reco){
            if (reco != null){
                postOrden(reco.izquierda);
                postOrden(reco.derecha);
                System.out.print(reco.dato + " - ");
            }
        }
    }
