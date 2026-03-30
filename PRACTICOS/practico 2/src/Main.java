//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int [] A = {}; //vacio va con llaves

    }

//ejercicio1
    // es publica porque el usuario me pasa los datos
    public static boolean estaOrdenado (int [] A) {
        //return miEstaOrdenado(int[] A, pos);
    }

    private boolean miEstaOrdenado(int [] A, int pos) {
        if(pos>=A.length){
            return true;
        }
        else {
            if(A[pos]>A[pos+1]){
                return false;
            }
            else {
                  return miEstaOrdenado(A, pos+1);
            }
        }
    }

//ejercicio2
    public int buscarElemento(int [] A, int i) {
        return i;
    }

    private int miBuscarElemento(int [] A, int i, int inicio, int fin) {
        if(A.length==0){
            return -1;
        }
        else if(inicio<fin) {
           int mitad = (inicio+fin)/2;
            if(i<A[mitad]) {
                return miBuscarElemento(A, i, inicio, mitad-1);
            }
            else {
                return miBuscarElemento(A, i, mitad+1, fin);
            }
        }
        else
            return i;
    }

    //ejercicio3


}