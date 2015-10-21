<%-- 
    Document   : PDF
    Created on : May 10, 2013, 1:28:32 PM
    Author     : Babol
--%>

<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.File"%>
<%@page import="LibraryAMuse.DBconnection"%>
<%@page import="LibraryAMuse.Book"%>
<%@page import="LibraryAMuse.GeneratePDF"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
      
        <%
            int id_book=Integer.parseInt(request.getParameter("id_book"));
            request.getHeader("Referer");
            String lan = request.getParameter("lan");
            Book bk = DBconnection.SearchBookElements(id_book);
            GeneratePDF.generate(bk,lan);

            File n;
            String FileName="/Users/Babol/Desktop/dVruhero/aMuseWebsite/build/web/pdfUser/"+bk.getTitle()+".pdf";
            File fichero = new File(FileName);

            OutputStream outStream = response.getOutputStream(); 
            BufferedInputStream fileInput= new BufferedInputStream(new FileInputStream(fichero)); 
            response.setContentType("application/pdf"); 
            response.setHeader("Content-Disposition","attachment;filename="+bk.getTitle());

            byte [] arrayBytes = null; 
            int data; 
            int length = (int)fichero.length();
            arrayBytes = new byte[length];
            
            while((data = fileInput.read(arrayBytes, 0,arrayBytes.length))!=-1) { 
                outStream.write(arrayBytes, 0, data); 
            }
            
            fileInput.close(); 
            outStream.close(); 
            
            response.sendRedirect(request.getHeader("Referer"));
        %>
    </body>
</html>
