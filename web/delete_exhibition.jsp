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
            
            if(request.getParameter("IDEH")==null){
                response.sendRedirect("admin.jsp");
                return;
            }else{
                if(request.getParameter("delete")!=null){
                    int id_ex= Integer.parseInt(request.getParameter("IDEH"));   
                    Exhibition ex=DBconnection.SearchSingleExhibition(id_ex);
                    String d=request.getParameter("delete");
                    if(d.equals("yes")){
                        DBconnection.deleteExhibition(id_ex);
                        response.sendRedirect("admin.jsp");
                    }
                    out.println("Sei sicuro di voler eliminare la mostra \""+ex.getTitle()+"\"?<br>");
                    out.println("Verranno eliminate anche le relative opere<br><br>");
                    out.println("<a style=\"margin:60px;\" href=\"delete_exhibition.jsp?IDEH="+id_ex+"&delete=yes\">ELIMINA</a>");
                    out.println("<a style=\"margin:60px;\" href=\"admin.jsp\">INDIETRO</a>");
                }
            }

        
        %>
        </div>
    </body>
</html>
