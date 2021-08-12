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

import dao.IRequestDAO;
import dao.impl.RequestDAOImpl;
import date.DateFormat;
import entity.Account;
import entity.Request;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class uses function in <code>RequestDAO</code> class to get data of
 * date, get data of request by id then forward to the <code>Solve.jsp</code>
 *
 * @author LongPHHE141469
 */
@WebServlet(name = "SovleController", urlPatterns = {"/solve"})
public class SovleController extends HttpServlet {



    /**
     * This method uses <code>DateTime</code>, <code>RequestDAO</code> and
     * <code>Request</code> to get data of to day, get data of request by
     * id.<br>
     * - Then all attribute of request to <code>solve.jsp</code>
     *
     * @param request stores attributes: req, dateTime, userName,message to send
     * to <code>solve.jsp</code>.<br>
     * It is a <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response sending a response to client's web browser, it is a
     * <code>javax.servlet.http.HttpServletResponse</code>object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //get date and time
            DateFormat dateNow = new DateFormat();
            String dateTime = dateNow.getDate();
            request.setAttribute("dateTime", dateTime);
            //get account session
            Account account = (Account) request.getSession().getAttribute("account");
            request.setAttribute("username", account.getUserName());
            IRequestDAO requestDAO = new RequestDAOImpl();
            Request requests;
            String id = request.getParameter("id");
            // check id of request
            if (id == null) {
                requests = requestDAO.getLatestRequest(1);
            } else {
                int idNumber = Integer.parseInt(id);
                requests = requestDAO.getRequest(idNumber);
            }
            String today = java.time.LocalDate.now().toString();
            request.setAttribute("req", requests);
            request.setAttribute("nowDate", today);
            request.setAttribute("solve", true);
            
            request.getRequestDispatcher("Solve.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    /**
     * This method uses <code>DateFormat</code>, <code>RequestDAO</code> to get
     * data of date and update request of <code>Request</code> object<br>
     * - Then forward to <code>HomeController</code>
     *
     * @param request stores attributes: dateTime, message to send to
     * <code>Error.jsp</code>.<br>
     * It is a <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response sending a response to client's web browser It is a
     * <code>javax.servlet.http.HttpServletResponse</code>object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String status = request.getParameter("state");
            //get date and time
            DateFormat dateNow = new DateFormat();
            String dateAndTime = dateNow.getDate();
            request.setAttribute("dateTime", dateAndTime);
            int id = Integer.parseInt(request.getParameter("id"));
            IRequestDAO requestDAO = new RequestDAOImpl();
            // check status exist
            if (status == null) {
                request.setAttribute("error", "Please choose Approved or Reject this request");
                Request requests = requestDAO.getRequest(id);
                request.setAttribute("req", requests);
                Account account = (Account) request.getSession().getAttribute("account");
                request.setAttribute("username", account.getUserName());
                String solution = request.getParameter("solution");
                request.setAttribute("solution", solution.trim());
                request.setAttribute("solve", true);
                request.getRequestDispatcher("Solve.jsp").forward(request, response);
            } else {
                String nowDate = java.time.LocalDate.now().toString();
                String solution = request.getParameter("solution");
                requestDAO.updateRequest(id, status, nowDate, true, solution.trim());
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
