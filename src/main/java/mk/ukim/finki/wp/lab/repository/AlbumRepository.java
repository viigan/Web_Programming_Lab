package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
//public class AlbumRepository {
//
//    private final List<Album> albums;
//
//    public AlbumRepository() {
//        albums = new ArrayList<>();
//        albums.add(new Album(1L, "Thriller", "Pop", "1982"));
//        albums.add(new Album(2L, "Back in Black", "Rock", "1980"));
//        albums.add(new Album(3L, "Dark Side of the Moon", "Progressive Rock", "1973"));
//        albums.add(new Album(4L, "Abbey Road", "Rock", "1969"));
//        albums.add(new Album(5L, "Rumours", "Rock", "1977"));
//    }
//
//    public List<Album> findAll() {
//        return new ArrayList<>(albums);
//    }
//    public Album findById(Long idSongAlbum) {
//        return albums.stream().filter(a -> a.getId().equals(idSongAlbum)).findFirst().orElse(null);
//    }
//
//}

import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}

