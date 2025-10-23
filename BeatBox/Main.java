package BeatBox;

public class Main {
    public static void main(String[] args) {
        args = new String[] { "40", "70" }; // For testing purposes
        MusicTest1 mini = new MusicTest1();
        if (args.length < 2) {
            System.out.println("Do not forget the instrument and note args");
        }  else {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.play(instrument, note);
        }
        
    }
}
