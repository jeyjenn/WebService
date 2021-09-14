<%-- 
    Document   : Servicios
    Created on : 19/08/2021, 15:57:05
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <link rel="icon" type="image/jpg" href="images/logo.jpg">
        <!-- sweealert!-->
        <link  href="css/sweetalert.css" rel="stylesheet">
        <!-- link de bootrap para los iconos!-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <!-- link de bootrap-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (request.getAttribute("alerta") != null && request.getAttribute("tipo2") != null) {
        %>
        <input type="text" hidden=""  id="txt_mensaje1" value="<%=request.getAttribute("alerta")%>"/>
        <input type="text" hidden=""   id="txt_tipo1" value="<%=request.getAttribute("tipo2")%>" />
        <script>
            var mensaje2 = document.getElementById("txt_mensaje1").value;
            var tipo2 = document.getElementById("txt_tipo1").value;

            window.onload = function () {
                swal("mensaje", mensaje2, tipo2);
            };
        </script>   
        <%
            }
        %>
        <br>

        <div class="container">
            <div class="d-flex  flex-row-reverse">
                <a style=" border: none" class="btn  bg-success" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Nuevo
                </a>
            </div>
        </div>   
        
            <div class="container">
                <br>
                <div class="card-header bg-success text-center">listado de servicios Exequiales</div>
                <table id="servicios" class="table table-sm  table-hover">
                    <thead>                        
                        <tr>
                            <th>ACCIONES</th>                   
                            <th>CODIGO SEL SERVICIO</th>
                            <th>NOMBRE DEL SERVICIO</th>
                            <th>VALOR DEL SERVICIO</th>
                        </tr>
                    </thead>
                    <tbody id="">
                        <c:forEach var="s" items="${servicios}">
                            <tr> 
                                <td><a title="ELIMINAR" href="#" onclick="eliminar_servicio(<c:out value ="${s.id_servicio}"/>)"><i class="btn btn-danger bi bi-person-x-fill"></i></a> 
                                    <a title="pasar" href="PrincipalController?menu=servicios&accion=pasar&id_servicio=<c:out value ="${s.id_servicio}"/>"><i class="btn btn-warning">ver items</i></a>
                                </td>
                                <td><c:out value ="${s.cod_servicio}"/></td>
                                <td><c:out value ="${s.nombre_servicio}"/></td>                            
                                <td><c:out value ="${s.valor_servicio}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
       

    </body>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="js/sweetalert.min.js"></script>
    <script>
                                    function eliminar_servicio(id_ser) {
                                        swal({
                                            title: "¿Seguro que quieres eliminar este empleado?",
                                            text: "El dato se eliminara permanentemente",
                                            type: "warning",
                                            showCancelButton: true,
                                            confirmButtonClass: "btn-danger",
                                            confirmButtonText: "SI",
                                            cancelButtonText: "No",
                                            closeOnConfirm: false,
                                            closeOnCancel: false
                                        },
                                                function (isConfirm) {
                                                    if (isConfirm) {
                                                        window.location = "PrincipalController?menu=servicios&accion=eliminar_servicio&ser_cod=" + id_ser;

                                                    } else {
                                                        swal("Cancelado", "tu archivo esta seguro :)", "error");
                                                    }
                                                });
                                    }
    </script>



</html>
