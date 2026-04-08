public class Crew implements ICrew {
    //soal2. menambahkan implements IImpostor
    private String name;
    //no.8 menambahkan atribut baru isAlive
    private boolean isAlive = true; 
    public Crew(String name) {
        this.name = name;
    }
    
    @Override
        public void doWork() {
            //perubahasab logika
            if (isAlive) {
                System.out.println("Crew " + this.name + " is doing work.");
            } else {
                System.out.println("Crew " + this.name + " is dead and cannot work.");
            }
    }
    
    @Override
        public String getName() {
        return this.name;
    }

    //soal2. jika diberikan @override maka pada implement ditambahkan IImpostor
    //@Override
    public void kill(ICrew crew){
        System.out.println(crew.getName() + " has been killed!");
    }
    
    //no.8 method callMeeting () diubah untuk memriksa status isAlive terlebih dahulu
    public void callMeeting() {
        if (isAlive){
            System.out.print(this.name + " found a corpse ");
            System.out.print("and calls a meeting. ");
            System.out.println("Let's find the impostor!");
        } else {
            System.out.println(this.name + " is dead and cannot call a meeting.");
        }
        
    }

    //soal7
    //ditamabhkan implementasi kick()
    @Override
    public void kick(ICrew crew){
        System.out.println(crew.getName() + " has been kicked out of the spaceship!");
    }

    //method baru untuk mengubah status isAlive menjadi false
    public void die(){
        this.isAlive = false;
    }

}