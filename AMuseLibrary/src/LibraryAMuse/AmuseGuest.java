/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryAMuse;

import java.text.DateFormatSymbols;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.util.Properties;
import java.util.Calendar;

public class AmuseGuest {
/**
     * 
     * @param addressTo
     * @param Password
     * @param LinkBook
     * @return 
     */
    
    
public static boolean WebSendMail(String addressTo, String Password, String LinkBook,String lan){
        Calendar c = Calendar.getInstance();
        int giorno = c.get(Calendar.DAY_OF_MONTH);
        int mese = c.get(Calendar.MONTH);
        int anno = c.get(Calendar.YEAR);
        String suff = null;
        
        if(giorno==1){
            suff = "st";
        }
        if(giorno==2){
            suff = "nd";
        }
        if(giorno==3){
            suff = "rd";
        }
        if(giorno==31){
            suff = "st";
        }
        else{
            suff = "th";
        }
        
        
        
        String smtpHost = "smtp.gmail.com"; 
        String addressFrom = "amuse.dvruhero@gmail.com";
        String login = addressFrom;
        String password = "ciaogabri";
        String subject = "aMuse experience!";
        String message;
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
        String mese_eng = (dfs.getMonths()[mese]);
        
        if(lan.equals("ita")){
       
            message = "\n" +
            "  <div style=\"margin-bottom:30xp; width: 100%; float:left\"><img src=\"http://www.ramponialan.it/host/img/logo.jpg\" align=\"right\"></img></div> "+
            "<html>\n" +
            "    <head>\n" +
            "        <meta http-equiv=\\\"Content-Type\\\" content=\\\"text/html; charset=UTF-8\\\">\n" +
            "        <title>JSP Page</title>\n" +
            "    </head>\n" +
            "    <body>\n" +
            "        <div style:\"margin-top: 93px; float:left\">\n" +
            "<br/><br/><br/><br/><br/><br/><br/><br/>Buongiorno!<br/>" +
            "La informiamo che il book relativo alla sua visita al museo creato in data "+ giorno +"/"+ mese +"/" + anno +"  è stato correttamente registrato. " +
            "E' possibile visonarlo, modificarlo e condividerlo al seguente link:<br/>"+
            "\"http://localhost:8080/aMuseWebsite/index.jsp\"" +
            "<br/><br/><br/>Le Sue credenziali di accesso sono le seguenti:" +
            "<div><h3>Nome Utente: <span style=\"font-size:12px; font-style:none; font-weight: 100;\">"+ addressTo +"</span></h3></div>\n" +
            "<div><h3>Password: <span style=\"font-size:12px; font-style:none; font-weight: 100;\">"+ Password +"</span></h3></div>\n" +
            "<br/>" +
            "<br/>" +
            "Grazie per aver utilizzato il servizio aMuse e torni a farci vista!<br/></div>" +
            "<div style=\"float: right\"><br/>" +
            "lo Staff di aMuse<br/>" +
            "via Roberto Da SanSeverino<br/>" +
            "38122 Trento<br/><br/><div style=\"color:white;\">.</div>" +
            "</div>" +
            "    </body>\n" +
            "</html>\n" +
            "";
        }
        else{
        message = "\n" +
            "  <div style=\"margin-bottom:30xp; width: 100%; float:left\"><img src=\"http://www.ramponialan.it/host/img/logo.jpg\" align=\"right\"></img></div> "+
            "<html>\n" +
            "    <head>\n" +
            "        <meta http-equiv=\\\"Content-Type\\\" content=\\\"text/html; charset=UTF-8\\\">\n" +
            "        <title>JSP Page</title>\n" +
            "    </head>\n" +
            "    <body>\n" +
            "        <div style:\"margin-top: 93px; float:left\">\n" +
            "<br/><br/><br/><br/><br/><br/><br/><br/>Greetings!<br/>" +
            "We inform you that the book relative to your visit created on "+ giorno + suff +" of "+ mese_eng +", "+anno+" has been successfully registered. " +
            "You are now able to view it, modify it, share it using the following link:<br/>"+
            "\"http://localhost:8080/aMuseWebsite/index.jsp\"" +
            "<br/><br/><br/>Your login credentials are:" +
            "<div><h3>User Name: <span style=\"font-size:12px; font-style:none; font-weight: 100;\">"+ addressTo +"</span></h3></div>\n" +
            "<div><h3>Password: <span style=\"font-size:12px; font-style:none; font-weight: 100;\">"+ Password +"</span></h3></div>\n" +
            "<br/>" +
            "<br/>" +
            "Thank you for using our services!<br/></div>" +
            "<div style=\"float: right\"><br/>" +
            "The Staff<br/>" +
            "via Roberto Da SanSeverino<br/>" +
            "38122 Trento<br/><br/><div style=\"color:white;\">.</div>" +
            "</div>" +
            "    </body>\n" +
            "</html>\n" +
            "";
        }
        
        
        try {
        Properties props = new Properties();
        props.setProperty("mail.host", smtpHost);
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        
        
        Authenticator auth = new SMTPAuthenticator(login, password);

        Session session = Session.getInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);
        msg.setText(message);
        msg.setSubject(subject);
        msg.setContent(message, "text/html");
        msg.setFrom(new InternetAddress(addressFrom));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(addressTo));
        Transport.send(msg);
        return true;

        } catch (Exception ex) {
            return false;
        }
    
    }   

