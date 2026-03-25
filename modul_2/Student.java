public class Student {
    /*
    [PERUBAHAN] Sebelumnya: public String nama
    Modifier diubah dari public menjadi private untuk menerapkan enkapsulasi.
    Atribut ini kini hanya bisa diakses dari dalam class Student sendiri.
    */
    private String nama;
    /*
    [PERUBAHAN] Sebelumnya: public int skor
    Modifier diubah dari public menjadi private untuk menerapkan enkapsulasi.
    Atribut ini kini hanya bisa diakses melalui method getter getSkor().
    */
    private int skor;
    public Student(String nama) {
        this.nama = nama;
    }

    /*
    Method static setNama() dengan parameter objek Student dan nama baru.
    Karena bersifat static, method ini dipanggil melalui nama class: Student.setNama(obj, "nama")
    Method ini bisa mengakses atribut private 'nama' karena berada dalam class yang sama (Student).
    */
    public static void setNama(Student std, String nama) {
        std.nama = nama;
    }

    /*
    Method ubahNama() sebagai pengganti setNama() yang kini private.
    Modifier public memungkinkan method ini dipanggil dari luar class (misal: SchoolApp).
    Digunakan untuk memperbarui nilai atribut private 'nama' dari luar class.
    */
    public void ubahNama(String nama){
        this.nama = nama; 
    }

    /*
    Getter untuk atribut private 'nama'.
    Karena 'nama' kini private, akses dari luar class harus melalui method ini.
    Method ini membuat atribut 'nama' bersifat readable dari luar class.
    */
    public String getNama(){
        return this.nama;
    }

    // Getter getSkor() sudah ada di kode asli, tidak ada perubahan.
    // Digunakan untuk membaca nilai atribut private 'skor' dari luar class.
    public int getSkor() {
        return this.skor;
    }
}
