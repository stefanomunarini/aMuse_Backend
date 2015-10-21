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
        window.location = 'exhibitions.jsp' 
        } 
        
    </script>
    
    </head>
    
    <body onload="time=setTimeout('move()',4000)">
        
        <div id="message_confirmation">
        
    
            
        <% 
            String email= request.getParameter("user_email");
            String selected_work= request.getParameter("user_selected");
            
            
            //CREA L'ARRAY DALLA STRINGA
            String[] string_array=selected_work.split(",");
            ArrayList<Integer> int_array= new ArrayList<Integer>();
            for(int i=0;i<string_array.length;i++){
                int_array.add(Integer.parseInt(string_array[i]));
                //   out.println(int_array[i]+"<br>");
            }

            String password=AmuseGuest.generatePsw(email);
            
            int find = DBconnection.MailControl(email);
            if(find==0){
                
            //INSERISCE L'UTENTE NEL DATABASE
                DBconnection.InsertUser(email, password);
              //  out.println("utente inserito");
            }
            
            
            int id_book=DBconnection.NewIDBook();
            //INSERISCE IL BOOK NEL DATABASE
            Book bk = new Book(email, id_book,"TITOLO DA INSERIRE", "DESCRIZIONE DA INSERIRE","cover_default.jpg", new ListWorksbook());
            DBconnection.InsertBook(bk);
            
            //INSERISCE I WORKBOOK
            for(int i=0;i<int_array.size();i++){
                Workbook wb = new Workbook(bk.getIDBook(),int_array.get(i)," "," "," "," "," "," ","null","null","null");
                DBconnection.InsertBookElement(wb);
            }
            
            //aggiorna la password
            String pass=DBconnection.FindPassword(email);
            
            //INVIA L'EMAIL
            boolean send=AmuseGuest.WebSendMail(email, pass, "www.aMuse.it","ita");
                
            
        %>
         
        
            <br/>
            <h1>Il tuo book è stato creato</h1>
            <h3>Controlla la tua email per visualizzarlo</h3>
            
           </div>
    </body>
</html>