<%-- 
    Document   : Grupos
    Created on : 19/08/2021, 17:33:29
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head><!-- sweealert!-->
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



        <form>
            <div class="container">
                <br>
                <div class="card-header bg-success text-center">Grupos clasificadores</div>
                <table id="servicios" class="table table-sm  table-hover">
                    <thead>                        
                        <tr>
                            <th>ACCIONES</th>                   
                            <th>ID</th>
                            <th>CODIGO</th>
                            <th>NOMBRES</th>
                        </tr>
                    </thead>
                    <tbody id="">
                        <c:forEach var="g" items="${grupos}">
                            <tr> 
                                <td><a title="ELIMINAR" href="#" onclick="eliminar_grupo(<c:out value ="${g.id_grupo}"/>)"><i class="btn btn-danger bi bi-person-x-fill"></i></a></td>                           
                                <td><c:out value ="${g.id_grupo}"/></td>
                                <td><c:out value ="${g.cod_grupo}"/></td>
                                <td><c:out value ="${g.descripcion}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>

    </body>
    <script src="js/sweetalert.min.js"></script>
     <script>
            function eliminar_grupo(id_grupo) {
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
                                window.location = "PrincipalController?menu=grupos&accion=eliminar_grupo&grupo_cod=" + id_grupo;

                            } else {
                                swal("Cancelado", "tu archivo esta seguro :)", "error");
                            }
                        });
            }
        </script>
</html>
