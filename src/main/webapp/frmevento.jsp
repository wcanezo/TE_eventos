<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="$(evento.id==0)" scope="request">Nuevo</c:if>
            <c:if test="$(evento.id==0)" scope="request">Editar</c:if>
            registro
            
        </h1>
            <form action="Inicio" method="POST">
                <input type="hidden" name="id" value="$(evento.id)"/>
                <label>Titulo:</label>
                <input type="text" name="titulo" value="$(evento.titulo)"/>
                
                <br>
                <label>Expositor:</label>
                <textarea name="expositor" value="$(evento.expositor)"/>
                
                <br>
                <label>Fecha:</label>
                <textarea name="fecha" value="$(evento.fecha)"/>
                
                <br>
                <label>Hora</label>
                <textarea name="hora" value="$(evento.hora)"/>
                
                <br>
                <label>Cupo</label>
                <textarea name="cupo" value="$(evento.cupo)"/>
                
                <br>
                <input type="submit" value="Enviar"/>
               
            </form>
    </body>
</html>
