
package conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
        public Connection ConectarBD(){
            try {
            Class.forName("com.mysql.jdbc.Driver");
            //Connection conexion = DriverManager.getConnection("jdbc:mysql://node3776-env-9646649.sp.skdrive.net/webservices","root","TDLmfm19122");
            //Connection conexion = DriverManager.getConnection("jdbc:mysql://node3927-webservices.sp.skdrive.net/webservices","root","MTx9bsu4op");
           
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/webservices","root","");
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
