package LibraryAMuse;

import java.util.*;

/**
 *
 * @author dVruhero
 */
public class ListWorksbook extends ArrayList<Workbook> {
    public ListWorksbook(){}
    
    /**
     * Adds a workbook to the list using his parameters
     * It takes as imput IDWork, title, author, genre, description, URLimg1, URLimg2, URLimg3, EmailUser, IDeshibition, URLimgI, URLimgII, URL imgIII, commento and it adds to the list a WorkBook with the specified attributes
     * @param IDWork
     * @param title
     * @param author
     * @param genre
     * @param description
     * @param description_eng
     * @param URLimg1
     * @param URLimg2
     * @param URLimg3
     * @param EmailUser
     * @param IDexhibition
     * @param URLimgI
     * @param URLimgII
     * @param URLimgIII
     * @param URLvideoI
     * @param URLvideoII
     * @param Commento 
     */
    public void add(int IDBook, int IDWork, String URLimg1, String URLimg2,  String Comment,String title, String description,String description_eng, String author, String URLimgUser1, String URLimgUser2 ) {
        this.add( new Workbook(IDBook,IDWork, URLimg1, URLimg2, title, description, description_eng, author, URLimgUser1, URLimgUser2, Comment)); 
    }   
    
    /**
     * Adds a workbook to the database using his parameters
     * It takes as imput IDWork, title, author, genre, description, URLimg1, URLimg2, URLimg3, EmailUser, IDeshibition, URLimgI, URLimgII, URL imgIII, commento and it adds a WorkBook to the database with the specified attributes
     * @param IDWork
     * @param title
     * @param author
     * @param genre
     * @param description
     * @param description_eng
     * @param URLimg1
     * @param URLimg2
     * @param URLimg3
     * @param EmailUser
     * @param IDexhibition
     * @param URLimgI
     * @param URLimgII
     * @param URLimgIII
     * @param URLvideoI
     * @param URLvideoII
     * @param Commento
     * @return 
     */
    public boolean addDB(int IDBook, int IDWork, String URLimg1, String URLimg2,  String Comment,String title, String description,String description_eng, String author, String URLimgUser1, String URLimgUser2) {
        Workbook wb = new Workbook(IDBook,IDWork, URLimg1, URLimg2, title, description, description_eng, author, URLimgUser1, URLimgUser2, Comment);
        if(DBconnection.InsertBookElement(wb)) { 
            this.add(wb); 
            return true;
        }
        
        return false;
    } 
    
    
    
     
    
}
