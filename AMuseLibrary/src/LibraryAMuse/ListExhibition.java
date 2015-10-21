package LibraryAMuse;

import java.util.*;

/**
 *
 * @author dVruhero
 */
public class ListExhibition extends ArrayList<Exhibition> {    
    
    public ListExhibition(){}
    
    /**
     * This method adds a new Exhibition to the list
     * @param ID
     * @param title
     * @param description
     * @param image1 
     */
    public void add (int ID, String title, String description,String title_eng, String description_eng, Date startDate, Date endDate, String image1, ListWorks listWork){
        this.add(new Exhibition (ID,title,description,title_eng,description_eng,startDate,endDate,image1,listWork));
    }
    /**
     * This method adds a new Exhibition to the list and in Database
     * @param ID
     * @param title
     * @param description
     * @param image1 
     */
    public boolean addDB (int ID, String title, String description,String title_eng, String description_eng, Date startDate, Date endDate, String image1, ListWorks listWork){
       Exhibition exhi = new Exhibition (ID,title,description,title_eng,description_eng,startDate,endDate,image1,listWork); 
       if(!DBconnection.InsertExhibition(exhi)) { return false; }
       
       this.add(exhi);
       
       return true;
    }
    
    /**
     * @return a string with the html language for the table layout
     */
    /*
    public String HTMLTable(){
       String buffer ="<ul>";
       
        for (Iterator<Exhibition> it = this.iterator(); it.hasNext();) {
            Exhibition exh = it.next();
            buffer+= "<li>";
            buffer += exh.HTMLRow();
            buffer+= "</li>";
        }
        
        buffer += "</ul>";
        
        return buffer;
    }*/
}