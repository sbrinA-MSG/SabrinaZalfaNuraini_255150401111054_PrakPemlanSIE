public class TiketBus extends Tiket {
    @Override
    public void pesan() {
        this.tujuan = "Bandung";
    }

    /*
    method baru ini di dalam class TiketBus
    menerima satu paramter String untuk mengisi nama penumpang
    bukan termasuk override karena pada Tiket tidak ada pesan(String)
    */
    public void pesan(String n){
        this.namaPenumpang = n;
    }

    @Override
    public void pesan(String n, String t) {
        if (t.equals("Makassar")) {
            this.tujuan = "Makassar";
            System.out.println("Maaf " + n + ", tiket tidak dapat dipesan.");
        }
    }
    
    @Override
    public void tampil() {
        if (!this.tujuan.equals("Makassar")) {
            super.tampil();
        } else {
            System.out.println("Tiket tujuan Makassar tidak tersedia.");
            System.out.println("--------------------");
        }
    }
}
