package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import LibraryAMuse.*;
import java.util.*;

public final class my_005fbook_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("  \n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <link rel=\"shortcut icon\" href=\"am.ico\" />\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'/>\n");
      out.write("    <title>aMuse</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/layout.css\" />\n");
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/layout.js\"></script>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div id=\"red_line\">\n");
      out.write("      <div id=\"red_line_wrapper\">\n");
      out.write("          <a href=\"my_book_eng.jsp\"><img src=\"images/flag_eng.jpg\" style=\"width: 25px; height: 15px; float: right; margin-top: 5px; margin-left: 10px;\">\n");
      out.write("          </a> \n");
      out.write("          <a id=\"go_back_logout\" href=\"logout.jsp\">LOGOUT</a>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    ");
 

            String email = "";
            email = (String) session.getAttribute("email");
            String cmail = AmuseGuest.encripted(email);
            ArrayList<Book> alb = DBconnection.SearchMyBooks(email);

            
            
    
      out.write("\n");
      out.write("    <div id=\"top_wrapper\">\n");
      out.write("      <div id=\"title_area\"><p id=\"title\">I MIEI BOOK</p></div>\n");
      out.write("      <div id=\"logo_area\">\n");
      out.write("          <img src=\"images/logo.jpg\" alt=\"aMuse\" height=\"62\" width=\"229\">\n");
      out.write("      </div>\n");
      out.write("      <div id=\"separator\"></div>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"content_wrapper\">\n");
      out.write("        ");

            for(Book b: alb){
                  out.println ( "<div id=\"book\">");
                  out.println("<div id=\"button_gestion\">");
                  out.println ("<a href=\"book.jsp?idb=" + AmuseGuest.encripted(Integer.toString(b.getIDBook())) + "&l=ita\"><div id=\"view_button\">VISUALIZZA</div></a>");                  
                  out.println ("<a href=\"modify_book.jsp?id_book=" + b.getIDBook() + "\"><div id=\"modify_button\">MODIFICA</div></a>");
                  out.println ("</div>");
                  out.println("<div id=\"book_name\"><h1 id=\"book_title\">" + b.getTitle() + "</h1></div>");
                  out.println ("<div id=\"image_exhibition\" style=\"background-image: url(userPhoto/"+ b.getCover() +");\"></div>");
                  out.println("</div>");
            }
                
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("  </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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
