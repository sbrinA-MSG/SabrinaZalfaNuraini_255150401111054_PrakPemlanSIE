public class CustomQueue {
    private Node head, tail;
    private int size = 0;

    //menambahkan elemen ke belakang queue
    public void enqueue(int x) {
        Node n = new Node(x);
        if (tail != null) tail.next = n;
        tail = n;
        if (head == null) head = tail;
        size++;
    }

    //menghapus dan mengembalikan elemen terdepan
    public int dequeue() {
        if (head == null)
            throw new RuntimeException("Queue is empty.");
        int val = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    // isEmpty
    public boolean isEmpty() {
        return head == null;
    }

    // Percobaan 3: print() - menampilkan seluruh isi queue
    public void print() {
        if (head == null) {
            System.out.println("Queue kosong.");
            return;
        }
        System.out.print("Queue (depan ke belakang): ");
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    //melihat elemen terdepan tanpa menghapus
    public int peek() {
        if (head == null)
            throw new RuntimeException("Queue is empty.");
        return head.data;
    }

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        queue.enqueue(5);
        queue.enqueue(15);
        queue.enqueue(25);
        System.out.print("Custom Queue: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();

        System.out.println("=== Percobaan 2 ====");
        CustomQueue queue2 = new CustomQueue();
        queue2.enqueue(5);
        queue2.enqueue(15);
        queue2.enqueue(25);
        //Deque 1x
        int removed = queue2.dequeue();
        System.out.println("Dequeue: " + removed);
        //Enqueue 2x
        queue2.enqueue(30);
        queue2.enqueue(35);
        System.out.print("Queue setelah dequeue 1x + enqueue 30, 35: ");
        while (!queue2.isEmpty()) {
            System.out.print(queue2.dequeue() + " ");
        }
        System.out.println();

        System.out.println("=== Percobaan 3 ====");
        CustomQueue queue3 = new CustomQueue();
        queue3.enqueue(5);
        queue3.enqueue(15);
        queue3.enqueue(25);
        queue3.print();
        queue3.dequeue();
        System.out.println("Setelah dequeue 1x: ");
        queue3.print();

        System.out.println("==== PERCOBAAN 4 ====");
        CustomQueue queue4 = new CustomQueue();
        queue4.enqueue(25);
        queue4.enqueue(50);
        queue4.enqueue(75);
        System.out.print("Isi queue sebelum peek(): ");
        queue4.print();
        System.out.println("Hasil peek(): " + queue4.peek());
        System.out.print("Isi queue sesudah peek(): ");
        queue4.print();

    }
}
