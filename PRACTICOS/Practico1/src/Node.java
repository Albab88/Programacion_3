public class Node<T> {

    //los nodos tienen dos partes: la info que guardan(T info) y la referencia al siguiente (Node<T> next)
    private T info; //guarda infomacion
    private Node<T> next; //guarda otro nodo a continuacion (referencia)

    public Node() {
        this.info = null;
        this.next = null;
    }

    public Node(T info, Node<T> next) {
        this.setInfo(info);
        this.setNext(next);
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

}
