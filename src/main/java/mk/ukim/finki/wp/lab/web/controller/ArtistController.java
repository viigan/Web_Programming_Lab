//package mk.ukim.finki.wp.lab.web.controller;
//
//import mk.ukim.finki.wp.lab.model.Artist;
//import mk.ukim.finki.wp.lab.model.Song;
//import mk.ukim.finki.wp.lab.service.ArtistService;
//import mk.ukim.finki.wp.lab.service.SongService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Controller
//@RequestMapping("/artists")
//public class ArtistController {
//    private final ArtistService artistService;
//    private final SongService songService;
//
//    public ArtistController(ArtistService artistService, SongService songService) {
//        this.artistService = artistService;
//        this.songService = songService;
//
//    }
//    @GetMapping("/search")
//    public String searchArtists(@RequestParam(required = false) String trackId,
//                                @RequestParam(required = false) String searchQuery,
//                                Model model) {
//        // Log inputs for debugging
//        System.out.println("Search Query: " + searchQuery);
//        System.out.println("Track ID: " + trackId);
//
//        // Perform the search
//        List<Artist> artists;
//        if (searchQuery != null && !searchQuery.isEmpty()) {
//            artists = artistService.searchArtists(searchQuery);
//        } else {
//            artists = artistService.listArtists();
//        }
//
//        // Add attributes to the model
//        model.addAttribute("listOfArtists", artists);
//        model.addAttribute("trackId", trackId);
//
//        // Return a new template for the search results
//        return "searchArtists";
//    }
//
//    @GetMapping
//    public String listArtists(@RequestParam(required = false) String trackId,
//                              @RequestParam(required = false) String searchQuery,
//                              Model model) {
//        if (trackId == null || trackId.isEmpty()) {
//            System.out.println("Track ID is missing or empty. Setting default value.");
//            trackId = ""; // Or handle it as needed
//        }
//
//        List<Artist> artists;
//        if (searchQuery != null && !searchQuery.isEmpty()) {
//            artists = artistService.searchArtists(searchQuery);
//        } else {
//            artists = artistService.listArtists();
//        }
//
//        model.addAttribute("listOfArtists", artists);
//        model.addAttribute("trackId", trackId); // Pass the default or original value
//
//        return "listArtists";
//    }
//
//
//
//
////
////    @PostMapping("/add-to-artist")
////    public String addToArtist(@RequestParam String trackId, @RequestParam Long artistId) {
////        Song song = songService.findByTrackId(trackId);
////        Artist artist = artistService.findById(artistId);
////
////        if (song != null && artist != null) {
////            song.getPerformers().add(artist);
////
////        }
////
////        return "redirect:/artists";
////    }
//@PostMapping("/add-to-artist")
//public String addToArtist(@RequestParam String trackId, @RequestParam Long artistId) {
//    // Find the song by trackId
//    Song song = songService.findByTrackId(trackId);
//
//    // Find the artist by artistId
//    Artist artist = artistService.findById(artistId);
//
//    if (song != null && artist != null) {
//        // Use the helper method to add the performer
//        song.addPerformer(artist);
//
//
//        // Save the updated song to persist the relationship
//        songService.save(song);
//    }
//
//    return "redirect:/artists";
//}
//
//
//
////    @PostMapping("/add-to-song")
////    public String addArtistToSong(@RequestParam String trackId, @RequestParam Long artistId) {
////        Song song = songService.findByTrackId(trackId);
////        Artist artist = artistService.findById(artistId);
////
////        if (song != null && artist != null) {
////            songService.addArtistToSong(artist, song);
////        } else {
////            return "redirect:/songs?error=Song or Artist not found";
////        }
////
////        return "redirect:/songs/details?trackId=" + trackId;
////    }
//
//
//    @PostMapping("/add-to-song")
//    public String addArtistToSong(@RequestParam String trackId, @RequestParam Long artistId) {
//        Song song = songService.findByTrackId(trackId);
//        Artist artist = artistService.findById(artistId);
//
//        if (song != null && artist != null) {
//            songService.addArtistToSong(artist, song);
//        }
//
//        return "redirect:/songs";
//    }
////@PostMapping("/add-to-song")
////public String addArtistToSong(@RequestParam Long songId, @RequestParam Long artistId) {
////    Optional<Song> song = songService.findById(songId);
////    Artist artist = artistService.findById(artistId);
////
////    if (song != null && artist != null) {
////        songService.addArtistToSong(songId, artist);
////    }
////
////    return "redirect:/songs";
////}
//
//
//    @GetMapping("/details")
//    public String getArtistDetails(@RequestParam Long artistId, Model model) {
//        Artist artist = artistService.findById(artistId);
//
//        if (artist == null) {
//            return "redirect:/artists?error=Artist not found";
//        }
//
//        model.addAttribute("artist", artist);
//        return "artistDetails"; // Create this template for displaying artist details
//    }
//
//
//}

