<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Eventos futuros</h1>
        <p><a href="Inicio?action=add">Nuevo Registro></a>></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Expositor</th>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Cupo</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="$(eventos)">
                <tr>
                    <td>$(item.id)</td>
                    <td>$(item.titulo)</td>
                    <td>$(item.expositor)</td>
                    <td>$(item.fecha)</td>
                    <td>$(item.hora)</td>
                    <td>$(item.cupo)</td>
                    <td><a href="Inicio?action=edit?id=$(item.id)">Editar</a></td>
                    <td><a href="Inicio?action=delete?id=$(item.id)">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>    
    </body>
</html>
