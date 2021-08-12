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
import dao.IRequestDAO;
import dao.impl.DepartmentDAOImpl;
import dao.impl.RequestDAOImpl;
import date.DateFormat;
import entity.Account;
import entity.Department;
import entity.Request;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class uses <code>DepartmentDAO</code> and <code>RequestDAO</code> to get
 * date of today, get all data of Department object, get all data of Request
 * object then forward to the <code>View.jsp</code>
 *
 * @author LongPHHE141469
 */
@WebServlet(name = "ViewController", urlPatterns = {"/view"})
public class ViewController extends HttpServlet {

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
    }

    /**
     * Handles the HTTP <code>GET</code> method.<br>
     * This method uses <code>DepartmentDAO</code>, <code>DateFormat</code> and
     * <code>RequestDAO</code> to get date of today, get all data of Department
     * object, get all data of Request object.<br>
     * Then forward all attribute of request to <code>View.jsp</code>
     *
     * @param request stores attributes: departments, requests, title,
     * departmentId, totalPage, pageIndex, message to send to JSP. It is a
     * <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response sending a response to client's web browser It is a
     * <code>javax.servlet.http.HttpServletResponse</code>object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get date and time
        DateFormat dateNow = new DateFormat();
        String dateTime = dateNow.getDate();
        request.setAttribute("dateTime", dateTime);
        //get userName
        Account account = (Account) request.getSession().getAttribute("account");
        request.setAttribute("username", account.getUserName());

        try {
            IDepartmentDAO departmentDAO = new DepartmentDAOImpl();
            IRequestDAO requestDAO = new RequestDAOImpl();
            ArrayList<Department> departments = departmentDAO.getAllDepartment();

            String pDepartmentId = request.getParameter("departmentId");
            String title = request.getParameter("title");
            if (pDepartmentId == null) {
                pDepartmentId = "0";
            }
            if (title == null) {
                title = "";
            }
            String page = request.getParameter("page");
            if (page == null) {
                page = "1";
            }
            try {
                int pageIndex = Integer.parseInt(page);
                int departmentId = Integer.parseInt(pDepartmentId);
                int numRecords = requestDAO.count(title.trim(), departmentId);
                int totalPage = (numRecords / 4) + (numRecords % 4 > 0 ? 1 : 0);
                ArrayList<Request> requests = requestDAO.getRequests(title.trim(), departmentId, pageIndex, 4);
                if (pageIndex <= totalPage && pageIndex > 0) {
                    request.setAttribute("departments", departments);
                    request.setAttribute("totalPage", totalPage);
                    request.setAttribute("pageIndex", pageIndex);
                    request.setAttribute("departmentId", departmentId);
                    request.setAttribute("requests", requests);
                    request.setAttribute("title", title.trim());
                    request.getRequestDispatcher("View.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "Page out of range");
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
