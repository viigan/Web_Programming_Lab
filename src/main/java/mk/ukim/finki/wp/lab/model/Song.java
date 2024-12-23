package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//@Data
//@AllArgsConstructor
//public class Song {
//    private Long id; // Unique identifier
//    private String trackId;
//    private String title;
//    private String genre;
//    private int releaseYear;
//    private Album album; // Reference to Album
//    private List<Artist> performers;
//
//    public Song(Long id, String trackId, String title, String genre, int releaseYear, Album album) {
//        this.id = id;
//        this.trackId = trackId;
//        this.title = title;
//        this.genre = genre;
//        this.releaseYear = releaseYear;
//        this.album = album;
//        this.performers = new ArrayList<>();
//    }
//    public Song() {
//        this.performers = new ArrayList<>();
//    }
//
//    public void addPerformer(Artist artist) {
//        if (!performers.contains(artist)) {
//            performers.add(artist);
//        }
//    }
//
//}

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//@Data
//@AllArgsConstructor
//@Entity // Mark this class as a JPA entity
//public class Song {
//
//    @Id // Primary key annotation
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate IDs
//    private Long id;
//
//    private String trackId;
//    private String title;
//    private String genre;
//    private int releaseYear;
//
//    @ManyToOne // Many songs can belong to one album
//    @JoinColumn(name = "album_id", nullable = false) // Foreign key column in the Song table
//    private Album album;
//
//
//
//    @ManyToMany // Many songs can have many performers
//    private List<Artist> performers;
//
//    public Song() {
//        this.performers = new ArrayList<>();
//    }
//
//    public Song(Long id, String trackId, String title, String genre, int releaseYear, Album album) {
//        this.id = id;
//        this.trackId = trackId;
//        this.title = title;
//        this.genre = genre;
//        this.releaseYear = releaseYear;
//        this.album = album;
//        this.performers = new ArrayList<>();
//    }
//
//    public void addPerformer(Artist artist) {
//        if (!performers.contains(artist)) {
//            performers.add(artist);
//        }
//    }
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
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    @ManyToMany
    @JoinTable(
            name = "song_artist",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> performers = new ArrayList<>();

    // Constructor matching the controller's usage
    public Song(Long trackId, String title, String genre, int releaseYear, Album album) {
//        this.trackId = String.valueOf(trackId);

        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = album;
        this.performers = new ArrayList<>();
    }

    // Helper methods for adding and removing performers
    public void addPerformer(Artist artist) {
        if (!performers.contains(artist)) {
            performers.add(artist);
        }
    }
}

