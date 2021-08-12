/*
 * Copyright(C) 2021,  FPT University
 * J3.L.P0010
 * FPT Education System
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-07-22    1.0              LongPHHE141469       First Implement
 */
package controller;

import dao.IAccountDAO;
import dao.impl.AccountDAOImpl;
import date.DateFormat;
import entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class uses function in <code>AccountDAO</code> class to get userName,
 * password Account object in the <code>GET</code> method then forward to the
 * <code>Login.jsp</code><br>
 * - User function in <code>AccountDAO</code> class to get and check exist of
 * userName, password of Account object and set attribute of session for request
 * in the <code>POST</code> method then forward to <code>home</code>
 *
 * @author LongPHHE141469
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request the <code>javax.servlet.http.HttpServletRequest</code>
     * object
     * @param response the <code>javax.servlet.http.HttpServletResponse</code>
     * object
     * @throws ServletException if a servlet-specific error occurs, it is the
     * <code> javax.servlet.ServletException</code> object
     * @throws IOException if an I/O error occurs, it is the
     * <code>java.io.IOException</code> object
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>GET</code> method.<br>
     * This method get date and time of today then forward all attribute of
     * request to <code>login.jsp</code>
     *
     * @param request stores attribute dateTime to send to
     * <code>login.jsp</code>. It is a
     * <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response sending a response to client's web browser It is a
     * <code>javax.servlet.http.HttpServletResponse</code>object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DateFormat dateNow = new DateFormat();
        String dateTime = dateNow.getDate();
        request.setAttribute("dateTime", dateTime);
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.<br>
     * This method uses function in <code>AccountDAO</code> class to get and
     * check userName and password and set attribute of session for request.<br>
     * Then forward to <code>home</code>
     *
     * @param request stores attributes:message, dateTime, username to
     * sendRedirect to HomeController. <br>
     * It is a <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response sending a response to client's web browser<br>
     * It is a <code>javax.servlet.http.HttpServletResponse</code>object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DateFormat dateNow = new DateFormat();
            String dateTime = dateNow.getDate();
            request.setAttribute("dateTime", dateTime);
            String userName = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            IAccountDAO accountDAO = new AccountDAOImpl();
            Account account = accountDAO.getAccount(userName, password);
            //check account 
            if (account.getUserName() == null) {
                request.setAttribute("dateTime", dateTime);
                request.setAttribute("userName", userName);
                request.setAttribute("message", "Invalid username or password");
                request.getRequestDispatcher("Login.jsp").forward(request, response);

            } else {
                request.getSession().setAttribute("account", account);
                request.setAttribute("username", account.getUserName());
                response.sendRedirect("home");
            }

        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
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
