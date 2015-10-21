package LibraryAMuse;

import java.util.*;

/**
 *
 * @author dVruhero
 */
public class ListWorks extends ArrayList<Work> {
    
    public ListWorks() { }
    
    /**
    * This method adds a new Work to the list
    * 
    * @param ID
    * @param title
    * @param description
    * @param author
    * @param genre
    * @param image1
    * @param image2
    * @param image3 
    */
    public void add (int IDwork, int IDexhibition , String title, String description,String description_eng, String author, String genre, String image1, String image2, String image3){
        this.add(new Work(IDwork, IDexhibition, title, description,description_eng, author, genre, image1, image2, image3));
    }
    
    /**
    * This method adds a new Work to the list and in the DataBase
    *   
    * @param ID
    * @param title
    * @param description
    * @param author
    * @param genre
    * @param image1
    * @param image2
    * @param image3 
    */
    public boolean addDB (int IDwork, int IDexhibition , String title, String description,String description_eng, String author, String genre, String image1, String image2, String image3){
        Work wk = new Work(IDwork, IDexhibition, title, description, description_eng, author, genre, image1, image2, image3);  
        if(!DBconnection.InsertWork(wk)) { return false; }

        this.add(wk);

        return true;
    }
    
    /**
    * 
    * @return a string with the html language for the table layout
    */
    public String HTMLTable(){
        String buffer ="<ul>";

        for (Iterator<Work> it = this.iterator(); it.hasNext();) {
            Work wk = it.next();
            buffer+= "<li>";
            buffer += wk.HTMLRow();
            buffer+= "</li>";
        }

        buffer += "</ul>";

        return buffer;
    }
}