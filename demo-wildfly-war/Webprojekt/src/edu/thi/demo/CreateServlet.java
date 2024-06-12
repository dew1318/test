
package edu.thi.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.thi.bean.storeData;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Resource(lookup="java:jboss/datasources/MySqlThidbDS")
    private javax.sql.DataSource DS;
    
    public CreateServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{ 
            // Erstellen des Beans und Einholen der eingegangenen Formularwerte
            storeData product = new storeData();
            product.setProductname(request.getParameter("productname"));
            product.setQuantity(request.getParameter("quantity"));

            // Einrichten der Datenbankverbindung
            try(Connection con = DS.getConnection();
                PreparedStatement stmt = con.prepareStatement("insert into products(productname, quantity) values(?,?)")) {
                  
                // Setzen der Werte in das PreparedStatement
                stmt.setString(1, product.getProductname());
                stmt.setString(2, product.getQuantity());
                
                // Ausführen des Updates auf die Datenbank
                stmt.executeUpdate();
                
            } catch(SQLException e){
                throw new ServletException("Database error", e);
            }            
            
            // Rückmeldung an den Benutzer
            response.getWriter().append("Product added successfully.");
           
        } catch(Exception e){
           throw new ServletException("General error", e);
        }
    }
}
