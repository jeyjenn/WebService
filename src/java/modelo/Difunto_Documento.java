
package modelo;

import java.io.InputStream;


public class Difunto_Documento {
    private int difunto_docu_id;
    private Difunto difunto;
    private String difunto_nombre_archivo;
    InputStream difunto_pdf;
    
    private byte [] difunto_pdf2;

    public int getDifunto_docu_id() {
        return difunto_docu_id;
    }

    public void setDifunto_docu_id(int difunto_docu_id) {
        this.difunto_docu_id = difunto_docu_id;
    }

    public Difunto getDifunto() {
        return difunto;
    }

    public void setDifunto(Difunto difunto) {
        this.difunto = difunto;
    }

    public String getDifunto_nombre_archivo() {
        return difunto_nombre_archivo;
    }

    public void setDifunto_nombre_archivo(String difunto_nombre_archivo) {
        this.difunto_nombre_archivo = difunto_nombre_archivo;
    }

    public InputStream getDifunto_pdf() {
        return difunto_pdf;
    }

    public void setDifunto_pdf(InputStream difunto_pdf) {
        this.difunto_pdf = difunto_pdf;
    }

    public byte[] getDifunto_pdf2() {
        return difunto_pdf2;
    }

    public void setDifunto_pdf2(byte[] difunto_pdf2) {
        this.difunto_pdf2 = difunto_pdf2;
    }
    
    
    
    
}
