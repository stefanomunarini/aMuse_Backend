/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryAMuse;

/**
 *
 * @author Babol
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.mail.*;
public class SMTPAuthenticator extends Authenticator {
 
 String pass = "";
 String login = "";
 
 public SMTPAuthenticator() { super(); }
 
 public SMTPAuthenticator(String login,String pass) {
 super();
 this.login = login;
 this.pass = pass;
 }
 
 public PasswordAuthentication getPasswordAuthentication() {
 if (pass.equals(""))
 return null;
 else
 return new PasswordAuthentication (login, pass);
 }
}