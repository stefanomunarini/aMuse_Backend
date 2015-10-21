<%-- 
    Document   : admin
    Created on : May 3, 2013, 5:52:25 PM
    Author     : Babol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>   
        <meta charset="UTF-8">
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

                    
        <div id="a" style="color: black; border: 1px solid black">
            <div id="a">

                <form name="uploadForm" action="upload.jsp" enctype="multipart/form-data" method="post">
                    </br>
                    <div id="a">
                        <input type="submit" id="button_update" name="update" value="Upload photo">
                        <input type="file" name="file">
                        <input name='Upload' Value='Upload' onClick="document.uploadForm.submit()" type="button"> 
                   </div>
                </form>
                </br></br></br></br>
            </div>
        </div>  
        
        
        <div id="a" style="color: black; border: 1px solid black">
            <div id="a">
                <form action="insert_exhibition.jsp">
                    <div id="a">
                        <p id="a">Inserisci il titolo della mostra </p>
                        <% out.println("<textarea id=\"title_book\" name=\"title\" maxlength=\"30\">Titolo</textarea>"); %>
                        <p id="a">Inserisci la descrizione</p>
                        <% out.println("<textarea id=\"popup_description\" name=\"description\">descrizione</textarea>"); %>
                        <p id="a">Inserisci il nome dell'immagine seguito dall'estensione</p>
                        <% out.println("<textarea id=\"popup_description\" name=\"img\">descrizione</textarea>"); %>
                        <input id="exhibition" type="text" name="IDEH" value="<% out.println(); %>">
                    </div>
                    <div id="a">
                    <input type="submit" id="button_update" name="update" value="INSERISCI MOSTRA">
                    </div>
                </form>
            </div>
        </div>  

        <div id="a" style="color: black; border: 1px solid black">
            <div id="a">
                <form action="delete_exhibition.jsp">
                    <div id="a">
                        <p id="a"><h1>WARNING!!</h1> </br> Si Sta per eliminare una mostra. I dati non 
                        potranno essere recuperati </br></br> Inserire correttamente il titolo della mostra </p>
                    <% out.println("<textarea id=\"title_book\" name=\"title\" maxlength=\"30\"></textarea>"); %>
                    </div>
                    
                    <div id="a">
                    <input type="submit" id="button_update" name="update" value="ELIMINA MOSTRA">
                    </div>
                </form>
            </div>
        </div>  
        <div id="a" style="color: black; border: 1px solid black">
            <div id="a">
                <form action="delete_work.jsp">
                    <div id="a">
                        <p id="a"><h1>WARNING!!</h1> </br> Si Sta per eliminare un opera! I dati non 
                        potranno essere recuperati </br></br> Inserire correttamente il titolo dell'opera</p>
                    <% out.println("<textarea id=\"title_book\" name=\"title\" maxlength=\"30\"></textarea>"); %>
                    </div>
                    
                    <div id="a">
                    <input type="submit" id="button_update" name="update" value="ELIMINA OPERA">
                    </div>
                </form>
            </div>
        </div>  
                    
        <div id="a" style="color: black; border: 1px solid black">
            <div id="a">
                <form action="insert_work.jsp">
                    <div id="a">
                        
                        <p id="a">Inserisci il nome della mostra di appartenena</p>
                        <% out.println("<textarea id=\"title_book\" name=\"title_ex\" maxlength=\"30\">Titolo</textarea>"); %>
                        <p id="a">Inserisci il titolo dell' opera</p>
                        <% out.println("<textarea id=\"title_book\" name=\"title\" maxlength=\"30\">Titolo</textarea>"); %>
                        <p id="a">Inserisci autore </p>
                        <% out.println("<textarea id=\"title_book\" name=\"author\" maxlength=\"30\">Titolo</textarea>"); %>
                        <p id="a">Inserisci il genere </p>
                        <% out.println("<textarea id=\"title_book\" name=\"genre\" maxlength=\"30\">Titolo</textarea>"); %>
                        <p id="a">Inserisci il la descrizione italiana</p>
                        <% out.println("<textarea id=\"title_book\" name=\"description_ita\" maxlength=\"30\">Titolo</textarea>"); %>
                        <p id="a">Inserisci il la descrizione inglese </p>
                        <% out.println("<textarea id=\"title_book\" name=\"description_eng\" maxlength=\"30\">Titolo</textarea>"); %>
                        <p id="a">Inserisci il titolo dell'immagine ex "panda.jpg"</p>
                        <% out.println("<textarea id=\"title_book\" name=\"image\" maxlength=\"30\">Titolo</textarea>"); %>
                        
                    </div>
                    
                    <div id="a">
                    <input type="submit" id="button_update" name="update" value="INSERISCI OPERA">
                    </div>
                </form>
            </div>
        </div>  
     
    </body>
</html>
