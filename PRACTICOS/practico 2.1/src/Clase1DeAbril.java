/*Dado un ABB que almacena enteros, implementar un metodo
* que retorne la cantidad*/

import java.util.LinkedList;
import java.util.List;

public class Clase1DeAbril {

    private TreeNode root;

    public int contarValores(int min, int max) {
        return contarValoresRec(min, max, this.root);
    }

    private int contarValoresRec(int min, int max, TreeNode actual) {
        if (actual == null)
            return 0;
        if (actual.getValue() < min) {
            return contarValoresRec(min, max, actual.getRight());
        }
        if (actual.getValue() > max) {
            return contarValoresRec(min, max, actual.getLeft());
        }
        return 1 + contarValoresRec(min, max, actual.getLeft()) + contarValoresRec(min, max, actual.getRight());

    }

    public List<Integer> contarValoresRango(int min, int max) {
        List<Integer> resultado = new LinkedList<>();
        contarValoresRango(min, max, this.root, resultado);
        return resultado;
    }

    private void contarValoresRango(int min, int max, TreeNode actual, List<Integer> resultado) {
        if (actual == null) {
            return;
        }
        if (actual.getValue() < min) {
            contarValoresRango(min, max, actual.getRight(), resultado);
        } else if (actual.getValue() > max) {
            contarValoresRango(min, max, actual.getLeft(), resultado);
        } else {
            contarValoresRango(min, max, actual.getRight(), resultado);
            resultado.add(actual.getValue());
            contarValoresRango(min, max, actual.getRight(), resultado);
        }
    }
}


        /*if(actual.getValue() >= min && actual.getValue()<=max) {
            return 1 + contarValores(min, max, actual.getLeft()) + contarValores(min, max, actual.getRight())*/

