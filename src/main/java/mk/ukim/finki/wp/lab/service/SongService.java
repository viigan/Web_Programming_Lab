package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;

import java.util.Optional;

public interface SongService {
    List<Song> findAll();

    Song findByTrackId(String trackId);

    void save(Song song);
    void addArtistToSong(Long songId, Artist artist); // Declare method



    Optional<Song> findById(Long id);

    void deleteById(Long id);

    void addArtistToSong(Artist artist, Song song);


    void update(Long id, String title, String trackId, String genre, int releaseYear, Long albumId);
}
