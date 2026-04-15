public class SingleLinkedList {
    
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
            tail = data;
        }
        size++;
    }

    //FindbyValue --> mencari node berdasarkan nilai data
    Node findByValue(Object value){
        Node current = head; //dimulai dari head
        while (current != null) {
            if(current.data.equals(value)){
                System.out.println("Cari '" + value + "' : " + current.data + " ditemukan");
                return current; //ketemu
            }
            current = current.next; //maju ke node berikutnya
        }
        System.out.println("Cari '" + value + "' : " + value + " tidak ditemukan");
        return null; //jika tidak ditemukan
    }

    //findByIndex --> cari node di posisi ke-n (mulai dari 0)
    Node findByIndex(int index){
        if (index < 0 || index >= size()){
            System.out.println("Index " + index + " : Tidak ditemukan" );
            return null;
        }
            
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.next; //maju sebanyak index langkah
        }
        System.out.println("Index " + index + "  : " + current.data);
        return current;
    }

    //deleteByIndex --> untuk menghapus node di sisi ke-n
    void deleteByIndex(int index){
        if (isEmpty() || index < 0 || index >= size){
            System.out.println("Index tidak valid atau list kosong.");
            return;
        }
        if (index==0){ 
            //menghapus node di depan: geser head ke node berikutnya
            head = head.next;
            if (head == null) tail=null; //list jadi kosong
        } else {
            //cari node sebelum posisi index
            Node prev = findByIndex(index-1);
            Node toDelete = prev.next;
            prev.next = toDelete.next; //lewati node yang dihapus

            if (toDelete == tail){
                tail = prev; //update tail jika node terkahir yang dihapus
            }
        }
        size--;
    }
    //delete by value --. untuk hapus node dengan nilai tertentu
    void deleteByValue(Object value){
        if (isEmpty()){
            System.out.println("List kosong.");
            return;
        }

        //jika node yang dihapus adlaah head
        if(head.data.equals(value)){
            head=head.next;
            if(head == null) tail = null;
            size--;
            return;
        }

        //cari node sebelum node target
        Node prev = head;
        Node current = head.next;
        while (current != null){
            if (current.data.equals(value)){
                prev.next = current.next; // lewati node target
                if (current == tail) tail = prev; //update tail jika diperlukan
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("Nilai " + value + "tidak ditemukan");
    }

    //AddAtIndex
    void addAtIndex (int index, Node data){
        if (index < 0 || index > size){
            System.out.println("Index tidak valid.");
            return;
        }
        if (index == 0){
            addFirst(data); //tamabh di depan
        } else if (index == size){
            addLast(data); //tambah dibelakang
        }else {
            //menyisipkan ditengah dengan mencari node sebelum posisi index
            Node prev = findByIndex(index-1);
            data.next = prev.next;

            //menghubungkan node baru ke node setelahnya
            prev.next = data;

            //menghubungkan node sebelumnya ke node baru
            size++;
        }
    }

    //addAfter
    void addAfter (Object value, Node data){
        Node target = findByValue(value);
        if (target == null) {
            System.out.println("Nilai " + value + "tidak ditemukan");
            return;
        }
        data.next = target.next; //node baru menunjuk ke node setelah target
        target.next = data; //target menunjuk ke node baru

        if(target == tail){
            tail = data; //update tail jika target adalah ekor
        }
        size++;
    }

    //addBefore --> tambah node sebelum node dengan nilai tertentu
    void addBefore (Object value, Node data){
        if (isEmpty()){
            System.out.println("List Kosong.");
            return;
        }

        //menargetkan head
        if (head.data.equals(value)) {
            addFirst(data);
            return;
        }

        //cari node sebelum target
        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.data.equals(value)){
                data.next = current; //node baru menunjuk ke target
                prev.next = data; //node sebelumnya menunjuk ke node baru
                size++;
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("Nilai " + value + " tidak ditemukan");
    }

    void print () {
        if (isEmpty()){
            System.out.println(" List Kosong!");
            return;
        }
        Node current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print("["+current.data + "]");
            if (current.next != null) 
                System.out.print(" -> ");
            current = current.next;
        }
        System.out.println(" -> NULL");
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        System.out.println("Head: " + list.head);
        System.out.println("Tail: " + list.tail);

        list.addFirst(new Node("A"));
        System.out.println("Head: " + list.head.data); //A
        System.out.println("Tail: " + list.tail.data); //A
        
        list.addFirst(new Node("B"));
        System.out.println("Head: " + list.head.data); //B (B ditambahkan di depan)
        System.out.println("Tail: " + list.tail.data); //A
        
        list.addLast(new Node("C"));
        System.out.println("Head: " + list.head.data); //B
        System.out.println("Tail: " + list.tail.data); //C (ditambhakn di akhir)

        list.addLast(new Node("D"));
        list.addLast(new Node("E"));


        //FindbyValue
        System.out.println("==== Find By Value ====");
        Node found;
        found = list.findByValue("C");
        found = list.findByValue("Z");

        //FindByIndex
        System.out.println("==== FindByIndex ====");
        Node n;
        n = list.findByIndex(2);
        n = list.findByIndex(10);
    
        //deleteByIndex
        System.out.println("==== deleteByIndex (hapus head) ====");
        list.deleteByIndex(0);
        list.print(); 
        System.out.println("==== deleteByIndex ====");
        list.deleteByIndex(2);
        list.print();
        
        //deleteByValue
        System.out.println("==== deleteByValue ====");
        list.deleteByValue("E");
        list.print();
        System.out.println("Tail sekarang: " + list.tail.data);

        //AddAtIndex
        System.out.println("==== AddAtIndex ====");
        list.addAtIndex(1, new Node("X"));
        list.print();

        //AddAfter
        System.out.println("==== AddAfter ====");
        list.addAfter ("X", new Node("Y"));
        list.print();

        //AddBefore
        System.out.println("==== AddAfter ====");
        list.addBefore ("A", new Node ("Z"));
        list.print();
    }
}