package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;

    }
    @GetMapping("/search")
    public String searchArtists(@RequestParam(required = false) String trackId,
                                @RequestParam(required = false) String searchQuery,
                                Model model) {
        // Log inputs for debugging
        System.out.println("Search Query: " + searchQuery);
        System.out.println("Track ID: " + trackId);

        // Perform the search
        List<Artist> artists;
        if (searchQuery != null && !searchQuery.isEmpty()) {
            artists = artistService.searchArtists(searchQuery);
        } else {
            artists = artistService.listArtists();
        }

        // Add attributes to the model
        model.addAttribute("listOfArtists", artists);
        model.addAttribute("trackId", trackId);


        // Return a new template for the search results
        return "searchArtists";
    }

    @GetMapping
    public String listArtists(@RequestParam(required = false) String trackId,
                              @RequestParam(required = false) String searchQuery,
                              Model model) {
        if (trackId == null || trackId.isEmpty()) {
            System.out.println("Track ID is missing or empty. Setting default value.");
            trackId = ""; // Or handle it as needed
        }

        List<Artist> artists;
        if (searchQuery != null && !searchQuery.isEmpty()) {
            artists = artistService.searchArtists(searchQuery);
        } else {
            artists = artistService.listArtists();
        }

        model.addAttribute("listOfArtists", artists);
        model.addAttribute("trackId", trackId); // Pass the default or original value

        return "listArtists";
    }




    //
//    @PostMapping("/add-to-artist")
//    public String addToArtist(@RequestParam String trackId, @RequestParam Long artistId) {
//        Song song = songService.findByTrackId(trackId);
//        Artist artist = artistService.findById(artistId);
//
//        if (song != null && artist != null) {
//            song.getPerformers().add(artist);
//
//        }
//
//        return "redirect:/artists";
//    }
    @PostMapping("/add-to-artist")
    public String addToArtist(@RequestParam String trackId, @RequestParam Long artistId) {
        // Find the song by trackId
        Song song = songService.findByTrackId(trackId);

        // Find the artist by artistId
        Artist artist = artistService.findById(artistId);

        if (song != null && artist != null) {
            // Use the helper method to add the performer
            song.addPerformer(artist);


            // Save the updated song to persist the relationship
            songService.save(song);
        }

        return "redirect:/artists";
    }



//    @PostMapping("/add-to-song")
//    public String addArtistToSong(@RequestParam String trackId, @RequestParam Long artistId) {
//        Song song = songService.findByTrackId(trackId);
//        Artist artist = artistService.findById(artistId);
//
//        if (song != null && artist != null) {
//            songService.addArtistToSong(artist, song);
//        } else {
//            return "redirect:/songs?error=Song or Artist not found";
//        }
//
//        return "redirect:/songs/details?trackId=" + trackId;
//    }


    @PostMapping("/add-to-song")
    public String addArtistToSong(@RequestParam String trackId, @RequestParam Long artistId) {
        Song song = songService.findByTrackId(trackId);
        Artist artist = artistService.findById(artistId);

        if (song != null && artist != null) {
            songService.addArtistToSong(artist, song);
        }

        return "redirect:/songs";
    }
//@PostMapping("/add-to-song")
//public String addArtistToSong(@RequestParam Long songId, @RequestParam Long artistId) {
//    Optional<Song> song = songService.findById(songId);
//    Artist artist = artistService.findById(artistId);
//
//    if (song != null && artist != null) {
//        songService.addArtistToSong(songId, artist);
//    }
//
//    return "redirect:/songs";
//}


    @GetMapping("/details")
    public String getArtistDetails(@RequestParam Long artistId, Model model) {
        Artist artist = artistService.findById(artistId);

        if (artist == null) {
            return "redirect:/artists?error=Artist not found";
        }

        model.addAttribute("artist", artist);
        model.addAttribute("artistId", artistId);
        return "artistDetails"; // Create this template for displaying artist details
    }


}

