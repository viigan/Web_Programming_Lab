package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
//@AllArgsConstructor
//public class Album {
//
//    private Long id;
//    private String name;
//    private String genre;
//    private String releaseYear;
//}
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // Mark this class as a JPA entity
public class Album {

    @Id // Primary key annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate IDs
    private Long id;

    private String name;

    private String genre;

    private String releaseYear;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true) // One-to-Many relationship
    private List<Song> songs = new ArrayList<>(); // List to hold associated songs

    // Constructor without the songs list
    public Album(Long id, String name, String genre, String releaseYear) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    // Add a song to the album
    public void addSong(Song song) {
        songs.add(song);
        song.setAlbum(this); // Set the relationship
    }

    // Remove a song from the album
    public void removeSong(Song song) {
        songs.remove(song);
        song.setAlbum(null); // Break the relationship
    }
}

