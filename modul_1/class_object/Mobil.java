public class Mobil {
    private String nopol; //variabel instances
    private String warna;
    private String merk;
    private int kecepatan;
    private double jarak;
    public void setNopol(String n) {
        nopol = n;
    }
    public void setWarna(String s) {
        warna = s;
    }
    public void setMerk(String m) {
        merk = m;
    }
    public void setKecepatan(int k) {
        kecepatan = k;
    }

    /*
    menghitung jarak tempuh dengan waktu(jam)
    menggunakan rumus: jarak = kecepatan * waktu
    hasilnya akan disimpan ke dan juga dikembalikan atribut jarak 
    */
    public double hitungJarak(double waktu){
        jarak = kecepatan * waktu;
        System.out.println("Jarak tempuh mobil selama " +waktu 
            + " dengan kecepatan " +kecepatan +" adalah " +jarak + " km");
        return jarak;
    }
    
    /*
    -atribut kecepatan disimpan dalam satuan kpj-
    kpj -> mengubah kecepatan dlam satuan meter/second (mps)
    rumus : 1 kpj= 1000/3600 mps = 1/3.6 mps
    */
    public double kecepatanMPS() {
        double mps = kecepatan/3.6;
        System.out.println("Kecepatan " + String.format ("%.0f kpj = %.4f m/s", (double) kecepatan, mps));
        return mps;
        //String.format ini digunakan untuk memberikan format pada atribut kecepatan dan mps.
    }
    public void display() {
        System.out.println("Mobil bermerk " + merk);
        System.out.println("bernomor polisi " + nopol);
        System.out.println("serta memiliki warna " + warna);
        System.out.println("bergerak dengan kecepatan " + kecepatan + " kpj");
    }
}

