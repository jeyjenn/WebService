<%-- 
    Document   : Inicio
    Created on : 21/07/2021, 16:05:23
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (session.getAttribute("Roles") != null) {

%>
<html>
    <head>
        <!-- sweealert!-->
        <link  href="css/sweetalert.css" rel="stylesheet">

        <!--estilos css-->
        <link rel="stylesheet" href="css/estilos.css">
        <!-- link de bootrap para los iconos!-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <!--bootrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
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

        <div> 
            <nav class="navbar navbar-expand-lg navbar-light container-fluid bg-success">

                <div class="d-flex flex-row">
                    <a  href="PrincipalController?menu=principal"><img class="logo_jesus"> </a> 
                    <h2>Funenaria "San Jose"</h2>

                </div>



            </nav>

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid ">

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">

                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item dropdown">
                                <a style=" border: none" class="btn btn-outline-success dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Empleados
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="PrincipalController?menu=empleado&accion=nuevo" target="myframe"><i class="bi bi-file-person-fill"></i>  Nuevo</a></li>
                                    <li><a class="dropdown-item" href="PrincipalController?menu=empleado&accion=listar"target="myframe"><i class="bi bi-gear"></i>  Acciones</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a style=" border: none" class=" btn btn-outline-success dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Clientes
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="PrincipalController?menu=cliente&accion=nuevo_cliente" target="myframe"><i class="bi bi-person-check"></i>  Nuevo</a></li>
                                    <li><a class="dropdown-item" href="PrincipalController?menu=cliente&accion=listar_clientes" target="myframe"><i class="bi bi-gear"></i>  Acciones</a></li>  
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a style=" border: none" class=" btn btn-outline-success dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Servicios
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="PrincipalController?menu=servicios&accion=listar_servicios" target="myframe">Servicos Exequiales</a></li>
                                   
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a style=" border: none" class=" btn btn-outline-success dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Inventario General
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="PrincipalController?menu=grupos&accion=listar_grupos" target="myframe">Grupos</a></li>
                                    <li><a class="dropdown-item" href="PrincipalController?menu=materiales&accion=pasar_datos" target="myframe">Ingresar Insumos y materiales</a></li>
                                   
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a style=" border: none" class=" btn btn-outline-success dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Factura
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="PrincipalController?menu=factura&accion=cargar_datos_funeraria" target="myframe">Nueva</a></li>
                                    
                                </ul>
                            </li>
                             <li class="nav-item dropdown">
                                <a style=" border: none" class=" btn btn-outline-success dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Reportes
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown"> 
                                    <li><a class="dropdown-item" href="GraficosController" target="myframe">Reportes de ventas</a></li>
                                     <li><a class="dropdown-item" href="exportar.jsp" target="myframe">prueba</a></li>
                                    
                                </ul>
                            </li>
                        </ul>
                        <div class="dropdown ">
                            <button style="border: none" class="btn btn-outline-success dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                Usuario: ${Roles.rol_nombres}
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">                                  
                                <li><a class="dropdown-item" href="#">Cargo: ${Roles.rol_rol}</a></li>
                                <li><a class="dropdown-item" href="Login.jsp">Salir</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </nav>
        </div>

        <div class="m-1 bg-white" style="height: 550px;">
            <iframe name="myframe" style="height: 100%; width: 100%">

            </iframe>
        </div>


    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="js/sweetalert.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</html>
<%
    } else {
        response.sendRedirect("Login.jsp");
    }
%>
