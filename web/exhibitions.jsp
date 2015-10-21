<%-- 
    Document   : exhibitions
    Created on : 13-apr-2013, 12.17.40
    Author     : Fede
--%>
<%-- 
    Document   : exhibitions
    Created on : 13-apr-2013, 12.17.40
    Author     : Fede
--%>

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
    <link rel="stylesheet" type="text/css" href="css/layout.css" />
    <link rel="stylesheet" type="text/css" href="css/slider.css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
    <script type="text/javascript" src="scripts/layout.js"></script>
    <script type="text/javascript" src="scripts/slider.js"></script>
  </head>
  <body>
      <% String email=(String)session.getAttribute("email"); 
        if(!email.equals("root@root.it")){}else{
      %>
      
      <div id="red_line">
        <div id="red_line_wrapper">
          <div class="guide_shadow">
          </div>
         <a href="exhibitions_eng.jsp"><img src="images/flag_eng.jpg" style="width: 25px; height: 15px; float: right; margin-top: 5px; margin-left: 10px;">
         </a>
        </div>
      </div>
      
      <div id="top_wrapper">
        <div class="guide">
          <p class="guide_number">1</p>
          <p class="guide_text">Scegli una mostra per il tuo book</p>
        </div>
          <div id="title_area"><p id="title">CREA IL TUO BOOK</p></div>
        <div id="logo_area"><img src="images/logo.jpg" alt="aMuse" height="62" width="229"></div>
        <div id="separator"></div>
      </div>
      
      <% 
          ArrayList<Exhibition> lstEx = DBconnection.ActiveExhibition();    
          ArrayList<Exhibition> lstEx2 = DBconnection.ActiveExhibition();         
          
      %>
      
      <div id="content_wrapper">
        <div id="slider_wrapper">
            <div id="left"></div>
            <div id="right"></div>
            <div id="thumbs">
              <ul id="thumbs_ul">
                  <% 
                      for (Exhibition ex : lstEx ){
                          out.println("<a href=\"CreateBook.jsp?IDEH="+ex.getID()+"\"><li onclick=\"\"style=\"background-image: url(imagesExhibition/"+ex.getImg1()+")\"></li></a>");
                      }
                  %>
              </ul>
            </div>
            <div id="slide">

              <ul id="slide_ul">
                  <%
                      for (int i=0; i<lstEx2.size();i++ ){
                         Exhibition ex=lstEx2.get(i);
                         out.println("<a href=\"CreateBook.jsp?IDEH="+ex.getID()+"\">");
                         out.println("<li style=\"background-image: url(imagesExhibition/"+ex.getImg1()+")\">");
                         out.println("<p class=\"title\">"+ex.getTitle()+"</p>");
                         out.println("<p class=\"description\">"+ex.getDescription()+"</p>");
                         out.println("</li></a>");
                      }
                  %>
              </ul>
            </div>
          </div>

        </div>
              <% } %>
      </body>
    </html>