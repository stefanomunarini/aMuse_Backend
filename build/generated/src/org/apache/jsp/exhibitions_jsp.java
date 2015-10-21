package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import LibraryAMuse.*;
import java.util.*;

public final class exhibitions_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <link rel=\"shortcut icon\" href=\"am.ico\" />\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'/>\n");
      out.write("    <title>aMuse</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/layout.css\" />\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/slider.css\" />\n");
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/layout.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/slider.js\"></script>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("      <div id=\"red_line\">\n");
      out.write("        <div id=\"red_line_wrapper\">\n");
      out.write("          <div class=\"guide_shadow\">\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("      <div id=\"top_wrapper\">\n");
      out.write("        <div class=\"guide\">\n");
      out.write("          <p class=\"guide_number\">1</p>\n");
      out.write("          <p class=\"guide_text\">Scegli una mostra per il tuo book</p>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"logo_area\"><img src=\"images/logo.jpg\" alt=\"aMuse\" height=\"62\" width=\"229\"></div>\n");
      out.write("        <div id=\"separator\"></div>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("      ");
 
          ArrayList<Exhibition> lstEx = DBconnection.ActiveExhibition();    
          ArrayList<Exhibition> lstEx2 = DBconnection.ActiveExhibition();         
          
      
      out.write("\n");
      out.write("      \n");
      out.write("      <div id=\"content_wrapper\">\n");
      out.write("        <div id=\"slider_wrapper\">\n");
      out.write("            <div id=\"left\"></div>\n");
      out.write("            <div id=\"right\"></div>\n");
      out.write("            <div id=\"thumbs\">\n");
      out.write("              <ul id=\"thumbs_ul\">\n");
      out.write("                  ");
 
                      for (Exhibition ex : lstEx ){
                          out.println("<li style=\"background-image: url(imagesExhibition/"+ex.getImg1()+")\"></li>");
                      }
                  
      out.write("\n");
      out.write("              </ul>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"slide\">\n");
      out.write("\n");
      out.write("              <ul id=\"slide_ul\">\n");
      out.write("                  ");

                      for (int i=0; i<lstEx2.size();i++ ){
                         Exhibition ex=lstEx2.get(i);
                         out.println("<a href=\"CreateBook.jsp?IDEH="+ex.getID()+"\">");
                         out.println("<li style=\"background-image: url(imagesExhibition/"+ex.getImg1()+")\">");
                         out.println("<p class=\"title\">"+ex.getTitle()+"</p>");
                         out.println("<p class=\"description\">"+ex.getDescription()+"</p>");
                         out.println("</li></a>");
                      }
                  
      out.write("\n");
      out.write("              </ul>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("      </body>\n");
      out.write("    </html>");
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
