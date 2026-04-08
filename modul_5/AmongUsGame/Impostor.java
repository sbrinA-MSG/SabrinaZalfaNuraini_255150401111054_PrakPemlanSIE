public class Impostor implements IImpostor, ICrew {
    
    private final String name;
    
    public Impostor(String name) {
        this.name = name;
    }
    @Override
    public void kill(ICrew crew) {
        System.out.println(crew.getName() + " has been killed!");
        //perubahan pada no.8 memanggil die() jika korban adlaah instance dari Crew
        if (crew instanceof Crew){
            ((Crew) crew).die();
        }
    }
    @Override
    public void doWork() {
        System.out.println("Impostor " + this.name + " is doing work.");
    }
    @Override
    public String getName() {
        return this.name;
    }

    //no7
    //ditambahkan implementasi kick()
    @Override 
    public void kick (ICrew crew){
        System.out.println(crew.getName() + " has been kicked out of the spaceship!");
    }
}