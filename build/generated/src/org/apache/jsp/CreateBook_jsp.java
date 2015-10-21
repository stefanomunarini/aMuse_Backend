package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import LibraryAMuse.*;
import java.util.*;

public final class CreateBook_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <link rel=\"shortcut icon\" href=\"am.ico\" />\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'/>\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Noto+Sans' rel='stylesheet' type='text/css'/>\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'/>\n");
      out.write("    <title>aMuse</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/layout.css\" />\n");
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/layout.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/counter.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/popup.js\"></script>\n");
      out.write("    </head>\n");
      out.write("  \n");
      out.write("    <body>\n");
      out.write("        ");

            String Ideh=request.getParameter("IDEH");
            int id_exhibition= Integer.parseInt(Ideh);
            Exhibition ex=DBconnection.SearchSingleExhibition(id_exhibition);
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div id=\"error_popup\"><p id=\"error_message\">Puoi selezionare massimo 20 opere.</p></div>\n");
      out.write("        \n");
      out.write("        <div id=\"email_popup\">\n");
      out.write("            <div id=\"email_box\">\n");
      out.write("                <form action=\"confirmation.jsp\">\n");
      out.write("                <div id=\"email_box_up\">\n");
      out.write("                  <p id=\"popup_email_text\">Inserisci la tua email</p>\n");
      out.write("                  <input type=\"email\" name=\"user_email\" autocomplete=\"off\" placeholder=\"email\" autofocus required id=\"email_input\">\n");
      out.write("                  <input id=\"selected_string\" type=\"text\" name=\"user_selected\" value=\"\">\n");
      out.write("                  <input id=\"exhibition\" type=\"text\" name=\"IDEH\" value=\"");
 out.println(Ideh); 
      out.write("\">\n");
      out.write("               </div>\n");
      out.write("               <div id=\"email_box_down\">\n");
      out.write("                <input type=\"submit\" id=\"button_email\" value=\"INVIA\">\n");
      out.write("               </div>\n");
      out.write("             </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <div id=\"red_line\">\n");
      out.write("            \n");
      out.write("            <div id=\"red_line_wrapper\">\n");
      out.write("              <div class=\"guide_shadow\">\n");
      out.write("              </div>\n");
      out.write("              <div class=\"guide_shadow\">\n");
      out.write("              </div>\n");
      out.write("                <a id=\"go_back\" href=\"exhibitions.jsp\">TORNA ALLE MOSTRE</a>\n");
      out.write("                <a href=\"exhibitions.jsp\"><img style=\"float:right; margin-top: 7px;\" src=\"images/back.jpg\"></a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    <div id=\"top_wrapper\">\n");
      out.write("\n");
      out.write("      <div class=\"guide\">\n");
      out.write("        <p class=\"guide_number\">2</p>\n");
      out.write("        <p class=\"guide_text\">Scegli cosa ti piace: <br>\n");
      out.write("            <span class=\"red\"><span id=\"counter\">0</span> selezionate</span></p>\n");
      out.write("      </div>\n");
      out.write("      <a id=\"create\" href=\"\" onclick=\"return false\">\n");
      out.write("        <div class=\"guide\" >\n");
      out.write("          <p class=\"guide_number\">3</p>\n");
      out.write("          <p class=\"guide_text\">Quando hai finito clicca: <br>\n");
      out.write("              <span class=\"red\">CREA BOOK</span></p>\n");
      out.write("        </div>\n");
      out.write("      </a>\n");
      out.write("\n");
      out.write("      <div id=\"title_area\"><p id=\"title\">");
 out.println(ex.getTitle()); 
      out.write("</p></div>\n");
      out.write("      <div id=\"logo_area\"><img src=\"images/logo.jpg\" alt=\"aMuse\" height=\"62\" width=\"229\"></div>\n");
      out.write("      <div id=\"separator\"></div>\n");
      out.write("    </div>\n");
      out.write("                \n");
      out.write("        ");
 
            if(ex != null) {        
        
      out.write("\n");
      out.write("                \n");
      out.write("          <div id=\"content_wrapper\"> \n");
      out.write("            \n");
      out.write("            ");
 
                for(Work w: ex.getListWorks()){
                    out.println("<div class=\"spacer\">");
                    out.println("<div class=\"object_wrapper\">");
                    out.println("<p class=\"object_id\" title=\""+w.getIdWork()+"\"></p>");
                    out.println("<div class=\"object_image\" style=\"background-image: url(imagesExhibition/"+w.getURLimg1()+");\"> </div>");
                    out.println("<div class=\"object_button\"> <p class=\"object_description\">"+ w.getTitle() +"</p></div>");
                    out.println("</div>");
                    out.println("</div>");
                } 
                
            
      out.write("\n");
      out.write("            \n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("             \n");
      out.write("        </div>    \n");
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
