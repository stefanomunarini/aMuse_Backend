package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import LibraryAMuse.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>   \n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"am.ico\" />\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'/>\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Noto+Sans' rel='stylesheet' type='text/css'/>\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'/>\n");
      out.write("        <title>aMuse</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/admin.css\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"scripts/layout.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"scripts/popup.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("           <p> SELEZIONA MOSTRA: </p>\n");
      out.write("        ");
 
           // ListExhibition lex=DBconnection.AllExhibition();
        
      out.write("\n");
      out.write("        <form action=\"modify_exhibition.jsp\">\n");
      out.write("        ");

           /* for(Exhibition ex: lex){
                out.println(ex.getTitle()+"<input type=\"radio\" name=\"IDEH\" value=\""+ex.getID()+"\"/>"+"<br/>");
            }*/
            
            for(int i=0;i<5;i++){
                out.println(i+"<input type=\"radio\" name=\"IDEH\" value=\""+i+"\"/>"+"<br/>");
            }
        
      out.write("\n");
      out.write("        <input type=\"submit\" value=\"MODIFICA\" name=\"modify\">\n");
      out.write("        <input type=\"submit\" value=\"ELIMINA\" name=\"delete\" onclick=\"return false;\">\n");
      out.write("        </form>\n");
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
