package LibraryAMuse;

import java.sql.*;
import java.util.*;
import java.util.logging.Level.*;
import java.util.logging.Logger.*;
 
/**
 *
 * @author dVruhero
 */
public class DBconnection {
    
    public DBconnection() {}
    
     
    
    
    /**
     * Stabilisce la connessione con il database
     * 
     * @return 0: la connessione e' stata aperta
     *         1: errore di connessione        */
    private static Connection getConnection() {
        try {    
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root"; 
            String pass = "";
            String strconn = "jdbc:mysql://localhost:3306/amuse"; 
            Connection con;
            Class.forName(driver).newInstance();
            con =DriverManager.getConnection (strconn,userName,pass);
            
            return con;
            
        } catch (Exception e) { 
                    return null;
        }
    }
    
    /**
     * Esegue la query.
     * Prende in input la query da eseguire e restituisce l'esecuzione della query.
     * @param stm
     * 
     * @return 0: la query ne eseguitao
     *         1: la query ha restituito un errore     
     */
    private static Object[] ExsecutionQuery(String Query) {
        Connection con; 
        Statement stm;
        ResultSet rs = null;
        try {
            con = getConnection();
            if (con  == null) { return null; }
            
            stm = con.createStatement();
            rs = stm.executeQuery(Query); 
            
        } catch (Exception e) { return null;}
        Object[] o ={rs,stm,con};
        return o;
    } 
    
    /**
     * Una volta presa in input una query da esguire esegue gli update della funzione.
     * @param query
     * 
     * @return 0: vengono eseguiti gli update
     *         1: restituisce un errore la connessione
     */
    private static boolean ExsecutionUpdate(String query) {
        try {
            Statement stmt = null;
            Connection con = getConnection();
            if(con == null) { return false; }
            
            try {
                
                stmt = con.createStatement();
                stmt.executeUpdate(query);
            } finally { stmt.close(); con.close(); }
            
            return true;
            
        } catch (Exception e) { return false; }
    }
    
    /**
     * La funzione controlla i dati di accesso
     * @param email email utente
     * @param password password utente
     * @return  (0) accesso corretto,  
     *          (1) dati non corretti, 
     *          (2) errore di connessione o esecuzione query
     */
    public static int LoginControl(String email, String password) { 
        try {
             ResultSet rs = null;
             Connection con = null;
             Statement stm =  null;
             int count = 0;
             try {
                String Query = "SELECT * FROM USERS WHERE email LIKE \"" + email + "\" AND password LIKE (\"" + password + "\")";
                Object[] o = ExsecutionQuery(Query);
                if(o == null) { return 2; }
                rs = (ResultSet) o[0];
                stm = (Statement) o[1];
                con = (Connection) o[2];
               

                while(rs.next()) { count++; }


                if(count == 1) {return 0;}
                else { return 1; }
                 } finally { rs.close(); stm.close(); con.close(); }
        } catch (Exception e) { return 2;}   
    }
    
