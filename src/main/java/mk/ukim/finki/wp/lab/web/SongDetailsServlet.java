//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Artist;
//import mk.ukim.finki.wp.lab.model.Song;
//import mk.ukim.finki.wp.lab.service.ArtistService;
//import mk.ukim.finki.wp.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "SongDetailsServlet",urlPatterns = "/details")
//public class SongDetailsServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//    private final SongService songService;
//    private final ArtistService artistService;
//
//    public SongDetailsServlet(SpringTemplateEngine springTemplateEngine, SongService songService, ArtistService artistService) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.songService = songService;
//        this.artistService = artistService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(webExchange);
//        String artistId = req.getParameter("artistId");
//        String trackId = req.getParameter("trackId");
//        if(artistId!=null){
//            Artist artist = artistService.ArtistfindById(Long.valueOf(artistId));
//            context.setVariable("artistObj",artist);
//            springTemplateEngine.process("artistDetails.html",context,resp.getWriter());
//        }
//        else {
//            Song song= songService.findById(Long.valueOf(trackId));
//            context.setVariable("songObj",song);
//            springTemplateEngine.process("songDetails.html",context,resp.getWriter());
//        }
//    }
//}
