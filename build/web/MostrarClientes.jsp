<%-- 
    Document   : MostrarClientes
    Created on : 22/07/2021, 13:35:40
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
          <!-- sweealert!-->
        <link  href="css/sweetalert.css" rel="stylesheet">
         <!-- link de bootrap para los iconos!-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- link de bootrap-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!-- link datatables-->
        <link rel="stylesheet" href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
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
       
                <form>
                    <div class="container">
                       
            <div>
                <div>
                    <table id="CLIENTE" class="table table-sm  table-hover">
                      
                        <thead>                        
                            <tr>
                                <th>ACCIONES</th>
                                <th>CODIGO</th>
                                <th>CEDULA</th>
                                <th>NOMBRE</th>
                                <th>TELEFONO</th>
                                <th>CORREO</th>
                                
                            </tr>
                        </thead>
                        <tbody id="">
                           <c:forEach var="clientes" items="${clientes}">
                                <tr> 
                                    <td><a title="SUBIR" href="PrincipalController?menu=cliente&accion=cargar&txt_codigo=<c:out value ="${clientes.cliente_id}"/>"><i class="btn btn-white bi bi-file-earmark-arrow-up-fill"></i></a>
                                        <a title="EDITAR" href="PrincipalController?menu=cliente&accion=editar&txt_codigo=<c:out value ="${clientes.cliente_id}"/>"><i class="btn btn-white bi bi-eraser-fill"></i></a>
                                        <a title="ELIMINAR" href="#" onclick="eliminar_cliente(<c:out value ="${clientes.cliente_id}"/>)"><i class="btn btn-white bi bi-person-x-fill"></i></a>                                   
                                       
                                        <a title="CARGAR" href="PrincipalController?menu=difunto&accion=listar&txt_codigo=<c:out value ="${clientes.cliente_id}"/>"><i class="btn btn-white bi bi-card-list"></i></a>
                                         <a title="ASIGNAR" href="PrincipalController?menu=difunto&accion=cargar_datos_del_cliente&txt_codigo=<c:out value ="${clientes.cliente_id}"/>"><i class="btn btn-white bi bi-person-lines-fill"></i></a>
                                    </td>
                                    <td><c:out value ="${clientes.cliente_id}"/></td>
                                    <td><c:out value ="${clientes.cliente_cedula}"/></td>
                                    <td><c:out value ="${clientes.cliente_nombres}"/></td>
                                    <td><c:out value ="${clientes.cliente_telefono}"/></td>
                                    <td><c:out value ="${clientes.cliente_correo}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

       
        </div>
                     </form>
    </body>
     <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <script src="  //cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
        <script>
                                        $(document).ready(function () {
                                            $('#CLIENTE').DataTable({
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
            function eliminar_cliente(ide1) {
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
                                window.location = "PrincipalController?menu=cliente&accion=eliminar_cliente&codigo_cliente=" + ide1;
                            } else {
                                swal("Cancelado", "tu archivo esta seguro :)", "error");
                            }
                        });

            }
        </script>
</html>
