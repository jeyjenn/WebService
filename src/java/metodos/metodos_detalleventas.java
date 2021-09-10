
package metodos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Cliente;
import modelo.DetalleVentas;
import modelo.Materiales;
import modelo.Servicios;
import modelo.Ventas;


public class metodos_detalleventas {
     Connection con;
    int r;

    public metodos_detalleventas() {
        Conexion conn = new Conexion();
        con = conn.ConectarBD();
    }
    public int guardarVenta(DetalleVentas ve){
        PreparedStatement iniciar;
        try {
            Ventas ventas = new Ventas();
            Servicios servicios = new Servicios();
            Materiales materiales = new  Materiales();
            
            iniciar = con.prepareStatement("insert into detalleVentas(id_detalleventas, id_ventas, id_servicio , id_producto ,nombre_producto ,precio, cant ) values(?,?,?,?,?,?,?)");
            iniciar.setInt(1, ve.getId_detalleventas());
            iniciar.setInt(2, ve.getVentas().getId_ventas());
            iniciar.setInt(3, ve.getServicios().getId_servicio());
            iniciar.setInt(4, ve.getMateriales().getId_producto());
            iniciar.setString(5, ve.getMateriales().getNombre_producto());
            iniciar.setDouble(6, ve.getMateriales().getPrecio());
            iniciar.setInt(7, ve.getCant());
            
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