    /**
     * Restituisce la lista delle mostre attualmente in corso.
     * 

     * @return 0: la lista di esibizioni
     *         1: errore di chiamata alla connessione
     */
    public static ListExhibition ActiveExhibition() {  
        ListExhibition le = new ListExhibition();
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        
        try {
            try {
                String Query = "SELECT * FROM exhibition WHERE  NOW() BETWEEN beginning AND end"; 
                Object[] o = ExsecutionQuery(Query);
                if(o == null) { return null; }
                rs = (ResultSet) o[0];
                stm = (Statement) o[1];
                con = (Connection) o[2];

                while(rs.next()) { 
                    int Eid = rs.getInt("ID_exhibition");
                    String Etitle = rs.getString("title");
                    String Edescription = rs.getString("description");
                    String Etitle_eng = rs.getString("title_eng");
                    String Edescription_eng = rs.getString("description_eng");
                    java.sql.Date Ebeginning = java.sql.Date.valueOf(rs.getString("beginning"));
                    java.sql.Date Eend = java.sql.Date.valueOf(rs.getString("end"));
                    String EURLimg = rs.getString("img");

                    le.add(new Exhibition(Eid, Etitle, Edescription,Etitle_eng, Edescription_eng, Ebeginning, Eend, EURLimg,null));

                }

                 return le;
             } finally { rs.close(); stm.close(); con.close(); }
        } catch (Exception e) { return null; }
    }
    /**
     * restituisce la lista di tutte le mostre
     * @return 0: la lista delle mostre
     *         1: errore di connessione
     */
    public static ListExhibition AllExhibition() {  
        ListExhibition le = new ListExhibition();
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        
        try {
            try {
                String Query = "SELECT * FROM exhibition"; 
                Object[] o = ExsecutionQuery(Query);
                if(o == null) { return null; }
                rs = (ResultSet) o[0];
                stm = (Statement) o[1];
                con = (Connection) o[2];

                while(rs.next()) { 
                    int Eid = rs.getInt("ID_exhibition");
                    String Etitle = rs.getString("title");
                    String Edescription = rs.getString("description");
                    String Etitle_eng = rs.getString("title_eng");
                    String Edescription_eng = rs.getString("description_eng");
                    java.sql.Date Ebeginning = java.sql.Date.valueOf(rs.getString("beginning"));
                    java.sql.Date Eend = java.sql.Date.valueOf(rs.getString("end"));
                    String EURLimg = rs.getString("img");

                    le.add(new Exhibition(Eid, Etitle, Edescription, Etitle_eng, Edescription_eng, Ebeginning, Eend, EURLimg,null));

                }

                 return le;
             } finally { rs.close(); stm.close(); con.close(); }
        } catch (Exception e) { return null; }
    }
    
    
    /**
     * Prende come input l'ID della mostra ed esegue la ricerca della mostra cercata.
     * Restituisce la singola mostra
     * @param idExhibition
     * 

     * @return 0: restituisce la singola mostra
     *         1: c'e' stato un errore nella chiamata alla connessione 
     */
    public static Exhibition SearchSingleExhibition(int idExhibition) {
        Exhibition exh = null;
         
        ResultSet rs = null;
        Statement stm = null;
        Connection con = null;
        ResultSet rs1 = null;
        Statement stm1 = null;
        Connection con1 = null;
        
        try {
            try {
                String Query = "SELECT * FROM exhibition WHERE ID_exhibition = " + idExhibition + " ";

                 Object[] o = ExsecutionQuery(Query);
                 if(o == null) { return null; }
                 rs = (ResultSet) o[0];
                 stm = (Statement) o[1];
                 con = (Connection) o[2];

                while(rs.next()) { 
                    int Eid = rs.getInt("ID_exhibition");
                    String Etitle = rs.getString("title");
                    String Edescription = rs.getString("description");
                    String Etitle_eng = rs.getString("title_eng");
                    String Edescription_eng = rs.getString("description_eng");
                    java.sql.Date Ebeginning = java.sql.Date.valueOf(rs.getString("beginning"));
                    java.sql.Date Eend = java.sql.Date.valueOf(rs.getString("end"));
                    String EURLimg = rs.getString("img");

                    ListWorks lw = new ListWorks();
                    try {
                        String Query1 = "SELECT * FROM works WHERE id_exhibition = " + Eid + " ";

                        Object[] o1 = ExsecutionQuery(Query1);
                        if(o1 == null) { return null; }
                        rs1 = (ResultSet) o1[0];
                        stm1 = (Statement) o1[1];
                        con1 = (Connection) o1[2];
                        while(rs1.next()) { 
                            int WIDWork = rs1.getInt("ID_work");
                            int WIDexhibition = rs.getInt("ID_exhibition");
                            String Wtitle = rs1.getString("title_work");;
                            String Wauthor = rs1.getString("author");
                            String Wgenre = rs1.getString("genre");
                            String Wdescription = rs1.getString("description");
                            String Wdescription_eng = rs1.getString("description_eng");
                            String WURLimg1 = rs1.getString("url_img_1");
                            String WURLimg2 = rs1.getString("url_img_2");
                            String WURLimg3 = rs1.getString("url_img_3");

                            lw.add(new Work(WIDWork, WIDexhibition, Wtitle, Wauthor, Wgenre, Wdescription,Wdescription_eng, WURLimg1, WURLimg2, WURLimg3)); 
                        }
                    } finally { rs1.close(); stm1.close(); con1.close(); }
                    exh = new Exhibition(Eid, Etitle, Edescription,Etitle_eng, Edescription_eng, Ebeginning, Eend, EURLimg, lw);   
                }
            } finally { rs.close(); stm.close(); con.close(); }
            
            return exh;
            
        } catch (Exception e) { return null; }
    }
    /**
     * Preso in input l' ID dell'opera, restituisce l'opera associata a quell'ID. Ricerca singola opera
     * @param idWork
     * 
     * 

     * @return 0: restituisce la singola opera
     *         1: c'e' stato un errore nella chiamata alla connessione 
     */
    public static Work SearchWork(int idWork) {
        Work wk = null;
        ResultSet rs = null;
        Statement stm = null;
        Connection con = null;
        
        try{
            try {
                String Query ="SELECT * FROM works WHERE ID_work = " + idWork + "";
                Object[] o = ExsecutionQuery(Query);
                if(o == null) { return null; }
                rs = (ResultSet) o[0];
                stm = (Statement) o[1];
                con = (Connection) o[2];

                while(rs.next()) { 
                    int WIDWork = rs.getInt("ID_work");
                    int WIDexhibition = rs.getInt("ID_exhibition");
                    String Wtitle = rs.getString("title_work");;
                    String Wauthor = rs.getString("author");
                    String Wgenre = rs.getString("genre");
                    String Wdescription = rs.getString("description");
                    String Wdescription_eng = rs.getString("description_eng");
                    String WURLimg1 = rs.getString("url_img_1");
                    String WURLimg2 = rs.getString("url_img_2");
                    String WURLimg3 = rs.getString("url_img_3");

                     wk = new Work(WIDWork, WIDexhibition, Wtitle,Wdescription,Wdescription_eng, Wauthor, Wgenre, WURLimg1, WURLimg2, WURLimg3); 
                }

                rs.close();

                return wk;
            } finally { rs.close(); stm.close(); con.close(); }
        }catch (Exception e) { return null;}
    }
    
    
    /**
     * 
     * @param idWork
     * @param idBook
     * @return 
     */
     public static Workbook SearchWorkbook(int idWork, int idBook) {
         Workbook wb=null;
         ResultSet rs = null;
        Statement stm = null;
        Connection con = null;
        
        try{
            try {
                String Query ="SELECT * FROM works_book NATURAL JOIN works WHERE ID_work = " + idWork + " AND ID_book = "+ idBook+";";
                Object[] o = ExsecutionQuery(Query);
                if(o == null) { return null; }
                rs = (ResultSet) o[0];
                stm = (Statement) o[1];
                con = (Connection) o[2];

                while(rs.next()) {  
                    int IDWork = rs.getInt("ID_work"); 
                    int IDexhibition = rs.getInt("ID_exhibition");
                    String title = rs.getString("title_work"); 
                    String author = rs.getString("author"); 
                    String genre = rs.getString("genre"); 
                    String description = rs.getString("description");
                    String description_eng = rs.getString("description_eng"); 
                    String URLimg1 = rs.getString("url_img_1"); 
                    String URLimg2 = rs.getString("url_img_2"); 
                    String URLimgUser1 = rs.getString("url_img_user1"); 
                    String URLimgUser2 = rs.getString("url_img_user2"); 
                    String Comment = rs.getString("comment"); 
                    
                    wb= new Workbook(idBook,idWork, URLimg1, URLimg2, title, description, description_eng, author, URLimgUser1, URLimgUser2, Comment); 
                }

                rs.close();

                return wb;
            } finally { rs.close(); stm.close(); con.close(); }
        }catch (Exception e) { return null;}
    }
    
