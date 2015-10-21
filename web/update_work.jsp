<%-- 
    Document   : update_work
    Created on : 16-mag-2013, 17.44.00
    Author     : Fede
--%>

<%@page language="Java" import="LibraryAMuse.*"%>
<%
    String email = "";
    email = (String) session.getAttribute("email");
    if(!(email.equals("admin@admin.it"))){
        response.sendRedirect("index.jsp");
    }   

    String id_work=request.getParameter("id_work");
    Work w=DBconnection.SearchWork(Integer.parseInt(id_work));
    
    String title=request.getParameter("title");
    String description=request.getParameter("description");
    String description_eng=request.getParameter("description_eng");
    String genre=request.getParameter("genre");
    String author=request.getParameter("author");
    DBconnection.EditWork(Integer.parseInt(id_work), title,author,genre, description, description_eng);
    
    response.sendRedirect("modify_work.jsp?id_work="+id_work+"&id_ex="+w.getIdExhibition());

%>