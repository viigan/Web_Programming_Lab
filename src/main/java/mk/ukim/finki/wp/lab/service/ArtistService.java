package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> listArtists();
    Artist findById(Long id);
    void save(Artist artist);
    void deleteById(Long id);
     List<Artist> searchArtists(String query);
}
