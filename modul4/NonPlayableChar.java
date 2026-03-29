/*
6
sebagai subclass dari Character
digunakan untuk "topeng" polimorfisme agar Jacky tidak terdeteksi
*/
public class NonPlayableChar extends Character {
    //Konstruktor : menyalin nama dari objek Character yang diberikan
    public NonPlayableChar(Character ch){
        this.name = ch.name;
    }

    @Override
    public void doWork() {
        System.out.println(this.name + " is wandering around.");
    }
}
