package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import LibraryAMuse.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <link rel=\"shortcut icon\" href=\"am.ico\" />\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'/>\n");
      out.write("    <title>aMuse</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/layout.css\" />\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/menu.css\" />\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/content.css\" />\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/register.css\" />\n");
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/scrollable.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/background.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("    <!-- MAIN BOX !-->\n");
      out.write("    <div id=\"box\">\n");
      out.write("      <!-- LOGO AREA !-->\n");
      out.write("      <div id=\"logoarea\">\n");
      out.write("        <div id=\"logo_background\">\n");
      out.write("          <a href=\"HomePage.jsp\">\n");
      out.write("          <h1 id=\"amuse\">aMUSE</h1>\n");
      out.write("          </a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <!-- LEFT COLUMN WITH BUTTONS !-->\n");
      out.write("      <div id=\"left\">\n");
      out.write("        <div id=\"menu_wrapper\">\n");
      out.write("          <div id=\"main_menu_not_active\">\n");
      out.write("            \n");
      out.write("            <div class=\"menu_content_not_active\">\n");
      out.write("              <div class=\"menu_text\">\n");
      out.write("                <h3>INSERT<br />YOUR<br />DETAILS</h3>\n");
      out.write("                <h3 style=\"margin-top: 10px\">and live the<br />aMuse experience!</h3>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <!-- CONTENT !-->\n");
      out.write("      <div id=\"content\">\n");
      out.write("        <!-- TOP MENU !-->\n");
      out.write("        <div id=\"top_menu_wrapper\">\n");
      out.write("          <ul id=\"top_menu\">\n");
      out.write("            <li><a href=\"login.jsp\"><h3>Login</h3></a></li>\n");
      out.write("            <li><a href=\"exhibitions.jsp\"><h3>Exhibitions</h3></a></li>\n");
      out.write("            <li><a href=\"my_books.jsp\"><h3>My books</h3></a></li>\n");
      out.write("          </ul>\n");
      out.write("        </div>\n");
      out.write("        <!-- TITLE !-->\n");
      out.write("        <h2>SIGN IN OR REGISTER</h2>\n");
      out.write("        <!-- ACTUAL CONTENT !-->\n");
      out.write("        <!-- ONE BOX WITH BUTTON AND IMAGE !-->\n");
      out.write("\n");
      out.write("          <div class=\"signin_wrapper\">\n");
      out.write("            <div class=\"signin_icon\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"signin\">\n");
      out.write("                <form id=\"signin\" action=\"login_control.jsp\" method=\"post\">\n");
      out.write("              <fieldset>\n");
      out.write("                 <h3>SIGN IN AND MANAGE YOUR BOOKS</h3>\n");
      out.write("                <ol>\n");
      out.write("                  <li>\n");
      out.write("                    <label for=\"email\">EMAIL</label>\n");
      out.write("                    <input id=\"email\" name=\"email\" type=\"email\" placeholder=\"Inserisci la tua email\" required>\n");
      out.write("                  </li>\n");
      out.write("                  <li>\n");
      out.write("                    <label for=\"psw\">PASSWORD</label>\n");
      out.write("                    <input id=\"psw\" name=\"psw\" type=\"password\" placeholder=\"Inserisci la tua password\" required>\n");
      out.write("                  </li>\n");
      out.write("                </ol>\n");
      out.write("              </fieldset>\n");
      out.write("              <fieldset>\n");
      out.write("                <button type=\"submit\" name=\"login_button\">LOGIN</button>\n");
      out.write("              </fieldset>\n");
      out.write("            </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"register\">\n");
      out.write("              <form id=\"register\">\n");
      out.write("              <h3>SIGN UP AND ENJOY<br /></h3>\n");
      out.write("              <h3>A NEW EXCITING<br /></h3>\n");
      out.write("              <h2>MUSEUM<br /></h2>\n");
      out.write("              <h3>EXPERIENCE!<br /><br /></h3>\n");
      out.write("\n");
      out.write("              <fieldset>\n");
      out.write("                  <a href=\"register.jsp\"><button>REGISTER</button> </a>\n");
      out.write("              </fieldset>\n");
      out.write("            </form>\n");
      out.write("            </div>\n");
      out.write("              \n");
      out.write("        <!-- ERROR POP UP -->\n");
      out.write("        ");
 String error=request.getParameter("Error"); 
      out.write("\n");
      out.write("        \n");
      out.write("          \n");
      out.write("        <div id=\"pop_up");
if(error!=null){out.println("_active\"");}else{out.println("\"");}
      out.write(">\n");
      out.write("              \n");
      out.write("             <h3>Email and/or password are incorrect!</h3>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("        <!-- ANOTHER BOX WITH BUTTON AND IMAGE !-->\n");
      out.write("\n");
      out.write("        <!-- END OF BOXES !-->\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    </body>\n");
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
}
