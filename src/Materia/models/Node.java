package Materia.models;

public class Node {

    private int value;
    private Node izquierdo;
    private Node derecho;
    private int height;

    public Node(int value) {
        this.value=value;
        this.derecho=null;
        this.izquierdo=null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Node izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Node getDerecho() {
        return derecho;
    }

    public void setDerecho(Node derecho) {
        this.derecho = derecho;
    }
    

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + ", izquierdo=" + izquierdo + ", derecho=" + derecho + ", height=" + height
                + "]";
    }

    
    
 
}
