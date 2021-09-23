<%-- 
    Document   : Facturapdf
    Created on : 17/09/2021, 16:31:54
    Author     : usuario
--%>

<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>

<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@page import="javax.servlet.ServletResponse"%>
<%@page import="conexion.Conexion"%>
<%@include file="ImprimirFactura.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
       Connection con;
       Conexion conn = new Conexion();
       con = conn.ConectarBD();
       
       
       File repotFile = new File (application.getRealPath("factura.jasper"));
       Map<String, Object> parameter = new HashMap<String, Object>();
       
       String valor = request.getParameter("txt_parametro");
       parameter.put("vari_facrura",new String(valor));
       byte[] bytes = JasperRunManager.runReportToPdf(repotFile.getPath(), parameter, con);
             
       response.setContentType("application/pdf");
       response.setContentLength(bytes.length);
       ServletOutputStream outputstream = response.getOutputStream();
       outputstream.write(bytes,0,bytes.length);
       outputstream.flush();
       outputstream.close();
       %>
    </body>
</html>
