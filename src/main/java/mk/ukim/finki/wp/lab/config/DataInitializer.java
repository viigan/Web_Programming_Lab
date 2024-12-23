package mk.ukim.finki.wp.lab.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class DataInitializer {
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public DataInitializer(AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    @PostConstruct
    public void init() {
        // Initialize albums
        Album album1 = new Album( 2L, "Thriller", "Pop", "1982");
        Album album2 = new Album(4L, "Back in Black", "Rock", "1980");
        Album album3 = new Album(5L, "Rumours", "Rock", "1977");
        Album album4 = new Album(6L, "The Dark Side of the Moon", "Progressive Rock", "1973");
        Album album5 = new Album(7L, "Abbey Road", "Rock", "1969");

        albumRepository.saveAll(List.of(album1, album2, album3, album4, album5));

        // Artists are already initialized in ArtistRepository, no need to re-add here

        // Fetch existing artists

//        // Add songs associated with albums and artists
//        Song song1 = new Song("track1", "Billie Jean", "Pop", 1983, album1);
//        song1.addPerformer(artists.get(0)); // Axl Rose
//
//        Song song2 = new Song("track2", "Beat It", "Pop", 1983, album1);
//        song2.addPerformer(artists.get(1)); // Jon Bon Jovi
//
//        Song song3 = new Song("track3", "Dreams", "Rock", 1977, album3);
//        song3.addPerformer(artists.get(2)); // David Bowie
//
//        Song song4 = new Song("track4", "Time", "Progressive Rock", 1973, album4);
//        song4.addPerformer(artists.get(3)); // Freddie Mercury
//
//        Song song5 = new Song("track5", "Come Together", "Rock", 1969, album5);
//        song5.addPerformer(artists.get(4)); // Mick Jagger
//
//        songRepository.saveAll(List.of(song1, song2, song3, song4, song5));
    }
}
