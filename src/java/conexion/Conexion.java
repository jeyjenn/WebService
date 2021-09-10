
package conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
        public Connection ConectarBD(){
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/webservice","root","");
            System.out.println("conexion exitosa");
            return conexion;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
    
    }
    
    
}
