<%-- 
    Document   : ModificarClientes
    Created on : 22/07/2021, 13:35:52
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <link rel="icon" type="image/jpg" href="images/logo.jpg">
        <!--sweetalert-->
        <link href="css/sweetalert.css" rel="stylesheet">
        <!--bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (request.getAttribute("mensaje") != null && request.getAttribute("tipo") != null) {
        %>
        <input type="text" hidden=""  id="txt_mensaje" value="<%=request.getAttribute("mensaje")%>"/>
        <input type="text" hidden=""   id="txt_tipo" value="<%=request.getAttribute("tipo")%>" />
        <script>
            var mensaje = document.getElementById("txt_mensaje").value;
            var tipo = document.getElementById("txt_tipo").value;
            window.onload = function () {
                swal("mensaje", mensaje, tipo);
            };
        </script>   
        <%
            }
        %>
        <div class="container">
            <div class="card card-register mx-auto mt-1 col-md-6">
                <div class="card-header bg-light">editar cliente</div>
                <div class="card-body">
                    <form action="PrincipalController?menu=cliente&accion=actualizar_cliente" method="post">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12 mb-2">
                                    <label>Codigo</label>
                                    <input class="form-control" readonly="" name="txt_codigo" type="number" value ="<c:out value="${clientes.cliente_id}"/>" >
                                    
                                    <label>CEDULA</label>
                                    <input class="form-control" name="txt_cedula" required="" type="number" value ="<c:out value="${clientes.cliente_cedula}"/>" >
                                </div>
                                <div class="col-md-12 mb-2">
                                    <label>NOMBRES COMPLETOS</label>
                                    <input class="form-control" name="txt_nombre"  required=" "type="text"  value ="<c:out value="${clientes.cliente_nombres}"/>"  >
                                </div>

                                <div class="col-md-12 mb-2">
                                    <label>TELEFONO</label>
                                    <input class="form-control" name="txt_telefono" required="" type="number"  value ="<c:out value="${clientes.cliente_telefono}"/>"  >
                                </div>
                                <div class="col-md-12 mb-2">
                                    <label>CORREO</label>
                                    <input class="form-control" name="txt_correo" required="" type="email" value ="<c:out value="${clientes.cliente_correo}"/>" >
                                </div>

                            </div>
                        </div>
                        <button type="submit" name="guardar" class="btn btn-secondary mt-4 w-100">Actualizar</button>
                    </form>

                </div>
            </div>
        </div>

    </body>
    <script src="js/sweetalert.min.js"></script>
</html>
