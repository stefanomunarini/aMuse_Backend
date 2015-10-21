package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import LibraryAMuse.*;

public final class HomePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
      out.write("\n");
      out.write("<!--\n");
      out.write("Project\t\t: aMuse\n");
      out.write("Team\t\t: dVruhero\n");
      out.write("Page\t\t: index.html\n");
      out.write("Description\t: Homepage of the aMuse website\n");
      out.write("Released\t: March 28th, 2013 (First Deliverable)\n");
      out.write("-->\n");
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"am.ico\" />\n");
      out.write("\t<meta name=\"keywords\" content=\"\" />\n");
      out.write("\t<meta name=\"description\" content=\"\" />\n");
      out.write("\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t<title>aMuse, Museo delle Scienze di Trento</title>\n");
      out.write("\t<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'/>\n");
      out.write("        <link href=\"css/homepage.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n");
      out.write("\t<script type=\"text/javascript\" src=\"scripts/jquery-1.7.1.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"scripts/jquery.slidertron-1.0.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<!-- start MAIN CONTAINER -->\n");
      out.write("<div id=\"wrapper\">\n");
      out.write("\n");
      out.write("\t<!-- start CONTENT CONTAINER -->\n");
      out.write("\t<div id=\"header-wrapper\">\n");
      out.write("\n");
      out.write("\t\t<!-- start HEADER -->\n");
      out.write("\t\t<div id=\"header\">\n");
      out.write("\t\t\t<div id=\"logo\">\n");
      out.write("\t\t\t\t<h1><a href=\"#\"><img src=\"images/titolo.png\"></a></h1>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- end HEADER -->\n");
      out.write("\n");
      out.write("\t\t<!-- start MENU -->\n");
      out.write("\t\t<div id=\"menu-wrapper\">\n");
      out.write("\t\t\t<ul id=\"menu\">\n");
      out.write("\t\t\t\t<li class=\"current_page_item\"><a href=\"#\"><span>Homepage</span></a></li>\n");
      out.write("                                \n");
      out.write("                                \n");
      out.write("                                <!-- controllo se è loggato -->\n");
      out.write("\t\t\t\t<li>");
 if(session.getAttribute("email")!=null){out.println("<a href=\"logout.jsp\"><span>Logout</span></a>");}
                                       else{out.println("<a href=\"login.jsp\"><span>Login</span></a>");}
      out.write("\n");
      out.write("\t\t\t\t</li>\n");
      out.write("                                       \n");
      out.write("                                       \n");
      out.write("                                       \n");
      out.write("                                <li><a href=\"#\"><span>Exhibitions</span></a></li>\n");
      out.write("\t\t\t\t");
 if(session.getAttribute("email")!=null){out.println("<li><a href=\"my_books.jsp\"><span>My Books</span></a></li>");}
      out.write("\n");
      out.write("                                       \n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- end MENU -->\n");
      out.write("\n");
      out.write("\t\t<!-- start EXHIBITIONS SLIDER -->\n");
      out.write("\t\t<div id=\"banner\">\n");
      out.write("\t\t\t<div id=\"slider\"> \n");
      out.write("\t\t\t\t<a href=\"#\" class=\"button previous-button\">&lt;</a> \n");
      out.write("\t\t\t\t<a href=\"#\" class=\"button next-button\">&gt;</a>\n");
      out.write("\t\t\t\t<div class=\"viewer\">\n");
      out.write("\t\t\t\t\t<div class=\"reel\">\n");
      out.write("                                            \n");
      out.write("                                            ");

                                                ListExhibition lex = DBconnection.ActiveExhibition();
                                                
                                                if(lex==null) { out.println("Nessuna Mostra attiva Attualmente"); }  
                                                else {
                                                    int count = 0;
                                                    for(Exhibition ex: lex){ 
                                                        out.println("<div class=\"slide\">");
                                                        out.println("<h2>" + ex.getTitle() + "</h2>");
                                                        out.println("<p>Click here to see this exhibition!</p>");
                                                        out.println("<a class=\"link\" href=\"exhibition.jsp?IDEH=" + ex.getID()+ "\">Exhibition</a>");
                                                        out.println("<img src=\"imagesExhibition/" + ex.getImg1() + "\" width=\"800\" height=\"350\" alt=\"\" /></div>");
                                                        count++;
                                                     }
                                           
      out.write("\n");
      out.write("                                           \n");
      out.write("                                            \n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"indicator\">\n");
      out.write("\t\t\t\t\t<ul>\n");
      out.write("                                             ");

                                                    if(count != 0) { out.println("<li class=\"active\">1</li>"); }
                                                    for(int i = 1; i < count; i++) { out.println("<li>" + (i+1) + "</li>"); }   
                                                }
                                            
      out.write("\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<script type=\"text/javascript\">\n");
      out.write("\t\t\t\t$('#slider').slidertron({\n");
      out.write("\t\t\t\t\tviewerSelector: '.viewer',\n");
      out.write("\t\t\t\t\treelSelector: '.viewer .reel',\n");
      out.write("\t\t\t\t\tslidesSelector: '.viewer .reel .slide',\n");
      out.write("\t\t\t\t\tadvanceDelay: 3000,\n");
      out.write("\t\t\t\t\tspeed: 'slow',\n");
      out.write("\t\t\t\t\tnavPreviousSelector: '.previous-button',\n");
      out.write("\t\t\t\t\tnavNextSelector: '.next-button',\n");
      out.write("\t\t\t\t\tindicatorSelector: '.indicator ul li',\n");
      out.write("\t\t\t\t\tslideLinkSelector: '.link'\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t</script> \n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- end EXHIBITIONS SLIDER -->\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<!-- end CONTENT CONTAINER -->\n");
      out.write("\n");
      out.write("\t<!-- start BOTTOM CONTAINER -->\n");
      out.write("\t<div id=\"page\">\n");
      out.write("\n");
      out.write("\t\t<!-- start AMUSE DESCRIPTION -->\n");
      out.write("\t\t<div id=\"content\">\n");
      out.write("\t\t\t<div class=\"post\">\n");
      out.write("\t\t\t\t<h2 class=\"title\">Welcome to aMuse!</h2>\n");
      out.write("\t\t\t\t<div class=\"entry\">\n");
      out.write("\t\t\t\t\t<p>Today, most museums are trying to offer visitors more than just a simple visit where they perceive artifacts and their meanings. They try to make the museum visit an unforgettable experience to be lived even outside of the museum environment and that can be shared with family and friends. The main reason to support this sharing is two-fold: first, by creating interest and a buzz about an exhibition, museums can get more people to come visit; second, museums have a commitment to reach out to those that, for various cognitive or physical limitations, find it impossible or impractical to visit an exhibition.</p>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- end AMUSE DESCRIPTION -->\n");
      out.write("\n");
      out.write("\t\t<!-- start EXHIBITIONS MENU -->\n");
      out.write("\t\t<div id=\"sidebar\">\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t<h2>Current exhibitions</h2>\n");
      out.write("\t\t\t\t\t<ul>\n");
      out.write("                                            \n");
      out.write("                                            ");

                                                if(lex != null) {
                                                    int count = 1;
                                                    for(Exhibition ex : lex) {
                                                        out.println("<li>#" + count + "  <a href=\"exhibition.jsp?IDEH=" + ex.getID()+ "\">" + ex.getTitle() + "</a></li>");
                                                        count++;
                                                    }
                                                }
                                             
      out.write("\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- end EXHIBITIONS MENU -->\n");
      out.write("\n");
      out.write("\t\t<div style=\"clear: both;\">&nbsp;</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<!-- end BOTTOM CONTAINER --> \n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- end MAIN CONTAINER -->\n");
      out.write("\n");
      out.write("<!-- start FOOTER -->\n");
      out.write("<div id=\"footer\">\n");
      out.write("\t<p>Software engineering project developed by dVruhero | @<a href=\"http://www.unitn.it/\" target=\"_new\">UNITN</a>, 2013</p>\n");
      out.write("</div>\n");
      out.write("<!-- end FOOTER -->\n");
      out.write("\n");
      out.write("</body>\n");
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
