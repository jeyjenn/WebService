
package metodos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Grupos;
import modelo.Servicios;


public class metodos_grupos {
    Connection con;
    int r;
    
     public metodos_grupos() {
        Conexion conn = new Conexion();
        con = conn.ConectarBD();

    }

       public List Listar_Grupos() {
        List<Grupos> lista = new ArrayList<>();
        PreparedStatement iniciar;
        ResultSet resultado;
        try {
            iniciar = con.prepareStatement("SELECT * FROM Grupos");
            resultado = iniciar.executeQuery();
            while (resultado.next()) {
                Grupos grupos = new Grupos();
                grupos.setId_grupo(resultado.getInt(1));
                grupos.setCod_grupo(resultado.getString(2));
                grupos.setDescripcion(resultado.getString(3));
                lista.add(grupos);
            }
            resultado.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
     public void eliminarGrupo(Grupos g) {
        PreparedStatement iniciar;
        try {
            iniciar = con.prepareStatement("delete from grupos where id_grupo=" + g.getId_grupo());
            iniciar.executeUpdate();
            System.out.println("dato eliminado correctamente");
            iniciar.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al mostrar datos");
        }
    }

    
}
