package servleti;

import org.ekipaenajst.beans.UporabnikiZrno;
import org.ekipaenajst.beans.AvtiZrno;
import org.ekipaenajst.beans.NasloviZrno;
import org.ekipaenajst.entitete.*;


import java.util.List;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet("/servlet")
public class JPAServlet extends HttpServlet {

    @Inject
    private UporabnikiZrno uporabnikiZrno;

    @Inject
    private AvtiZrno avtiZrno;

    @Inject
    private NasloviZrno nasloviZrno;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Uporabnik> uporabniki = uporabnikiZrno.getUporabniki();
        List<Avto> avti = avtiZrno.getAvti();
        List<Naslov> naslovi = nasloviZrno.getNaslovi();

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();

        // izpis uporabnikov
        writer.append("<br/><br/>Uporabniki:<br/>");


        for (Uporabnik uporabnik : uporabniki) {
            writer.append(uporabnik.toString());
            writer.append("<br/>");
        }

        // izpis avtov
        writer.append("<br/><br/>Avti:<br/>");


        for (Avto avto : avti) {
            writer.append(avto.toString());
            writer.append("<br/>");
        }

        // izpis naslovov
        writer.append("<br/><br/>Naslovi:<br/>");


        for (Naslov naslov : naslovi) {
            writer.append(naslov.toString());
            writer.append("<br/>");
        }

        // ustvarjanje novega uporabnika
        writer.append("<br/>Ustvarjanje uporabnika <br/>");
        Uporabnik u = new Uporabnik();
        u.setFirstName("Andrej");
        u.setLastName("Andrejevič");
        u.setUsername("aa");
        u.setEmail("aa@gmail.com");


        writer.append(u.toString());
        writer.append("<br/>");

        uporabnikiZrno.createUporabnik(u);

        // izpis uporabnikov
        writer.append("<br/><br/>Uporabniki:<br/>");

        uporabniki = uporabnikiZrno.getUporabniki();

        for (Uporabnik uporabnik : uporabniki) {
            writer.append(uporabnik.toString());
            writer.append("<br/>");
        }

        Uporabnik u2 = uporabnikiZrno.getUporabnik(2);
        writer.append("<br/><br/>Posodabljanje Uporabnika 2:<br/>");

        if (u2!=null) writer.append(u2.toString());
        writer.append("<br/>");

        u2.setFirstName("Ožbej");

        uporabnikiZrno.updateUporabnik(u2);


        // izpis uporabnikov
        writer.append("<br/><br/>Uporabniki:<br/>");

        uporabniki = uporabnikiZrno.getUporabniki();

        for (Uporabnik uporabnik : uporabniki) {
            writer.append(uporabnik.toString());
            writer.append("<br/>");
        }

        writer.append("<br/><br/>Brisanje Uporabnika 2:<br/>");

        writer.append(u2.toString());
        writer.append("<br/>");


        uporabnikiZrno.deleteUporabnik(u2);


        // izpis uporabnikov
        writer.append("<br/><br/>Uporabniki:<br/>");

        uporabniki = uporabnikiZrno.getUporabniki();

        for (Uporabnik uporabnik : uporabniki) {
            writer.append(uporabnik.toString());
            writer.append("<br/>");
        }



    }
}