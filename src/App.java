import Materia.Controller.AVLTree;
import Materia.Controller.BinaryTree;

public class App {
    public static void main(String[] args) {

        System.out.println("Nombre: Felipe Parra");
        AVLTree avl= new AVLTree();

        avl.insert(5);
        avl.insert(20);
        avl.insert(15);

        /*BinaryTree ab = new BinaryTree();

        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);*/

      /*  System.out.println("Peso del arbol = " + ab.getSize());
        System.out.println("Altura es = " + ab.getHeightTree() + "");

        System.out.println("Arbol InOrder");
        ab.printInOrder();

        System.out.println("Arbol InOrder con alturas");
        ab.printInOrderHeight();

        System.out.println("Arbol InOrder con factor de equilibrio");
        ab.printBalanceFactors();

        System.out.println("Arbol esta equilibrado = " + ab.isBalanced());

        int buscado = 15;
        boolean existe = ab.findValue(buscado);
        System.out.println("Existe el nodo " + buscado + "= " + existe);

        if (!existe) {
            System.out.println("Agregamos valor = " + buscado);
            ab.insert(buscado);
        }

        System.out.println("Arbol esta equilibrado = " + ab.isBalanced());

        System.out.println("Arbol InOrder con factor de equilibrio");
        ab.printBalanceFactors();
        System.out.println();

        ab.printUnbalancedNodes();*/
    }
}
