<%-- 
    Document   : NuevoEmpleado
    Created on : 22/07/2021, 14:12:06
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <link rel="icon" type="image/jpg" href="images/logo.jpg">
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
                <div class="card-header bg-light">Registrar nuevo empleado</div>
                <div class="card-body">
                    <form action="PrincipalController?menu=empleado&accion=guardar" method="post">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12 mb-2">
                                    <label>Codigo</label>
                                    <c:forEach var="empleado" items="${lista}">
                                        <input class="form-control" name="txt_codigo" readonly="" type="text" value ="<c:out value="${empleado.rol_id}"/>">
                                    </c:forEach>
                                    
                                </div>
                                <div class="col-md-12 mb-2">
                                    <label>NOMBRES</label>
                                    <input class="form-control" name="txt_nombre" type="text"  placeholder="Ingrese sus nombres Completos">
                                </div>
                                <div class="col-md-12 mb-2">
                                    <label>USUARIO</label>
                                    <input class="form-control" name="txt_usuario" type="text"  placeholder="Ingrese su nombre de usuario">
                                </div>
                                <div class="col-md-12 mb-2">
                                    <label>Contraseña</label>
                                    <input class="form-control" name="txt_pass" type="password" placeholder="Ingrese su contraseña">
                                </div>

                                <div class="col-md-12 mb-2">
                                        <label>ESTADO</label>
                                        <select name="seleccion_estado" class="col-md-12">
                                            <option value=""> ---seleccionar-- </option>
                                            <option value="Activo">Activo</option>                        
                                            <option value="Inactivo">Inactivo</option>  
                                        </select>
                                </div>
                                 <div class="col-md-12 mb-2">
                                        <label>ROL</label>
                                        <select name="seleccion_rol" class="col-md-12">
                                            <option value=""> ---seleccionar-- </option>
                                            <option value="Administrador">Administrador</option>                        
                                            <option value="Contratista">Contratista</option>  
                                            <option value="Capturista">Capturista</option>  
                                        </select>
                                </div>
                            </div>
                        </div>
                        <button type="submit" name="guardar" class="btn btn-success mt-4 w-100">guardar</button>
                    </form>

                </div>
            </div>
        </div>
    </body>
     
    <script src="js/sweetalert.min.js"></script>
</html>
