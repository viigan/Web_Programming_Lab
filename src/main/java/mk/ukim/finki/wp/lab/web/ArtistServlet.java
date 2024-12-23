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
//
//@WebServlet(name = "ArtistServlet",urlPatterns = "/artist")
//public class ArtistServlet extends HttpServlet {
//    private final ArtistService artistService;
//    private final SongService songService;
//
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public ArtistServlet(ArtistService artistService, SongService songService, SpringTemplateEngine springTemplateEngine) {
//        this.artistService = artistService;
//        this.songService = songService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//        //this
//
//       String trackId = req.getParameter("trackId");
//
//        context.setVariable("trackId", trackId);
//        context.setVariable("listOfArtists",artistService.listArtists());
//
//        springTemplateEngine.process("listArtists.html", context, resp.getWriter());
//    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
////        String artistId = req.getSession.("artistId");
//        String trackId = req.getParameter("trackId");
//       String artistId = req.getParameter("artistId");
//
//            Song song = songService.findByTrackId(trackId);
//            Artist artist = artistService.ArtistfindById(Long.valueOf(artistId));
//         songService.addArtistToSong(artist, song);
//
//         if(artistId!=null){
//             req.getSession().setAttribute("artist", artist);
//             resp.sendRedirect(String.format("/details?artistId=%s", artistId));
//
//         }else {
//
//             req.getSession().setAttribute("song", song);
//             resp.sendRedirect(String.format("/details?trackId=%s", trackId));
//
//         }
//
//
//
//    }
//
//
//
//
//
//
//}
