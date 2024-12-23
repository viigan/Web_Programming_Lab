package mk.ukim.finki.wp.lab.service.implementation;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }


    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Artist not found!"));
    }
    public List<Artist> searchArtists(String query) {
        if (query == null || query.isEmpty()) {
            return listArtists(); // Return all artists if no query is provided
        }

        return listArtists().stream()
                .filter(artist ->
                        (artist.getFirstName() != null && artist.getFirstName().toLowerCase().contains(query.toLowerCase())) ||
                                (artist.getLastName() != null && artist.getLastName().toLowerCase().contains(query.toLowerCase())) ||
                                (artist.getBio() != null && artist.getBio().toLowerCase().contains(query.toLowerCase()))
                )
                .collect(Collectors.toList());
    }



    @Override
    public void save(Artist artist) {
        artistRepository.save(artist);

    }

    @Override
    public void deleteById(Long id) {
        artistRepository.deleteById(id);
    }
}
