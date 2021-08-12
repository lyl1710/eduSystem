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

import dao.IDepartmentDAO;
import dao.impl.DepartmentDAOImpl;
import date.DateFormat;
import entity.Account;
import entity.Department;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class uses function in <code>DepartmentDAO</code> class to get data of
 * the list of Department object then forward to the <code>Home.jsp</code>
 *
 * @author LongPHHE141469
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {


    /**
     * Handles the HTTP <code>GET</code> method.<br>
     * This method uses function in <code>DepartmentDAO</code> class to get data
     * of the department list.<br>
     * Then forward all attribute of request to <code>Home.jsp</code>
     *
     * @param request stores attributes: departments, date, totalPage,
     * pageIndex, message to send to JSP. It is a
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
        //get userName
        Account account = (Account) request.getSession().getAttribute("account");
        request.setAttribute("username", account.getUserName());
        try {
            IDepartmentDAO departmentDAO = new DepartmentDAOImpl();
            String page = request.getParameter("page");
            if (page == null) {
                page = "1";
            }
            //check NumberFormatException of pageIndex 
            try {
                int pageIndex = Integer.parseInt(page);
                String today = java.time.LocalDate.now().toString();
                ArrayList<Department> departments = departmentDAO.getDepartmentToday(today, pageIndex, 3, false);
                ArrayList<Department> departmentsLast2days = departmentDAO.getDepartmentLast2days(pageIndex, 3, false);
                int numRecords = departmentDAO.count();
                int totalPage = (numRecords / 3) + (numRecords % 3 > 0 ? 1 : 0);
                if (pageIndex <= totalPage && pageIndex > 0) {
                    request.setAttribute("pageIndex", pageIndex);
                    request.setAttribute("date", today);
                    request.setAttribute("totalPage", totalPage);
                    request.setAttribute("departments", departments);
                    request.setAttribute("departmentsLast2days", departmentsLast2days);
                    request.getRequestDispatcher("Home.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "page out of range");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                }

            } catch (NumberFormatException e) {
                request.setAttribute("message", e.getMessage());
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
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
