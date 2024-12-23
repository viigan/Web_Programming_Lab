package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SongDetailsController {
    private final SongService songService;

    public SongDetailsController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/songs/details")
    public String getSongDetails(@RequestParam String trackId, Model model) {
        Song song = songService.findByTrackId(trackId);

        if (song == null) {
            return "redirect:/songs?error=Song not found";
        }

        model.addAttribute("song", song);
        return "songDetails"; // Matches the Thymeleaf template
    }
}
