import java.util.Hashtable;
import java.util.LinkedList;

public class Aplicacion {
    Linkedlist<Libro> libros;
    Hashtable<Integer, Libro> indicePorId;
    Hashtable<String, List<Libro>> indicePorGenero;

    public static void main (String[] args) {
        for(Registro r :  registros) {
            Libro l = new Libro;
            libros.add(l);
            indicePorId.put(l.getID(), l);

            Linkedist<Libro> lista = indicePorGenero.get(l.getGenero());
            if(lista == null)
                lista = new LinkedList();
            lista.add(l);
            indicePorGenero.put(l.getGenero(), lista);
        }
    }
    public static int servicio1(int ID) {
        return indicePorId.get(ID).getCantidadEjemplares();
    }

    public static String servicio2(String ) {
        return
    }
}
