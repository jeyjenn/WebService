<%-- 
    Document   : MostrarEmpleados
    Created on : 22/07/2021, 14:12:29
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="metodos.metodos"%>
<!DOCTYPE html>
<html>
    <head> 
        <!-- alertyfy-->
        <link  href="css/alertify.css" rel="stylesheet">
        <!-- sweealert!-->
        <link  href="css/sweetalert.css" rel="stylesheet">
        <!-- link de bootrap para los iconos!-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <!-- link de bootrap-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!-- link datatables-->
        <link rel="stylesheet" href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <!-- este sweetalert es para mostrarse al momento de guardar-->
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


        <!-- este sweetalert es para mostrarse al momento eliminar-->
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
        <div class="container">
        <form>
            <div>
                <div>
                    <table id="hola" class="table table-sm  table-hover">
                        <thead>
                            <tr>
                                <th>CODIGO</th>
                                <th>NOMBRE</th>
                                <th>USUARIO</th>
                                <th>CONTRASEÑA</th>
                                <th>ESTADO</th>
                                <th>ROL</th>
                                <th>MODIFICAR</th>
                               
                              
                                <th>ELIMINAR SWEEALERT</th>
                                <th>ELIMINAR ALERTYFY</th>

                            </tr>
                        </thead>
                        <tbody id="employed_data">
                            <c:forEach var="usuario" items="${roles}">
                                <tr>
                                    <td><c:out value ="${usuario.rol_id}"/></td>
                                    <td><c:out value ="${usuario.rol_nombres}"/></td>
                                    <td><c:out value ="${usuario.rol_usuario}"/></td>
                                    <td><c:out value ="${usuario.rol_contraseña}"/></td>
                                    <td><c:out value ="${usuario.rol_estado}"/></td>
                                    <td><c:out value ="${usuario.rol_rol}"/></td>
                                    <td><a href="PrincipalController?menu=empleado&accion=editar&txt_codigo=<c:out value ="${usuario.rol_id}"/>"><i class="bi bi-eraser tamaño"></i></a></td>                                
                                    <td><a href="#" onclick="eliminar2(<c:out value ="${usuario.rol_id}"/>)"  <i class="btn btn-success bi bi-trash"></i></a></td>
                                    <td><a href="#" onclick="eliminar(${usuario.rol_id})"  <i class="btn btn-danger bi bi-trash"></i></a></td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </form>
            </div>

        <!-- Modal -->




        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <script src="  //cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
        <script>
                                        $(document).ready(function () {
                                            $('#hola').DataTable({
                                                "language": {
                                                    "lengthMenu": " _MENU_ vistas por pagina",
                                                    "zeroRecords": "Datos no encontrados",
                                                    "sSearch": "Buscar",
                                                    "info": "Pagina _PAGE_ de _PAGES_",
                                                    "infoEmpty": "Datos no disponibles en la tabla",
                                                    "infoFiltered": "( _MAX_ Datos en la tabla)",

                                                    "oPaginate": {
                                                        "sFirst": "Primero",
                                                        "sLast": "Último",
                                                        "sNext": "Siguiente",
                                                        "sPrevious": "Anterior"
                                                    }

                                                }
                                            });
                                        });
        </script>
        <script src="js/sweetalert.min.js"></script>
        <script src="js/EliminarEmpleado.js"></script>
        <script src="js/alertify.js"></script>
        <script>
                                        function eliminar(ide) {

                                            alertify.confirm("¿Seguro que quieres eliminar este empleado?",
                                                    function () {
                                                        window.location = "PrincipalController?menu=empleado&accion=eliminar1&codigo=" + ide;
                                                    },
                                                    function () {
                                                        alertify.error('Accion Cancelada');
                                                    });
                                        }
        </script>

        <script>
            function eliminar2(ide1) {
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
                                window.location = "PrincipalController?menu=empleado&accion=eliminar2&codigo=" + ide1;
                            } else {
                                swal("Cancelado", "tu archivo esta seguro :)", "error");
                            }
                        });

            }
        </script>
    </body>

</html>
