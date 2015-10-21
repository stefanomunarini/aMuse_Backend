package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=ISO-8859-1");
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
      out.write("<html>\n");
      out.write("  \n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"ISO-8859-1\">\n");
      out.write("    <link rel=\"shortcut icon\" href=\"am.ico\" />\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'/>\n");
      out.write("    <title>aMuse</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\" />\n");
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/login.js\"></script>\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("      ");
 String error=request.getParameter("Error"); 
      out.write("\n");
      out.write("    \n");
      out.write("    <div id=\"email_popup\">\n");
      out.write("            <div id=\"email_box\">\n");
      out.write("                <div style=\"width: 100%; height: 0px;\"><div class=\"ics\"></div></div>\n");
      out.write("                <form action=\"sendPassword.jsp\">\n");
      out.write("                <div id=\"email_box_up\">\n");
      out.write("                    <br/><br/>\n");
      out.write("                    <h2>Inserisci la tua email:</h2>\n");
      out.write("                    <p>Ti sarà mandata la tua password sulla tua email</p>\n");
      out.write("                    <br/>\n");
      out.write("                  <input id=\"email_err_input\" type=\"email\" name=\"user_email\" autocomplete=\"off\" placeholder=\"email\" autofocus required >\n");
      out.write("               </div>\n");
      out.write("               <div id=\"email_box_down\">\n");
      out.write("                    <input type=\"submit\" id=\"button_email\" value=\"INVIA\">\n");
      out.write("               </div>\n");
      out.write("             </form>\n");
      out.write("            </div>\n");
      out.write("    </div>\n");
      out.write("      \n");
      out.write("    <div id=\"login_wrapper\">\n");
      out.write("      <div id=\"logo\"></div>\n");
      out.write("      <form name=\"login\"  action=\"login_control.jsp\" method=\"get\" accept-charset=\"utf-8\">\n");
      out.write("\n");
      out.write("        <div id=\"forms\">\n");
      out.write("          <input id=\"email_input\" type=\"email\" name=\"usermail\" placeholder=\"email\" autofocus required>\n");
      out.write("          <input id=\"passw_input\" type=\"password\" name=\"password\" placeholder=\"password\" required>\n");
      out.write("        </div>\n");
      out.write("          <input id=\"button_login\" name=\"button_login\" type=\"submit\" value=\"Login\">\n");
      out.write("      </form>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("      \n");
      out.write("      ");
 if (error!=null){ 
      out.write("\n");
      out.write("        \n");
      out.write("      <div style=\"margin-top: 45px; text-align: center; font-size: 20px;\">\n");
      out.write("          Email o password errati!\n");
      out.write("          <br/>\n");
      out.write("          <a id=\"forgot\" href=\"\" onclick=\"return false;\">Password dimenticata?</a>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("      ");
 } 
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("</html>");
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
}
