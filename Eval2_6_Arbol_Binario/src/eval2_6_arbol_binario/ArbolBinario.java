/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval2_6_arbol_binario;

/**
 *
 * @author moviles
 */
public class ArbolBinario {
    private Nodo root;
    

    public ArbolBinario() {
        this.root = null;
    }
    
    //metodo publico para el usuario
    public void agregar(int valor){
        if(root == null)
            root = new Nodo(valor);
        else
            agregarRecur(valor, root);
    }
    
    // Metodo recursivo agregar
    //necesita el valor y el nodo actual
    private void agregarRecur(int valor,Nodo nodoActual){
        //que el nodo recibido es null
        //arbol vacio
        //2 decidir si va a izq o der
        /*
          verificar si el lado (nodo) es null
             si es null, ahi va el valor
          si no
             repetir recursión
         
        */
        Nodo nuevo = new Nodo(valor);
        if(valor < nodoActual.getValor()){//va a la izq
            if(nodoActual.getIzquierda()==null){
                nodoActual.setIzquierda(nuevo);
            }else{
                agregarRecur(valor, nodoActual.getIzquierda());
            }
            
        }else if(valor > nodoActual.getValor()){//va a la der
            if(nodoActual.getDerecha()==null){
                nodoActual.setDerecha(nuevo);
            }else{
                agregarRecur(valor, nodoActual.getDerecha());
            }
            
        }else{//igual
            //ignorar
            System.out.println("Elemento repetido!!");
        }              
    }
    
    //impresion de valores.
        //in orden
        //izq valor der
        //metodo publico
        public void inOrder(){
            inOrderRecu(root);
            System.out.println("");
        }
        //metodo privado recursivo
        private void inOrderRecu(Nodo nodo){
            if(nodo != null){
                inOrderRecu(nodo.getIzquierda()); 
                System.out.print(nodo.getValor()+" - ");                
                inOrderRecu(nodo.getDerecha());
            }
        }
        
        public void preOrder(){
            preOrderRecu(root);
            System.out.println("");
        }
        
        private void preOrderRecu(Nodo nodo){
            if(nodo != null){ 
                System.out.print(nodo.getValor()+" - ");              
                preOrderRecu(nodo.getIzquierda());               
                preOrderRecu(nodo.getDerecha()); 
                
                                
           }
        }
    
        public void postOrder(){
            postOrderRecu(root);
            System.out.println("");
        }
        
        private void postOrderRecu(Nodo nodo){
            if(nodo != null){               
                postOrderRecu(nodo.getIzquierda()); 
                postOrderRecu(nodo.getDerecha());
                System.out.print(nodo.getValor()+" - ");                
                
            }
        }
       //como borramos nodos
}
