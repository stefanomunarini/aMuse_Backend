<%-- 
    Document   : my_book
    Created on : Apr 16, 2013, 1:04:09 PM
    Author     : Babol
--%>
<%-- 
    Document   : my_book
    Created on : Apr 16, 2013, 1:04:09 PM
    Author     : Babol
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
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
    <script type="text/javascript" src="scripts/layout.js"></script>
  </head>
  <body>
    <div id="red_line">
      <div id="red_line_wrapper">
          
                <a href="my_book.jsp"><img src="images/flag_ita.jpg" style="width: 25px; height: 15px; float: right; margin-top: 5px; margin-left: 10px;">
                </a> 
          <a id="go_back_logout" href="logout.jsp">LOGOUT</a>
      </div>
    </div>
    <% 

            String email = "";
            email = (String) session.getAttribute("email");
            String cmail = AmuseGuest.encripted(email);
            ArrayList<Book> alb = DBconnection.SearchMyBooks(email);
    
    %>
    <div id="top_wrapper">
      <div id="title_area"><p id="title">MY BOOKS</p></div>
      <div id="logo_area">
          <img src="images/logo.jpg" alt="aMuse" height="62" width="229">
      </div>
      <div id="separator"></div>
    </div>
    <div id="content_wrapper">
        <%
             for(Book b: alb){
                  out.println ( "<div class=\"book\">");
                  out.println("<div class=\"button_gestion\">");
                  out.println ("<a href=\"book.jsp?idb=" + AmuseGuest.encripted(Integer.toString(b.getIDBook())) + "&l=eng\"><div class=\"view_button\">VIEW</div></a>");                  
                  out.println ("<a href=\"modify_book_eng.jsp?id_book=" + b.getIDBook() + "\"><div class=\"modify_button\">MODIFY</div></a>");
                  out.println ("</div>");
                  out.println("<div class=\"book_name\"><h1 class=\"book_title\">" + b.getTitle() + "</h1></div>");
                  out.println ("<div class=\"image_exhibition\" style=\"background-image: url(userPhoto/"+ b.getCover() +");\"></div>");
                  out.println("</div>");
            }
         
                %>
    </div>

    
    
  </body>
</html>


