<%-- 
    Document   : newjsp
    Created on : 9-apr-2013, 15.16.30
    Author     : Fede
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="LibraryAMuse.*" %> 
<%@ page import="sun.net.smtp.SmtpClient, java.io.*" %>


<!DOCTYPE html>


<html>
    <head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="am.ico" />
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'/>
    <link href='http://fonts.googleapis.com/css?family=Noto+Sans' rel='stylesheet' type='text/css'/>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'/>
    <title>aMuse</title>
    <link rel="stylesheet" type="text/css" href="css/confirmation_layout.css" />
    
    <script type="text/javascript"> 
        
        var time = null 
        function move() { 
        window.location = 'index.jsp' 
        } 
        
    </script>
    
    </head>
    
    <body onload="time=setTimeout('move()',3000)">
        
        <div id="message_confirmation">
        
    
            
        <% 
            String email= request.getParameter("user_email");
            
            
            int find = DBconnection.MailControl(email);
            if(find==0){ //vuol dire che non esiste
            
                out.println("<h2>Utente non trovato.</h2>");
            }else{ //l'email esiste
            //trova la password
            String pass=DBconnection.FindPassword(email);
            //INVIA L'EMAIL
            boolean send=AmuseGuest.WebSendPassMail(email, pass, "www.aMuse.it");
             
            out.println("<h1>Email inviata</h1>");
            out.println("<h3>I tuoi dati di accesso ti sono stati mandati per email.</h3>");
            }
        %>
         

           </div>
    </body>
</html>