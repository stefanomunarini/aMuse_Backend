<%-- 
    Document   : modify_work
    Created on : 16-mag-2013, 17.18.48
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="LibraryAMuse.*" %>

<!DOCTYPE html>
<html>
    <head>
    <meta charset="ISO-8859-1">
        <link rel="shortcut icon" href="am.ico" />
        <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'/>
        <link href='http://fonts.googleapis.com/css?family=Noto+Sans' rel='stylesheet' type='text/css'/>
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'/>
        <title>aMuse</title>
        <link rel="stylesheet" type="text/css" href="css/admin.css" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
        
    </head>
    <body>
        <%
             int id_work= Integer.parseInt(request.getParameter("id_work"));   
             Work w=DBconnection.SearchWork(id_work);             
        %>
       
        <br>
        <% out.println("<a href=\"modify_exhibition.jsp?IDEH="+w.getIdExhibition()+"\" style=\"position:absolute; margin-left: 138px; padding:5px; border: 2px solid; border-color: #660000; \">TORNA INDIETRO</a>"); %>
        
        <div class="conteiner">
            <div id="campi">
                <p style="text-align: center; margin-bottom: 20px; font-size: 20px;">MODIFICA CAMPI OPERA:</p>
                <form action="update_work.jsp">
                    <input type="text" style="visibility: hidden; position: absolute;" name="id_work" value="<% out.println(id_work); %>">
                    <div class="riga2"><p class="campo2">TITOLO</p> <input class="text2" type="text" name="title" autocomplete="off" value="<% out.println(w.getTitle()); %>"></div>
                    <div class="riga2"><p class="campo2">AUTORE</p> <input class="text2" type="text" name="author" autocomplete="off" value="<% out.println(w.getAuthor()); %>"></div>
                    <div class="riga2"><p class="campo2">GENERE</p> <input class="text2" type="text" name="genre" autocomplete="off" value="<% out.println(w.getGenre()); %>"></div>
                    <div class="riga2"><p class="campo2">DESCRIZIONE</p> <input class="text2" type="text" name="description" autocomplete="off"  value="<% out.println(w.getDescription()); %>"></div>
                    <div class="riga2"><p class="campo2">DESCRIZIONE INGLESE</p> <input class="text2" type="text" name="description_eng" autocomplete="off"  value="<% out.println(w.getDescriptionEng()); %>"></div>
                    <input class="bottone" type="submit" name="update_work" value="SALVA">        
                </form>
            </div>
            <div id="img_wrapper">
                <div class="img" style="background-image: url(imagesExhibition/<% out.println(w.getURLimg1());%>);"></div>
                <form name="uploadForm" action="upload_img_work"  enctype="multipart/form-data" method="post">
                    <input type="text" style="visibility: hidden; position: absolute;" name="id_work" value="<% out.println(id_work); %>">
                    <input type="text" style="visibility: hidden; position: absolute;" name="id_ex" value="<% out.println(w.getIdExhibition()); %>">
                    <input style="margin: 10px;" type="file" name="file">
                    <input class="bottone" type="submit" name="change_work" value="CAMBIA">        
                </form>
            </div>
                    <div style="clear: both"></div> 
        </div>
        
    </body>
</html>