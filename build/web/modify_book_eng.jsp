<%-- 
    Document   : modify_book
    Created on : Apr 16, 2013, 9:59:19 AM
    Author     : Babol
--%>



<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="LibraryAMuse.*" %> 
<%@page import="java.util.*"%>

<!DOCTYPE html>

<html>
    <head>
    <meta charset="ISO-8859-1">
    <link rel="shortcut icon" href="am.ico" />
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'/>
    <link href='http://fonts.googleapis.com/css?family=Noto+Sans' rel='stylesheet' type='text/css'/>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'/>
    <title>aMuse</title>
    <link rel="stylesheet" type="text/css" href="css/layout.css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
    <script type="text/javascript" src="scripts/layout.js"></script>
    <script type="text/javascript" src="scripts/popup.js"></script>
    </head>
  
    <body>
        <%
            
            int id_book=Integer.parseInt(request.getParameter("id_book"));
            String id_work=request.getParameter("id_work");
            String add=request.getParameter("add");
            String email=(String)session.getAttribute("email");            
            Book bk=DBconnection.SearchBookElements(id_book);
            String cmail=AmuseGuest.encripted(email);
            int rr = 0;
            %>
        
        
        <div id="modify_popup">
                <div id="modify_box">
                    <div style="width: 100%; height: 0px;"><div class="ics"></div></div>

                    <form action="update_book.jsp" method="post">
                    <div id="modify_box_up">
                      <p class="popup_email_text">Insert title</p>
                      <% out.println("<textarea class=\"title_book\" name=\"title\" maxlength=\"25\">"+bk.getTitle()+"</textarea>"); %>
                      <p class="popup_email_text">Insert description</p>
                      <% out.println("<textarea class=\"popup_description\" name=\"description\" maxlength=\"200\" >"+bk.getDescription()+"</textarea>"); %>
                      <input class="exhibition" type="text" name="id_book" value="<% out.println(id_book); %>">
                      <input type="text" style="visibility:hidden; position:absolute;"  name="len" value="eng">
                   </div>
                   <div id="modify_box_down">
                    <input type="submit" class="button_update" name="update" value="EDIT">
                   </div>
                 </form>

                </div>
                
        </div>
         <div id="cover_popup">      
            <div id="cover_box">
                <div style="width: 100%; height: 0px;"><div class="ics"></div></div>
                <form name="uploadForm" action="upload_cover"  enctype="multipart/form-data" method="post">
                    <div id="cover_box_up">
                        <p class="popup_email_text">Change cover</p>
                        <div class="cover_img" style="background-image: url(userPhoto/<% out.println(bk.getCover());%>);"></div>
                        <input type="text" style="visibility:hidden;" name="id_book" value="<% out.println(bk.getIDBook()); %>">
                        <input type="text" style="visibility:hidden; position:absolute;"  name="len" value="eng">
                        <div class="choose"><input type="file" name="file"></div>
                        
                    </div>
                    <div id="cover_box_down">
                        <input type="submit" class="button_update" name="update" value="CHANGE COVER">
                    </div>
                </form>
            </div>
          </div>
             
        <% if((id_work!=null)&&(add.equals("comm"))){ 
              Workbook w=DBconnection.SearchWorkbook(Integer.parseInt(id_work), id_book);              
        %>
        <div id="comment_popup">
            <div id="comment_box">
                <div style="width: 100%; height: 0px;"><div class="ics"></div></div>

                <form action="update_book.jsp" method="post">
                <div id="comment_box_up">                       
                  <p class="popup_email_text">Comment the work<br/>
                                           <i>"<% out.println(w.getTitle());%>"</i><br/></p>
                  <textarea id="comment" class="popup_description" autofocus name="comment" style="margin-top:20px; width: 300px;" maxlength="100"><% if(!w.getComment().equals("null"))out.println(w.getComment());  %></textarea>
                  <input type="text" style="visibility:hidden; position:absolute;"  name="id_work" value="<% out.println(id_work); %>">
                  <input type="text" style="visibility:hidden; position:absolute;" name="id_book" value="<% out.println(id_book); %>">  
                  <input type="text" style="visibility:hidden; position:absolute;"  name="len" value="eng">
               </div>
               <div id="comment_box_down">
                <input type="submit" class="button_update" name="comment_button" value="ADD">
               </div>
             </form>

            </div>
        </div>
         <% } %>        
           
          <% if((id_work!=null)&&(add.equals("photo"))){ 
              Workbook w=DBconnection.SearchWorkbook(Integer.parseInt(id_work), id_book);              
          %>
         <div id="photo_popup">      
            <div id="photo_box">
                <div style="width: 100%; height: 0px;"><div class="ics"></div></div>
                <form name="uploadForm" action="upload_photo"  enctype="multipart/form-data" method="post">
                    <div id="photo_box_up">
                        <p class="popup_email_text">Add one or two photos <br/>
                            <i>"<% out.println(w.getTitle()); %>"</i>  </p>
                        <input type="text" style="visibility:hidden; position:absolute;"  name="id_work" value="<% out.println(id_work); %>">
                        <input type="text" style="visibility:hidden; position:absolute;" name="id_book" value="<% out.println(id_book); %>">  
                        <input type="text" style="visibility:hidden; position:absolute;"  name="len" value="eng">
                        <br/>
                        <div style="float:left; width: 210px; margin-left: 40px;">
                            <div class="cover_img" style="background-image: url(userPhoto/<% out.println(w.getURLworkIMG1());%>);"></div>                        
                            <br/><div class="choose"><input type="file" name="file"></div>
                            <% out.println("<a href=\"delete_photo.jsp?idw="+id_work+"&idb="+id_book+"&name="+w.getURLworkIMG2()+"&v=1\">DELETE PHOTO</a>"); %>
                        </div>
                        <div style="float:right; width: 210px; margin-right: 40px;">
                            <div class="cover_img" style="background-image: url(userPhoto/<% out.println(w.getURLworkIMG2());%>);"></div>                        
                            <br/><div class="choose"><input type="file" name="file"></div>
                            <% out.println("<a href=\"delete_photo.jsp?idw="+id_work+"&idb="+id_book+"&name="+w.getURLworkIMG1()+"&v=2\">DELETE PHOTO</a>"); %>
                        </div>    
                    </div>
                    <div id="photo_box_down">
                        <input type="submit" class="button_update" name="photo" value="ADD">
                    </div>
                </form>
            </div>
          </div>
          <% } %>
        
        <div id="red_line">
            <div id="red_line_wrapper">
              <div class="guide_shadow">
              </div>
              <div class="guide_shadow">
              </div>
                <div class="guide_shadow">
              </div>
                <% out.println("<a href=\"modify_book.jsp?id_book="+id_book+"\"><img src=\"images/flag_ita.jpg\" style=\"width: 25px; height: 15px; float: right; margin-top: 5px; margin-left: 10px;\"></a> "); %>
                <a id="go_back_logout" href="logout.jsp">LOGOUT</a>
                <a id="go_back" href="my_book_eng.jsp">GO BACK TO YOUR BOOKS</a>
                <a href="my_book_eng.jsp"><img style="float:right; margin-top: 7px;" src="images/back.jpg"></a>
            </div>
        </div>

        
    <div id="top_wrapper">

      <%
      out.println("<a href=\"book.jsp?&idb="+AmuseGuest.encripted(Integer.toString(id_book))+"&l=eng\">");
      out.println("<div class=\"guide\">");   
      out.println("<img src=\"images/lens.jpg\" style=\"width: 64px; height: 64px; margin-left: 33px; margin-top: 18px;\"><br>");
      out.println("<span class=\"special_button\">VIEW</span>");
      out.println("</div>");
      out.println("</a>");
