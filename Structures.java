import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Structures {

    public static void go() {
        List<String> mockSongs = MockSongs.getSongStrings();
        System.out.println(mockSongs);
        Collections.sort(mockSongs);
        System.out.println(mockSongs);
    }


    public class SongV2 {
        private String title;
        private String artist;
        private int bpm;
        
        SongV2(String title, String artist, int bpm) {
            this.title = title;
            this.artist = artist;
            this.bpm = bpm;
        }
        public String getTitle() {
            return title;
        }
        public String getArtist() {
            return artist;
        }
        public int getBpm() {
            return bpm;
        }
        
        public String toString() {
            return title;
        }
    }

    public class MockSongs {
        public static List<String> getSongStrings() {
            List<String> songs = new ArrayList<>();
            songs.add("somersault");
            songs.add("cassidy");
            songs.add("$10");
            songs.add("havana");
            songs.add("Cassidy");
            songs.add("50 Ways");
            return songs;
        }
    }



}