<%-- 
    Document   : Agregar_material
    Created on : 20/08/2021, 16:42:59
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!--bootrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <div class="container">
            <div class="card card-register mx-auto mt-1 col-md-6">
                <div class="card-header bg-light">Registrar nuevo material</div>
                <div class="card-body">
                    <form action="PrincipalController?menu=materiales&accion=agregar" method="post">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12 mb-2">
                                    <label>GRUPO</label>
                                    <select name="seleccion_grupo" class="col-md-12">
                                        <c:forEach var="g" items="${grupos}">
                                            <option value="${g.id_grupo}"> ${g.descripcion} </option>  
                                        </c:forEach>
                                    </select>


                                </div>
                                <div class="col-md-12 mb-2">
                                    <label>SERVICIO</label>
                                    <select name="seleccion_servicio" class="col-md-12">
                                         <c:forEach var="s" items="${servicios}">
                                            <option value="${s.id_servicio}"> ${s.nombre_servicio} </option>  
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-md-12 mb-2">
                                    <label>Codigo del producto</label>
                                    <input class="form-control" name="txt_codigo"  type="text" >
                                </div>
                                <div class="col-md-12 mb-2">
                                    <label>NOMBRES del producto</label>
                                    <input class="form-control" name="nombre_producto" type="text"  placeholder="Ingrese sus nombres Completos">
                                </div>
                                <div class="col-md-12 mb-2">
                                    <label>precio</label>
                                    <input class="form-control" name="txt_precio" type="text"  placeholder="Ingrese su nombre de usuario">
                                </div>
                                <div class="col-md-12 mb-2">
                                    <label>stock</label>
                                    <input class="form-control" name="txt_stock" type="text" placeholder="Ingrese su contraseña">
                                </div>


                            </div>
                        </div>
                        <button type="submit" name="guardar" class="btn btn-secondary mt-4 w-100">guardar</button>
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>
