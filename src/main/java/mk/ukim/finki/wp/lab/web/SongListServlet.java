//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "SongListServlet",urlPatterns = "/listSongs")
//public class SongListServlet extends HttpServlet {
//    private final SongService songService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public SongListServlet(SongService songService, SpringTemplateEngine springTemplateEngine) {
//        this.songService = songService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//@Override
//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////    String trackId = req.getParameter("trackId");
////    if (trackId != null) {
////        req.getSession().setAttribute("trackId", trackId);
////    }
//
//    IWebExchange webExchange = JakartaServletWebApplication
//            .buildApplication(getServletContext())
//            .buildExchange(req, resp);
//
//    WebContext context = new WebContext(webExchange);
//    context.setVariable("listOfSongs", songService.listSongs());
//
//    springTemplateEngine.process("listSongs.html", context, resp.getWriter());
//}
//
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String trackId = req.getParameter("trackId");
//
//        if (trackId != null) {
//            resp.sendRedirect(String.format("/artist?trackId=%s", trackId));
//        }
//        else {
//            resp.sendRedirect("/artist");
//        }
//    }
//
//}
