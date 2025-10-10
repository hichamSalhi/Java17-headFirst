import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Structures {
    static Structures s = new Structures();
    
    public static void go() {
        List<String> mockSongs = MockSongs.getSongStrings();
        System.out.println(mockSongs);
        Collections.sort(mockSongs);
        System.out.println(mockSongs);
    }

    public static void goV2() {
        List<SongV2> mockSongs = MockSongs.getSongsV2();
        System.out.println(mockSongs);
        ArtistCompare artistCompare = s.new ArtistCompare();
        //Collections.sort(mockSongs); this one was for the Comparable interface
        mockSongs.sort(artistCompare);

        // the inner class example for the comparator
        mockSongs.sort(new Comparator<SongV2>() {
            @Override
            public int compare(SongV2 o1, SongV2 o2) {
                return o1.getArtist().compareTo(o2.getArtist());
            }
        });
        System.out.println(mockSongs);
    }

    public static void goV3() {
        List<SongV2> mockSongs = MockSongs.getSongsV2();
        mockSongs.sort((o1, o2) -> o1.getArtist().compareTo(o2.getArtist()));
        System.out.println(mockSongs);

        Set<SongV2> mockSongSet = new HashSet<>(mockSongs);
        System.out.println(mockSongSet);
    }

    public class SongV2{
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

        @Override
        public boolean equals(Object obj) {
            SongV2 other = (SongV2) obj;
            return title.equals(other.getTitle());
        }

        @Override
        public int hashCode() {
            return title.hashCode();
        }
    }


    class ArtistCompare implements Comparator<SongV2> {
        @Override
        public int compare(Structures.SongV2 o1, Structures.SongV2 o2) {
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }

    public class MockSongs {
        public static List<String> getSongStrings() {
            List<String> songs = new ArrayList<>();
            songs.add("somersault");
            songs.add("cassidy");
            songs.add("");
            songs.add("havana");
            songs.add("Cassidy");
            songs.add("50 Ways");
            return songs;
        }
        public static List<SongV2> getSongsV2() {
            List<SongV2> songs = new ArrayList<>();
            songs.add(s.new SongV2("somersault", "zero 7", 147));
            songs.add(s.new SongV2("cassidy", "grateful dead", 158));
            songs.add(s.new SongV2("$10", "hitchhiker", 140));
            songs.add(s.new SongV2("havana", "cabello", 105));
            songs.add(s.new SongV2("Cassidy", "grateful dead", 158));
            songs.add(s.new SongV2("50 ways", "simon", 102));
            return songs;
        }
    }

}