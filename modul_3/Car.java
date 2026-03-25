public class Car extends Vehicle {
    //[Soal 9] Modifier diubah dari public menjadi private
    //untuk emnguji aksesibilitas atribut dalam hierarki pewarisan
    private int numWheel = 4;
    Car() {
        System.out.println("Car is created");
    }
    public void drift() {
        System.out.println("Car is drifting");
    }
    public void honk() {
        System.out.println("Car is honking");
    }

    //[soal 9c] Getter ditambahkan sebagai solusi perbaikan eroor
    //karena numWheel tidak dapat diakses langsung dari laur class (private)
    public int getNumWheel(){
        return numWheel;
    }
}
