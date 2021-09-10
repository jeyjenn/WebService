package metodos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Roles;

public class metodos {

    Connection con;
    int r;
    int rol_id=1;

    public metodos() {
        Conexion conn = new Conexion();
        con = conn.ConectarBD();

    }

    public Roles valida(String nombre, String pass) {
        PreparedStatement iniciar;
        ResultSet resultado;
        Roles roles = new Roles();
        try {
            iniciar = con.prepareStatement("SELECT * FROM roles where rol_usuario=? and rol_contraseña=?");

            iniciar.setString(1, nombre);
            iniciar.setString(2, pass);

            resultado = iniciar.executeQuery();

            if (resultado.next()) {
                roles.setRol_usuario(resultado.getString("rol_usuario"));
                roles.setRol_contraseña(resultado.getString("rol_contraseña"));
                roles.setRol_rol(resultado.getString("rol_rol"));
                roles.setRol_estado(resultado.getString("rol_estado"));
                roles.setRol_nombres(resultado.getString("rol_nombres"));

            }
            resultado.close();

        } catch (SQLException ex) {

            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roles;

    }

    public List Listar() {

        List<Roles> lista = new ArrayList<>();

        PreparedStatement iniciar;
        ResultSet resultado;

        try {

            iniciar = con.prepareStatement("SELECT * FROM roles");
            resultado = iniciar.executeQuery();
            while (resultado.next()) {
                Roles roles = new Roles();
                roles.setRol_id(resultado.getInt(1));
                roles.setRol_nombres(resultado.getString(2));
                roles.setRol_usuario(resultado.getString(3));
                roles.setRol_contraseña(resultado.getString(4));
                roles.setRol_estado(resultado.getString(5));
                roles.setRol_rol(resultado.getString(6));
                lista.add(roles);
            }
            resultado.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public Roles editar(int pasar_id) {
        
        PreparedStatement iniciar;
        ResultSet resultado;
        Roles roles = new Roles();
        try {
            iniciar = con.prepareStatement("select rol_id , rol_nombres, rol_usuario, rol_contraseña, rol_estado, rol_rol from roles where rol_id=?");
            iniciar.setInt(1, pasar_id);
          
            resultado = iniciar.executeQuery();
            while (resultado.next()) {             
                roles.setRol_id(resultado.getInt(1));
                roles.setRol_nombres(resultado.getString(2));
                roles.setRol_usuario(resultado.getString(3));
                roles.setRol_contraseña(resultado.getString(4));
                roles.setRol_estado(resultado.getString(5));
                roles.setRol_rol(resultado.getString(6));          
            }   
            resultado.close();
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al mostrar datos");
            return null;
        }
        return roles; 
    }

    public int insertar(Roles mensajero_insertar) {
        PreparedStatement iniciar;
        try {
            iniciar = con.prepareStatement("insert into roles(rol_id, rol_nombres, rol_usuario, rol_contraseña, rol_estado, rol_rol ) values(?,?,?,?,?,?)");
            iniciar.setInt(1, mensajero_insertar.getRol_id());
            iniciar.setString(2, mensajero_insertar.getRol_nombres());
            iniciar.setString(3, mensajero_insertar.getRol_usuario());
            iniciar.setString(4, mensajero_insertar.getRol_contraseña());
            iniciar.setString(5, mensajero_insertar.getRol_estado());
            iniciar.setString(6, mensajero_insertar.getRol_rol());
            iniciar.executeUpdate();
            System.out.println("datos guardados correctamente");
            iniciar.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al guardar los datos");
        } 
        return r;
    }
    
    
        public int Actualizar(Roles mensajero_actualizar) {
        PreparedStatement iniciar;
        try {
            iniciar = con.prepareStatement("update roles set rol_nombres=?, rol_usuario=?, rol_contraseña=?, rol_estado=?, rol_rol=? where rol_id=?");
           
            iniciar.setString(1, mensajero_actualizar.getRol_nombres());
            iniciar.setString(2, mensajero_actualizar.getRol_usuario());
            iniciar.setString(3, mensajero_actualizar.getRol_contraseña());
            iniciar.setString(4, mensajero_actualizar.getRol_estado());
            iniciar.setString(5, mensajero_actualizar.getRol_rol());
            
            iniciar.setInt(6, mensajero_actualizar.getRol_id());
            iniciar.executeUpdate();
            System.out.println("datos actualizados correctamente");
            iniciar.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al guardar los datos");
        } 
        return r;
    }
    
    
       public Roles validar_cedula(String rol_nombres) {
        PreparedStatement iniciar;
        ResultSet resultado;
        Roles roles = new Roles();
        try {
            iniciar = con.prepareStatement("SELECT * FROM roles where rol_nombres=?");

            iniciar.setString(1, rol_nombres);

            resultado = iniciar.executeQuery();

            if (resultado.next()) {
                roles.setRol_nombres(resultado.getString("rol_nombres"));
            }
            resultado.close();
        } catch (SQLException ex) {

            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roles;
    }

    public void eliminarEmpleado(Roles roles){
        PreparedStatement iniciar;
        try {
            iniciar = con.prepareStatement("delete  from roles where rol_id="+roles.getRol_id());
            iniciar.executeUpdate();
            iniciar.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("error al mostrar datos"); 
        } 
    }
    
    public List<Roles> GenerarCodigo(){       
        PreparedStatement iniciar;
        ResultSet resultado;

        List<Roles> lista= new ArrayList<>();           
        try {            
            iniciar = con.prepareStatement("SELECT MAX(rol_id)+1 FROM roles");
            resultado = iniciar.executeQuery();           
            while(resultado.next()){  
                
            rol_id = resultado.getInt(1);
            Roles fff = new Roles(rol_id,"","","","","");
            lista.add(fff);
            } 
            resultado.close();
           return lista;
           
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    } 

}
