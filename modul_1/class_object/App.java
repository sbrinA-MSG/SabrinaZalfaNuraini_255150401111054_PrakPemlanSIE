import java.util.*;

public class App {
    public static void main(String[] args) {
        // penambahan Scanner, import java.util.*, dan sintakis in.nextLine dll ini agar pengguna bisa menambahkan input
        Scanner in = new Scanner (System.in);
        //intansiasi objek oleh pengguna
        System.out.println("");
        System.out.print("masukkan merk mobil 1 :");
        String merk = in.nextLine();
        System.out.print("Masukkan nomor polisi mobil 1 : ");
        String nopol = in.nextLine();

        //instansiasi objek bernama m1
        Mobil m1 = new Mobil();
        m1.setKecepatan(50);
        m1.setMerk(merk); // method setMerk digunakna untuk mengirim nilai dari variabel merk yang diinput pengggunakedalam merk pada objek m1
        m1.setNopol(nopol); // method setMerk digunakna untuk mengirim nilai dari variabel nopol yang diinput pengggunakedalam nopol pada objek m1, berlaku juga pada objek m2
        m1.setWarna("Merah");
        m1.display();
        System.out.println("---------------");

        //instansiasi objek bernama m2
        Mobil m2 = new Mobil();
        System.out.print("masukkan merk mobil 2 :");
        merk = in.nextLine();
        System.out.print("Masukkan nomor polisi mobil 2 : ");
        nopol = in.nextLine();
        m2.setKecepatan(100);
        m2.setMerk(merk);
        m2.setNopol(nopol);
        m2.setWarna("Biru");
        m2.display();
        System.out.println("---------------");
        System.out.println("Atribut pada objek m1 diubah.");
        //mengubah warna dari objek m1
        m1.setWarna("Hijau");
        //menampilkan hasil perubahan
        m1.display();

        in.close();

        // testing
    }

}