    /**
     * ricerca tutti i miei book. Utilizzando come riferimento l' email 
     * (chiave primaria) di User
     * 
     * @param email

     * @return 0: restituisce la lista dei miei book
     *         1: c'e' stato un errore nella chiamata di connessione
     */
    public static ArrayList<Book> SearchMyBooks(String email) {
        ArrayList<Book> bk = new ArrayList<Book>();
        ResultSet rs = null;
        Statement stm = null;
        Connection con = null;
        
        try{
            try {
                String Query = "SELECT * FROM books WHERE email_user LIKE \"" + email + "\" ";
                Object[] o = ExsecutionQuery(Query);
                if(o == null) { return null; }
                rs = (ResultSet) o[0];
                stm = (Statement) o[1];
                con = (Connection) o[2];

                while(rs.next()) { 
                    String Title = rs.getString("title");
                    String Description = rs.getString("description");
                    int id_book = rs.getInt("id_book");
                    String cover = rs.getString("cover");
                    ListWorksbook lwb = new ListWorksbook();
                    bk.add(new Book(email,id_book, Title, Description,cover,lwb));            
                }     
            } finally { rs.close(); stm.close(); con.close(); }
            return bk;
            
        }catch (Exception e) { return null; }
    }
    /**
     * Trova la lista degli elementi presenti nel book prendendo 
     * come input
     * 
     * @param email_user
     * @param IDexhibition
     * 
     * @return 0: restituisce il singolo book
     *         1: errore connessione fallita
     */
    public static Book SearchBookElements(int IDBook) {
        Book bk = null;         
        ResultSet rs= null;
        Statement stm= null;
        Connection con= null;
        ResultSet rs1= null;
        Statement stm1= null;
        Connection con1= null;
        
        try {
            try {
                String Query = "SELECT * FROM books WHERE ID_book = " +IDBook+ " ";  
                Object[] o = ExsecutionQuery(Query);
                 if(o == null) { return null; }
                 rs = (ResultSet) o[0];
                 stm = (Statement) o[1];
                 con = (Connection) o[2];

                while(rs.next()) { 
                    String Title = rs.getString("title");
                    String Description = rs.getString("description");
                    String email_user = rs.getString("email_user"); 
                    String cover = rs.getString("cover");
                    
                    ListWorksbook lwb = new ListWorksbook(); 
                    try {
                        String Query1 = "SELECT * FROM works_book NATURAL JOIN works WHERE ID_book =" +IDBook+""; 
                        Object[] o1 = ExsecutionQuery(Query1);
                        if(o1 == null) { return null; }
                        rs1 = (ResultSet) o1[0];
                        stm1 = (Statement) o1[1];
                        con1 = (Connection) o1[2];

                        while(rs1.next()) { 
                            int IDWork = rs1.getInt("ID_work"); 
                            int IDexhibition = rs1.getInt("ID_exhibition");
                            String title = rs1.getString("title_work"); 
                            String author = rs1.getString("author"); 
                            String genre = rs1.getString("genre"); 
                            String description = rs1.getString("description");
                            String description_eng = rs1.getString("description_eng"); 
                            String URLimg1 = rs1.getString("url_img_1"); 
                            String URLimg2 = rs1.getString("url_img_2"); 
                            String URLimgUser1 = rs1.getString("url_img_user1"); 
                            String URLimgUser2 = rs1.getString("url_img_user2"); 
                            String Comment = rs1.getString("comment"); 

                            lwb.add(new Workbook(IDBook,IDWork, URLimg1, URLimg2, title, description, description_eng, author, URLimgUser1, URLimgUser2, Comment));
                        }
                    } finally { rs1.close(); stm1.close(); con1.close(); }
                    bk = new Book(email_user, IDBook, Title, Description, cover, lwb);
                }
            } finally { rs.close(); stm.close(); con.close(); }
        } catch (Exception e) { return null; }
        
        return bk;
    }
    
       
    
