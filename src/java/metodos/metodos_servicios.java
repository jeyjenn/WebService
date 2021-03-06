package metodos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Servicios;

public class metodos_servicios {

    Connection con;
    int r;

    public metodos_servicios() {
        Conexion conn = new Conexion();
        con = conn.ConectarBD();

    }

    public List Listar_Servicios() {
        List<Servicios> lista = new ArrayList<>();
        PreparedStatement iniciar;
        ResultSet resultado;
        try {
            iniciar = con.prepareStatement("SELECT * FROM servicios");
            resultado = iniciar.executeQuery();
            while (resultado.next()) {
                Servicios servicios = new Servicios();
                servicios.setId_servicio(resultado.getInt(1));
                servicios.setCod_servicio(resultado.getString(2));
                servicios.setNombre_servicio(resultado.getString(3));
                servicios.setFoto_servicio(resultado.getString(4));
                servicios.setValor_servicio(resultado.getDouble(5));
                lista.add(servicios);
            }
            resultado.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
     public void eliminarServicio(Servicios s) {
        PreparedStatement iniciar;
        try {
            iniciar = con.prepareStatement("delete from servicios where id_servicio=" + s.getId_servicio());
            iniciar.executeUpdate();
            System.out.println("dato eliminado correctamente");
            iniciar.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al mostrar datos");
        }
    }
     
       public int insertar_servicio(Servicios ser) {
        PreparedStatement iniciar;
        try {
            iniciar = con.prepareStatement("insert into servicios(id_servicio,cod_servicio,nombre_servicio, foto_servicio, valor_servicio) values(?,?,?,?,?)");
            iniciar.setInt(1, ser.getId_servicio());
            iniciar.setString(2, ser.getCod_servicio());
            iniciar.setString(3, ser.getNombre_servicio());
            iniciar.setString(4, ser.getFoto_servicio());
            iniciar.setDouble(5, ser.getValor_servicio());

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
