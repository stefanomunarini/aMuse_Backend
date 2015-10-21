package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import LibraryAMuse.*;
import java.util.*;

public final class object_005fdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <link rel=\"shortcut icon\" href=\"am.ico\" />\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'/>\n");
      out.write("    <title>aMuse - Object Details</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/layout.css\" />\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/menu.css\" />\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/content.css\" />\n");
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/scrollable.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/background.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");

    
    int IDWork=Integer.parseInt(request.getParameter("IDW")); 
    int exhibition=Integer.parseInt(request.getParameter("IDEH"));
            
    Work w =  DBconnection.SearchWork(IDWork);
    Exhibition ex= DBconnection.SearchSingleExhibition(exhibition);

      out.write("\n");
      out.write("        <!-- MAIN BOX !-->\n");
      out.write("    <div id=\"box\">\n");
      out.write("      <!-- LOGO AREA !-->\n");
      out.write("      <div id=\"logoarea\">\n");
      out.write("        <div id=\"logo_background\">\n");
      out.write("          <a href=\"exhibition.html\">\n");
      out.write("          <h1 id=\"amuse\">aMUSE</h1>\n");
      out.write("          </a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <!-- LEFT COLUMN WITH BUTTONS !-->\n");
      out.write("      <div id=\"left\">\n");
      out.write("        <div id=\"menu_wrapper\">\n");
      out.write("          <div id=\"main_menu\">\n");
      out.write("             <a href=\"exhibition.jsp?IDEH=");
out.println(exhibition);
      out.write("\">\n");
      out.write("              <div class=\"menu_content\">\n");
      out.write("              <div class=\"menu_text\">\n");
      out.write("                <h3>FATTO</h3>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            </a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <!-- CONTENT !-->\n");
      out.write("      <div id=\"content\">\n");
      out.write("        <!-- TOP MENU !-->\n");
      out.write("        <div id=\"top_menu_wrapper\">\n");
      out.write("          <ul id=\"top_menu\">\n");
      out.write("  <!-- controllo se è loggato -->\n");
      out.write("\t\t\t\t<li>");
 if(session.getAttribute("email")!=null){out.println("<a href=\"logout.jsp\"><span>Logout</span></a>");}
                                       else{out.println("<a href=\"login.jsp\"><span>Login</span></a>");}
      out.write("\n");
      out.write("\t\t\t\t            <li><a href=\"#\"><h3>Exhibitions</h3></a></li>\n");
      out.write("            <li><a href=\"my_books.html\"><h3>My books</h3></a></li>\n");
      out.write("          </ul>\n");
      out.write("        </div>\n");
      out.write("        <!-- TITLE !-->\n");
      out.write("        <h2>");
out.println(ex.getTitle());
      out.write("</h2>\n");
      out.write("        <h3 class=\"content_title\">");
out.println(w.getTitle());
      out.write("</h3>\n");
      out.write("        <!-- ACTUAL CONTENT !-->\n");
      out.write("        <div class=\"details_wrapper\">\n");
      out.write("          <div class=\"details_image\" style=\"background-image: ");
out.println(w.getURLimg1()) ;
      out.write(";\">\n");
      out.write("          </div>\n");
      out.write("            ");
 out.println("ciao" + w.getDescription()); 
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    </body>\n");
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
