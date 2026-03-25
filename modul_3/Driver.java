public class Driver {
    /*
    [Soal Uses-A No.4] Atribut Car ditambahkan sebagai bentuk
    implementasi hubungan Has-A antara Driver dan Car 
    Objek Car disimpan sebagai atribut permanen class Driver
    */
    private Car car; //-> HAS-A

    public Driver() {
        System.out.println("Driver is created.");
        /*
        [Soal Uses-A no 4] objek Car dibuat di constructpr (bukan diddalm method)
        sehingga Car hidup selama objek Driver hidup 
        */
        this.car = new Car();
    }
    public void driving() {
        System.out.println("Driver is driving.");
        /*
        [Soal Uses-A No.4] Menggunakan car.getNumWheel() karena
        numWheel sudah private di Car (hasil perubahan soal 9)
        */
        System.out.println("Using a car that has " + car.getNumWheel() + " wheels.");
    }
}
