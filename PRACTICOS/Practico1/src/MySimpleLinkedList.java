import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {

    private Node<T> first; //referencia al primer nodo de la lista
    private int _size; //es su responsabilidad saber cuantos elementos tiene

    public MySimpleLinkedList() {
        this.first = null;
        this._size = 0;
    }

    //O(1)
// se inserta desde el primer elemento, por eso se agrega el null al nodo nuevo
    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null); // creo un nuevo nodo
        tmp.setNext(this.first); //tmp en su siguiente (referencia) apunta al first
        this.first = tmp; //mi nuevo first en tmp
        this._size++;
    }

    //O(1)
    //se elimina del principio
    public T extractFront() {
        Node<T> tmp = this.first;
        T info = tmp.getInfo(); //guardo en info del tipo T la info de tmp
        this.first = tmp.getNext(); // el primero apunta al siguiente
        this._size--; // le resto uno al tamaño
        return info;
    }

    /* if(first !=null){
        * T info = first.getInfo()
        * first = first.getNext()
        * size--;*/

    //O(1)
    public boolean isEmpty() {
        return this.first == null; //puedo hacerlo con el size = 0
    }

    //O(n)
    public T get(int index) {
        if(index<0 || index>this._size){
            return null;
        }
        else {
            Node<T> tmp = this.first;
            int i = 0;
            while (index < this.size() && i < index) { //while(temp !=null && i<indes)
                tmp = tmp.getNext();
                i++;
            }
        return tmp.getInfo();
        }
    }

    /*if(index>0 && index<size) { ver las diferencias con el mio
    int pos =0;
    Node <T> tmp = this.first;
    while(temp !=null && i<index){
        pos++
        tmp = tmp.getNext()
        }
        if(tmp !=nulll)
        return tmp.getInfo();
    return null;
*/
    // O(1) porque ya traigo el tamaño de arriba asi que es un solo espacio de memoria
    public int size() {
        return _size;
    }

    //O(n)
    public int indexOf(T elem) { //analizar bien el metodo
        Node<T> tmp = this.first;
        int i = 0;
        while (tmp != null) {
            if(tmp.getInfo().equals(elem)){
                return i;
            }
            tmp = tmp.getNext();
            i++;
        }
        return -1;
    }

   /* //O(n) donde n es el tamaño de la lista (cantidad de nodos)
    public int size() {
        Node<T> cursor = first; //arranca en el primer nodo
        int contador = 0;
        while(cursor != null) {
            contador++;
            cursor = cursor.getNext(); //se para en el cursor del siguiente nodo
        }
        return contador;
    }*/

    //O(n)
   @Override
   public String toString() {
       String resultado = "["; //escribo el corchete para iniciar el arreglo
       Node<T> tmp = first;
       while (tmp != null) {
           resultado = resultado + tmp.getInfo().toString(); //le pido su info
           if (tmp.getNext() != null) { //veo si tiene siguiete
               resultado += ", "; //agrego una coma para concatenar
           }
           tmp = tmp.getNext(); //avanzo al siguiente
       }
       resultado += "]"; //cierro el corchete
       return resultado; //devuelvo el arreglo
   }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
    //la agrego com privada adentro porque solo la voy a utilizar aca. Si hay mas de un iterador va afuera como publica
    private class MyIterator implements Iterator<T> {
       private Node<T> cursor;

       public MyIterator() {
           this.cursor = first;
       }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
           T info = cursor.getInfo();
           cursor = cursor.getNext();
            return info;
        }
    }
}
