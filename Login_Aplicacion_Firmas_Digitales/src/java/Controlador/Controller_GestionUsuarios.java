/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import Persistencia.Usuarios_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author andre
 */
public class Controller_GestionUsuarios extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Usuarios_DAO udao = new Usuarios_DAO();
        
        String Accion = request.getParameter("accion");
        switch (Accion)
        {
            case "Listar Usuarios Registrados":
                List<Usuario> LISTA = udao.TraerRegistrosUsuarios();
                request.setAttribute("lista", LISTA);
                request.getRequestDispatcher("Vista/Gestion_Usuarios.jsp").forward(request, response);
                break;
            case "Agregar Nuevo Usuario":
                //request.getRequestDispatcher("Paginas_Web_Vista/Gestion_de_Firmas.jsp").forward(request, response);
            case "Actualizar":
                request.getRequestDispatcher("Vista/Actualizar_Registro_Usuario.jsp").forward(request, response);
            default:
                request.getRequestDispatcher("ControllerDocs?accion=Listar Usuarios Registrados").forward(request, response);
                break;
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
