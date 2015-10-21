<%-- 
    Document   : delete_photo
    Created on : May 14, 2013, 1:22:08 PM
    Author     : Babol
--%>

<%@page language="Java" import="LibraryAMuse.*"%>

<% 
    /*
        String email = "";
        email = (String) session.getAttribute("email");
        if(!(email.equals("admin@admin.it"))){
            response.sendRedirect("index.jsp");
        }
    */
    String id_work=request.getParameter("idw");
    String id_book=request.getParameter("idb");
    String name=request.getParameter("name");
    String v=request.getParameter("v");
    if(v.equals("1")) DBconnection.EditWorksbookUserImg(1,"null",name, Integer.parseInt(id_book), Integer.parseInt(id_work));
    else DBconnection.EditWorksbookUserImg(2,name,"null", Integer.parseInt(id_book), Integer.parseInt(id_work));
    response.sendRedirect(request.getHeader("Referer")); 
%>  