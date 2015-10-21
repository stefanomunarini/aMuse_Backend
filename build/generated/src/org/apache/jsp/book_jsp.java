package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URL;
import javax.mail.Session;
import LibraryAMuse.*;
import java.util.*;

public final class book_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  \n");
      out.write("        \n");
      out.write("<html>\n");
      out.write("  \n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <link rel=\"shortcut icon\" href=\"am.ico\" />\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'/>\n");
      out.write("    <title>aMuse</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/book.css\" />\n");
      out.write("    <script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/heights.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/amuse_book.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/popup.js\"></script>\n");
      out.write("   <script type=\"text/javascript\">var switchTo5x=true;</script>\n");
      out.write("    <script type=\"text/javascript\" src=\"http://w.sharethis.com/button/buttons.js\"></script>\n");
      out.write("    <script type=\"text/javascript\">stLight.options({publisher: \"dVruhero\", doNotHash: false, doNotCopy: false, hashAddressBar: false});</script>\n");
      out.write(" </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("      ");

            //prendo email e IDEH dall'url
            String hemail = request.getParameter("e");
            String email=AmuseGuest.decripted(hemail);
            String hIdeh=request.getParameter("IDEH");
            int ideh = Integer.parseInt(AmuseGuest.decripted(hIdeh));
            String l=request.getParameter("l");
            
            StringBuffer url = request.getRequestURL();
            url.append("?e="+hemail+"&IDEH="+hIdeh+"&l="+l);
          //  System.out.println("_________"+url);
            
      out.write("\n");
      out.write("      \n");
      out.write("      <!-- POPUP -->\n");
      out.write("    <div id=\"popup_share\"> \n");
      out.write("            <div id=\"box_share\"> \n");
      out.write("                ");
 if(l.equals("ita")){ 
      out.write("\n");
      out.write("                <p id=\"popup_share_text\"> Condividi il tuo book con chi vuoi tu: </p>  \n");
      out.write("                ");
 }else { 
      out.write("\n");
      out.write("                <p id=\"popup_share_text\"> Share your book: </p>  \n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("                <input id=\"url_input\" autofocus=\"autofocus\" type=\"text\" value=\"");
 out.println(url); 
      out.write("\" /> \n");
      out.write("                \n");
      out.write("               ");
 out.println("<span class='st_facebook_large'  st_title=\""+ url +"\" displayText='Facebook'></span>"); 
      out.write("\n");
      out.write("               ");
 out.println("<span class='st_twitter_large' displayText='Tweet'></span>"); 
      out.write("\n");
      out.write("               ");
 out.println("<span class='st_linkedin_large' st_title=\""+url+"\" displayText='LinkedIn'></span>"); 
      out.write("\n");
      out.write("               ");
 out.println("<span class='st_email_large' st_title=\""+url+"\" displayText='Email'></span>"); 
      out.write("\n");
      out.write("               ");
 out.println("<span class='st_googleplus_large' st_title=\""+url+"\" displayText='Google +'></span>"); 
      out.write("\n");
      out.write("               \n");
      out.write("            </div>\n");
      out.write("    </div>\n");
      out.write("      \n");
      out.write("    <a href=\"#\">\n");
      out.write("      <div id=\"previous\">\n");
      out.write("      </div>\n");
      out.write("    </a>\n");
      out.write("      \n");
      out.write("    <a href=\"#\">\n");
      out.write("      <div id=\"next\">\n");
      out.write("      </div>\n");
      out.write("    </a>\n");
      out.write(" \n");
      out.write(" ");
 
     String imail=(String)session.getAttribute("email");
     if(imail == null){
                  

      out.write("\n");
      out.write("        \n");
      out.write("    <div id=\"menu_left\">\n");
      out.write("      <a href=\"index.jsp\">\n");
      out.write("        <div id=\"amuse\">\n");
      out.write("        </div>\n");
      out.write("      </a>\n");
      out.write("    </div>\n");
      out.write(" ");

     }else {
 
      out.write("\n");
      out.write("    \n");
      out.write("    <!-- se loggato -->\n");
      out.write("    <div id=\"menu_left_logged\">\n");
      out.write("        <div id=\"amuse\">\n");
      out.write("        </div>\n");
      out.write("        <div id=\"mouse_on\">\n");
      out.write("            ");
 if(l.equals("ita")){ 
      out.write("\n");
      out.write("           <a href=\"my_book.jsp\"> <div id=\"mouse_on_link\"> I miei Book </div></a> \n");
      out.write("           ");
 }else{ 
      out.write("\n");
      out.write("           <a href=\"my_book_eng.jsp\"> <div id=\"mouse_on_link\"> My Book </div></a> \n");
      out.write("           ");
 }
                if(l.equals("ita")){ 
                out.println("<a href=\"modify_book.jsp?IDEH="+ideh+"\"><div id=\"mouse_on_link\"> Modifica Book </div></a> "); 
              }else{
                out.println("<a href=\"modify_book_eng.jsp?IDEH="+ideh+"\"><div id=\"mouse_on_link\"> Modify Book </div></a> ");                 
              }
           
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write(" \n");
      out.write(" ");
 } 
      out.write("\n");
      out.write("    <div id=\"menu_right\">\n");
      out.write("      <a href=\"\" id=\"share_link\" onclick=\"return false;\">\n");
      out.write("        <div id=\"share\">\n");
      out.write("        </div>\n");
      out.write("      </a>\n");
      out.write("    </div> \n");
      out.write(" \n");
      out.write("    \n");
      out.write(" \n");
      out.write(" \n");
      out.write("    <div id=\"slider\">\n");
      out.write("      <div id=\"wrapper\">\n");
      out.write("          <div id=\"last_slide\"></div>\n");
      out.write("        <ul>\n");
      out.write("            ");

                                
                Exhibition ex= DBconnection.SearchSingleExhibition(ideh);
                
                Book b = DBconnection.SearchBookElements(email, ideh);
                ListWorksbook lwb = b.getMyWorks();
                
                for(int i=lwb.size()-1;i>=0;i--)
                {
                    out.println("<li><div><h3>"+lwb.get(i).geTitle()+"</h3></div>"
                            + "<div class=\"image_one\" style=\"background-image: url(imagesExhibition/"+ lwb.get(i).getURLworkIMG1() +")\">");
                    out.println("</div><div class=\"description_one\">");
                    out.println("<p>"+ lwb.get(i).getDescriptionw() +"</p>");
                    out.println("</div></li>");
                }     
                
                out.println("<li><div><h1>"+b.getTitle()+"</h1></div><div class=\"image_one\" style=\"background-image: url(imagesExhibition/"+ ex.getImg1() +")\">");
                out.println("</div><div class=\"description_one\">");
                out.println("<p style=\"margin-top: 20px\">"+b.getDescription()+"</p>");
                out.println("</div></li>");
                
            
      out.write("\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("\n");
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
