//package mk.ukim.finki.wp.lab.repository;
//
//import mk.ukim.finki.wp.lab.model.Artist;
//import org.springframework.stereotype.Repository;
//
//import jakarta.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class ArtistRepository {
//    private List<Artist> artistList;
//
////    @PostConstruct
////    public void init() {
////        artistList = new ArrayList<>();
////        artistList.add(new Artist(1L, "Axl", "Rose", "Lead singer of Guns N' Roses."));
////        artistList.add(new Artist(2L, "Jon", "Bon Jovi", "American singer-songwriter."));
////        artistList.add(new Artist(3L, "David", "Bowie", "English singer-songwriter."));
////        artistList.add(new Artist(4L, "Freddie", "Mercury", "Lead singer of Queen."));
////        artistList.add(new Artist(5L, "Mick", "Jagger", "Lead singer of The Rolling Stones."));
////    }
//
//    public List<Artist> findAll() {
//        return artistList;
//    }
//
//    public Optional<Artist> findById(Long id) {
//        return artistList.stream().filter(artist -> artist.getId().equals(id)).findFirst();
//    }
//
//    public void save(Artist artist) {
//        artistList.add(artist);
//    }
//
//
//    public void deleteById(Long id) {
//        artistList.removeIf(artist -> artist.getId().equals(id));
//    }
//}
package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Artist;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {

    private final List<Artist> artistList = new ArrayList<>();

    @PostConstruct
    public void init() {
        artistList.add(new Artist(1L, "Axl", "Rose", "Lead singer of Guns N' Roses."));
        artistList.add(new Artist(2L, "Jon", "Bon Jovi", "American singer-songwriter."));
        artistList.add(new Artist(3L, "David", "Bowie", "English singer-songwriter."));
        artistList.add(new Artist(4L, "Freddie", "Mercury", "Lead singer of Queen."));
        artistList.add(new Artist(5L, "Nick", "Jagger", "Lead singer of The Rolling Stones."));
    }

    public List<Artist> findAll() {
        return new ArrayList<>(artistList);
    }

    public Optional<Artist> findById(Long id) {
        return artistList.stream().filter(artist -> artist.getId().equals(id)).findFirst();
    }
    public void save(Artist artist) {
        Optional<Artist> existingArtist = artistList.stream()
                .filter(a -> a.getId().equals(artist.getId()))
                .findFirst();
        if (existingArtist.isPresent()) {
            // Update existing artist
            existingArtist.get().setFirstName(artist.getFirstName());
            existingArtist.get().setLastName(artist.getLastName());
            existingArtist.get().setBio(artist.getBio());
        } else {
            // Add new artist
            artist.setId((long) (artistList.size() + 1)); // Generate a simple ID
            artistList.add(artist);
        }
    }


    public void deleteById(Long id) {
        artistList.removeIf(artist -> artist.getId().equals(id));
    }

    public void saveAll(List<Artist> artist1) {

    }
}

