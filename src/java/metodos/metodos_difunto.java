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
import modelo.Difunto_Documento;

public class metodos_difunto {

    Connection con;
    int r;

    public metodos_difunto() {
        Conexion conn = new Conexion();
        con = conn.ConectarBD();
    }

    public int insertar_difunto(Difunto d) {
        PreparedStatement iniciar;
        try {
            Cliente cliente = new Cliente();
            iniciar = con.prepareStatement("insert into difuntos(difunto_id, cliente_id, difunto_cedula,difunto_nombres,difunto_edad,difunto_sexo,d_fecha_nacimiento,d_fecha_deceso,difunto_causa ) values(?,?,?,?,?,?,?,?,?)");
            iniciar.setInt(1, d.getDifunto_id());
            iniciar.setInt(2, d.getCliente().getCliente_id());
            iniciar.setString(3, d.getDifunto_cedula());
            iniciar.setString(4, d.getDifunto_nombres());
            iniciar.setInt(5, d.getDifunto_edad());
            iniciar.setString(6, d.getDifunto_sexo());
            iniciar.setString(7, d.getD_fecha_nacimiento());
            iniciar.setString(8, d.getD_fecha_deceso());
            iniciar.setString(9, d.getDifunto_causa());

            iniciar.executeUpdate();
            System.out.println("datos guardados correctamente");
            iniciar.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al guardar los datos");
        }
        return r;
    }

    public List Listar_por_id__difunto(int cod) {
        List<Difunto> listar = new ArrayList<>();
        PreparedStatement iniciar;
        ResultSet resultado;
        try {
            iniciar = con.prepareStatement("select difunto_id,cliente_id,difunto_nombres from difuntos  where cliente_id=" + cod);
            resultado = iniciar.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                Difunto difunto = new Difunto();

                difunto.setDifunto_id(resultado.getInt(1));
                cliente.setCliente_id(resultado.getInt(2));
                difunto.setDifunto_nombres(resultado.getNString(3));
                difunto.setCliente(cliente);
                listar.add(difunto);

            }
            resultado.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listar;
    }

    public Difunto Cargar_Datos_dif(int pasar_id) {

        PreparedStatement iniciar;
        ResultSet resultado;
        Difunto difunto = new Difunto();
        try {
            iniciar = con.prepareStatement("select difunto_id from difuntos where difunto_id=?");
            iniciar.setInt(1, pasar_id);

            resultado = iniciar.executeQuery();
            while (resultado.next()) {
                difunto.setDifunto_id(resultado.getInt(1));
            }
            resultado.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al mostrar datos");
            return null;
        }
        return difunto;
    }

    public int insertar_doc_difunto(Difunto_Documento df) {
        PreparedStatement iniciar;
        try {
            Difunto difunto = new Difunto();
            iniciar = con.prepareStatement("insert into docu_difuntos(difunto_docu_id, difunto_id , difunto_nombre_archivo, difunto_pdf ) values(?,?,?,?)");
            iniciar.setInt(1, df.getDifunto_docu_id());
            iniciar.setInt(2, df.getDifunto().getDifunto_id());
            iniciar.setString(3, df.getDifunto_nombre_archivo());
            iniciar.setBlob(4, df.getDifunto_pdf());

            iniciar.executeUpdate();
            System.out.println("datos guardados correctamente");
            iniciar.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al guardar los datos");
        }
        return r;
    }
        public List Listar_pdf_difunto(int cod) {
        List<Difunto_Documento> listar = new ArrayList<>();
        PreparedStatement iniciar;
        ResultSet resultado;
        try {
            iniciar = con.prepareStatement("select difunto_docu_id,difunto_nombre_archivo,difunto_pdf from docu_difuntos   where difunto_id=" + cod);
            resultado = iniciar.executeQuery();
            while (resultado.next()) {
                Difunto_Documento df = new Difunto_Documento();

                df.setDifunto_docu_id(resultado.getInt(1));
                df.setDifunto_nombre_archivo(resultado.getString(2));
                df.setDifunto_pdf2(resultado.getBytes(3));
                listar.add(df);

            }
            resultado.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listar;
    }


}
