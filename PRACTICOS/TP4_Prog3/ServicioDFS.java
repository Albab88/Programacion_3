package ProgramacionIII.tp4;

import java.util.List;

public class ServicioDFS {
    Grafo<?> grafo;
    List<Integer> resultado;
    //colores

    public ServicioDFS(Grafo<?> grafo) {
        this.grafo = grafo;
    }

    /*public void dfs {
        //inicializa en blanco
        //llama al dfsVisit (colores)
    }*/

    public List<Integer> dfs {
        //inicializa en blanco
        //llama al dfsVisit
        return resultado;
    }

    private void dfsVisit(int origen) {
        System.out.println(origen);
        resultado.add(origen);
    }
}
