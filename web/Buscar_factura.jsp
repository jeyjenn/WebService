<%-- 
    Document   : Buscar_factura
    Created on : 23/09/2021, 9:55:24
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--bootrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            
        
            <div class="card-header bg-light">ingrese numero de factura a buscar</div>
            <br>
             <form action="ReporteFactura.jsp">
                   <input  class="col-md-4" type="text" name="txt_parametro" size="20" placeholder="Ingrese numero de factura" />
                   <button type="submit" name="guardar" class="btn btn-success mt-4 w-25">GENERAR PDF DE LA FACTURA</button>
            </form>
            </div>
    </body>
</html>
