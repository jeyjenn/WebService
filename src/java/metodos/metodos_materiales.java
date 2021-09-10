package metodos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Difunto;
import modelo.Grupos;
import modelo.Materiales;
import modelo.Servicios;
import modelo.Ventas;

public class metodos_materiales {

    Connection con;
    int r;

    public metodos_materiales() {
        Conexion conn = new Conexion();
        con = conn.ConectarBD();
    }


    
    public List Listar_por_servicio(int cod) {
        List<Materiales> listar = new ArrayList<>();
        PreparedStatement iniciar;
        ResultSet resultado;
        try {
            iniciar = con.prepareStatement("select id_producto, nombre_producto, precio, stock  from materiales where id_servicio="+cod);
            resultado = iniciar.executeQuery();
            while (resultado.next()) {
                
                Materiales materiales = new Materiales();
                
                materiales.setId_producto(resultado.getInt(1));
                materiales.setNombre_producto(resultado.getNString(2));
                materiales.setPrecio(resultado.getDouble(3));
                materiales.setStock(resultado.getInt(4));
                listar.add(materiales);
                System.out.println(materiales.getNombre_producto());
               
            }
            resultado.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listar;
    }
    public int guardarMateriales(Materiales m){
        PreparedStatement iniciar;
        try {
            Grupos g = new Grupos();
            Servicios s = new Servicios();
           
            iniciar = con.prepareStatement("insert into Materiales(id_producto , cod_producto ,id_grupo ,id_servicio ,nombre_producto ,precio ,stock   ) values(?,?,?,?,?,?,?)");
            iniciar.setInt(1, m.getId_producto());
            iniciar.setString(2, m.getCod_producto());
            iniciar.setInt(3, m.getGrupos().getId_grupo());
            iniciar.setInt(4, m.getServicios().getId_servicio() );
            iniciar.setString(5, m.getNombre_producto());
            iniciar.setDouble(6, m.getPrecio());
            iniciar.setInt(7, m.getStock());
            iniciar.executeUpdate();
            System.out.println("datos guardados correctamente");
            iniciar.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al guardar los datos");
        } 
        return r;
    }

}
