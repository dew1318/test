package edu.thi.demo;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

     // Überprüfen Sie die Anmeldeinformationen
        if (authenticate(loginBean)) {
            // Erstellen Sie eine Sitzung und setzen Sie die Attribute
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Benutzer zur Willkommensseite umleiten
            response.sendRedirect("../../../userDashboard.jsp");
        } else {
            // Falls die Anmeldung fehlschlägt, leiten Sie zurück zur Anmeldeseite mit einer Fehlermeldung
            response.sendRedirect(request.getContextPath() + "/login.html?error=1");
        }
    	
    	
    }
    
 // Authentifizierungsmethode zur Überprüfung der Anmeldeinformationen
    private boolean authenticate(LoginBean loginBean) {
        // Hier sollte die Überprüfung mit der Datenbank erfolgen
        // Beispiel:
        // return "admin".equals(loginBean.getUsername()) && "password".equals(loginBean.getPassword());
        // Implementieren Sie die echte Überprüfung mit der Datenbank
        // Zum Beispiel:
        // return UserDAO.validate(loginBean);

        // Dummy-Überprüfung (zu ersetzen mit realer Überprüfung)
        return "admin".equals(loginBean.getUsername()) && "password".equals(loginBean.getPassword());
    }
    
    
}
