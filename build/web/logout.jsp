<%-- 
    Document   : logout
    Created on : Apr 22, 2013, 3:07:46 PM
    Author     : Babol
--%>

<%@page language="Java" import="LibraryAMuse.*"%>

<% 
    session.invalidate();
    response.sendRedirect("index.jsp");
    
%>
