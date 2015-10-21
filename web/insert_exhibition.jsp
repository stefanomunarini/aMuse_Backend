<%-- 
    Document   : update_jsp
    Created on : Apr 16, 2013, 4:38:52 PM
    Author     : Babol
--%>

<%@page language="Java" import="LibraryAMuse.*"%>
<%@page import="java.sql.Date"%>

<% 
    
    String email = "";
    email = (String) session.getAttribute("email");
    if(!(email.equals("admin@admin.it"))){
        response.sendRedirect("index.jsp");
    }
    
    if(request.getParameter("save")!=null){
    
   String title= request.getParameter("title");
   String description= request.getParameter("description"); 
   String title_eng= request.getParameter("title_eng");
   String description_eng= request.getParameter("description_eng"); 
   String startDate= request.getParameter("start_date");
   String endDate= request.getParameter("end_date"); 
   ListWorks lwb=new ListWorks();
   if(startDate.equals("")) startDate="0001-01-01";
   if(endDate.equals("")) endDate="0001-01-01";
   int id_seguente = DBconnection.NewIdExhibition();
   Exhibition ex = new Exhibition(id_seguente,title,description,title_eng,description_eng,Date.valueOf(startDate),Date.valueOf(endDate),"",lwb);
   
   DBconnection.InsertExhibition(ex);
   response.sendRedirect("modify_exhibition.jsp?IDEH="+id_seguente);  
}
%>
