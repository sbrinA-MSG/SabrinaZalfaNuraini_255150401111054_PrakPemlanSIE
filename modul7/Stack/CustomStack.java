public class CustomStack {
    Node top;
    int size = 0;

    //push : untuk menambahkan elemen ke atas stack
    public void push(int x) {
        Node n = new Node(x);
        n.next = top;
        top = n;
        size++;
    }
    
    //Pop : mengeluarkan elemen paling atas
    public int pop() {
        if (top == null)
        throw new RuntimeException("Stack is empty.");
        int val = top.data;
        top = top.next;
        size--;
        return val;
    }
    
    //isEmpty : mengecek apakah stack kosong
    public boolean isEmpty() {
        return top == null;
    }

    //no.2 method peek() untuk melihat elemn teratas tanpa mengeluarkannya
    public int peek(){
        if (top == null)
            throw new RuntimeException ("Stack is empty.");
        return top.data;
    }

    public static void main(String[] args) {
        CustomStack custom = new CustomStack();
        custom.push(1);
        custom.push(2);
        custom.push(3);
        System.out.print("Custom Stack: ");
        System.out.println("Hasil peek(): " + custom.peek());
        while (!custom.isEmpty()) {
            System.out.print("[" + custom.pop() + "]");
        }
        System.out.println("End.");
        //System.out.println(custom.pop()); --> percobaan 3

        System.out.println("===== PERCOBAAN 2: peek() =====");
        CustomStack stackPeek = new CustomStack();
        stackPeek.push(10);
        stackPeek.push(20);
        stackPeek.push(30);
        System.out.println("Isi stack sebelum peek: [30 (top), 20, 10]");
        System.out.println("Hasil peek(): " + stackPeek.peek());
        System.out.print("Isi stack setelah peek (tidak berubah): ");
        while (!stackPeek.isEmpty()) {
            System.out.print("[" + stackPeek.pop() + "]");
        }
        System.out.println();

        System.out.println("===== PERCOBAAN 4: menyisipkan 5 di posisi ke-2 =====");
        CustomStack stackSisip = new CustomStack();
        stackSisip.push(1);
        stackSisip.push(2);
        stackSisip.push(3);
        stackSisip.push(4);
        //stack saat ini (4, 3, 2, 1) top ke bottom
        //untuk pop semua elemen kecuali 1, dan menyimpannya distack sementara
        CustomStack tempStack = new CustomStack();
        while (stackSisip.peek() != 1) {
            tempStack.push(stackSisip.pop());
        }
        //push nilai 5
        stackSisip.push(5);
        //mengembalikan elemen dari tempStack ke stackSisip
        while (!tempStack.isEmpty()) {
            stackSisip.push(tempStack.pop());
        }
        //stackSisip sekarang (top ke bottom) 4,3,2,5,1
        System.out.print("Hasil Stack (top ke bottom): ");
        while (!stackSisip.isEmpty()) {
            System.out.print("[" + stackSisip.pop() + "]");
        }
        System.out.println();
    }
}
