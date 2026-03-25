public class GeometriApp {
    public static void main(String[] args) {
      Lingkaran lingKecil = new Lingkaran(2.0f);
      Lingkaran lingBesar = new Lingkaran(11.0f);
      float lK = lingKecil.luas();
      float lB = lingBesar.luas();
      float kK = Lingkaran.keliling(lingKecil.r);
      float kB = Lingkaran.keliling(lingBesar.r);
      System.out.println("Keliling Lingkaran Kecil: " + kK);
      System.out.println("Keliling Lingkaran Besar: " + kB);
      System.out.println("Luas Lingkaran Kecil: " + lK);
      System.out.println("Luas Lingkaran Besar: " + lB);
    }
}
