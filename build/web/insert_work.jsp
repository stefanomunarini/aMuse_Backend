<%-- 
    Document   : update_jsp
    Created on : Apr 16, 2013, 4:38:52 PM
    Author     : Babol
--%>

<%@page language="Java" import="LibraryAMuse.*"%>

<% 
    
    
    String email = "";
    email = (String) session.getAttribute("email");
    if(!(email.equals("admin@admin.it"))){
        response.sendRedirect("index.jsp");
    }
    
    
    if(request.getParameter("insert_work")!=null){
    
   int id_work = DBconnection.NewIdWork();
   int id_ex= Integer.parseInt(request.getParameter("id_ex"));
   String title= request.getParameter("title");
   String author= request.getParameter("author");
   String genre= request.getParameter("genre");
   String description = request.getParameter("description");
   String description_eng = request.getParameter("description_eng"); 
   Work w = new Work(id_work,id_ex,title,description,description_eng,author,genre,"","","");
   DBconnection.InsertWork(w);
   
   response.sendRedirect("modify_work.jsp?id_work="+id_work+"&id_ex="+id_ex);  
}
%>
