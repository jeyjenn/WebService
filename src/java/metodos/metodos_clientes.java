package metodos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Cliente_Documento;
import modelo.Roles;

public class metodos_clientes {

    Connection con;
    int r;

    public metodos_clientes() {
        Conexion conn = new Conexion();
        con = conn.ConectarBD();

    }

    public List Listar_cliente() {
        List<Cliente> lista = new ArrayList<>();
        PreparedStatement iniciar;
        ResultSet resultado;
        try {
            iniciar = con.prepareStatement("SELECT * FROM clientes");
            resultado = iniciar.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setCliente_id(resultado.getInt(1));
                cliente.setCliente_cedula(resultado.getString(2));
                cliente.setCliente_nombres(resultado.getString(3));
                cliente.setCliente_telefono(resultado.getString(4));
                cliente.setCliente_correo(resultado.getString(5));
                lista.add(cliente);
            }
            resultado.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public int insertar_cliente(Cliente mensajero_insertar_cliente) {
        PreparedStatement iniciar;
        try {
            iniciar = con.prepareStatement("insert into clientes(cliente_id,cliente_cedula ,cliente_nombres, cliente_telefono, cliente_correo ) values(?,?,?,?,?)");
            iniciar.setInt(1, mensajero_insertar_cliente.getCliente_id());
            iniciar.setString(2, mensajero_insertar_cliente.getCliente_cedula());
            iniciar.setString(3, mensajero_insertar_cliente.getCliente_nombres());
            iniciar.setString(4, mensajero_insertar_cliente.getCliente_telefono());
            iniciar.setString(5, mensajero_insertar_cliente.getCliente_correo());

            iniciar.executeUpdate();
            System.out.println("datos guardados correctamente");
            iniciar.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al guardar los datos");
        }
        return r;
    }

    public Cliente Cargar_Datos(int pasar_id) {

        PreparedStatement iniciar;
        ResultSet resultado;
        Cliente cliente = new Cliente();
        try {
            iniciar = con.prepareStatement("select cliente_id ,cliente_cedula, cliente_nombres,cliente_telefono,cliente_correo from clientes where cliente_id=?");
            iniciar.setInt(1, pasar_id);

            resultado = iniciar.executeQuery();
            while (resultado.next()) {
                cliente.setCliente_id(resultado.getInt(1));
                cliente.setCliente_cedula(resultado.getString(2));
                cliente.setCliente_nombres(resultado.getString(3));
                cliente.setCliente_telefono(resultado.getString(4));
                cliente.setCliente_correo(resultado.getString(5));
            }
            resultado.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al mostrar datos");
            return null;
        }
        return cliente;
    }

    public int insertar_doc_cliente(Cliente_Documento men) {
        PreparedStatement iniciar;
        try {
            Cliente cliente = new Cliente();
            iniciar = con.prepareStatement("insert into docu_clientes(cliente_docu_id,cliente_id, cliente_docu_nombres, archivopdf ) values(?,?,?,?)");
            iniciar.setInt(1, men.getCliente_docu_id());
            iniciar.setInt(2, men.getCliente().getCliente_id());
            iniciar.setString(3, men.getNombre_docu());
            iniciar.setBlob(4, men.getArchivopdf());

            iniciar.executeUpdate();
            System.out.println("datos guardados correctamente");
            iniciar.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al guardar los datos");
        }
        return r;
    }

    public int Actualizar_cliente(Cliente mensajero_actualizar) {
        PreparedStatement iniciar;
        try {
            iniciar = con.prepareStatement("update clientes set cliente_cedula=?, cliente_nombres=?, cliente_telefono=?, cliente_correo=? where cliente_id=?");

            iniciar.setString(1, mensajero_actualizar.getCliente_cedula());
            iniciar.setString(2, mensajero_actualizar.getCliente_nombres());
            iniciar.setString(3, mensajero_actualizar.getCliente_telefono());
            iniciar.setString(4, mensajero_actualizar.getCliente_correo());

            iniciar.setInt(5, mensajero_actualizar.getCliente_id());
            iniciar.executeUpdate();
            System.out.println("datos actualizados correctamente");
            iniciar.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al guardar los datos");
        }
        return r;
    }

    public void eliminarCliente(Cliente cliente) {
        PreparedStatement iniciar;
        try {
            iniciar = con.prepareStatement("delete from clientes where cliente_id=" + cliente.getCliente_id());
            iniciar.executeUpdate();
            iniciar.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al mostrar datos");
        }
    }
    
        public void eliminarDocumento(Cliente_Documento cliente_documento) {
        PreparedStatement iniciar;
        try {
            iniciar = con.prepareStatement("delete from docu_clientes where cliente_docu_id="+cliente_documento.getCliente_docu_id());
            iniciar.executeUpdate();
            iniciar.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al eliminar los datos");
        }
    }

    
    
    public List Listar_por_id(int cod) {
        List<Cliente_Documento> listar = new ArrayList<>();
        PreparedStatement iniciar;
        ResultSet resultado;
        try {
            iniciar = con.prepareStatement("select cliente_docu_id, cliente_id, cliente_docu_nombres,archivopdf from docu_clientes where cliente_id="+cod);
            resultado = iniciar.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                Cliente_Documento cliente_documento = new Cliente_Documento();
                
                cliente_documento.setCliente_docu_id(resultado.getInt(1));
                cliente.setCliente_id(resultado.getInt(2));
                cliente_documento.setNombre_docu(resultado.getString(3));
                cliente_documento.setArchivopdf2(resultado.getBytes(4));
                
                cliente_documento.setCliente(cliente);
                listar.add(cliente_documento);
               
            }
            resultado.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listar;
    }
    
        public Cliente buscar_cedula(String pasar_cedula) {
        
        PreparedStatement iniciar;
        ResultSet resultado;
        Cliente c = new Cliente();
        try {
            iniciar = con.prepareStatement("select cliente_id,cliente_nombres,cliente_cedula,cliente_telefono,cliente_correo from clientes where cliente_cedula=?");
            iniciar.setString(1, pasar_cedula);
          
            resultado = iniciar.executeQuery();
            while (resultado.next()) {  
                c.setCliente_id(resultado.getInt(1));
                c.setCliente_nombres(resultado.getString(2));
                c.setCliente_cedula(resultado.getNString(3));
                c.setCliente_telefono(resultado.getNString(4));
                c.setCliente_correo(resultado.getString(5));         
            }   
            resultado.close();
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al mostrar datos");
            return null;
        }
        return c; 
    }

}
