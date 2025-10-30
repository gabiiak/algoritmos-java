package arbolesbinarios;

class ArbolBinario{
        static int cant;
        Nodo raiz;
        public ArbolBinario(){
            raiz = null;
        }

        //GENERAR ALEATORIOS
        public int[] numAleatorio(int cantNodos){
            int[] vector = new int[cantNodos];
            for (int i = 0; i < cantNodos; i++){
                int num;
                boolean repetido;

                do{
                    num = (int)(Math.random() * 100 + 1);
                    repetido = false;

                    for (int j = 0; j < i; j++){ //para verificar que no esté repetido
                        if (vector[j] == num){
                            repetido = true;
                            break;
                        }
                    }
                }while (repetido);
                vector[i] = num;
            }//insertar numeros aleatorios

            for (int i : vector){ //foreach para más placer
                System.out.print(i + " "); //lista para copiar en el binary tree viewer y verificar el árbol
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
                System.out.print("\nNo hay subarbol derecho.");
                return;
            }
            while (reco.izquierda != null){
                reco = reco.izquierda;
            }
            System.out.print("\n1 - El menor valor de la derecha es: " + reco.dato);        
        }

        //MAYOR VALOR EN EL SUB ARBOL IZQUIERDO
        public void mayorValorIzquierda(){
            Nodo reco = raiz.izquierda;
            if (raiz == null || raiz.izquierda == null) {
                System.out.print("\nNo hay subarbol izquierdo.");
                return;
            }
            while(reco.derecha != null){
                reco = reco.derecha;
            }
            System.out.print("\n2 - El mayor valor del subarbol izquierdo es: " + reco.dato);
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
                    System.out.print("el valor " + dato + " se encuentra en el nivel " + nivel);
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

        //CONTAR NODOS MAYORES A UN VALOR N
        public int contarNodosMayoresA(int num){
            cant = 0;
            cantidad (raiz, num);
            return cant;
        }
        private void cantidad (Nodo reco, int num){
            if (reco != null){
                if (reco.dato > num) cant++;
                cantidad(reco.izquierda, num);
                cantidad(reco.derecha, num);
            }
        }

        //RETORNAR EL NIVEL DONDE ESTA EL NODO CON EL VALOR INDICADO
        public int nivelDelNodo (int valor){
            return nivelNodo (raiz, 1, valor);
        }
        private int nivelNodo (Nodo reco, int nivel, int valor){
            if (reco == null) return -1;
            if (reco.dato == valor) return nivel;
            int nivelIzquierdo = nivelNodo(reco.izquierda, nivel + 1, valor);
            if (nivelIzquierdo != -1) return nivelIzquierdo;
            return nivelNodo (reco.derecha, nivel + 1, valor);
        }

        //INDICAR SI EL ARBOL ES SIMÉTRICO (TARS)
        public boolean esSimetrico(){
            return simetrico (raiz.izquierda, raiz.derecha);
        }
        private boolean simetrico (Nodo recoIzq, Nodo recoDer){
            if (recoIzq == null && recoDer == null) return true;
            if (recoIzq == null || recoDer == null) return false;
            return simetrico(recoIzq.izquierda, recoDer.derecha) && simetrico(recoIzq.derecha, recoDer.izquierda);
        }

        //SUMAR NODOS IMPARES (TARS)
        public int sumarImpares(){
            return sumarImparesRecursivo(raiz);
        }
        private int sumarImparesRecursivo(Nodo reco){
                if (reco == null) return 0;
                int suma = 0;
                if (reco.dato % 2 != 0) suma += reco.dato;
                return suma + sumarImparesRecursivo(reco.izquierda) + sumarImparesRecursivo(reco.derecha); 
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

        /*comodin: QUEDA MÁS FACHERO AGREGAR NUMS ALEATORIOS A UNA LISTA
        
            public int[] numAleatorio(int cantNodos) {
            List<Integer> numeros = new ArrayList<>();
            for (int i = 1; i <= 100; i++) numeros.add(i);
            Collections.shuffle(numeros);

            int[] vector = new int[cantNodos];
            for (int i = 0; i < cantNodos; i++) {
                vector[i] = numeros.get(i);
            }

            System.out.println(Arrays.toString(vector));
            return vector;
        } SABRÁ DIOS COMO FUNCIONA MI CÓDIGO*/ 
    }
