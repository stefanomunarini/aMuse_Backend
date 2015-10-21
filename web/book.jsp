<%-- 
    Document   : book
    Created on : 26-mar-2013, 13.24.33
    Author     : Babol
--%>

<%@page import="java.net.URL"%>
<%@page import="javax.mail.Session"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="LibraryAMuse.*" %> 
<%@page import="java.util.*"%>

<!DOCTYPE html>

<html>
  
  <head>
    <meta charset="ISO-8859-1">
    <link rel="shortcut icon" href="am.ico" />
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'/>
    <title>aMuse</title>
    <link rel="stylesheet" type="text/css" href="css/book.css" />
    <script type="text/javascript" src="scripts/jquery.js"></script>
    <script type="text/javascript" src="scripts/jquery.transit.min.js" ></script>
    <script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
    <script type="text/javascript" src="scripts/book_heights.js"></script>
    <script type="text/javascript" src="scripts/book.js"></script>
    <script type="text/javascript" src="scripts/popup.js"></script>
    <script type="text/javascript" src="scripts/dynamic_layout.js"></script>
    
  </head>

  <body>
    
      <% 
        String email=(String)session.getAttribute("email");
        String hid_book=request.getParameter("idb");
        int id_book = Integer.parseInt(AmuseGuest.decripted(hid_book));
        String l=request.getParameter("l");

        StringBuffer url = request.getRequestURL();
        url.append("?idb="+hid_book+"&l="+l);
        
        Book b=DBconnection.SearchBookElements(id_book);
            
      %>
      
    <div id="popup_share">
      <div id="box_share">
          <div style="width: 100%; height: 0px;"><div class="ics"></div></div>
        
        <% if(l.equals("ita")){ %>
                <p class="popup_share_text"> Condividi il tuo book con chi vuoi tu: </p>  
                <% }else { %>
                <p class="popup_share_text"> Share your book: </p>  
                <% } %>
                <input id="url_input" autofocus="autofocus" style="height: 20px;width: 450px;" type="text" value="<% out.println(url); %>" /> 
                
               <% out.println("<span class='st_facebook_large'  st_title=\""+ url +"\" displayText='Facebook'></span>"); %>
               <% out.println("<span class='st_twitter_large' displayText='Tweet'></span>"); %>
               <% out.println("<span class='st_linkedin_large' st_title=\""+url+"\" displayText='LinkedIn'></span>"); %>
               <% out.println("<span class='st_email_large' st_title=\""+url+"\" displayText='Email'></span>"); %>
               <% out.println("<span class='st_googleplus_large' st_title=\""+url+"\" displayText='Google +'></span>"); %>

      </div>
    </div>

    <div id="slider">

      <a href="" onclick="return false;">
        <div id="left">
        </div>
      </a>

      <a href="" onclick="return false;">
        <div id="right">
        </div>
      </a>

      <div id="wrapper">
        <a href="" onclick="return false;">
          <div id="menu">
            <div id="share_link"></div>
            <div id="options_link"></div>
          </div>
        </a>
          <div id="menu2">
              <% if(email!=null){ 
                    if(l.equals("ita")){
              out.println("<a href=\"modify_book.jsp?id_book="+id_book+"\"><div class=\"menu2_button\" style=\"background-image:url(images/menu/mod_b_ita.jpg)\"></div></a>");
            %>
            <a href="my_book.jsp"><div class="menu2_button" style="background-image:url(images/menu/my_b_ita.jpg)"></div></a>
            <%      } else {
              out.println("<a href=\"modify_book_eng.jsp?id_book="+id_book+"\"><div class=\"menu2_button\" style=\"background-image:url(images/menu/mod_b_eng.jpg)\"></div></a>");            
            %>
            <a href="my_book_eng.jsp"><div class="menu2_button" style="background-image:url(images/menu/my_b_eng.jpg)"></div></a>            
                  <%  }} 
            
            out.println("<a href=\"PDF.jsp?id_book="+id_book+"&lan="+l+"\"><div class=\"menu2_button\" style=\"background-image:url(images/menu/download.jpg)\"></div></a>");
            
            if(l.equals("ita")){ 
               out.println("<a href=\"book.jsp?idb="+hid_book+"&l=eng\"><img src=\"images/flag_eng.jpg\" style=\"width: 25px; height: 15px; margin-left: 62px; margin-top: 10px;\"></a>");
           }else{
               out.println("<a href=\"book.jsp?idb="+hid_book+"&l=ita\"><img src=\"images/flag_ita.jpg\" style=\"width: 25px; height: 15px; margin-left: 62px; margin-top: 10px;\"></a>");
           }
              %>
          </div>
        <ul>
            
            <li style="background-color: #333; background-image: url(images/<% if(l.equals("ita")) out.println("finalIT.jpg");else out.println("finalEN.jpg"); %>); background-repeat: no-repeat; background-size: contain; background-position: center;">
          </li>
          <%
            for(int i=b.getMyWorks().size()-1;i>=0;i--){
                Workbook w=b.getMyWorks().get(i);
                out.println("<li><div class=\"tmp_content\"><p class=\"tmp_title\">"+w.getTitle()+"</p>");
                if(w.getAuthor()!=null){
                    out.println("<p class=\"tmp_author\">- "+w.getAuthor()+"</p>");
                }else{
                    out.println("<p class=\"tmp_author\"> </p>");
                }
                if(l.equals("ita")){
                out.println("<p class=\"tmp_description\">"+w.getDescription()+"</p>");}
                else{out.println("<p class=\"tmp_description\">"+w.getDescriptionEng()+"</p>");}
                if(!w.getComment().equals("null")){
                    if(l.equals("ita")){
                        out.println("<p class=\"tmp_comment\">Commento:    "+w.getComment()+"</p>");}else{
                        out.println("<p class=\"tmp_comment\">Comment:    "+w.getComment()+"</p>");}}
                out.println("</div>");
                out.println("<div class=\"tmp_image_wrapper\">");
              //  System.out.println("__________________"+w.getURLworkIMG1());
                out.println("<div class=\"tmp_image\" style=\"background-image: url(imagesExhibition/"+w.getURLimg1()+")\"></div>");
                if(!w.getURLworkIMG1().equals("null")){
                out.println("<div class=\"tmp_image\" style=\"background-image: url(userPhoto/"+w.getURLworkIMG1()+")\"></div>");}
                if(!w.getURLworkIMG2().equals("null")){
                out.println("<div class=\"tmp_image\" style=\"background-image: url(userPhoto/"+w.getURLworkIMG2()+")\"></div>");}
                out.println("</div></li>");
              }
          %>
         
          <li>
            <div id="cover_content">
              <p id="cover_title">
                <% out.println(b.getTitle()); %>
              </p>
              <p id="cover_description">
                <% out.println(b.getDescription()); %>
              </p>
            </div>
            <div id="cover_image_wrapper">
              <div id="cover_image" style="background-image: url(userPhoto/<% out.println(b.getCover()); %>)">
              </div>
            </div>
          </li>
        </ul>

      </div>
    </div>
    
  </body>
</html>