    /**
     * Inserimento di un nuovo utente utilizzando i parametri in ingresso
     * 
     * @param email
     * @param name
     * @param surname
     * @param password
     * 
     * @return 0: inserisce un nuovo user all'interno del database
     *         1: email gia presente
     *         2: errore di connessione
     */
    public static int InsertUser(String email, String password) {
        int tmp=MailControl(email);
        if(tmp!=0){
            return tmp;
        }
        
        String query ="INSERT INTO users value('" + password +"','" + email + "')";
        if(ExsecutionUpdate(query)){
            return 0;
        }
        return 2;
    }
    /**
     * Inserisce un'elemeto all'interno di un book
     * Prende come input il wb associato
     * @param wb
     * 
     * @return 0: inserimento di un elemento all'interno del book
     *         1: errore query
     */
    public static boolean InsertBookElement(Workbook wb) {
        String query ="INSERT INTO works_book value('" + wb.getIDWork() + "','" + wb.getIDBook() + "','" + wb.getURLworkIMG1() + "','" + wb.getURLworkIMG2() + "','" + wb.getComment() + "');";
        return ExsecutionUpdate(query);
    }
    /**
     * Inserisce un book nel database 
     * @param bk
     * 
     * @return 0: inserisce in database il book
     *         1: errore query
     */
    public static boolean InsertBook(Book bk) {
        String query ="INSERT INTO books value('" + bk.getIDBook() + "','" + bk.getEmail_user() + "','" + bk.getTitle() + "','" + bk.getDescription() + "','" + bk.getCover() + "');";
        return ExsecutionUpdate(query);
    }
    
