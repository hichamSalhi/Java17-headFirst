package JukeBoxProject;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Song> songs = new Songs().getSongs();

        // Filter songs with genre containing "rock" (case-insensitive)
        List<Song> rockSongs = songs.stream().filter(song -> song.getGenre().toLowerCase().contains("rock")).collect(Collectors.toList());

        // Returning a String List of genres
        List<String> rockSongsGenres = rockSongs.stream().map(song -> song.getGenre()).toList();

        // Returning a String List of genres with no duplicates
        List<String> rockSongsGenresWithNoDuplicates = rockSongs.stream().map(song -> song.getGenre()).distinct().toList();

        System.out.println(rockSongsGenresWithNoDuplicates);
        
    }
}
