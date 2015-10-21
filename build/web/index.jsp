<%-- 
    Document   : index
    Created on : 15-apr-2013, 16.48.59
    Author     : Fede
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<html>
  
  <head>
    <meta charset="ISO-8859-1">
    <link rel="shortcut icon" href="am.ico" />
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,500' rel='stylesheet' type='text/css'/>
    <title>aMuse</title>
    <link rel="stylesheet" type="text/css" href="css/login.css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
    <script type="text/javascript" src="scripts/login.js"></script>
  </head>

  <body>
      <% String error=request.getParameter("Error"); %>
    
    <div id="email_popup">
            <div id="email_box">
                <div style="width: 100%; height: 0px;"><div class="ics"></div></div>
                <form action="sendPassword.jsp">
                <div id="email_box_up">
                    <br/><br/>
                    <h2>Inserisci la tua email:</h2>
                    <p>Ti sarà mandata la tua password sulla tua email</p>
                    <br/>
                  <input id="email_err_input" type="email" name="user_email" autocomplete="off" placeholder="email" autofocus required >
               </div>
               <div id="email_box_down">
                    <input type="submit" id="button_email" value="INVIA">
               </div>
             </form>
            </div>
    </div>
      
    <div id="login_wrapper">
      <div id="logo"></div>
      <form name="login"  action="login_control.jsp" method="get" accept-charset="utf-8">

        <div id="forms">
          <input id="email_input" type="email" name="usermail" placeholder="email" autofocus required>
          <input id="passw_input" type="password" name="password" placeholder="password" required>
        </div>
          <input id="button_login" name="button_login" type="submit" value="Login">
      </form>
      
      
      
      <% if (error!=null){ %>
        
      <div style="margin-top: 45px; text-align: center; font-size: 20px;">
          Email o password errati!
          <br/>
          <a id="forgot" href="" onclick="return false;">Password dimenticata?</a>
      </div>
      
      <% } %>
    </div>

  </body>
</html>