<%-- 
    Document   : Login
    Created on : 21/07/2021, 15:43:44
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- link de bootrap para los iconos!-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <!--estilos css-->
        <link rel="stylesheet" href="css/estilos.css">
        <!--bootrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
         <!--sweetalert-->
        <link href="css/sweetalert.css" rel="stylesheet">
         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="LoginController" method="post">

            <div class="cuadrado">    
                <div class="mitad1">
                    <div class="mitad2">
                        <div class="dentro mb-3">
                            
                              <label class="form-label ">Usuario</label>
                                  <div class="user">
                                      <i class="bi bi-person "></i>
                                      <input name="txt_nombre" type="text"class="form-control"  placeholder="Ingrese su usuario" >
                                   </div>
                              
                              <label  class="form-label">Password</label>
                                   <div class="contraseña ">
                                   <i class="bi bi-file-lock"></i>
                                   <input name="txt_pass" type="password" class="form-control" placeholder="Ingrese su contraseña">
                                  </div>
                             <button type="submit" class="btn btn-secondary mt-4 w-100">Ingresar</button>
                         </div>
                    </div>
                    <div class="circulo">      
                    </div>
                </div>
            </div>
        </form>
    </body>
    
     <%
            if (request.getAttribute("mensaje") != null) {
        %>
        <input type="text" hidden="" id="txtmensaje" value="<%=request.getAttribute("mensaje").toString()%>"/>
        <script>
            window.onload = function () {
                 swal("", document.getElementById("txtmensaje").value, "info");
             };
        </script>   
        <%
            }
        %>
        <script src="js/sweetalert.min.js"></script>
</html>
