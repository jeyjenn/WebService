<%-- 
    Document   : Cargar_Documentos
    Created on : 09/08/2021, 18:11:51
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- link de bootrap para los iconos!-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
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

        <div class="d-flex">
            
            <input hidden="" name="txt_codigo"  class="form-control w-100" readonly=""  value ="<c:out value="${clientes.cliente_id}"/>"/>  
 
            <div class="w-25">
                <div class="card-body"> 
                    <form action="PrincipalController?menu=cliente&accion=guardar_docu" method="post" enctype="multipart/form-data">
                        <div class="form-group ">
                            <div class="form-row">
                                <div class="card-header text-center bg-success">CARGAR DOCUMENTOS:</div>
                                <label class="card-header col-md-12 bg-light">Cliente: ${clientes.cliente_nombres}</label>        
                                <!-- columna-->
                                <div class=" form-control">
                                    <label>CODIGO DEL CLIENTE</label>
                                    <input  name="txt_codigo"  class="form-control w-100" readonly=""  value ="<c:out value="${clientes.cliente_id}"/>"/>  
                                    <label>NOMBRE DEL ARCHIVO</label>
                                    <input  class="w-100" name="txt_nombre" required=""> 
                                    <br><br>
                                    <div class="form-control w-100">
                                        <input class="form-control w-100" type="file" name="fichero"/>
                                    </div> 
                                    <button type="submit" name="guardar_docu" class="btn btn-secondary mt-2 w-100">guardar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="w-75">
                <div class="card-body ">
                    <div class="form-group ">
                        <div class="card-header text-center bg-success">docuementos del cliente</div>
                        <table class="table table-sm table-hover ">
                            <thead>
                                <tr>
                                    <th>ACCIONES</th>
                                    <td>cod</td>
                                    <td>nombre</td>
                                    <td>archivo</td>
                                </tr>
                            </thead>  
                            <tbody id="">
                                <c:forEach var="d" items="${documentos}">
                                    <tr>
                                        <td>

                                            <a href="#" onclick="eliminar_doc(<c:out value ="${d.getCliente_docu_id()}"/>)"><i class="btn btn-white bi bi-person-x-fill"></i></a>
                                            <a href="#" ><i class="bi bi-cloud-download-fill"></i></a>

                                        </td>
                                        <td><c:out value ="${d.getCliente_docu_id()}"/></td>
                                        <td><c:out value ="${d.getNombre_docu()}"/></td>
                                        <td> <a href="pdf?id=${d.getCliente_docu_id()}" target="_blank"><i class="bi bi-file-earmark-pdf"></i></a> </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
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
