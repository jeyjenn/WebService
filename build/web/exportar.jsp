<%@page import="java.io.StringReader"%>
<%@page import="com.lowagie.text.html.simpleparser.HTMLWorker"%>
<%@page import="com.lowagie.text.pdf.PdfWriter"%>
<%@page import="com.lowagie.text.*"%>
<%@page import="com.lowagie.text.pdf.PdfTable"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    response.setContentType("application/pdf");
    response.setHeader("Content-Disposition", "attachment: filename=\"reporte.pdf\"");
    
    try {
            Document documento = new Document();
            
            PdfWriter.getInstance(documento, response.getOutputStream());
            documento.open();
            
            HTMLWorker htmlworker = new HTMLWorker(documento);
            String str = "   <c:forEach var=c items=${cabecera}>"+""
                    +"<h4>${c.getRazon_social()}</h4>"
                    +"<h6>${c.persona_natural}</h6>"
                    +"<h6>${c.tipo_servicio}</h6>";
                
            htmlworker.parse(new StringReader(str));
            documento.close();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }

%>

