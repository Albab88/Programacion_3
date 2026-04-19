import java.util.LinkedList;
import java.util.List;

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
       //genera la recursion para entrar al arbol
        return hasElemRec(root, value);
    }

    private boolean hasElemRec(TreeNode actual, int value) {
        if(actual == null) {
            return false;
        } else
            if(actual.getValue() == value) {
                return true;
        } else if(actual.getValue() < value) {
                return hasElemRec(actual.getRight(), value); //busco el elemento a la derecha
        } else {
            return hasElemRec(actual.getLeft(), value); //busco el elemento a la izquierda
        }
    }

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

    //imprimir preOrder
    public void printPreOrder() {
        /*if(this.root != null) {
            this.printPreOrder(this.root);
        }*/
        this.printPreOrder(this.root);
    }

    private void printPreOrder(TreeNode actual) {
        if(actual == null) {
            System.out.println("-");
        }
        else {
            System.out.print(actual.getValue() + " ");
            this.printPreOrder(actual.getLeft());
            this.printPreOrder(actual.getRight());
        }
    }

    //imprimir posOrder
    public void printPosOrder(){
        /*if(this.root !=null) {
            this.printPosOrder(this.root);
        }*/
        this.printPosOrder(this.root);
    }

    private void printPosOrder(TreeNode actual) {
        if(actual == null) {
            System.out.println("-");
        }
        else {
            this.printPosOrder(actual.getLeft());
            this.printPosOrder(actual.getRight());
            System.out.print(actual.getValue() + " ");
        }
    }

    //imprimir inOrder
    public void printInOrder() {
        /*if(this.root != null) {
            this.printInOrder(this.root);
        }*/
        this.printInOrder(this.root);
    }

    private void printInOrder(TreeNode actual) {
        if(actual == null) {
            System.out.println("-");
        }
        else {
            this.printInOrder(actual.getLeft());
            System.out.print(actual.getValue() + " ");
            this.printInOrder(actual.getRight());
        }
    }

    //encontrar la rama mas larga
    public List getLongestBranch() {
        return this.getLongestBranch(this.root);
    }

    private List getLongestBranch(TreeNode actual) {
        List<Integer> branch = new LinkedList<>();
        if(actual == null) {
            return branch;
        }
        // genero un List
        //pregunto a la raiz si tiene hijos
        //si tiene hijos se llama a si misma
        //devuelvo lo que me da mas uno
//si no tiene devuelvo uno
        return;
    }

    //obtener la frontera, todas las hojas
    public List<Integer> getFrontera() {
        List<Integer> frontera = new LinkedList<>();
        getFronteraRec(this.root, frontera);
    }

    private void getFronteraRec(TreeNode actual, List<Integer> frontera) {
        if(actual == null) {
            return;
        }
        //si actual no tiene hijos lo agregamos a el a la lista
        if(actual.getLeft() == null && actual.getRight() == null) {
            frontera.add(actual.getValue());
        }
        // si tiene hijos recorre y agrega por recursividad
        getFronteraRec(actual.getLeft(), frontera);
        getFronteraRec(actual.getRight(), frontera);
    }
}
