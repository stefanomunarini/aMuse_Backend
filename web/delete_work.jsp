<%-- 
    Document   : update_jsp
    Created on : Apr 16, 2013, 4:38:52 PM
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
    </head>
    <body>
        <div style="margin: 150px; font-size: 30px;">
        <% 
            String email = "";
            email = (String) session.getAttribute("email");
            if(!(email.equals("admin@admin.it"))){
                response.sendRedirect("index.jsp");
            }
            
            if(request.getParameter("delete_work")!=null){
    
            int id_work= Integer.parseInt(request.getParameter("id_work"));   
            Work w=DBconnection.SearchWork(id_work);
            String d=request.getParameter("delete_work");
            if(d.equals("yes")){
                DBconnection.deleteWork(id_work);
                response.sendRedirect("modify_exhibition.jsp?IDEH="+w.getIdExhibition());
                
            }
            out.println("Sei sicuro di voler eliminare l'opera \""+w.getTitle()+"\"?<br><br>");
            out.println("<a style=\"margin:60px;\" href=\"delete_work.jsp?id_work="+id_work+"&delete_work=yes\">ELIMINA</a>");
            out.println("<a style=\"margin:60px;\" href=\"modify_exhibition.jsp?IDEH="+w.getIdExhibition()+"\">INDIETRO</a>");
             
   
}
%>
        </div>
    </body>
</html>
