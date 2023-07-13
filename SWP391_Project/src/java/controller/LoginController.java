/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author admin
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    
    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDBContext userDBContext = new UserDBContext();
            User user = userDBContext.LoginUser(username, password);
            if (user == null) {
                request.setAttribute("message", "Login failed");
                request.getRequestDispatcher("header.jsp").forward(request, response);
            } else if (password.length() < 6 && password.length() > 32 ){
            request.setAttribute("message", "Please enter password from 6 to 32 character");
            request.getRequestDispatcher("header.jsp").forward(request, response); 
            } else if (!username.matches(EMAIL_REGEX)) {
                request.setAttribute("message", "Please enter email correct with format");
                request.getRequestDispatcher("header.jsp").forward(request, response);
            }
            else {
                request.getSession().setAttribute("user", user);
                request.setAttribute("message", "Login successfully");
                request.getRequestDispatcher("home").forward(request, response);
//                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
//            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
