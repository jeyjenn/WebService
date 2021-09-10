<%-- 
    Document   : Ver_Documentos
    Created on : 09/08/2021, 22:07:42
    Author     : usuario
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="metodos.metodos_clientes"%>
<%@page import="modelo.Cliente_Documento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <!-- link datatables-->
        <link rel="stylesheet" href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
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
            <div class="card-header bg-light text-center">Documentos de la funeraria</div>
            <table id="DOCUMENTOS" class="table table-sm  table-hover">
                <thead>                        
                    <tr>
                        <th>ACCIONES</th>
                        <th>NOMBRES DEL DOCUMENTO</th>
                        <th>ARCHIVO</th>

                    </tr>
                </thead>
                <tbody id="employed_data">
                    <c:forEach var="documentos" items="${documentos}">
                        <tr>
                            <td>
                                
                                <a href="#" onclick="eliminar_doc(<c:out value ="${documentos.getCliente_docu_id()}"/>)"><i class="btn btn-white bi bi-person-x-fill"></i></a>
                                <a href="#" ><i class="bi bi-cloud-download-fill"></i></a>

                            </td>
                            <td><c:out value ="${documentos.nombre_docu}"/></td>
                            <td>                          
                                <a href="pdf?id=${documentos.getCliente_docu_id()}" target="_blank"><i class="bi bi-file-earmark-pdf"></i></a> 
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <script src="  //cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
    <script>
                                    $(document).ready(function () {
                                        $('#DOCUMENTOS').DataTable({
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
    <script>
                                    function eliminar_doc(ide1) {
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
                                                        window.location = "PrincipalController?menu=cliente&accion=eliminar_documento&codigo_d=" + ide1;
                                                    } else {
                                                        swal("Cancelado", "tu archivo esta seguro :)", "error");
                                                    }
                                                });

                                    }
    </script>
</html>
