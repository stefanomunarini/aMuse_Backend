<%-- 
    Document   : modify_exhibition
    Created on : 6-mag-2013, 23.48.44
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
         <style type="text/css">
            input[type='radio'] {
                display: none;
               }
        </style>
    </head>
    <body>
        <%
            int id_ex=0;
            ListWorks lstWork = null;
            Exhibition ex=null;
            if(request.getParameter("IDEH") == null){
                response.sendRedirect("admin.jsp");
                return;
            }else{
                id_ex= Integer.parseInt(request.getParameter("IDEH"));   
                ex=DBconnection.SearchSingleExhibition(id_ex); 
                lstWork=ex.getListWorks();
            }
        %>
       
        <br>
        <a href="admin.jsp" style="position:absolute; margin-left: 138px; padding:5px; border: 2px solid; border-color: #660000; ">TORNA INDIETRO</a>
        <div class="conteiner">
            <div id="campi">
                <p style="text-align: center; margin-bottom: 20px; font-size: 20px;">MODIFICA CAMPI MOSTRA:</p>
                <form action="update_exhibition.jsp">
                    <input type="text" style="visibility: hidden; position: absolute;" name="id_ex" value="<% out.println(id_ex); %>">
                <div class="riga"><p class="campo">TITOLO</p> <input class="text" type="text" name="title" autocomplete="off" value="<% out.println(ex.getTitle()); %>"></div>
                <div class="riga"><p class="campo">TITOLO INGLESE</p> <input class="text" type="text" name="title_eng" autocomplete="off" value="<% out.println(ex.getTitle_eng()); %>"></div>
                <div class="riga"><p class="campo">DESCRIZIONE</p> <input class="text" type="text" name="description" autocomplete="off"  value="<% out.println(ex.getDescription()); %>"></div>
                <div class="riga"><p class="campo">DESCRIZIONE INGLESE</p> <input class="text" type="text" name="description_eng" autocomplete="off"  value="<% out.println(ex.getDescription_eng()); %>"></div>
                <div class="riga"><p class="campo">DATA INIZIO (aaaa-mm-gg)</p> <input class="text" type="text" name="start_date" autocomplete="off"  value="<% out.println(ex.getStartDate()); %>"></div>
                <div class="riga"><p class="campo">DATA FINE (aaaa-mm-gg)</p> <input class="text" type="text" name="end_date" autocomplete="off"  value="<% out.println(ex.getEndDate()); %>"></div>
                <input class="bottone" type="submit" name="save" value="SALVA">        
                </form>
            </div>
            <div id="img_wrapper">
                <div class="img" style="background-image: url(imagesExhibition/<% out.println(ex.getImg1());%>);"></div>
                <form name="uploadForm" action="upload_img_ex"  enctype="multipart/form-data" method="post">
                    <input type="text" style="visibility: hidden; position: absolute;" name="id_ex" value="<% out.println(id_ex); %>">
                    <input style="margin: 10px;" type="file" name="file">
                    <input class="bottone" type="submit" name="change" value="CAMBIA">        
                </form>
            </div>
                    <div style="clear: both"></div> 
        </div>
        <div class="conteiner">
            <div style="text-align:left; width: 600px; float:left;">                
                <p style=" margin: 0 auto; text-align: center; font-size: 20px; margin-top: 20px;"> OPERE:</p><br>
                <%
                        for(Work w : lstWork){
                            out.println("<form action=\"modify_work.jsp\" style=\"display:inline-block; margin-bottom:10px;\"><input type=\"radio\" name=\"id_work\" checked value=\""+w.getIdWork()+"\"/> <label style=\"width: 300px; text-align:center; display:inline-block;\"> "+w.getTitle()+"</label>");                        
                            out.println("<input type=\"submit\" name=\"modify_work\" value=\"MODIFICA OPERA\"></form>");
                            out.println("<form action=\"delete_work.jsp\" style=\"display:inline-block; margin-bottom:10px;\"><input type=\"radio\" name=\"id_work\" checked value=\""+w.getIdWork()+"\"/>");                        
                            out.println("<input type=\"submit\" name=\"delete_work\" value=\"ELIMINA OPERA\"></form><br>");
                        }
                %>
            </div>
            <div style="float:right; width:400px; text-align:center; margin-top:20px;">
               <p style="font-size: 20px;">AGGIUNGI OPERA:</p><br>
               <form action="insert_work.jsp">
                    <input type="text" style="visibility: hidden; position: absolute;" name="id_ex" value="<% out.println(id_ex); %>">
                    <div class="riga2"><p class="campo2">TITOLO</p> <input class="text2" type="text" name="title" autocomplete="off" value=""></div>
                    <div class="riga2"><p class="campo2">AUTORE</p> <input class="text2" type="text" name="author" autocomplete="off" value=""></div>
                    <div class="riga2"><p class="campo2">GENERE</p> <input class="text2" type="text" name="genre" autocomplete="off" value=""></div>
                    <div class="riga2"><p class="campo2">DESCRIZIONE</p> <input class="text2" type="text" name="description" autocomplete="off"  value=""></div>
                    <div class="riga2"><p class="campo2">DESCRIZIONE INGLESE</p> <input class="text2" type="text" name="description_eng" autocomplete="off"  value=""></div>
                    <input class="bottone" type="submit" name="insert_work" value="SALVA">        
                </form>
            </div>
                    <div style="clear: both"></div> 
        </div>
    </body>
</html>