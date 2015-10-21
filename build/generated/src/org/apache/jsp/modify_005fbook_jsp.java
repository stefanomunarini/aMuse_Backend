package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import LibraryAMuse.*;
import java.util.*;

public final class modify_005fbook_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <script type=\"text/javascript\" src=\"scripts/popup.js\"></script>\n");
      out.write("    </head>\n");
      out.write("  \n");
      out.write("    <body>\n");
      out.write("        ");

            
            int id_book=Integer.parseInt(request.getParameter("id_book"));
            String id_work=request.getParameter("id_work");
            String email=(String)session.getAttribute("email");            
            Book bk=DBconnection.SearchBookElements(id_book);
            String cmail=AmuseGuest.encripted(email);
            int rr = 0;
            
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div id=\"modify_popup\">\n");
      out.write("                <div id=\"modify_box\">\n");
      out.write("\n");
      out.write("                    <form action=\"update_book.jsp\" method=\"post\">\n");
      out.write("                    <div id=\"modify_box_up\">\n");
      out.write("                      <p class=\"popup_email_text\">Inserisci il titolo</p>\n");
      out.write("                      ");
 out.println("<textarea class=\"title_book\" name=\"title\" maxlength=\"25\">"+bk.getTitle()+"</textarea>"); 
      out.write("\n");
      out.write("                      <p class=\"popup_email_text\">Inserisci la descrizione</p>\n");
      out.write("                      ");
 out.println("<textarea class=\"popup_description\" name=\"description\" maxlength=\"200\" >"+bk.getDescription()+"</textarea>"); 
      out.write("\n");
      out.write("                      <input class=\"exhibition\" type=\"text\" name=\"id_book\" value=\"");
 out.println(id_book); 
      out.write("\">\n");
      out.write("                   </div>\n");
      out.write("                   <div id=\"modify_box_down\">\n");
      out.write("                    <input type=\"submit\" class=\"button_update\" name=\"update\" value=\"SALVA\">\n");
      out.write("                   </div>\n");
      out.write("                 </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("        </div>\n");
      out.write("         <div id=\"cover_popup\">      \n");
      out.write("            <div id=\"cover_box\">\n");
      out.write("                <form name=\"uploadForm\" action=\"upload_photo\"  enctype=\"multipart/form-data\" method=\"post\">\n");
      out.write("                    <div id=\"cover_box_up\">\n");
      out.write("                        <p class=\"popup_email_text\">Cambia immagine di copertina</p>\n");
      out.write("                        <div class=\"cover_img\" style=\"background-image: url(userPhoto/");
 out.println(bk.getCover());
      out.write(");\"></div>\n");
      out.write("                        <input type=\"text\" style=\"visibility:hidden;\" name=\"id_book\" value=\"");
 out.println(bk.getIDBook()); 
      out.write("\">\n");
      out.write("                        <div class=\"choose\"><input type=\"file\" name=\"file\"></div>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"cover_box_down\">\n");
      out.write("                        <input type=\"submit\" class=\"button_update\" name=\"update\" value=\"CAMBIA COVER\">\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("                        \n");
      out.write("        <div id=\"comment_popup\">\n");
      out.write("                <div id=\"comment_box\">\n");
      out.write("\n");
      out.write("                    <form action=\"update_book.jsp\" method=\"post\">\n");
      out.write("                    <div id=\"comment_box_up\">                       \n");
      out.write("                      <p class=\"popup_email_text\">Inserisci il tuo commento all'opera</p>\n");
      out.write("                      <textarea id=\"comment\" class=\"popup_description\" name=\"comment\" style=\"margin-top:20px; width: 300px;\" maxlength=\"100\"> </textarea>\n");
      out.write("                      <input class=\"idwork\" type=\"text\" name=\"id_work\" value=\"\">\n");
      out.write("                      <input type=\"text\" style=\"visibility:hidden;\" name=\"id_book\" value=\"");
 out.println(id_book); 
      out.write("\">\n");
      out.write("                      \n");
      out.write("                   </div>\n");
      out.write("                   <div id=\"comment_box_down\">\n");
      out.write("                    <input type=\"submit\" class=\"button_update\" name=\"comment_button\" value=\"AGGIUNGI\">\n");
      out.write("                   </div>\n");
      out.write("                 </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("        </div>\n");
      out.write("           \n");
      out.write("          ");
 if(id_work!=null){ 
              Workbook w=DBconnection.SearchWorkbook(Integer.parseInt(id_work), id_book);              
          
      out.write("\n");
      out.write("         <div id=\"photo_popup\">      \n");
      out.write("            <div id=\"photo_box\">\n");
      out.write("                <form name=\"uploadForm\" action=\"upload_photo\"  enctype=\"multipart/form-data\" method=\"post\">\n");
      out.write("                    <div id=\"photo_box_up\">\n");
      out.write("                        <p class=\"popup_email_text\">Aggiungi una tua foto dell'opera <br/>\n");
      out.write("                            <i>\"");
 out.println(w.getTitle()); 
      out.write("\"</i> </p>\n");
      out.write("                        <br/>\n");
      out.write("                        \n");
      out.write("                        <div class=\"cover_img\" style=\"background-image: url(userPhoto/");
 out.println(w);
      out.write(");\"></div>\n");
      out.write("                        \n");
      out.write("                        <!--<input class=\"idwork\" type=\"text\" name=\"id_work\" value=\"\"> -->\n");
      out.write("                        <input type=\"text\" name=\"id_work\" value=\"");
 out.println(id_work); 
      out.write("\">\n");
      out.write("                        <input type=\"text\" style=\"visibility:hidden;\" name=\"id_book\" value=\"");
 out.println(id_book); 
      out.write("\">                        \n");
      out.write("                        <div class=\"choose\"><input type=\"file\" name=\"file\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"photo_box_down\">\n");
      out.write("                        <input type=\"submit\" class=\"button_update\" name=\"photo\" value=\"AGGIUNGI\">\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          ");
 } 
      out.write("\n");
      out.write("        \n");
      out.write("        <div id=\"red_line\">\n");
      out.write("            <div id=\"red_line_wrapper\">\n");
      out.write("              <div class=\"guide_shadow\">\n");
      out.write("              </div>\n");
      out.write("              <div class=\"guide_shadow\">\n");
      out.write("              </div>\n");
      out.write("                <div class=\"guide_shadow\">\n");
      out.write("              </div>\n");
      out.write("                ");
 out.println("<a href=\"modify_book_eng.jsp?id_book="+id_book+"\"><img src=\"images/flag_eng.jpg\" style=\"width: 25px; height: 15px; float: right; margin-top: 5px; margin-left: 10px;\"></a> "); 
      out.write("\n");
      out.write("                <a id=\"go_back_logout\" href=\"logout.jsp\">LOGOUT</a>\n");
      out.write("                <a id=\"go_back\" href=\"my_book.jsp\">TORNA AI TUOI BOOK</a>\n");
      out.write("                <a href=\"my_book.jsp\"><img style=\"float:right; margin-top: 7px;\" src=\"images/back.jpg\"></a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        \n");
      out.write("    <div id=\"top_wrapper\">\n");
      out.write("\n");
      out.write("      <div class=\"guide\">   \n");
      out.write("          <img src=\"images/lens.jpg\" style=\"width: 64px; height: 64px; margin-left: 33px; margin-top: 18px;\"><br>\n");
      out.write("          ");
 out.println("<a class=\"special_button\" href=\"book.jsp?&idb="+AmuseGuest.encripted(Integer.toString(id_book))+"&l=ita\">VISUALIZZA</a>"); 
      out.write("\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("      <div class=\"guide\" >\n");
      out.write("          <img src=\"images/pencil.jpg\" style=\"width: 64px; height: 64px; margin-left: 33px; margin-top: 18px;\"><br>\n");
      out.write("          <a id=\"modify\" class=\"special_button\" href=\"\" onclick=\"return false;\">RINOMINA</a>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"guide\" >\n");
      out.write("          <img src=\"images/cover.jpg\" style=\"width: 70px; height: 64px; margin-left: 30px; margin-top: 18px;\"><br>\n");
      out.write("          <a id=\"cover\" class=\"special_button\" href=\"\" onclick=\"return false;\">COVER</a>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("      <div id=\"title_area\"></div>\n");
      out.write("      <div id=\"logo_area\"><img src=\"images/logo.jpg\" alt=\"aMuse\" height=\"62\" width=\"229\"></div>\n");
      out.write("      <div id=\"separator\"></div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("                \n");
      out.write("        ");
 
            if(bk != null) {        
        
      out.write("\n");
      out.write("                \n");
      out.write("        \n");
      out.write("          <div id=\"content_wrapper\"> \n");
      out.write("            <div id=\"book_info\">\n");
      out.write("              <p id=\"book_title\">");
 out.println(bk.getTitle()); 
      out.write("</p>\n");
      out.write("              <p id=\"book_description\">");
 out.println(bk.getDescription()); 
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("              \n");
      out.write("            ");
 
                for(int i=0;i<bk.getMyWorks().size();i++ ){
                    Workbook wb=bk.getMyWorks().get(i);  
                    
                    out.println("<div class=\"spacer spacer_modify\">");
                    
                    out.println("<div class=\"object_wrapper\">");
                    out.println("<div class=\"object_button1\" style=\"margin-bottom: 4px; background-color: white;\">");
                    out.println("<a class=\"add_photo\" href=\"modify_book.jsp?id_book="+id_book+"&id_work="+wb.getIDWork()+"\" ><div style=\"background-color: #999999; height:36px; width: 133px;float:left; \"><img src=\"images/add.jpg\" style=\"float:left;\"><p class=\"add\"> Foto</p> </div></a>");
                    out.println("<a class=\"add_comment\" href=\"\" onclick=\"return false;\"><div style=\"background-color: #999999; float:right;height:36px; width: 133px;\"><img src=\"images/add.jpg\" style=\"float:left;\"><p class=\"add\"> Commento</p> <p class=\"object_id\" title=\""+wb.getIDWork()+"\"></p> </div></a> </div>");
                    out.println("<div class=\"object_image\" style=\"background-image: url(imagesExhibition/"+wb.getURLimg1()+");\"> </div>");
                    out.println("<div class=\"object_button1\"> <p class=\"object_description1\">"+ wb.getTitle() +"</p></div>");
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
