<%-- 
    Document   : modal
    Created on : 13/09/2021, 18:14:26
    Author     : usuario
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <!--bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">  
         <link href="css/sweetalert.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <body>
            <div class="container">
                 <div class="card-header text-center bg-light">items por servicio</div>
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
                                    <td>1</td>
                                    <td><c:out value ="${d.precio}"/></td>
                                    <td><c:out value ="${d.getPrecio()}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
    </body>
</html>