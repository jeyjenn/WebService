/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.InputStream;


public class Cliente_Documento {
    
    private int cliente_docu_id;
    private Cliente cliente;
    private String nombre_docu;
    InputStream archivopdf;
    
    private byte [] archivopdf2;

    public byte[] getArchivopdf2() {
        return archivopdf2;
    }

    public void setArchivopdf2(byte[] archivopdf2) {
        this.archivopdf2 = archivopdf2;
    }
    
    

    public String getNombre_docu() {
        return nombre_docu;
    }

    public void setNombre_docu(String nombre_docu) {
        this.nombre_docu = nombre_docu;
    }
    
    

    public int getCliente_docu_id() {
        return cliente_docu_id;
    }

    public void setCliente_docu_id(int cliente_docu_id) {
        this.cliente_docu_id = cliente_docu_id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public InputStream getArchivopdf() {
        return archivopdf;
    }

    public void setArchivopdf(InputStream archivopdf) {
        this.archivopdf = archivopdf;
    }
     
 
}
