//Complejidad O(n) donde n es el numero de nodos
public class Ejercicio2 {
    private TreeNode root;

    public Ejercicio2(TreeNode root) {
        this.root = root;
    }

    public Integer sumaNodosInt() {
        return sumaNodosIntRec(this.root);
    }

    private Integer sumaNodosIntRec(TreeNode actual) {
        //si no hay arbol
        if (actual == null) {
            return 0;
        }
        //si el arbol tiene hijos a alguno de los dos lados (es nodo interno)
        if (actual.getLeft() != null || actual.getRight() != null) {
            return actual.getValue() + sumaNodosIntRec(actual.getLeft()) + sumaNodosIntRec(actual.getRight());
        }
        //si es una hoja
        return 0;
    }
}
