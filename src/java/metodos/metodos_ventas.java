
package metodos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Ventas;


public class metodos_ventas {
    
    Connection con;
    int r;
    int id_ventas =1;
    int id_cliente =1;
    double valor = 0.0;

    public metodos_ventas() {
        Conexion conn = new Conexion();
        con = conn.ConectarBD();
    }
    public int guardarVenta(Ventas ve){
        PreparedStatement iniciar;
        try {
            Cliente cliente = new Cliente();
            iniciar = con.prepareStatement("insert into Ventas(id_ventas, cliente_id,fecha_emision,cliente_cedula,cliente_nombres,valor_servicio,numeroSerie  ) values(?,?,?,?,?,?,?)");
            iniciar.setInt(1, ve.getId_ventas());
            iniciar.setInt(2, ve.getCliente().getCliente_id());
            iniciar.setDate(3, ve.getFecha_emision());
            iniciar.setString(4, ve.getCliente().getCliente_cedula());
            iniciar.setString(5, ve.getCliente().getCliente_nombres());
            iniciar.setDouble(6, ve.getValor_servicio());
            iniciar.setString(7, ve.getNumeroSerie());
            iniciar.executeUpdate();
            System.out.println("datos guardados correctamente");
            iniciar.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al guardar los datos");
        } 
        return r;
    }
    
    public String IdVentas(){
        String idventas="";
        PreparedStatement iniciar;
        ResultSet resultado;
        
         try {
            iniciar = con.prepareStatement("SELECT MAX(id_ventas)+1 FROM Ventas");
            resultado = iniciar.executeQuery();           
            while(resultado.next()){ 
                idventas =resultado.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al guardar los datos");
        } 
        return idventas;
    }
    
     public String GenerarSerie(){
        String numeroserie="";
        PreparedStatement iniciar;
        ResultSet resultado;
        
         try {
            iniciar = con.prepareStatement("SELECT MAX(numeroSerie)FROM Ventas");
            resultado = iniciar.executeQuery();           
            while(resultado.next()){ 
                numeroserie=resultado.getString(1);
                 System.out.println(numeroserie);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al guardar los datos");
        } 
        return numeroserie;
    }


    
}
