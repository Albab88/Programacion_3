import java.util.ArrayList;
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
        if(this.root != null) {
            this.printPreOrder(this.root);
        }
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
        if(this.root !=null) {
            this.printPosOrder(this.root);
        }
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
        if(this.root != null) {
            this.printInOrder(this.root);
        }
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

    //obtener todas las hojas
    public List<Integer> getFrontera() {
        List<Integer> frontera = new LinkedList<>();
        getFronteraRec(root, frontera);
        return frontera;
    }

    private void getFronteraRec(TreeNode actual, List<Integer> frontera) {
        if(actual == null) {
            return;
        } else if (actual.getLeft() == null && actual.getRight() == null) {
            //si es una hoja se agrega a la lista
            frontera.add(actual.getValue());
        } else { //si no es una hoja debe ir a izquierda y derecha y hacer recursivo
            getFronteraRec(actual.getLeft(), frontera);
            getFronteraRec(actual.getRight(), frontera);
        }
    }

    //borrado hecho con Maxi
    private TreeNode delete(TreeNode actual, int valor) {
        if(valor > actual.getValue()) {
            //le seteo 
            actual.setValue(delete(actual.getRight(), valor));
        }
        if(valor < actual.getValue()) {
            actual.setValue(delete(actual.getLeft(), valor));
        }
        //busco el nodo mas a la izquierda que sea hoja para poder usarlo
        TreeNode hijo = buscarNMI(actual.getRight());
    }

    private TreeNode buscarNMI(TreeNode actual) {
        if(actual == null) {
            return null;
        }
        else {
            return actual.getLeft();
        }
    }

    //borrado en clase
    public void delete(int valor) {
        root = deleteRec(this.root, valor); //esto es para cuando la raiz ...
    }

    private TreeNode deleteRec(TreeNode actual, int valor) {
        //el arbol es null entonces devuelvo arbol vacio
        if(actual == null) {
            return null;
        } else if(actual.getValue().equals(valor)) { //lo encontre
            //caso 1: es hoja
            if(actual.esHoja()) { //este metodo es del TreeNode y hay que hacerlo
                //este arbol tiene una unica hoja que es este valor
                return null;
            }
            else {
                //caso 2: tiene un hjo (tengo que ver los dos)
                if(actual.getLeft() == null) {
                    return actual.getRight(); //devolve lo que estaba a la derecha
                }
                else if(actual.getRight() == null) {
                    return actual.getLeft(); //devolvi lo que estaba a la izquierda
                } else {
                    //caso 3:cuando tengo dos hojas - ver si pero no es el valor
                    int valorNuevo = getMaxElem(actual.getLeft()); //hacer el getMAxElem en el Tree
                    actual.setValue(valorNuevo); //nuevo valor queda duplicado
                    actual.setLeft(delete(actual.getLeft(), valorNuevo));
                    return actual;
                }
            }
            //cuando no encontre el valor y tengo que ver si esta a derecha o a izquierda
        } else if(actual.getValue() > valor){
             actual.setLeft(delete(actual.getLeft(), valor));
        } else {
            actual.setRight(delete(actual.getRight(), valor));
        }
    }

    //ejercicio 2 - arbol binario de busqueda
    public int contarNodosInternos() {
        return contarNodosInternosRec(this.root);
    }

    private int contarNodosInternosRec(TreeNode actual) {
        //pregunto si esta vacio
        if(actual == null) {
            return 0;
        }
        else {
            //pregunto si tiene hojas a derecha o izquierda
            if(actual.getLeft()!= null || actual.getRight() != null) {
                return actual.getValue() + contarNodosInternosRec(actual.getLeft()) + contarNodosInternosRec(actual.getRight());
            }
        }
        return 0;
    }

    //ejercicio 3 - buscar hojas mayores a un numero
    public List<Integer> valoresMayorA(int k) {
        List<Integer> resultado = new ArrayList<>();
        valoresMayorARec(this.root, k, resultado);
        return resultado;
    }

    private void valoresMayorARec(TreeNode actual, int k, List<Integer> resultado) {
        if(actual == null) {
            return;
        } else if (actual.getLeft() == null && actual.getRight() == null) {
            //controlo si es una hoja y en ese caso consulto el valor de k
            if(actual.getValue()>k) {
                resultado.add(actual.getValue());
            }
        } else {
            //busco recursivo a izquierda y derecha hasta llegar a una hoja
            valoresMayorARec(actual.getLeft(), k, resultado);
            valoresMayorARec(actual.getRight(), k, resultado);
        }
    }

    //ejercicio 4 - arbol binario no de busqueda - ver si funciona
    public void completarArbol() {
        if(root != null) {
            completarArbolRec(this.root);
        }
    }

    private void completarArbolRec(TreeNode actual) {
        //pregunto su tiene dos hojas y retorno el valor pedido
        if(actual.getLeft() != null && actual.getRight() != null) {
            actual.setValue(actual.getRight().getValue() - actual.getLeft().getValue());
        } else if(actual.getLeft() != null && actual.getRight() == null) {
            // el derecho se hace 0 y resuelvo
            actual.setValue(0-actual.getLeft().getValue());
        } else if(actual.getLeft() == null && actual.getRight() != null) {
            //el izquierdo se hace 0 y resuelvo
            actual.setValue(actual.getRight().getValue());
        } else {
            completarArbolRec(actual.getLeft());
            completarArbolRec(actual.getRight());
        }
    }

    //ejercicio 4 charlado con Maxi
    public void completaArbol(){
        completar(this.root);
    }

    private int completar(TreeNode actual){
        if(actual == null){
            return 0;
        }
        if(actual.getRight() == null && actual.getLeft() == null) {
            return actual.getValue();
        }
        int valorR = completar(actual.getRight());
        int valorL = completar(actual.getLeft());
        actual.setValue(valorR - valorL);
        return actual.getValue();
    }

    //ejercicio 6 -
}
