
package metodos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Funeraria;
import modelo.Roles;
import modelo.Servicios;


public class metodos_funeraria {
    
    Connection con;
    int r;
    
    public metodos_funeraria(){
        Conexion conn = new Conexion();
        con = conn.ConectarBD();
    }
    

        
        public List Listar_cabecera() {
        List<Funeraria> lista = new ArrayList<>();
        PreparedStatement iniciar;
        ResultSet resultado;
        try {
            iniciar = con.prepareStatement("SELECT * FROM funeraria");
            resultado = iniciar.executeQuery();
            while (resultado.next()) {
                Funeraria funeraria = new Funeraria();
                funeraria.setId_funeraria(resultado.getInt(1));
                funeraria.setRazon_social(resultado.getString(2));
                funeraria.setRuc(resultado.getNString(3));
                funeraria.setTipo_servicio(resultado.getString(4));
                funeraria.setAutorizacion(resultado.getNString(5));
                funeraria.setPersona_natural(resultado.getNString(6));
                funeraria.setDireccion(resultado.getNString(7));
                funeraria.setTelefono(resultado.getNString(8));
                funeraria.setEmail(resultado.getNString(9));
                lista.add(funeraria);
            }
            resultado.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
    
    
    
}
