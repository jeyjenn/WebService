<%-- 
    Document   : Factura
    Created on : 19/08/2021, 10:26:14
    Author     : usuario
--%>

<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <link rel="icon" type="image/jpg" href="images/logo.jpg">
        <!--sweetalert-->
         <link href="css/sweetalert.css" rel="stylesheet">
        <!--estilos css-->
        <link rel="stylesheet" href="css/estilos.css">
        <link rel="stylesheet" href="css/Factura.css">
        <!--bootrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
        <%
            String hoy = LocalDate.now().toString();
        %>
        <div class="container">
            <!-------------------------------  -------------------------------->
            <form action="PrincipalController?menu=factura&accion=buscar" method="post">
                <div class="card-header bg-light d-flex flex-row-reverse">Numero de Serie: ${nserie}</div>
                <div class="form-control w-100">

                    <div class=" d-flex justify-content-between">
                        <label class="ml-1 mr-1">INGRESE CEDULA</label>
                        <input class="ml-1 mr-1" name="txt_cedula" type="text"  placeholder="Ingrese cedula" required="">
                        <button type="submit" name="buscar" class="btn btn-outline-success  w-25">buscar</button>
                    </div>
                </div>
            </form>

            <div class=" form-control">
                <div class="d-flex">
                    <div class=" w-50">
                        <div class="container">
                            <div class="d-flex content-start">
                                <div class="d-flex flex-column">
                                    <div class="">Cliente:  ${clientes.cliente_nombres}</div>
                                    <div class="">R.U.C:  ${clientes.cliente_cedula}</div>
                                    <div class="">Direccion: ${clientes.cliente_correo}</div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="w-50">
                        <div class="container">
                            <div class="d-flex content-start">
                                <div class="d-flex flex-column">
                                    <div class="">Telefono: ${clientes.cliente_telefono} </div>
                                    <div>Fecha:  <%=hoy%> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <!-------------------------------  -------------------------------->
            <div class="form-control w-100">


                <div class="d-flex flex-column">
                    <div class="card-header bg-light">seleccione servicio</div>
                    <div>
                        <c:forEach var="s" items="${servicios}">
                            <a style=" border: none" class="btn btn-outline-success" title="SUBIR" href="PrincipalController?menu=factura&accion=cargar1&txt_codigo=<c:out value ="${s.id_servicio}"/>&txt_cedula=${clientes.cliente_cedula}">${s.nombre_servicio}</a>
                        </c:forEach>
                    </div>
                </div>
            </div> 


            <!-------------------------------  -------------------------------->
            <form>
                <div class="form-control w-100">
                    <div class="d-flex flex-row">
                        <div class="form-control w-100">
                            <table id="servicios" class="table table-sm  table-hover w-100">
                                <thead>                        
                                    <tr>
                                        <th>COD</th>                   
                                        <th>DESCRIPCION</th>
                                        <th>CANT</th>
                                        <th>PRECIO</th>
                                        <th>SUBTOTAL</th>
                                    </tr>
                                </thead>
                                <tbody id="">
                                    <c:forEach var="d" items="${doc}">
                                        <tr> 
                                            <td> <c:out value ="${d.id_producto}"/></td>
                                            <td><c:out value ="${d.nombre_producto}"/> </td>
                                            <td><input value="1"></td>
                                            <td><c:out value ="${d.precio}"/></td>
                                            <td><c:out value ="${d.getPrecio()}"/></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                </table>

                        </div>


                        <div class="mx-auto">
                            <div class="form-control w-100">
                                <div class="card-header bg-light">Valores</div>
                                <div class="d-flex w-100">
                                    <label class="w-50" >Subtotal</label>
                                    <input class="w-50" name="txttotal" value="${totalpagar}" type="text" > 
                                </div>
                                <div class="d-flex w-100">
                                    <label class="w-50">I.V.A 0%</label>
                                    <input class="w-50"  name="txttotal"  type="text" > 
                                </div> 
                                <div class="d-flex w-100">
                                    <label class="w-50">I.V.A 12%</label>
                                    <input class="w-50" name="txttotal"  type="text" > 
                                </div> 
                                <div class="d-flex w-100">
                                    <label class="w-50">TOTAL</label>
                                    <input class="w-50"  name="txttotal" value="S/. ${totalpagar}0"  type="text" > 
                                </div> 
                            </div>
                        </div>
                    </div>    
                </div>
            </form>
            <div class="form-control w-100">
                <div class="d-flex justify-content-around">
                    <a class="btn btn-success mx-auto w-25"  href="PrincipalController?menu=factura&accion=nueva_venta&txt_codigo=<c:out value ="${clientes.cliente_id}"/>&txt_cedula=<c:out value ="${clientes.cliente_cedula}"/>&txt_nombres=<c:out value ="${clientes.cliente_nombres}"/>&txttotal=<c:out value ="${totalpagar}"/>&id_servicio=<c:out value ="${pasar}"/>&numero=<c:out value ="${nserie}"/>">generar venta</a> 
                    
                </div>
            </div>


        </div>








    </body>
     <script src="js/sweetalert.min.js"></script>
</html>
