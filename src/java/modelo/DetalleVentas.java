
package modelo;


public class DetalleVentas {
    
    private int id_detalleventas;
    private Ventas ventas;
    private Servicios servicios;
    private Materiales materiales;
    private int cant;

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    

 
    

    public int getId_detalleventas() {
        return id_detalleventas;
    }

    public void setId_detalleventas(int id_detalleventas) {
        this.id_detalleventas = id_detalleventas;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    public Materiales getMateriales() {
        return materiales;
    }

    public void setMateriales(Materiales materiales) {
        this.materiales = materiales;
    }
    
    
   
}
