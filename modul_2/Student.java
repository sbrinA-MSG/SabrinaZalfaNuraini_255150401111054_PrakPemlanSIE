public class Student {
    private String nama;
    private int skor;
    public Student(String nama) {
        this.nama = nama;
    }
    public static void setNama(Student std, String nama) {
        std.nama = nama;
    }
    public void ubahNama(String nama){
        this.nama = nama; 
    }
    public String getNama(){
        return this.nama;
    }
    public int getSkor() {
        return this.skor;
    }
}
