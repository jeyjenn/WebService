
package modelo;

import java.sql.Date;


public class Difunto {
    private int difunto_id;
    private Cliente cliente;
    private String difunto_cedula;
    private String difunto_nombres;
    private int difunto_edad;
    private String difunto_sexo;
    private String d_fecha_nacimiento;
    private String d_fecha_deceso;
    private String difunto_causa;

    public String getD_fecha_nacimiento() {
        return d_fecha_nacimiento;
    }

    public void setD_fecha_nacimiento(String d_fecha_nacimiento) {
        this.d_fecha_nacimiento = d_fecha_nacimiento;
    }

    public String getD_fecha_deceso() {
        return d_fecha_deceso;
    }

    public void setD_fecha_deceso(String d_fecha_deceso) {
        this.d_fecha_deceso = d_fecha_deceso;
    }
    
    

    public int getDifunto_id() {
        return difunto_id;
    }

    public void setDifunto_id(int difunto_id) {
        this.difunto_id = difunto_id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDifunto_cedula() {
        return difunto_cedula;
    }

    public void setDifunto_cedula(String difunto_cedula) {
        this.difunto_cedula = difunto_cedula;
    }

    public String getDifunto_nombres() {
        return difunto_nombres;
    }

    public void setDifunto_nombres(String difunto_nombres) {
        this.difunto_nombres = difunto_nombres;
    }

    public int getDifunto_edad() {
        return difunto_edad;
    }

    public void setDifunto_edad(int difunto_edad) {
        this.difunto_edad = difunto_edad;
    }

    public String getDifunto_sexo() {
        return difunto_sexo;
    }

    public void setDifunto_sexo(String difunto_sexo) {
        this.difunto_sexo = difunto_sexo;
    }

   


    public String getDifunto_causa() {
        return difunto_causa;
    }

    public void setDifunto_causa(String difunto_causa) {
        this.difunto_causa = difunto_causa;
    }
    
    
    
    
    
    
    
}
