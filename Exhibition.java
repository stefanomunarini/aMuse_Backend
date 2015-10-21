package LibraryAMuse;

import java.util.*;

/**
 *
 * @author dVruhero
 */
public class Exhibition {
    public int ID;
    public String title;
    public String title_eng;
    public String description;
    public String description_eng;
    public String image1;
    public ListWorks listWorks;
    public Date startDate;
    public Date endDate;
    
    public int getID(){ return this.ID; }
    public String getTitle (){ return this.title; }
    public String getTitle_eng (){ return this.title_eng; }
    public String getDescription (){ return this.description; }
    public String getDescription_eng (){ return this.description_eng; }
    public String getImg1 (){ return this.image1; }
    public Date getStartDate(){return this.startDate;}
    public Date getEndDate(){return this.endDate;}
    public ListWorks getListWorks(){ return this.listWorks; }
    public void setTitle(String title){ this.title = title; }
    public void setDescription(String description){ this.description = description; }
    public void setImg1(String image1){ this.image1 = image1; }
    public void setID(int ID){this.ID=ID;}
    
    public Exhibition(){}
    /**
     * 
     * @param ID
     * @param title
     * @param description
     * @param image1 
     */
    public Exhibition (int ID, String title, String description,String title_eng, String description_eng, Date startDate, Date endDate, String image1,ListWorks listWorks ){
        this.ID=ID;
        this.title=title;
        this.description=description;
        this.title_eng=title_eng;
        this.description_eng=description_eng;
        this.image1=image1;
        this.listWorks = listWorks;
        this.startDate = startDate;
        this.endDate = endDate;
    }
/*
    public Exhibition (int ID, String title, String description, String image1){
        this.ID=ID;
        this.title=title;
        this.description=description;
        this.image1=image1;
    }*/
    
    /**
     * @return a string with the html language for the row layout
     */
    /*
    public String HTMLRow(){
        String buffer;

        buffer = "<ul> <li>";
        buffer+= title;
        buffer+= "</li> <li>";    
        buffer+= description;
        buffer+= "</li> <li>";
        buffer+= image1;
        buffer+= "</li> <li>";
        listWorks.HTMLTable();
        buffer+= "</li> </ul>";
        
        return buffer;
    }
*/
}
