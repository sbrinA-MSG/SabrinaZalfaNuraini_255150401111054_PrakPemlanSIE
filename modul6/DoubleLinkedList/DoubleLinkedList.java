
public class DoubleLinkedList {
    Node head, tail;
    int size = 0;

    void init() { head = null; }
    boolean isEmpty() { return size == 0; }
    int size() { return size; }

    void addFirst(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            data.next = head;
            head.prev = data;
            head = data;
        }
        size++;
    }

    void addLast(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            data.prev = tail;
            tail = data;
        }
        size++;
    }

    void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    void printReverse() {
        if (isEmpty()) { 
            System.out.println("List kosong"); 
            return; 
        }
        Node current = tail;   // mulai dari tail, bukan head
        while (current != null) {
            System.out.print("[" + current.data + "]");
            if (current.prev != null) 
                System.out.print(" , ");
            current = current.prev;  // mundur menggunakan pointer prev
        }
    }

    Node findByValue(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(value)) 
                return current;
            current = current.next;
        }
        return null;
    }

    Node findByIndex(int index) {
        if (index < 0 || index >= size) 
            return null;
        Node current = head;
        for (int i = 0; i < index; i++) 
            current = current.next;
        return current;
    }

    void deleteByIndex(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            System.out.println("Index tidak valid.");
            return;
        }
        if (size == 1) {
            // Hanya satu node, hapus semuanya
            head = null; 
            tail = null;
        } else if (index == 0) {
            // Hapus head
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            // Hapus tail
            tail = tail.prev;
            tail.next = null;
        } else {
            // Hapus node di tengah
            Node target = findByIndex(index);
            target.prev.next = target.next;   // menyambungkan prev ke next
            target.next.prev = target.prev;   // menyambungkan next ke prev
        }
        size--;
    }

    void deleteByValue(Object value) {
        Node target = findByValue(value);
        if (target == null) {
            System.out.println("Nilai " + value + " tidak ditemukan.");
            return;
        }
        if (size == 1) {
            head = null; 
            tail = null;
        } else if (target == head) {
            head = head.next;
            head.prev = null;
        } else if (target == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
        size--;
    }

    void addAtIndex(int index, Node data) {
        if (index < 0 || index > size) {
            System.out.println("Index tidak valid.");
            return;
        }
        if (index == 0) {
            addFirst(data); 
            return;
        }
        if (index == size) { 
            addLast(data);  
            return; 
        }
        Node successor = findByIndex(index);  // node yang akan bergeser ke kanan
        Node predecessor = successor.prev;

        // Hubungkan pointer dua arah
        data.next = successor;
        data.prev = predecessor;
        predecessor.next = data;
        successor.prev = data;
        size++;
    }

    void addAfter(Object value, Node data) {
        Node target = findByValue(value);
        if (target == null) {
            System.out.println("Nilai " + value + " tidak ditemukan.");
            return;
        }
        if (target == tail) {
            addLast(data);   //target adalah tail
            return;
        }
        Node successor = target.next;
        data.prev = target;
        data.next = successor;
        target.next = data;
        successor.prev = data;
        size++;
    }

    void addBefore(Object value, Node data) {
        Node target = findByValue(value);
        if (target == null) {
            System.out.println("Nilai " + value + " tidak ditemukan.");
            return;
        }
        if (target == head) {
            addFirst(data);   //target adalah head
            return;
        }
        Node predecessor = target.prev;
        data.next = target;
        data.prev = predecessor;
        predecessor.next = data;
        target.prev = data;
        size++;
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        Node nodeA = new Node ("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node ("C");

        list.addFirst(nodeA);
        System.out.println("head: " + list.head.data);
        System.out.println("tail: " +list.tail.data);

        list.addLast(nodeB);
        System.out.println("head: " + list.head.data);
        System.out.println("tail: " +list.tail.data);

        list.addLast(nodeC);
        System.out.println("head: " + list.head.data);
        System.out.println("tail: " +list.tail.data);

        list.print();

        System.out.println("=====");

        //no.5 mencari perbedaan addlast dan addfirst
        DoubleLinkedList list2 = new DoubleLinkedList();
        list2.addLast(new Node("A"));
        list2.addLast(new Node("B"));
        list2.addLast(new Node("C"));

        list2.print();
        
        System.out.println("Next of B: " + nodeB.next.data);
        System.out.println("Prev of B: " + nodeB.prev.data);

        //soal 7
        System.out.println("=== Cetak dari belakang ===");
        list.printReverse();
        System.out.println();

        //findByvalue no 8a
        System.out.println("=== Soal 8a: findByValue ===");
        Node found = list.findByValue("B");
        System.out.println("Cari 'B': " + (found != null ? found.data : "tidak ada"));
        found = list.findByValue("Z");
        System.out.println("Cari 'Z': " + (found != null ? found.data : "tidak ada"));

        //findByIndex 8b
        System.out.println("=== findByIndex ===");
        Node n = list.findByIndex(2);
        System.out.println("Index 2 : " + (n != null ? n.data : "tidak ada"));

        //deleteByIndex
        System.out.println("=== deleteByIndex ===");
        list.addLast(new Node("D"));
        list.addLast(new Node("E"));
        System.out.println("Sebelum: "); 
        list.print();
        list.deleteByIndex(1);
        System.out.println("Hapus index 1: "); 
        list.print();

        //deleteByValue
        System.out.println("=== deleteByValue ===");
        list.deleteByValue("D");
        System.out.println("Hapus 'D': "); 
        list.print();

        //addAtIndex
        System.out.println("=== addAtIndex ===");
        list.addAtIndex(1, new Node("B"));
        System.out.println("Tambah B di index 1: "); 
        list.print();

        //addAfter
        System.out.println("=== addAfter ===");
        list.addAfter("B", new Node("S"));
        System.out.println("Tambah S setelah B: "); 
        list.print();

        //addBefore
        System.out.println("=== addAfter ===");
        list.addBefore("A", new Node("R"));
        System.out.println("Tambah R sebelum A: "); 
        list.print(); 

    }
}
