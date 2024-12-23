//package mk.ukim.finki.wp.lab.web.controller;
//
//
//import ch.qos.logback.core.model.Model;
//import mk.ukim.finki.wp.lab.model.Album;
//import mk.ukim.finki.wp.lab.model.Song;
//import mk.ukim.finki.wp.lab.service.AlbumService;
//import mk.ukim.finki.wp.lab.service.SongService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Controller
//@RequestMapping("/albums")
//public class AlbumController{
//
//    private final AlbumService albumService;
//    private final SongService songService;
//
//    public AlbumController(AlbumService albumService, SongService songService) {
//        this.albumService = albumService;
//        this.songService = songService;
//    }
//
//    @GetMapping("/albums/{id}")
//    public String getAlbumDetails(@PathVariable Long id, Model model) {
//        Album album = albumService.findBy(id);
//        if (album == null) {
//            return "redirect:/songs?error=Album not found";
//        }
//
//        // Filter the songs related to the album
//        List<Song> songs = songService.findAll().stream()
//                .filter(song -> song.getAlbum() != null && song.getAlbum().getId().equals(id))
//                .collect(Collectors.toList());
//
//        model.addAttribute("album", album);
//        model.addAttribute("songs", songs);
//        return "albumDetails"; // Ensure this template exists
//    }
//}
