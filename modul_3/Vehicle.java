public class Vehicle {
    Vehicle() {
        System.out.println("Vehicle is created");
    }

    //[Soal 8] Modifier diubah dari public menjadi protected
    //untuk menguji aksessobilitas method dalam hierarki pewarisan
    protected void drive() {
        System.out.println("Vehicle is driving");
    }
    public void stop() {
        System.out.println("Vehicle is stopping");
    }
}
