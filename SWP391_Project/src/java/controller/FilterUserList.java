/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.RoleDAO;
import dao.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author 84877
 */
@WebServlet(name="FilterUserList", urlPatterns={"/filterUserList"})
public class FilterUserList extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FilterUserList</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilterUserList at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
        
        try {
            int status = Integer.parseInt(request.getParameter("status"));
            int role = Integer.parseInt(request.getParameter("role"));
            int gender = Integer.parseInt(request.getParameter("gender"));
            
            UserDBContext udbc = new UserDBContext();
            RoleDAO roleDAO = new RoleDAO();            
            List<User> listU = udbc.filterUserBy(gender, role, status);
            request.setAttribute("listR", roleDAO.getListRoleWithoutAdmin());
            request.setAttribute("listC", listU);
            if(listU.size() <= 0){
                String message = "No result found with ";
                message += status == -1 ? "" : "status: " + (status == 1 ? "Active" : "InActive");
                message += role == -1 ?  "" : " role: " + roleDAO.getRoleById(role).getRole_name();
                message += gender == -1 ? "" : " gender: " + (gender == 1 ? "Male" : "Female");
                request.setAttribute("message", message);
            }
            request.getRequestDispatcher("userList.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FilterUserList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
