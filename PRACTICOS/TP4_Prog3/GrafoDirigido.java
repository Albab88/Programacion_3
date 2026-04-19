package ProgramacionIII.tp4;

import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {
    //Uso HashSet porque me aseguro que los arcos no esten repetidos
    //set es un conjunto
    private Hashtable<Integer,HashSet<Arco<T>>> vertices;
    private HashSet<Arco<T>> arcos;


    //constructor
    public GrafoDirigido() {
        this.vertices = new Hashtable<>();
        this.arcos = new HashSet<>();
    }

	@Override
	public void agregarVertice(int verticeId) {
        if(!vertices.contieneVertice(verticeId)) {
            vertices.put(verticeId, new HashSet<>());
        }

        /*Set<Arco<T>> arcos = new HashSet<Arco<T>>;
        * vertices.put(verticeId, arcos)*/
	}

	@Override
	public void borrarVertice(int verticeId) {
        //esto borra el vertice de la lista y todos sus arcos salientes
		if(vertices.contieneVertice(verticeId)) {
            vertices.remove(verticeId);
        }
        //ver en la lista si algun elemento tiene arco con el vertice que quiero borrar

	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if(vertices.contieneVertice(verticeId1) && vertices.contieneVertice(verticeId2)) { //ver si corresponde y cambiar el contains
            Arco<T> arco = new Arco<>(verticeId1, verticeId2, etiqueta);
            vertices.get(verticeId1).add(arco);
            //redefinir en la clase arco el equals
        }
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
    //arreglar porque no tengo las cosas
        /*LinkedList<Integer> vertices = new LinkedList<>();
        for(NodoGrafo nodo: lista) {
            vertices.add(nodo.verticeId);
        }
		// TODO Auto-generated method stub
		return vertices.iterator();*/
        //la funcion keySet() me permite resolver sin hacer codigo
        return vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        List<Integer> adyacentes = new LinkedList<>();
        if(contieneVertice(verticeId)) {

        }
        List<Arco<T>> arcos = new LinkedList<>();
        for(Arco<T> arco : vertices.get(verticeId)) {
            //obtener todos los arcos que estan adyacentes a cada vertice

        }
		return adyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