public static boolean WebSendPassMail(String addressTo, String Password, String LinkBook){

        String suff = null;

        String smtpHost = "smtp.gmail.com"; 
        String addressFrom = "gabriele.bonadiman@gmail.com";
        String login = addressFrom;
        String password = "GymBr%j'$eixnmGJ26eQ";
        String subject = "aMuse experience!";
        String message;
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
        
       
            message = "\n" +
            "  <div style=\"margin-bottom:30xp; width: 100%; float:left\"><img src=\"http://www.ramponialan.it/host/img/logo.jpg\" align=\"right\"></img></div> "+
            "<html>\n" +
            "    <head>\n" +
            "        <meta http-equiv=\\\"Content-Type\\\" content=\\\"text/html; charset=UTF-8\\\">\n" +
            "        <title>JSP Page</title>\n" +
            "    </head>\n" +
            "    <body>\n" +
            "        <div style:\"margin-top: 93px; float:left\">\n" +
            "<br/><br/><br/><br/><br/><br/><br/><br/>Buongiorno!<br/>" +            
            "<br/><br/><br/>Le Sue credenziali di accesso sono le seguenti:" +
            "<div><h3>Nome Utente: <span style=\"font-size:12px; font-style:none; font-weight: 100;\">"+ addressTo +"</span></h3></div>\n" +
            "<div><h3>Password: <span style=\"font-size:12px; font-style:none; font-weight: 100;\">"+ Password +"</span></h3></div>\n" +
            "<br/>" +
            "<br/>" +
            "Grazie per aver utilizzato il servizio aMuse e torni a farci vista!<br/></div>" +
            "<div style=\"float: right\"><br/>" +
            "lo Staff di aMuse<br/>" +
            "via Roberto Da SanSeverino<br/>" +
            "38122 Trento<br/><br/>" +
            "</div>" +
            "    </body>\n" +
            "</html>\n" +
            "";
        
        try {
        Properties props = new Properties();
        props.setProperty("mail.host", smtpHost);
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        
        
        Authenticator auth = new SMTPAuthenticator(login, password);

        Session session = Session.getInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);
        msg.setText(message);
        msg.setSubject(subject);
        msg.setContent(message, "text/html");
        msg.setFrom(new InternetAddress(addressFrom));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(addressTo));
        Transport.send(msg);
        return true;

        } catch (Exception ex) {
            return false;
        }
    
    }  

/**
     * 
     * @param mail
     * @return 
     */
public static String generatePsw(String mail) { 
        String ALPHABET = "0123456789" + mail;
        Random rnd = new Random(System.currentTimeMillis());
        int LENGHT = 8;
        
        StringBuilder sb;
        sb = new StringBuilder(LENGHT);
        for (int i = 0; i < LENGHT; i++) {
            char tmp = ALPHABET.charAt(rnd.nextInt(ALPHABET.length()));
            if(tmp!='.' && tmp!='@'){sb.append(tmp);}
            else{sb.append('G');}
        }
        System.out.println(sb);
        return sb.toString();
}

public static String encripted(String cstring){
            
            String hash = "";
            
            int c;
            for( int i=0; i< cstring.length(); i++)
            {
                c = cstring.charAt(i);
                hash += Integer.toString( c ) + "e";
            }
        
    
    return hash;
}

public static String decripted (String hash){
    String email="",c="";
    for (int i=0;i<hash.length();i++){
        char a=hash.charAt(i);
        if(a=='e'){
            email += (char)Integer.parseInt(c);
            c="";}
        else {c+=a;}
        
    }
    
    return email;
}




}


