<%-- 
    Document   : update_exhibition
    Created on : 15-mag-2013, 4.15.07
    Author     : Fede
--%>

<%@page language="Java" import="LibraryAMuse.*"%>
<%
        String email = "";
        email = (String) session.getAttribute("email");
        if(!(email.equals("admin@admin.it"))){
            response.sendRedirect("index.jsp");
        }   

    String id_ex=request.getParameter("id_ex");
    String title=request.getParameter("title");
    String title_eng=request.getParameter("title_eng");
    String description=request.getParameter("description");
    String description_eng=request.getParameter("description_eng");
    String startDate=request.getParameter("start_date");
    String endDate=request.getParameter("end_date");
    DBconnection.EditExhibition(Integer.parseInt(id_ex), title, description, title_eng, description_eng, startDate, endDate);
    response.sendRedirect("modify_exhibition.jsp?IDEH="+id_ex);


%>