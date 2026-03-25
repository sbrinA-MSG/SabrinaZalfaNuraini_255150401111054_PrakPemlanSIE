public class Lingkaran {
    //Dengan static, PI bisa diakses langsung melalui Lingkaran.PI tanpa perlu membuat objek.
    public static float PI = 3.14f;
    //Non-static berarti setiap objek Lingkaran memiliki nilai r-nya masing-masing.
    public float r;
    public Lingkaran(float r) {
        this.r = r;
    }
    //Karena menggunakan atribut non-static 'r', method luas dipanggil melalui objek.
    public float luas() {
        return PI * r * r;
    }

    /*
    Method static keliling() untuk menghitung keliling lingkaran.
    Bersifat static sehingga bisa dipanggil langsung via Lingkaran.keliling(r) tanpa objek.
    Menerima parameter float r karena static method tidak bisa mengakses atribut non-static 'r' secara langsung.
    */
    public static float keliling(float r){
        return 2*PI*r;
    }
}
