import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Antrian {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Menu Antrian Pelanggan:");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Antria Depan");
            System.out.println("5. Keluar");
            System.out.print("Pilih (1-5): ");
            try {
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline
                switch (choice) {
                    case 1:
                        //percobaan 1, baris ke-19 = membaca nama dari keyboard
                        System.out.print("Masukan Nama Pelanggan: ");
                        String name = sc.nextLine();
                        //jika inpput "Budi"
                        if (name.equalsIgnoreCase("Budi")){
                            //LinkedList mendukung addFirst() untuk menaruh di depan
                            ((LinkedList<String>) queue).addFirst(name);
                            System.out.println(name + " (prioritas)");
                        }else {
                            queue.offer(name); //offer : untuk memasukkan elemen ke dalam antrean
                            System.out.println(name + " ditambahkan ke antrian.");
                        }
                        
                        break;
                    case 2:
                        if (queue.isEmpty())
                        System.out.println("Antrian kosong.");
                        else {
                            String dilayani = queue.poll(); // poll : mengambil dan menghapus elemen head (pertama) antrean
                            System.out.println("Melayani pelanggan : " + dilayani);
                        }
                        break;
                    case 3:
                        System.out.println("Antrian Saat Ini: " + queue);
                        break;
                    case 4: 
                        if (queue.isEmpty()) {
                            System.out.println("Tidak ada antrian.");
                        } else {
                            System.out.println("Antrian paling depan: " + queue.peek());
                        }
                        break;
                    case 5:
                        System.out.println("Keluar.");
                        sc.close();
                        return;
                    default:
                        throw new Exception("Invalid input.");
                }
            } catch(Exception e) {
                System.out.println("Invalid input.");
                sc.next(); // consume newline
            }
        }
    }
}