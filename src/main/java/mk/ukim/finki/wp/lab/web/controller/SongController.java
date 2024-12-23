package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "listSongs";
    }


    @GetMapping("/add-form")
    public String getAddSongPage(Model model) {
        model.addAttribute("albums", albumService.findAll());
        model.addAttribute("song", new Song());
        return "add-song";
    }

    @PostMapping("/select")
    public String selectSong(@RequestParam String selectedTrackId) {
        return "redirect:/artists?trackId=" + selectedTrackId; // Pass as String
    }
    @GetMapping("/add")
    public String showAddSongForm(Model model) {
        model.addAttribute("song", new Song());
        model.addAttribute("albums",albumService.findAll());// For binding form fields
        return "add-song"; // Thymeleaf template
    }
//    @PostMapping("/add")
//    public String saveSong(@RequestParam String title,
//                           @RequestParam Long trackId,
//                           @RequestParam String genre,
//                           @RequestParam int releaseYear,
//                           @RequestParam Long albumId) {
//        Album album = albumService.findAll().stream()
//                .filter(a -> a.getId().equals(albumId))
//                .findFirst()
//                .orElse(null);
//
////        Song song = new Song(null, trackId, title, genre, releaseYear, album);
////        songService.save(song);
////        return "redirect:/songs";
//        Song song = new Song(trackId, title, genre, releaseYear, album);
//        songService.save(song);
//        return "redirect:/songs";
//
//    }
@PostMapping("/add")
public String saveSong(@RequestParam String title,
                       @RequestParam Long trackId,
                       @RequestParam String genre,
                       @RequestParam int releaseYear,
                       @RequestParam Long albumId) {
    // Fetch the album by its ID
    Album album = albumService.findBy(albumId);
    if (album == null) {
        // Handle the case where the album is not found
        return "redirect:/songs/add?error=AlbumNotFound";
    }


    // Create and save the new song
    Song song = new Song(trackId, title, genre, releaseYear, album);
    songService.save(song);

    // Redirect to the songs list
    return "redirect:/songs";
}




    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        // Fetch the song by ID
        Song song = this.songService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Song ID: " + id));
        // Fetch all albums for the dropdown
        List<Album> albums = this.albumService.findAll();

        model.addAttribute("song", song);
        model.addAttribute("albums", albums);

        // Redirect to the song edit page
        return "add-song";
    }

    @PostMapping("/edit/{id}")
    public String saveEditedSong(@PathVariable Long id,
                                 @RequestParam String title,
                                 @RequestParam String trackId,
                                 @RequestParam String genre,
                                 @RequestParam int releaseYear,
                                 @RequestParam Long albumId) {
        // Update the song details
        this.songService.update(id, title, trackId, genre, releaseYear, albumId);
        return "redirect:/songs";
    }



    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable String id) {
        songService.deleteById(Long.valueOf(id));
        return "redirect:/songs";
    }
    @GetMapping("/songs/details")
    public String getSongDetails(@RequestParam String trackId, Model model) {
        Song song = songService.findByTrackId(trackId);

        if (song == null) {
            return "redirect:/songs?error=Song not found";
        }

        model.addAttribute("song", song);
        return "songDetails"; // Create this template for displaying song details
    }

}
