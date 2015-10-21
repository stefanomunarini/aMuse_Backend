package LibraryAMuse;

/**
 *
 * @author dVruhero
 */
public class Workbook extends Work{
    
    public int IDBook;
    public int IDWork;   
    public String Comment;
    String URLimgUser1="";
    String URLimgUser2="";
    
    
    public int getIDBook() {return this.IDBook;}    
    public String getComment() {return this.Comment;}
    public int getIDWork(){return this.IDWork;}
    public String getURLworkIMG1(){ return this.URLimgUser1;}
    public String getURLworkIMG2(){ return this.URLimgUser2;}
    
    
    
    public Workbook() {}
    
    /**
     * 
     * @param IDBook
     * @param IDWork
     * @param URLimg1
     * @param URLimg2
     * @param title
     * @param description
     * @param description_eng
     * @param author
     * @param URLimgUser1
     * @param URLimgUser2
     * @param Comment 
     */
    public Workbook(int IDBook, int IDWork,  String URLimg1, String URLimg2, String title,String description,String description_eng, String author, String URLimgUser1,String URLimgUser2, String Comment) {
        this.IDBook=IDBook;
        this.IDWork=IDWork;
        this.URLimg1=URLimg1;
        this.URLimg2=URLimg2;
        this.title=title;
        this.description=description;
        this.description_eng=description_eng;
        this.author=author;
        this.URLimgUser1=URLimgUser1;
        this.URLimgUser2=URLimgUser2;
        this.Comment=Comment;
        
    }
    
    
    
}
