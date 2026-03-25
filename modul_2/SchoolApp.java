public class SchoolApp {
    public static void main(String[] args) {
      Student miki = new Student("Miki");
      Student mini = new Student("Mini");
        /* 
        [PERUBAHAN] Sebelumnya: miki.nama & mini.nama (akses langsung ke atribut public)
        Karena atribut 'nama' diubah menjadi private, akses langsung tidak bisa dilakukan.
        Diganti dengan memanggil method getter getNama() dan getSkor()
        agar atribut private tetap bisa dibaca dari luar class.
        */
      System.out.println("Grade " + miki.getNama() + " " + miki.getSkor());
      System.out.println("Grade " + mini.getNama() + " " + mini.getSkor());
        /*
        [PERUBAHAN] Sebelumnya: mini.setNama("Mono") dengan modifier default (package-private)
        Karena setNama() diubah menjadi private, tidak bisa dipanggil dari luar class.
        Diganti dengan method baru ubahNama() yang memiliki modifier public,
        sehingga bisa diakses dari SchoolApp.
        */
      mini.ubahNama("Mono");
      System.out.println("Grade " + miki.getNama() + " " + miki.getSkor());
      System.out.println("Grade " + mini.getNama() + " " + mini.getSkor());

        /*
        [PENAMBAHAN BARU] Memanggil static method setNama() milik class Student
        Method ini dipanggil melalui nama class (Student.setNama), bukan melalui objek,
        karena bersifat static. Digunakan untuk mengubah nama objek miki menjadi "Kiki".
        */
      Student.setNama(miki, "Kiki");
      System.out.println("Grade " + miki.getNama() + " " + miki.getSkor());
    }
}
