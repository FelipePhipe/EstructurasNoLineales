package Materia.Controller;

import Materia.models.Node;

public class AVLTree {
    private Node root;


    public AVLTree(){
        root=null;
    }

    public void insert(int value){
        root= insertRec(root,value);
    }

    private Node insertRec(Node node, int value){
        if( node==null){
            Node newNode= new Node(value);
            newNode.setHeight(1);
            System.out.println("Nodo insertado: "+ value+ " con balance: "+getBalance(newNode));
            return newNode;
        }
        if (value < node.getValue()) {
        node.setIzquierdo(insertRec(node.getIzquierdo(), value));

        } else if (value > node.getValue()) {
        node.setDerecho(insertRec(node.getDerecho(), value));

        }else{

        return node;

        }
        System.out.println("Nodo actual-> "+ node.getValue());
        int altura= 1+ Math.max(height(node.getIzquierdo()),height(node.getDerecho()));
        node.setHeight(altura);
        System.out.println("Altura -> "+ altura);

        int balance= getBalance(node);
        System.out.println("Balance-> "+ balance);
        //CASO IZQUIERDA-IZQUIERDA
        if (balance>1 && value<node.getIzquierdo().getValue()){
            System.out.println("Rotacion simple derecha");
            return rigthRotation(node);
        }
        //CASO DERECHA-DERECHA
        if( balance<-1&& value>node.getDerecho().getValue()){
            System.out.println("Rotacion simple izquierda");
            return leftRotation(node);
        }
        //CASO IZQUIERDA-DERECHA
        if (balance>1 && value>node.getIzquierdo().getValue()){
            System.out.println("Cambio ");
            node.setIzquierdo(leftRotation(node.getIzquierdo()));
            System.out.println("Rotacion simple derecha");
            return rigthRotation(node);
        }
        //CASO DERECHA-IZQUIERDA
        if (balance<-1 && value<node.getDerecho().getValue()){
            System.out.println("Cambio ");
            node.setDerecho(rigthRotation(node.getDerecho()));
            System.out.println("Rotacion simple a la izquierda");
            return leftRotation(node);
        }

        return node;
    }

    private int height(Node node){

        if (node==null){
            return 0;
        }else{
            return node.getHeight();
        }
    }

    private int getBalance(Node node){
    if (node == null) {
        return 0;
    }
    return height(node.getIzquierdo()) - height(node.getDerecho());
    }

    private Node leftRotation( Node x){
        Node y= x.getDerecho();
        Node temp=y.getIzquierdo();
        
        //IMPRIMIR INFORMACION ANTES DE LA ROTACION
        System.out.println("Rotacion a la IZQ en nodo: "+ x.getValue()+ " con balance= "+ getBalance(x));

        //APLICAMOS LA ROTACION
        y.setIzquierdo(x);
        x.setDerecho(temp);

        //ACTUALIZAR LAS ALTURAS
        x.setHeight(Math.max(height(x.getIzquierdo()), height(x.getDerecho()))+1);
        y.setHeight(Math.max(height(y.getIzquierdo()), height(y.getDerecho()))+1);

        //IMPRIMIR INFORMACION DESPIES DE LA ROTACION
        System.out.println("Nueca raiz despues de la rotacion: "+ y.getValue());

        return y;
    }

    private Node rigthRotation(Node y){
        Node x= y.getIzquierdo();
        Node temp= x.getDerecho();

         //IMPRIMIR INFORMACION ANTES DE LA ROTACION
        System.out.println("Rotacion a la DER en nodo: "+ y.getValue()+ " con balance= "+ getBalance(y));

        //APLICAMOS LA ROTACION
        x.setDerecho(y);
        y.setIzquierdo(temp);

        //ACTUALIZAR LAS ALTURAS
        y.setHeight(Math.max(height(y.getIzquierdo()), height(y.getDerecho()))+1);
        x.setHeight(Math.max(height(x.getIzquierdo()), height(x.getDerecho()))+1);

        //IMPRIMIR INFORMACION DESPIES DE LA ROTACION
        System.out.println("Nueca raiz despues de la rotacion: "+ x.getValue());

        return x;


    }

    
}