    /**
     * Inserimento di un'opera
     * @param w
     * 
     * @return inserisce una singola oepra
     *         1: errore query
     */
    public static boolean InsertWork(Work w) {
        String query ="INSERT INTO works value( " + w.getIdWork() + ", " + w.getIdExhibition() + ", '" + w.getTitle() + "', '" + w.getAuthor() + "', '" + w.getGenre() + "', '" + w.getDescription() + "', '" + w.getDescriptionEng() +"', '" + w.getURLimg1() + "', '" + w.getURLimg2() + "', '" + w.getURLimg3() + "');";
        return ExsecutionUpdate(query);
    }
    
    
   
    /**
     * Possibilita' di modifica di un book
     * @param bk
     * 
     * @return 0: il book viene editato
     *         1: errore nell'esecuzione della query
     */
 
                
    public static boolean EditBook(String title, String description, int ID_book) {
        String query = "UPDATE books SET title='" + title + "', description='" + description + "' WHERE ID_book="+ ID_book+ ";";
        return ExsecutionUpdate(query);
    }
    
    public static boolean EditCoverBook(String cover, int ID_book) {
        String query = "UPDATE books SET cover='" + cover + "' WHERE ID_book="+ ID_book+ ";";
        return ExsecutionUpdate(query);
    }
    
    public static boolean EditWorksbookUserImg(int j,String img1, String img2, int id_book, int id_work) {
        String query="";
        if (j==3){
         query="UPDATE works_book SET url_img_user1='"+img1+"', url_img_user2='"+img2+"' WHERE ID_book="+ id_book+ " AND ID_work="+id_work+";";}
        else if(j==2){ query="UPDATE works_book SET url_img_user2='"+img2+"' WHERE ID_book="+ id_book+ " AND ID_work="+id_work+";";}
        else if(j==1){ query="UPDATE works_book SET url_img_user1='"+img1+"' WHERE ID_book="+ id_book+ " AND ID_work="+id_work+";";}
        return ExsecutionUpdate(query);
    }
    
    public static boolean InsertWorksbookComment(String comment,int id_book, int id_work){
        String query="UPDATE works_book SET comment='"+comment+"' WHERE ID_book="+ id_book+ " AND ID_work="+id_work+";";
        return ExsecutionUpdate(query);
    }

    public static boolean EditExhibition(int id_ex,String title, String description, String title_eng, String description_eng,String startDate,String endDate) {
        String query = "UPDATE exhibition SET title='" + title + "', description='" + description + "', title_eng='" + title_eng + "', description_eng='" + description_eng + "', beginning='" + startDate + "', end='" + endDate + "' WHERE ID_exhibition="+ id_ex+ ";";
        return ExsecutionUpdate(query);
    }
   
    public static boolean EditImgExhibition(int id_ex,String img) {
        String query = "UPDATE exhibition SET img='" + img + "' WHERE ID_exhibition="+ id_ex+ ";";
        return ExsecutionUpdate(query);
    }
    
    public static boolean EditImgWork(int id_work,String img) {
        String query = "UPDATE works SET url_img_1 ='" + img + "' WHERE ID_work="+ id_work+ ";";
        return ExsecutionUpdate(query);
    }
    
    public static boolean EditWork(int id_work, String title,String author,String genre, String description, String description_eng) {
        String query = "UPDATE works SET title_work='" + title + "', description='" + description + "', author='" + author + "', description_eng='" + description_eng + "', genre='" + genre + "' WHERE ID_work="+ id_work+ ";";
        return ExsecutionUpdate(query);
    }
    
