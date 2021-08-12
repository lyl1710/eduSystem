package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Solve_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/Login.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"login\">\n");
      out.write("            <div class=\"left\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Left.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"homeMid\">\n");
      out.write("                <div class=\"homeTilte\"><h2>RequestID:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${req.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2> </div>\n");
      out.write("                <div class=\"Solve\">\n");
      out.write("                    <form id=\"form\" action=\"solve\" method=\"POST\">\n");
      out.write("                        <input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${req.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"id\">\n");
      out.write("                        <div class=\"department\" >Request to department <input class=\"inputSolve\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${req.department.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly name=\"department\"></div>\n");
      out.write("                        <div class=\"studentID\" >Student ID <input  class=\"inputSolve\"  type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${req.studentID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly name=\"studentID\"></div>\n");
      out.write("                        <div class=\"studentName\" >Student name <input  class=\"inputSolve\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${req.studentName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly name=\"studentName\"></div>\n");
      out.write("                        <div class=\"dateCreated\" >Date created <input  class=\"inputSolve\" type=\"text\"value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${req.dateCreated}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly name=\"dateCreated\"></div>\n");
      out.write("                        <div class=\"requestTitle\" >Request title <input  class=\"inputSolve\" type=\"text\"value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${req.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly name=\"requestTitle\"></div>\n");
      out.write("                        <div class=\"requestContent\" ><p>Request content</p> <textarea  class=\"inputSolve\" readonly  style=\"margin: 0px; width: 300px; height: 50px;margin-left: 10px;\" name=\"requestContent\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${req.content}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea></div>\n");
      out.write("                        <div class=\"requestState\" >Request State <input  class=\"inputSolve\" id=\"Approved\" ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write(" value=\"Approved\" type=\"radio\" name=\"state\"><label class=\"Approved\"  for=\"Approved\">Approved</label> <input id=\"Reject\" ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("  value=\"Reject\" type=\"radio\" name=\"state\"> <label class=\"Reject\" for=\"Reject\">Reject</label> </div>\n");
      out.write("                        <div style=\"color: red; margin-left: 155px\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                        <div class=\"closeDate\" >Close date <input  class=\"inputSolve\" type=\"text\"readonly value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${req.closeDatel}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"closeDate\"></div>\n");
      out.write("                        <div class=\"admin\" >Solve by <input  class=\"inputSolve\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"readonly name=\"admin\"></div>\n");
      out.write("                        <div class=\"solution\" ><p>School solution</p> <textarea  class=\"inputSolve\" id=\"solution\"  required=\"\" minlength=\"1\" maxlength=\"200\" style=\"margin: 0px; width: 300px; height: 50px;margin-left: 10px;\" name=\"solution\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.solution}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea></div>\n");
      out.write("                        <div id=\"alert\"><span style=\"font-size:16px; margin-left: 10px\" >Please fill out the solution field </span></div>\n");
      out.write("                        <input class=\"b\" type=\"button\" value=\"Save\" onclick=\"validate()\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("     function validate(){\n");
      out.write("         var solution = document.getElementById(\"solution\").value;\n");
      out.write("         if(solution.trim() ===\"\"){\n");
      out.write("             document.getElementById(\"alert\").style.display=\"block\";\n");
      out.write("         }else{\n");
      out.write("             document.getElementById(\"form\").submit();\n");
      out.write("         }\n");
      out.write("     }\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${req.status=='Approved'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("checked=\"\"");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${req.status=='Reject'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("checked=\"\"");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
