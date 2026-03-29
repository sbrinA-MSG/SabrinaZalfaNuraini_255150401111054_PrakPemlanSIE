public class AgenBusApp {
    public static void main(String[] args) {
        Tiket t1 = new Tiket();
        t1.pesan();
        t1.tampil();

        TiketBus t2 = new TiketBus();
        t2.pesan();
        t2.tampil();

        TiketBus t3 = new TiketBus();
        t3.pesan("Kasino", "Bandung", 650, 450000);
        t3.tampil();

        /*
        4a
        penambahan instnsiasi
        */
        TiketBus tb = new TiketBus();
        tb.pesan("Sabrina");
        tb.tampil();

        /*
        no 5
        Override method tampil() langsung instansiasi 
        */
        TiketBus t4 = new TiketBus() {
            @Override
            public void tampil(){
                System.out.println("----------------------------------------");
                System.out.printf("| %-36s |\n", "TIKET BUS HARAPAN BARU", "");
                System.out.println("----------------------------------------");
                System.out.printf("| %-13s : %-20s |\n", "Penumpang", this.namaPenumpang);
                System.out.printf("| %-13s : %-20s |\n", "Tujuan", this.tujuan);
                System.out.printf("| %-13s : Rp %-17.2f |\n", "Harga", this.hargaTiket);
                System.out.println("----------------------------------------");
            }
        };
        t4.pesan ("Charleen", "Jakarta Barat", 700, 120000);
        t4.tampil();
        
        t1.pesan("Indro", "Makassar");
        t1.tampil();
        t2.pesan("Dono", "Makassar");
        t2.tampil();
    }
}
