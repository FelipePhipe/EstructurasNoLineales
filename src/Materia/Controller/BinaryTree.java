package Materia.Controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Materia.models.Node;

public class BinaryTree {

    private Node root;
    private int size = 0;

    public BinaryTree(){
        this.root = null;
    }
    
    public void insert(int value){
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
    if (padre == null) {
        size++; 
        return new Node(value);
    }
    if (value < padre.getValue()) {
        padre.setIzquierdo(insertRec(padre.getIzquierdo(), value));
    } else if (value > padre.getValue()) {
        padre.setDerecho(insertRec(padre.getDerecho(), value));
    }
    return padre;
}

    public void printPosOrder(){
        printPosOrderRec(root);
    }

    private void printPosOrderRec(Node node){
        if (node != null){
            printPosOrderRec(node.getIzquierdo());
            printPosOrderRec(node.getDerecho());
            System.out.print(node.getValue() + ", ");
        }
    }

    public void printPreOrder(){
        printPreOrderRec(root);
    }

    private void printPreOrderRec(Node node){
        if (node != null){
            System.out.print(node.getValue() + ", ");
            printPreOrderRec(node.getIzquierdo());
            printPreOrderRec(node.getDerecho());
        }
    }

    public void printInOrder(){
        printInOrderRec(root);
    }

    private void printInOrderRec(Node node){
        if (node != null){
            printInOrderRec(node.getIzquierdo());
            System.out.print(node.getValue() + ", ");
            printInOrderRec(node.getDerecho());
        }
    }

    public boolean findValue(int value) {
    return findValueRec(root, value);
}

    private boolean findValueRec(Node node, int value) {
    if (node == null) {
        return false;
    }

    if (value == node.getValue()) {
        return true;
    } else if (value < node.getValue()) {
        return findValueRec(node.getIzquierdo(), value);
    } else {
        return findValueRec(node.getDerecho(), value);
    }
}

    public int getHeightTree(){
    return getHeightTreeRec(root);

    }
    public int getHeightTreeRec(Node node){
        if (node==null){
            return 0;
        }
        int lefHeight= getHeightTreeRec(node.getIzquierdo());
        int rightHeight= getHeightTreeRec(node.getDerecho());

       /*  if (lefHeight>rightHeight){
            return lefHeight+1;
        }else{
            return rightHeight+1;
        }*/

        return Math.max(lefHeight, rightHeight)+1;



    }


    public void printInOrderHeight(){
        printInOrderHeightRec(root);
    }

    private void printInOrderHeightRec(Node node){
        if (node != null){
            printInOrderHeightRec(node.getIzquierdo());
            int height= getHeightTreeRec(node);
            System.out.print(node.getValue()+"(h=" +height+")"+ ", ");
            printInOrderHeightRec(node.getDerecho());
        }
    }



   public void printBalanceFactors() {
    printBalanceFactorsRec(root);
    }

    private void printBalanceFactorsRec(Node node) {
        if (node != null) {
            int leftHeight = getHeightTreeRec(node.getIzquierdo());
            int rightHeight = getHeightTreeRec(node.getDerecho());
            int balance = leftHeight - rightHeight;

        System.out.print(node.getValue()+"(bf=" +balance+")"+ ", ");
        
        printBalanceFactorsRec(node.getIzquierdo());
        printBalanceFactorsRec(node.getDerecho());
        }
    }

 

    public int getSize() {
        return size; 
    }

    public boolean isBalanced() {
        return isBalancedRec(root);
    }

    private boolean isBalancedRec(Node node) {
        if (node == null) return true;

        int bf = Math.abs(getHeightTreeRec(node.getIzquierdo()) - getHeightTreeRec(node.getDerecho()));
        return (bf <= 1) && isBalancedRec(node.getIzquierdo()) && isBalancedRec(node.getDerecho());
    }

    public void printUnbalancedNodes() {
        printUnbalancedNodesRec(root);
    }

    private void printUnbalancedNodesRec(Node node) {
        if (node != null) {
            int bf = getHeightTreeRec(node.getIzquierdo()) - getHeightTreeRec(node.getDerecho());
            if (Math.abs(bf) > 1) {
                System.out.print("Nodo desequilibrados " + node.getValue() + " (fE = " + bf + ")");
            }
            printUnbalancedNodesRec(node.getIzquierdo());
            printUnbalancedNodesRec(node.getDerecho());
        }
    }

}
