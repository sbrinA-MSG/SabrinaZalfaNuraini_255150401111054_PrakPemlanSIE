public class Sedan extends Car {
    public int numDoors = 3;

    /*
    [Soal 3] Constructor di-comment untuk menguji
    bahwa Java otomatis membuat default constructor
    yang tetap memanggil constructor superclass
    */
    /*Sedan() {
        System.out.println("Sedan is created"); //kondisi setelah percobaan nmor 3
    }*/
    public void trunk() {
        System.out.println("Sedan is opening trunk");
    }
    public void honk() {
        /*
        [Soal 11] super.honk() ditambahkan untuk emmanggil 
        method honk() milik superclass (Car) sebelum
        menjalankan perilaku honk() milik Sedan sendiri
        */
        super.honk();
        System.out.println("Sedan is honking");
    }
    public void getNumWheels() {
        /*
        [Soal 9c] numWheel diganti getNumWheel() karena
        numWheel sudah private di Car, tidak bisa diakses langsung
        */
        System.out.println("Sedan has " + getNumWheel() + " wheels");
    }
}