%>
      
      <a id="modify" href="" onclick="return false;">
      <div class="guide" >
          <img src="images/pencil.jpg" style="width: 64px; height: 64px; margin-left: 33px; margin-top: 18px;"><br>
          <span class="special_button">EDIT</span>
      </div>
      </a>

      <a id="cover" href="" onclick="return false;">
      <div class="guide" >
          <img src="images/cover.jpg" style="width: 70px; height: 64px; margin-left: 30px; margin-top: 18px;"><br>
          <span class="special_button">COVER</span>
      </div>
      </a>
      
      <div id="title_area"></div>
      <div id="logo_area"><img src="images/logo.jpg" alt="aMuse" height="62" width="229"></div>
      <div id="separator"></div>
    </div>

                
        <% 
            if(bk != null) {        
        %>
                
        
          <div id="content_wrapper"> 
              <a href="" onclick="return false;">
            <div id="book_info">
              <p class="book_title"><% out.println(bk.getTitle()); %></p>
              <p id="book_description"><% out.println(bk.getDescription()); %></p>
            </div>
              </a>
              
            <% 
                for(int i=0;i<bk.getMyWorks().size();i++ ){
                    Workbook wb=bk.getMyWorks().get(i);  
                    
                    out.println("<div class=\"spacer spacer_modify\">");
                    
                    out.println("<div class=\"object_wrapper\">");
                    out.println("<div class=\"object_button1\" style=\"margin-bottom: 4px; background-color: white;\">");
                    out.println("<a class=\"add_photo\" href=\"modify_book_eng.jsp?id_book="+id_book+"&id_work="+wb.getIDWork()+"&add=photo\" ><div style=\"background-color: #999999; height:36px; width: 133px;float:left; \"><img src=\"images/add.jpg\" style=\"float:left;\"><p class=\"add\"> Photo</p> </div></a>");
                    out.println("<a class=\"add_comment\" href=\"modify_book_eng.jsp?id_book="+id_book+"&id_work="+wb.getIDWork()+"&add=comm\"><div style=\"background-color: #999999; float:right;height:36px; width: 133px;\"><img src=\"images/add.jpg\" style=\"float:left;\"><p class=\"add\"> Comment</p> <p class=\"object_id\" title=\""+wb.getIDWork()+"\"></p> </div></a> </div>");
                    out.println("<div class=\"object_image\" style=\"background-image: url(imagesExhibition/"+wb.getURLimg1()+");\"> </div>");
                    out.println("<div class=\"object_button1\"> <p class=\"object_description1\">"+ wb.getTitle() +"</p></div>");
                    out.println("</div>");
                    out.println("</div>");
                } 
                
            %>
            
            <% } %>
             
        </div>    
    </body>
</html>
