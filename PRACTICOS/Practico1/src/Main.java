//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();
        lista.insertFront(5);
        lista.insertFront(8);
        lista.insertFront(20);
        lista.insertFront(31);
        lista.insertFront(35);

        for(Integer elem : lista) {
            System.out.println(elem);
        }
    }
}