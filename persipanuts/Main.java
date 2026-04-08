package persipanuts;

class Hewan {
    void suara() { System.out.print("Suara "); }
}
class Kucing extends Hewan {
    void suara() { 
        super.suara();
        System.out.print("Meong "); }
}
public class Main {
    public static void main(String[] args) {
        Hewan h = new Kucing();
        h.suara();
    }
}
