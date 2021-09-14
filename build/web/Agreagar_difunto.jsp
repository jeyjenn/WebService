<%-- 
    Document   : Agreagar_difunto
    Created on : 12/08/2021, 13:03:05
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
        <!-- link de bootrap-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
                <div class="card-header bg-light">Agregar nuevo Difunto al Cliente: ${clientes.cliente_nombres}</div>
                <div class="card-body">
                    <form action="PrincipalController?menu=difunto&accion=guardar_difunto" method="post">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12 ">
                                    <label>CODIGO DEL CLIENTE</label>
                                    <input class="col-md-12 form-control"name="txt_codigo"  readonly=""  value ="<c:out value="${clientes.cliente_id}"/>"/>
                                </div>
                                <div class="col-md-12 ">
                                    <label>CEDULA DEL DIFUNTO</label>
                                    <input class="form-control" name="txt_cedula" type="number"  placeholder="Ingrese su Cedula de identidad" required="">
                                </div>
                                <div class="col-md-12 ">
                                    <label>APELLIDOS Y NOMBRES</label>
                                    <input class="form-control" name="txt_nombre" type="text"  placeholder="Ingrese sus nombres Completos" required="">
                                </div>
                                <div class="col-md-4">
                                    <label>EDAD</label>
                                    <input class="form-control" name="txt_edad" type="number"  placeholder="Ingrese la edad" required="">
                                </div>
                                <div class="col-md-8 ">
                                    <label>SEXO</label>
                                    <select name="seleccion_sexo" class="col-md-12">
                                        <option value=""> ---seleccionar-- </option>
                                        <option value="HOMBRE">HOMBRE</option>                        
                                        <option value="MUJER">MUJER</option>  
                                    </select>
                                </div>
                                <div class="col-md-6 ">
                                    <label>FECHA NACIMIENTO</label>
                                    <input class="form-control" name="txt_fecha_nacimiento" type="date"   required="">
                                </div>
                                <div class="col-md-6 ">
                                    <label>FECHA DEFUNCION</label>
                                    <input class="form-control" name="txt_fecha_defuncion" type="date"   required="">
                                </div>
                                <div class="col-md-12">
                                    <label>CAUSA DEL DECESO</label>
                                    <input class="form-control" name="txt_deceso" type="text"  placeholder="Ingrese la causa del deceso" required="">
                                </div>
                            </div>
                        </div>
                        <button type="submit" name="guardar" class="btn btn-secondary mt-1 w-100">guardar</button>
                    </form>

                </div>
            </div>
        </div>
    </body>
      <script src="js/sweetalert.min.js"></script>
</html>
