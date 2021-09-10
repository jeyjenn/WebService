
package metodos;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.IOException;


public class GuardarPDF {
    public static final String destino="C:\\Users\\usuario\\Downloads\\Desktop\\prueba\\mi primer.pdf";
    
    public static void main(String []args)throws IOException{
       // new GuardarPDF().crearPdf(destino);
    }
    
    public void crearPdf(String dest) throws IOException{
        PdfWriter write = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(write);
        Document documento = new Document(pdf);
        documento.add(new Paragraph("hola"));
        documento.close();
    }
    
}