    /**
     * Controlla l'esistenza della email
     * @param email
     * 
     * 
     * @return 0: email non presente
     *         1: email presente
     *         2: errore di connessione
     */
    public static int MailControl(String email) {        
        try {
            
            ResultSet rs = null;
            Statement stm = null;
            Connection con = null;
            int count = 0;
            try {
                String Query = "SELECT * FROM USERS WHERE email LIKE \"" + email + "\";";
                Object[] o = ExsecutionQuery(Query);
                if(o == null) { return 2; }
                rs = (ResultSet) o[0];
                stm = (Statement) o[1];
                con = (Connection) o[2];

                while(rs.next()) { count++; }
            } finally { rs.close(); stm.close(); con.close(); }
             
            if (count == 0) { return 0; }
            return 1;  
        }catch (Exception e) { return 2; }  // hahahahahahaha
    }
    
    
    
public static int NewIdExhibition(){  
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        int count = 0;
        try {
            try {
                String Query = "SELECT MAX(ID_exhibition) as max FROM exhibition"; 
                Object[] o = ExsecutionQuery(Query);
                if(o == null) { return 1; }
                rs = (ResultSet) o[0];
                stm = (Statement) o[1];
                con = (Connection) o[2];
                int id=0;
                while(rs.next()) {                
                id=rs.getInt("max");
                }
                id++;
               return id;
             } finally { rs.close(); stm.close(); con.close(); }
        } catch (Exception e) { return 2; }
    }


public static int NewIdWork(){  
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        
        try {
            try {
                String Query = "SELECT MAX(ID_work) as max FROM works"; 
                Object[] o = ExsecutionQuery(Query);
                if(o == null) { return 1; }
                rs = (ResultSet) o[0];
                stm = (Statement) o[1];
                con = (Connection) o[2];
                int id=0;
                while(rs.next()) {
                    id=rs.getInt("max");
                }
                id++;
               return id;
             } finally { rs.close(); stm.close(); con.close(); }
        } catch (Exception e) { return 2; }
    }

public static int NewIDBook(){
    Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        int count = 0;
        try {
            try {
                String Query = "SELECT * FROM books"; 
                Object[] o = ExsecutionQuery(Query);
                if(o == null) { return 1; }
                rs = (ResultSet) o[0];
                stm = (Statement) o[1];
                con = (Connection) o[2];

                while(rs.next()) { 
                    count ++;
                }
               return count+1;
             } finally { rs.close(); stm.close(); con.close(); }
        } catch (Exception e) { return 2; }
}

public static boolean deleteExhibition(int id_ex){
    
            
    String Query = "DELETE  FROM exhibition WHERE ID_exhibition='"+id_ex+"'"; //elimino la singola mostra
    String Query2= "DELETE FROM works WHERE ID_exhibition = " + id_ex + " "; //elimino le opere della mostra
    
    ExsecutionUpdate(Query);
    ExsecutionUpdate(Query2);
    
    return ExsecutionUpdate(Query);
}

public static boolean deleteWork(int id_work){
    String Query = "DELETE FROM works WHERE ID_work='"+id_work+"'"; 
    return ExsecutionUpdate(Query);
}
public static boolean InsertExhibition(Exhibition exhi) {
    String query = "INSERT INTO exhibition value('" + exhi.getID() + "','" + exhi.getTitle() + "','" + exhi.getDescription() + "','" + exhi.getImg1() + "','" + exhi.getStartDate() + "','" + exhi.getEndDate() + "','" + exhi.getTitle_eng() + "','" + exhi.getDescription_eng() + "')";
    return ExsecutionUpdate(query);
}

public static String FindPassword(String email){
    
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        
        try {
            try {
                String Query = "SELECT * FROM users WHERE email LIKE \""+email+"\""; 
                Object[] o = ExsecutionQuery(Query);
                if(o == null) { return null; }
                rs = (ResultSet) o[0];
                stm = (Statement) o[1];
                con = (Connection) o[2]; 
                String pass=null;
                while(rs.next()){
                    pass = rs.getString("password");
                }
                return pass;
             } finally { rs.close(); stm.close(); con.close(); }
        } catch (Exception e) { return null; }
}

}



