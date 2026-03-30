public class Tree {

    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    //determina el valor de la raiz
    public Integer getRoot() {
        if(this.root == null) {
            return null;
        }
        else {
            return root.getValue();//me devuelve el valor
        }
    }

    //ver si tiene un elemento
    public boolean hasElem(int value) {
        //verifica si el valor no existe o si no tiene raiz
        if(root ==null) {
            return false;
        }
        //genera la recursion para entrar al arbol
        return hasElemRec(root, value);
    }

    private boolean hasElemRec(TreeNode actual, int value) {
        if(actual == null) {
            return false;
        } if
    }

    /*private boolean hasElemRecursive(Node node, Integer value) {
        if (node == null) {
            return false; // Elemento no encontrado si se llega a un nodo nulo
        } else if (value.equals(node.getValue())) {
            return true; // Elemento encontrado si coincide con el valor del nodo
        } else if (value < node.getValue()) {
            return hasElemRecursive(node.getLeft(), value); // Busca en el subárbol izquierdo
        } else {
            return hasElemRecursive(node.getRight(), value); // Busca en el subárbol derecho
        }
    }*/

    //verifica si esta vacio el arbol
    public boolean isEmpty() {
        return this.root == null;
    }

    //agregar un valor
    public void add(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root,value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(),value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(),value);
            }
        }
    }

    //obtener altura del arbol
    public Integer getHeight() {
        if(isEmpty()) {
            return -1;
        }
        return getHeightRec(root);
    }

    private Integer getHeightRec(TreeNode arbol) {
        if(arbol == null) {
            return 0; //no hay arbol por lo que no tiene altura
        }
        else {
            //calculo por recursion cada rama del arbol
            int izquierda = getHeightRec(arbol.getLeft());
            int derecha = getHeightRec(arbol.getRight());
            //devuelve la rama las larga, mas 1 de la raiz
            return Math.max(derecha, izquierda) + 1;
        }
    }
}
