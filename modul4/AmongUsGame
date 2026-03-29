public class AmongUsGame {
    public static void main(String[] args) {
        // Create references of Character
        Character brian, cindy, david, jacky;
        brian = new Crew("Brian");
        cindy = new Crew("Cindy");
        david = new Crew("David");
        jacky = new Crew("Jacky");
        brian.doWork();
        cindy.doWork();
        david.doWork();
        jacky.doWork();
        jacky = (Character) new Impostor(jacky);
        jacky.kill(cindy);
        if (david instanceof Crew crew)
        crew.callMeeting();
        AmongUsGame.check(brian);
        AmongUsGame.check(david);
        AmongUsGame.check(jacky);

        /*
        5b 
        menerapkan polimorfisme agar jacky tidak terdeteksi sebagai impostor
        dengan mengembalikan referensi jacky ke objek Crew baru
        */
        System.out.println("-- Setelah jacky menyamar kembali -- ");
        jacky = new Crew(jacky.name); //jacky sekarang merefesi objek Crewlagi
        AmongUsGame.check(jacky); //jacky is not the impostor
        
        /*
        soal 6
        menggunakan NonPlayable sebagai "topeng" dimana jacky Crew diubah ke NPC
        */
        System.out.println("-- Jacky menyamar sebagai NPC --");
        jacky = (Character) new NonPlayableChar(jacky); //mengubah langsung dari Crew ke NPC
        AmongUsGame.check(jacky);

    }

    public static void check(Character ch) {
    if (AmongUsGame.isImpostor(ch))
    System.out.println(ch.name + " is the impostor!");
    else System.out.println(ch.name + " is not the impostor.");
    }
    
    public static boolean isImpostor(Character ch) {
        return (ch instanceof Impostor);
    }
}
