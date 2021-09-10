<%-- 
    Document   : Guardar_doc_difunto
    Created on : 17/08/2021, 10:33:00
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
          <!-- sweealert!-->
        <link  href="css/sweetalert.css" rel="stylesheet">
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
                        <div class="card-body"> 
                    <form action="PrincipalController?menu=difunto&accion=guardar" method="post" enctype="multipart/form-data">
                        <div class="form-group ">
                            <div class="form-row">
                                <div class="card-header text-center bg-success">CARGAR DOCUMENTOS DEL DIFUNTO:</div>
                                <label class="card-header col-md-12 bg-light"></label>        
                                <!-- columna-->
                                <div class=" form-control">
                                    <label>CODIGO DEL DIFUNTO</label>
                                    <input  name="txt_codigo"  class="form-control w-100" readonly=""  value ="<c:out value="${difunto.difunto_id}"/>" />  
                                    <label>NOMBRE DEL ARCHIVO</label>
                                    <input  class="w-100" name="txt_nombre" required=""> 
                                    <br><br>
                                    <div class="form-control w-100">
                                        <label>El archivo no debe superar los 3 mg</label>
                                       
                                        <input class="form-control w-100" type="file" name="fichero"/>
                                    </div> 
                                    <button type="submit" name="" class="btn btn-secondary mt-2 w-100">guardar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
    </body>
     <script src="js/sweetalert.min.js"></script>
       <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>
