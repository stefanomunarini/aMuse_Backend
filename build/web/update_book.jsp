<%-- 
    Document   : update_jsp
    Created on : Apr 16, 2013, 4:38:52 PM
    Author     : Babol
--%>

<%@page language="Java" import="LibraryAMuse.*"%>

<% 
   int id_book=Integer.parseInt(request.getParameter("id_book"));
   String len=request.getParameter("len");
   if(request.getParameter("update")!=null){//se ho premuto update
        String title= request.getParameter("title");
        String description= request.getParameter("description"); 
        if(title==""){
            title="TITOLO DA INSERIRE";
        }
        //modifico descrizione e titolo del book
        DBconnection.EditBook(title, description, id_book);
        
   } else if (request.getParameter("comment_button")!=null){ //se ho premuto aggiungi commento
        int id_work = Integer.parseInt(request.getParameter("id_work"));
        String comment=request.getParameter("comment");
        if(comment.equals("")) comment="null";
        //metodo per aggiungere commento
        DBconnection.InsertWorksbookComment(comment, id_book, id_work);
    }
   
   if(len.equals("ita")) response.sendRedirect("modify_book.jsp?id_book="+id_book); 
    else response.sendRedirect("modify_book_eng.jsp?id_book="+id_book); 

%>
