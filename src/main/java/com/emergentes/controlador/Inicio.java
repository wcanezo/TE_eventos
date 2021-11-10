package com.emergentes.controlador;

import com.emergentes.dao.EventoDAO;
import com.emergentes.dao.EventoDAOimpl;
import com.emergentes.modelo.Evento;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EventoDAO dao = new EventoDAOimpl();
            int id;
            Evento eve=new Evento();
            
            String action = (request.getParameter("action") != null )? request.getParameter("action") : "view";
            switch(action){
                case "add": 
                    request.setAttribute("evento",eve);
                    request.getRequestDispatcher("frmevento.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    eve = dao.getById(id);
                    request.setAttribute("evento", eve);
                    request.getRequestDispatcher("frmevento.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    request.getRequestDispatcher("Inicio").forward(request, response);
                    break;
                default:
                    List<Evento> lista = dao.getAll();
                    request.setAttribute("eventos",lista);
                    request.getRequestDispatcher("listado.jsp").forward(request, response);
                    break;
            }
            
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EventoDAO dao = new EventoDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String expositor = request.getParameter("expositor");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String cupo = request.getParameter("cupo");
        
        eve.setId(id);
        eve.setTitulo(titulo);
        eve.setExpositor(expositor);
        eve.setFecha(fecha);
        eve.setHora(hora);
        eve.setCupo(cupo);
        
        if(id == 0){
            try {
                dao.insert(eve);
                response.sendRedirect("Inicio");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }
        else{
            try {
                dao.update(eve);
                response.sendRedirect("Inicio");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }
    }
    
    

}
