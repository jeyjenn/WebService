<%-- 
    Document   : CargarDocu_difunto
    Created on : 16/08/2021, 21:25:27
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
        <!--bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">  
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
        
                <div class="card-body ">
                    <div class="form-group ">
                        <div class="card-header text-center bg-success">listado por cliente</div>
                        <table class="table table-sm table-hover ">
                            <thead>
                                <tr>
                                    <th>ACCIONES</th>
                                    <td>Id_difutno</td>
                                    <td>Id_cliente</td>
                                    <td>Nombres</td>
                                    <td></td>
                                </tr>
                            </thead>  
                            <tbody id="">
                                <c:forEach var="d" items="${documentos}">
                                    <tr>
                                        <td>

                                            <a title="cargar archivos" href="PrincipalController?menu=difunto&accion=cargar&txt_codigo_difunto=<c:out value ="${d.getDifunto_id()}"/>"><i class="bi bi-folder-plus"></i></a>
                                            <a title="ver archivos subidos" href="PrincipalController?menu=difunto&accion=listar_pdf&txt_codigo_difunto=<c:out value ="${d.getDifunto_id()}"/>"><i class="bi bi-card-checklist"></i></a>
                                        </td>
                                         <td><c:out value ="${d.getDifunto_id()}"/></td>
                                        <td><c:out value ="${d.getCliente().getCliente_id()}"/></td>
                                        <td><c:out value ="${d.getDifunto_nombres()}"/></td>
                                        <td> </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
    </body>
      <script src="js/sweetalert.min.js"></script>
       <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>
