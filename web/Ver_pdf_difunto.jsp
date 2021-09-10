<%-- 
    Document   : prueba
    Created on : 12/08/2021, 22:38:50
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <!-- link datatables-->
        <link rel="stylesheet" href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
        <!--bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">  
        <!-- link de bootrap para los iconos!-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
             <table id="documento" class="table table-sm  table-hover">
            <tr>
                <td>cod</td>
                <td>nombre</td>
                <td>archivo</td>
            </tr>
            <c:forEach var="d" items="${pdf}">
                <tr>
                    <td><c:out value ="${d.getDifunto_docu_id()}"/></td>
                    <td><c:out value ="${d.getDifunto_nombre_archivo()}"/></td>
                    <td><a href="pdf_difunto?id=${d.getDifunto_docu_id()}" target="_blank"><i class="bi bi-file-earmark-pdf"></i></a> </td>
                    
            </tr>
            </c:forEach>

        </table>
            
        </div>
       
    </body>
      <script src="  //cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
      <script>
                                        $(document).ready(function () {
                                            $('#documento').DataTable({
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
</html>
