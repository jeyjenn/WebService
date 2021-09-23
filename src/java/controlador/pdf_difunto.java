/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */
@WebServlet(name = "pdf_difunto", urlPatterns = {"/pdf_difunto"})
public class pdf_difunto extends HttpServlet {

  
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
         Connection con;
        
        Conexion conn = new Conexion();
        con = conn.ConectarBD();
        
        PreparedStatement iniciar;
        ResultSet resultado;
        byte[] b=null;
        try {
            int doc_id = Integer.parseInt(request.getParameter("id"));
            iniciar = con.prepareStatement("select difunto_pdf from docu_difuntos  where difunto_docu_id=?");
            iniciar.setInt(1, doc_id);
            
            resultado = iniciar.executeQuery();
            while (resultado.next()) {
                b=resultado.getBytes(1);
            }
            InputStream bos= new ByteArrayInputStream(b);
            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF,0, tamanoInput);
            
            response.getOutputStream().write(datosPDF);
            bos.close();
            iniciar.close();
            resultado.close();
            
        } catch (Exception e) {
            System.out.println("error al mostrar datos");
        }
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
