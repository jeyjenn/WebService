
package modelo;

import java.sql.Date;


public class Ventas {
    private int id_ventas;
    private Cliente cliente;
    private Date fecha_emision;
    private double valor_servicio;
    private String numeroSerie ;

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    
    
    

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    

    public double getValor_servicio() {
        return valor_servicio;
    }

    public void setValor_servicio(double valor_servicio) {
        this.valor_servicio = valor_servicio;
    }
    
    

    public int getId_ventas() {
        return id_ventas;
    }

    public void setId_ventas(int id_ventas) {
        this.id_ventas = id_ventas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   

    
    
    
    
}
