package LibraryAMuse;
import java.util.*;

/**
 *
 * @author dVruhero
 */
public class Work {
    private int IDWork;
    private int IDexhibition;
    public String title;
    public String description;
    public String description_eng;
    public String author;
    public String genre;
    public String URLimg1;
    public String URLimg2;
    public String URLimg3;
    
    public int getIdWork(){ return this.IDWork; }
    public int getIdExhibition(){ return this.IDexhibition; }
    public String getTitle (){ return this.title; }
    public String getAuthor (){ return this.author; }
    public String getGenre (){ return this.genre; }
    public String getDescription (){ return this.description;}
    public String getDescriptionEng (){ return this.description_eng;}
    public String getURLimg1 (){ return this.URLimg1; }
    public String getURLimg2 (){ return this.URLimg2; }
    public String getURLimg3 (){ return this.URLimg3; }
    
    public void setIdWork(int IdWork) { this.IDWork = IdWork; }
    public void setIdExhibition(int IDexhibition) { this.IDexhibition = IDexhibition; }
    public void setTitle(String title){ this.title = title; }
    public void setAuthor(String author){ this.author = author; }
    public void setGenre(String genre){ this.genre = genre; }
    public void setDescription(String description){ this.description = description; }
    public void setURLimg1(String URLimg1){ this.URLimg1 = URLimg1; }
    public void setURLimg2(String URLimg2){ this.URLimg2 = URLimg2; }
    public void setURLimg3(String URLimg3){ this.URLimg3 = URLimg3; }
    
    public Work () { }
    
    /**
    * 
    * @param ID
    * @param title
    * @param description
    * @param description_eng
    * @param author
    * @param genre
    * @param image1
    * @param image2
    * @param image3 
    */
    public Work(int IDWork, int IDexhibition,  String title, String description,String description_eng, String author, String genre, String URLimg1, String URLimg2, String URLimg3){
        this.IDWork = IDWork;
        this.IDexhibition = IDexhibition;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.description_eng = description_eng;
        this.URLimg1 = URLimg1;
        this.URLimg2 = URLimg2;
        this.URLimg3 = URLimg3;
    }
    
    /**
    * 
    * @return a string with the html language for the row layout
    */
    public String HTMLRow(){
        String buffer;

        buffer = "<ul> <li>";
        buffer+= title;
        buffer+= "</li> <li>";
        buffer+= author;
        buffer+= "</li> <li>";
        buffer+= genre;
        buffer+= "</li> <li>";    
        buffer+= description;
        buffer+= "</li> <li>";
        buffer+= URLimg1;
        buffer+= "</li> <li>";
        buffer+= URLimg2;
        buffer+= "</li> <li>";    
        buffer+= URLimg3;
        buffer+= "</li> </ul>";

        return buffer;
    }

}