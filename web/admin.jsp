<%-- 
    Document   : admin
    Created on : May 3, 2013, 5:52:25 PM
    Author     : Babol
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
        <script type="text/javascript" src="scripts/layout.js"></script>
        <script type="text/javascript" src="scripts/popup.js"></script>
    </head>
    <body>
        <% 
           
            
            String email = "";
            email = (String) session.getAttribute("email");
            if(!(email.equals("admin@admin.it"))){
                response.sendRedirect("index.jsp");
            }   
            ListExhibition lex=DBconnection.AllExhibition();
        %>
        <br>
        <a href="logout.jsp" style="position:absolute; margin-left: 138px; padding:5px; border: 2px solid; border-color: #660000;">LOGOUT</a>
        <div class="conteiner">
            <div class="contenitore">
                <p style="text-align: center; margin-bottom: 20px; font-size: 16px;"> MODIFICA MOSTRA: </p>
                <form action="modify_exhibition.jsp"><div style="text-align: left; width: 150px; margin:0 auto; margin-top: 10px; margin-bottom: 10px;">
                <%
                    for(Exhibition ex: lex){
                        out.println("<input type=\"radio\" name=\"IDEH\" value=\""+ex.getID()+"\"/>  "+ex.getTitle()+"<br>");
                    }
                %>
                </div>
                <input class="bottone" type="submit" value="MODIFICA" name="modify">
                </form>
            </div>
            <div class="contenitore">
                <p style="text-align: center; margin-bottom: 20px; font-size: 16px;">ELIMINA MOSTRA: </p>
                <form action="delete_exhibition.jsp"><div style="text-align: left; width: 150px; margin:0 auto; margin-top: 10px; margin-bottom: 10px;">
                <%
                    for(Exhibition ex: lex){
                        out.println("<input type=\"radio\" name=\"IDEH\" value=\""+ex.getID()+"\"/>  "+ex.getTitle()+"<br>");
                    }
                %>
                </div>
                <input class="bottone" type="submit" value="ELIMINA" name="delete">
                </form>
            </div>
            <div class="contenitore" style="width: 520px;">
                <p style="text-align: center; margin-bottom: 20px; font-size: 16px;"> AGGIUNGI MOSTRA: </p>
                <div id="campi">
                    <form action="insert_exhibition.jsp">
                    <div class="riga"><p class="campo">TITOLO</p> <input class="text" type="text" name="title" autocomplete="off" value=""></div>
                    <div class="riga"><p class="campo">TITOLO INGLESE</p> <input class="text" type="text" name="title_eng" autocomplete="off" value=""></div>
                    <div class="riga"><p class="campo">DESCRIZIONE</p> <input class="text" type="text" name="description" autocomplete="off"  value=""></div>
                    <div class="riga"><p class="campo">DESCRIZIONE INGLESE</p> <input class="text" type="text" name="description_eng" autocomplete="off"  value=""></div>
                    <div class="riga"><p class="campo">DATA INIZIO (aaaa-mm-gg)</p> <input class="text" type="text" name="start_date" autocomplete="off"  value=""></div>
                    <div class="riga"><p class="campo">DATA FINE (aaaa-mm-gg)</p> <input class="text" type="text" name="end_date" autocomplete="off" value=""></div>
                    <input class="bottone" type="submit" name="save" value="SALVA">        
                    </form>
                </div>
            </div>
            <div style="clear: both"></div> 
        </div>
    </body>
</html>
