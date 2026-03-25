public class GeometriApp {
    public static void main(String[] args) {
      Lingkaran lingKecil = new Lingkaran(2.0f);
      Lingkaran lingBesar = new Lingkaran(11.0f);
      float lK = lingKecil.luas();
      float lB = lingBesar.luas();
        /*
        Memanggil static method keliling() dari class Lingkaran.
        Dipanggil melalui nama class (Lingkaran.keliling), bukan melalui objek,
        tidak bisa mengakses atribut non-static 'r' secara langsung.
        */
      float kK = Lingkaran.keliling(lingKecil.r);
      float kB = Lingkaran.keliling(lingBesar.r);
        //Menampilkan hasil keliling lingkaran
      System.out.println("Keliling Lingkaran Kecil: " + kK);
      System.out.println("Keliling Lingkaran Besar: " + kB);
      System.out.println("Luas Lingkaran Kecil: " + lK);
      System.out.println("Luas Lingkaran Besar: " + lB);
    }
}
