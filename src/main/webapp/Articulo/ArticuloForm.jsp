<%-- 
    Document   : categoriaForm
    Created on : 7 abr. 2022, 08:18:51
    Author     : darkdestiny
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Articulo Form</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
    </head>
    <body>
        <%
            String accion  = request.getParameter("accion");
        %>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="CategoriaServlet?accion=listaDeCategorias">Listado de Categorías</a>
                            </li>

                        </ul>
                    </div>
                </div>
            </nav>
            <div class="mb-3"></div>
            <div class="card text-primary">
                <div class="card-header">
                    <h1 class="card-title  text-center">
                        Formulario para Datos del Articulo
                    </h1>
                </div>
                <div class="card-body">
                    <form method="post" action="ArticuloServlet?accion=guardar">
                        <%
                            if(accion.equals("nuevo")){
                        %>
                            <div class="mb-3" hidden="true">
                                <label for="idArticulo" class="form-label">Clave Articulo</label>
                                <input type="text" class="form-control" id="idArticulo" name="idArticulo" 
                                       value="${dto.entidad.idCategoria}"/>
                            </div>
                        <%}else{%>
                        <div class="mb-3" >
                            <label for="idArticulo" class="form-label">Clave Articulo</label>
                            <input type="text" class="form-control" id="idArticulo" name="idArticulo" 
                                   value="${dto.entidad.idCategoria}"
                                   readonly
                                   />
                        </div>
                        <%}%>
                        
                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre Articulo</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" 
                                   value="${dto.entidad.nombreCategoria}"
                                   placeholder="Nombre del Articulo"
                                   required
                                   />
                        </div>
                        
                        <div class="mb-3">
                            <label for="cantidad" class="form-label"> Cantidad</label>
                            <input type="number" name="cantidad" id="cantidad" 
                                   class="form-control"
                                   value="${dto.entidad.descripcionCategoria}"
                                   placeholder="Cantidad del articulo"
                                   required/>
                        </div>
                                   
                                    
                        <div class="mb-3">
                            <label for="precio" class="form-label">Precio del articulo</label>
                            <input type="number" name="precio" id="precio" 
                                   class="form-control"
                                   value="${dto.entidad.descripcionCategoria}"
                                   placeholder="Precio del articulo"
                                   required/>
                        </div>
                                   
                        <div class="mb-3">
                            <label for="precio" class="form-label">Precio del articulo</label>
                            <input type="number" name="precio" id="precio" 
                                   class="form-control"
                                   value="${dto.entidad.descripcionCategoria}"
                                   placeholder="Precio del articulo"
                                   required/>
                        </div>
                                  
                        <div class="mb-3">
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Seleccione la Categoria</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                               
                                   
                        <div class="mb-3">
                            <input type="submit" name="btnEnviar" id="btnEnviar" 
                                   class="btn-outline-primary"
                                   value="Registrar"
                                   />
                        </div>

                    </form>
                </div>
            </div>

        </div>
    </body>
</html>
