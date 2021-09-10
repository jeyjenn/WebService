
package modelo;


public class Cliente {
    private int cliente_id;
    private String cliente_cedula;
    private String cliente_nombres;
    private String cliente_telefono;
    private String cliente_correo;

    public String getCliente_telefono() {
        return cliente_telefono;
    }

    public void setCliente_telefono(String cliente_telefono) {
        this.cliente_telefono = cliente_telefono;
    }
    

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente_cedula() {
        return cliente_cedula;
    }

    public void setCliente_cedula(String cliente_cedula) {
        this.cliente_cedula = cliente_cedula;
    }

    public String getCliente_nombres() {
        return cliente_nombres;
    }

    public void setCliente_nombres(String cliente_nombres) {
        this.cliente_nombres = cliente_nombres;
    }



    public String getCliente_correo() {
        return cliente_correo;
    }

    public void setCliente_correo(String cliente_correo) {
        this.cliente_correo = cliente_correo;
    }
    
    

   
    
}
