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

/**
 *
 * @author andre
 */
public class Controlador_Usuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String txtRUT = request.getParameter("txtRUT");
        String txtName = request.getParameter("txtName");
        String txtFSurname = request.getParameter("txtFSurname");
        String txtLSurname = request.getParameter("txtLSurname");
        int selGen = Integer.parseInt(request.getParameter("selGen"));
        String txtBirthDate = request.getParameter("txtBirthDate");
        String txtEmail = request.getParameter("txtEmail");
        String selCom = request.getParameter("selCom");
        String selCiu = request.getParameter("selCiu");
        String selPais = request.getParameter("selPais");
        String txtConfPass = request.getParameter("txtConfPass");
        
        Usuario USER = new Usuario(txtRUT, txtName, txtFSurname, txtLSurname, selGen, txtBirthDate, txtEmail, selCom, selCiu, selPais, txtConfPass);
        Usuarios_DAO U1 = new Usuarios_DAO();
        
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<script type='text/javascript'>");
            
            boolean USUARIOYAREGISTRADO = U1.Validar_Usuario_Existente(USER);
            if(USUARIOYAREGISTRADO == true)
            {
                out.println("alert('¡ATENCION! EL RUT QUE INTENTAS INGRESAR :"+txtRUT+" YA EXISTE EN EL SISTEMA')");
                out.println("location='index.html'");
            }
            else
            {
                boolean REGISTRO = U1.Registrar_Nuevo_Usuario(USER);
                if(REGISTRO == true)
                {
                    out.println("alert('¡Usuario Registrado exitosamente!')");
                    out.println("location='index.html'");
                }
                else
                {
                    out.println("alert('¡ERROR, NO SE PUDO REGISTRAR EL USUARIO!')");
                    out.println("location='index.html'");
                }
            }
            
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        
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
