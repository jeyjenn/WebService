<%-- 
    Document   : NuevoCliente
    Created on : 22/07/2021, 13:35:26
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--bootrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <!--sweetalert-->
         <link href="css/sweetalert.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
            <%
        if(request.getAttribute("mensaje")!= null && request.getAttribute("tipo")!=null) {
    %>
    <input type="text" hidden=""  id="txt_mensaje" value="<%=request.getAttribute("mensaje")%>"/>
    <input type="text" hidden=""   id="txt_tipo" value="<%=request.getAttribute("tipo")%>" />
    <script>
            var mensaje = document.getElementById("txt_mensaje").value;
            var tipo = document.getElementById("txt_tipo").value;
             window.onload = function () {
                       swal("mensaje",mensaje,tipo);
                      };
    </script>   
    <%
        }
    %>
        <div class="container">
            <div class="card card-register mx-auto mt-1 col-md-6">
                <div class="card-header bg-light">Registrar nuevo cliente</div>
                <div class="card-body">
                    <form action="PrincipalController?menu=cliente&accion=guardar" method="post">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12 mb-2">
                                    <label>CEDULA</label>
                                    <input class="form-control" name="txt_cedula" type="number"  placeholder="Ingrese su Cedula de identidad" required="">
                                </div>
                                <div class="col-md-12 mb-2">
                                    <label>NOMBRES COMPLETOS</label>
                                    <input class="form-control" name="txt_nombre" type="text"  placeholder="Ingrese sus nombres Completos" required="">
                                </div>

                                <div class="col-md-12 mb-2">
                                    <label>TELEFONO</label>
                                    <input class="form-control" name="txt_telefono" type="number"  placeholder="Ingrese numero telefonico" required="">
                                </div>
                                <div class="col-md-12 mb-2">
                                    <label>CORREO</label>
                                    <input class="form-control" name="txt_correo" type="email" placeholder="Ingrese su correo electronico" required="">
                                </div>

                            </div>
                        </div>
                        <button type="submit" name="guardar" class="btn btn-secondary mt-4 w-100">guardar</button>
                    </form>

                </div>
            </div>
        </div>
    </body>
     <script src="js/sweetalert.min.js"></script>
</html>
