package modul6.KonsepLinkedList;
public class Node {
    Object data; //menyimpan nilai node
    Node next; //pointer ke node selanjutnya

    public static void main(String[] args){
        Node node = new Node();
        node.data ="A";

        System.out.println("node    : " + node);
        System.out.println("data    : " + node.data);
        System.out.println("pointer : " + node.next);

    }
}
