<%-- 
    Document   : login_control
    Created on : 15-apr-2013, 16.32.04
    Author     : Fede
--%>

<%@page language="Java" import="LibraryAMuse.*"%>

<% if(request.getParameter("button_login")!=null){
    String email= request.getParameter("usermail");
   String psw= request.getParameter("password"); 
   System.out.println(email);
   String url="";
   int control=DBconnection.LoginControl(email, psw);
   if(control==0){
       if(email.equals("root@root.it")) {
           url="exhibitions.jsp";
           session.setAttribute("email", email);
       }
       else if(email.equals("admin@admin.it")) {
           url="admin.jsp";
           session.setAttribute("email", email);
       }
       else {
           url="my_book.jsp";
           session.setAttribute("email", email);
       }
   }
   if(control==1){url="index.jsp?Error=true";}
   if(control==2){url="aaa";} 
   response.sendRedirect(url);
  
}
%>