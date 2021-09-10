
package modelo;


public class Roles {
    
    private int rol_id;
    private String rol_nombres;
    private String rol_usuario;
    private String rol_contraseña;
    private String rol_estado;
    private String rol_rol;
    
    public Roles(){
    }

    public Roles(int rol_id, String rol_nombres, String rol_usuario, String rol_contraseña, String rol_estado, String rol_rol) {
        this.rol_id = rol_id;
        this.rol_nombres = rol_nombres;
        this.rol_usuario = rol_usuario;
        this.rol_contraseña = rol_contraseña;
        this.rol_estado = rol_estado;
        this.rol_rol = rol_rol;
    }
    



    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getRol_nombres() {
        return rol_nombres;
    }

    public void setRol_nombres(String rol_nombres) {
        this.rol_nombres = rol_nombres;
    }

    public String getRol_usuario() {
        return rol_usuario;
    }

    public void setRol_usuario(String rol_usuario) {
        this.rol_usuario = rol_usuario;
    }

    public String getRol_contraseña() {
        return rol_contraseña;
    }

    public void setRol_contraseña(String rol_contraseña) {
        this.rol_contraseña = rol_contraseña;
    }

    public String getRol_estado() {
        return rol_estado;
    }

    public void setRol_estado(String rol_estado) {
        this.rol_estado = rol_estado;
    }

    public String getRol_rol() {
        return rol_rol;
    }

    public void setRol_rol(String rol_rol) {
        this.rol_rol = rol_rol;
    }
    
    
    
    
}
