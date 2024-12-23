package mk.ukim.finki.wp.lab.service.implementation;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//
@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    public List<Song> findAll() {
        return songRepository.findAll();
    }


    public Song findByTrackId(String trackId) {
        return songRepository.findAll().stream()
                .filter(song -> song.getTrackId().equals(trackId)) // Direct String comparison
                .findFirst()
                .orElse(null);
    }


    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }




    public void save(Song song) {
        songRepository.save(song);
    }
//@Override
//public void save(Optional<Song> optionalSong) {
//    if (optionalSong.isPresent()) {
//        songRepository.save(optionalSong.get());
//    } else {
//        throw new RuntimeException("Song not found"); // Handle missing Song appropriately
//    }
//}


    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }
    @Override
    public void addArtistToSong(Long songId, Artist artist) {
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found!"));

        // Add the artist to the song
        song.getPerformers().add(artist);

        // Save the updated song
        songRepository.save(song);
    }



//    public void addArtistToSong(Artist artist, Song song) {
//        songRepository.addArtistToSong(artist,song);
//    }
@Override
public void addArtistToSong(Artist artist, Song song) {
    // Add the artist to the song's list of performers
    song.getPerformers().add(artist);

    // Save the updated song
    songRepository.save(song);
}

    @Override
    public void update(Long id, String title, String trackId, String genre, int releaseYear, Long albumId) {
        Song song = this.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Song ID: " + id));
        Album album = this.albumRepository.findById(albumId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Album ID: " + albumId));

        song.setTitle(title);
        song.setTrackId(trackId);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(album);

        this.songRepository.save(song);
    }

}
//
//@Service
//public class SongServiceImpl {
//
//    private final SongRepository songRepository;
//
//    public SongServiceImpl(SongRepository songRepository) {
//        this.songRepository = songRepository;
//    }
//
//    public Song findByTrackId(String trackId) {
//        return songRepository.findByTrackId(trackId);
//    }
//
//    public Song save(Song song) {
//        return songRepository.save(song);
//    }
////    public void addArtistToSong(Artist artist, Song song) {
////        songRepository.addArtistToSong(artist,song);
////    }
//
//
//}


