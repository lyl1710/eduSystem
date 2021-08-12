/*
 * Copyright(C) 2021,  FPT University
 * J3.L.P0010
 * FPT Education System
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-07-22    1.0              LongPHHE141469       First Implement
 */
package filter;

import entity.Account;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Represent check accession of user, cannot access another function when user
 * is not login in the program
 *
 * @author LongPHHE141469
 */
@WebFilter(filterName = "LoginAccessFilter", urlPatterns = {"/*"})
public class LoginAccessFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    /**
     * Filter without constructor
     */
    public LoginAccessFilter() {
    }

    /**
     * this method do Before Processing
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
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AccesstionFilter:DoBeforeProcessing");
        }

    }

    /**
     * this method do After Processing
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
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AccesstionFilter:DoAfterProcessing");
        }

    }

    /**
     * Do not allow user access to other function, it will return user to the
     * login page
     *
     * @param request the <code>javax.servlet.http.HttpServletRequest</code>
     * object
     * @param response the <code>javax.servlet.http.HttpServletResponse</code>
     * object
     * @param chain the <code>FilterChain</code> object
     * @throws ServletException if a servlet-specific error occurs, it is the
     * <code> javax.servlet.ServletException</code> object
     * @throws IOException if an I/O error occurs, it is the
     * <code>java.io.IOException</code> object
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("AccesstionFilter:doFilter()");
        }

        doBeforeProcessing(request, response);
        HttpServletRequest requests = (HttpServletRequest) request;
        HttpServletResponse respone = (HttpServletResponse) response;
        Account account = (Account) requests.getSession().getAttribute("account");
        String path = requests.getServletPath();
        if (account == null && path.equals("/home")) {
            request.getRequestDispatcher("login").forward(request, response);
        }

        if (account == null && path.equals("/view")) {
            request.getRequestDispatcher("login").forward(request, response);

        }
        if (account == null && path.equals("/solve")) {
            request.getRequestDispatcher("login").forward(request, response);

        }
        if (account != null && path.equals("/login")) {
            request.getRequestDispatcher("home").forward(request, response);

        }

        Throwable problem = null;
        try {
            chain.doFilter(request, response);
        } catch (IOException | ServletException t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
        }

        doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     *
     * @return the filter configuration object
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     *
     * @param filterConfig the <code>FilterConfig</code> object
     */
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("AccesstionFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AccesstionFilter()");
        }
        StringBuilder sb = new StringBuilder("AccesstionFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    /**
     * This method send the processing if something error
     *
     * @param t is the <code>Throwable</code> object
     * @param response the <code>ServletResponse</code> object
     */
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                try (PrintStream ps = new PrintStream(response.getOutputStream()); PrintWriter pw = new PrintWriter(ps)) {
                    pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                    // PENDING! Localize this for next official release
                    pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                    pw.print(stackTrace);
                    pw.print("</pre></body>\n</html>"); //NOI18N
                }
                response.getOutputStream().close();
            } catch (IOException ex) {
            }
        } else {
            try {
                try (PrintStream ps = new PrintStream(response.getOutputStream())) {
                    t.printStackTrace(ps);
                }
                response.getOutputStream().close();
            } catch (IOException ex) {
            }
        }
    }

    /**
     * Get the stack trace from buffer
     *
     * @param t is the <code>Throwable</code> object
     * @return stack trace
     */
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (IOException ex) {
        }
        return stackTrace;
    }

    /**
     * Send log filterConfig
     *
     * @param msg is a String
     */
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
