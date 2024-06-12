package edu.thi.demo;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/StörungsServlet")
public class StörungsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Parameter aus dem Formular auslesen
        String wohnung = request.getParameter("wohnung");
        String kategorie = request.getParameter("kategorie");
        String beschreibung = request.getParameter("beschreibung");

        // Session erstellen und Attribute setzen
        HttpSession session = request.getSession();
        session.setAttribute("wohnung", wohnung);
        session.setAttribute("kategorie", kategorie);
        session.setAttribute("beschreibung", beschreibung);

        // HTML-Antwort generieren
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Störung Bestätigung</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f0f0f0; margin: 0; padding: 0; }");
            out.println("header { background-color: #4CAF50; color: white; padding: 15px; text-align: center; }");
            out.println("main { padding: 20px; max-width: 600px; margin: auto; background-color: white; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
            out.println("footer { background-color: #4CAF50; color: white; padding: 15px; text-align: center; }");
            out.println("nav a { color: white; text-decoration: none; padding: 0 15px; }");
            out.println("nav a:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<header><h1>Störung gemeldet</h1></header>");
            out.println("<main>");
            out.println("<h2>Störungsdetails</h2>");
            out.println("<p>Wohnung: " + wohnung + "</p>");
            out.println("<p>Kategorie: " + kategorie + "</p>");
            out.println("<p>Beschreibung: " + beschreibung + "</p>");
            out.println("</main>");
            out.println("<footer>");
            out.println("<nav>");
            out.println("<a href='Projekt/uebung81/StörungenHauptseite.html'>Aktuelle Störungen</a>");
            out.println("</nav>");
            out.println("</footer>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}



