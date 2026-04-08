public class AmongUsGame {
    public static void main(String[] args) {
        
        Crew brian, cindy, david;
        Impostor jacky;
        
        brian = new Crew("Brian");
        cindy = new Crew("Cindy");
        david = new Crew("David");
        jacky = new Impostor("Jacky");
        
        brian.doWork();
        cindy.doWork();
        david.doWork();
        jacky.doWork();
        
        //no.8
        jacky.kill(cindy); //cindy.die() dipanggil
        cindy.callMeeting(); //akan mencetak cindy is dead and cannot call a meeting
        david.callMeeting();// david masih hidup, meeting berhasil
        
        //percobaan no.5
        //jacky.callMeeting();
        //no.7
        jacky.kick(cindy);
        AmongUsGame.check(brian);
        AmongUsGame.check(david);
        AmongUsGame.check(jacky);
    }
    
    public static void check(ICrew crew) {
        if (AmongUsGame.isImpostor(crew))
            System.out.println(crew.getName() + " is the impostor!");
        else System.out.println(crew.getName() + " is not the impostor.");
    }
    public static boolean isImpostor(ICrew crew) {
        return (crew instanceof Impostor);
    }
}