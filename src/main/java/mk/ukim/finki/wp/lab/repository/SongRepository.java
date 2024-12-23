package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//
//@Repository
//public class SongRepository {
//    private List<Song> songs;
//
//    @PostConstruct
//    public void init() {
//        Album thriller = new Album(1L, "Thriller", "Pop", "1982");
//        Album backInBlack = new Album(2L, "Back in Black", "Rock", "1980");
//        Album rumours = new Album(3L, "Rumours", "Rock", "1977");
//        Album darkSide = new Album(4L, "The Dark Side of the Moon", "Progressive Rock", "1973");
//        Album abbeyRoad = new Album(5L, "Abbey Road", "Rock", "1969");
//
//        songs = new ArrayList<>();
//        songs.add(new Song(1L, "track1", "Billie Jean", "Pop", 1983, thriller));
//        songs.add(new Song(2L, "track2", "Beat It", "Pop", 1983, thriller));
//        songs.add(new Song(3L, "track3", "Dreams", "Rock", 1977, rumours));
//        songs.add(new Song(4L, "track4", "Time", "Progressive Rock", 1973, darkSide));
//        songs.add(new Song(5L, "track5", "Come Together", "Rock", 1969, abbeyRoad));
//    }
//
//    public List<Song> findAll() {
//        return songs;
//    }
//
//    public Song findById(Long id) {
//        return songs.stream()
//                .filter(song -> song.getId().equals(id))
//                .findFirst()
//                .orElse(null);
//    }
//
//    public void save(Song song) {
//        // If the song exists, update it. Otherwise, add it.
//        Optional<Song> existingSong = Optional.ofNullable(findById(song.getId()));
//        if (existingSong.isPresent()) {
//            Song existing = existingSong.get();
//            existing.setTrackId(song.getTrackId());
//            existing.setTitle(song.getTitle());
//            existing.setGenre(song.getGenre());
//            existing.setReleaseYear(song.getReleaseYear());
//            existing.setAlbum(song.getAlbum());
//        } else {
//            // Assign a new unique ID if the song is new
//            song.setId((long) (songs.size() + 1));
//            songs.add(song);
//        }
//    }
//    public void addArtistToSong(Artist artist, Song song) {
//        songs.stream()
//                .filter(s -> s.getId().equals(song.getId()))
//                .findFirst().ifPresent(foundSong -> foundSong.getPerformers().add(artist));
//
//    }
//    public Song findByTrackId(String trackId) {
//        return songs.stream()
//                .filter(song -> song.getTrackId().equals(trackId))
//                .findFirst()
//                .orElse(null);
//    }
//
//    public void deleteById(Long id) {
//        songs.removeIf(song -> song.getId().equals(id));
//    }
//}


import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findAllByAlbum_Id(Long albumId); // Fetch songs by album ID
    Song findByTrackId(String trackId);        // Find a song by trackId
}


