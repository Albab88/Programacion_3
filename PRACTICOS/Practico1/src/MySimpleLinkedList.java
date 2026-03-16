public class MySimpleLinkedList<T> {

    private Node<T> first;
    private int _size; //es su responsabilidad saber cuantos elementos tiene

    public MySimpleLinkedList() {
        this.first = null;
        this._size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null); // genero un nuevo nodo temporal
        tmp.setNext(this.first); //le seteo el siguiente nodo
        this.first = tmp;
        this._size++;
    }

    public T extractFront() {
        Node<T> tmp = this.first;
        T info = tmp.getInfo(); //guardo en info del tipo T la info de tmp
        this.first = tmp.getNext(); // el siguiente se vuelve el primero
        this._size--; // le resto uno al tamaño
        return info;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T get(int index) { //ver por que esta mal
        Node<T> tmp = this.first;
        int i=0;
        while(index<this.size() && i<index) {
            tmp = tmp.getNext();
            i++;
        }
        return tmp.getInfo();
    }

    // O(1) porque ya traigo el tamaño de arriba asi que es un solo espacio de memoria
    public int size() {
        return _size;
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

    @Override
    public String toString() {
        // TODO
        return "";
    }

}
