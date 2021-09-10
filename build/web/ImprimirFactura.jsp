<%-- 
    Document   : ImprimirFactura
    Created on : 26/08/2021, 18:11:32
    Author     : usuario
--%>

<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
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
            <a href="PrincipalController?menu=factura&accion=imprimir" onclick="print()">imprimir</a>          
            <div class=" form-control">
                <div class="d-flex  justify-content-around text-center">
                    <div>
                        <img class="logo_jesus2">
                    </div>
                    <c:forEach var="c" items="${cabecera}">
                        <div class="letras">

                            <h4>${c.getRazon_social()}</h4>
                            <h6>${c.persona_natural}</h6>
                            <h6>${c.tipo_servicio}</h6>
                            <h6>${c.direccion}</h6>
                            <h6>${c.telefono}</h6>
                            <h6>${c.email}</h6>  
                        </div>
                        <div class="letras">
                            <h6>${c.ruc}</h6>
                            <h6>${c.autorizacion}</h6>
                            <h1>Factura: ${ns}</h1>
                        </div>
                    </c:forEach>
                </div>    
            </div>
            <!-------------------------------  -------------------------------->
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
            <form>
                        <div class="form-control w-100">
                            <table id="servicios" class="table table-sm  table-hover w-100">
                                <thead>                        
                                    <tr>
                                        <th>COD</th>                   
                                        <th>DESCRIPCION</th>
                                        <th>CANT</th>
                                        <th>PRECIO</th>
                                        
                                    </tr>
                                </thead>
                                <tbody id="">
                                    <c:forEach var="d" items="${doc}">
                                        <tr> 
                                            <td> <c:out value ="${d.id_producto}"/></td>
                                            <td><c:out value ="${d.nombre_producto}"/> </td>
                                            <td>1</td>
                                            <td><c:out value ="${d.precio}"/></td>
                                            
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
              </form>  
             <!-------------------------------  --------------------------------> 
             
             <div class="form-control w-100">
                 <div class="d-flex flex-row">
                     <div class="form-control w-100">
                           <div class="card-header bg-light">formas de pago</div>
                     </div>
                     <div class="mx-auto">
                            <div class="form-control w-100">
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
                             
                            
                 
                
                        
            
       </div>
      </body>
      <script src="js/sweetalert.min.js"></script>
     </html>
