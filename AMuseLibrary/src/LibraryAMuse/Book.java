package LibraryAMuse;

/**
 *
 * @author dVruhero
 */
public class Book {
    
    private String Email_user;
    private int ID_book;
    private String Title;
    private String Description;
    private ListWorksbook myWorks;
    public String cover; 
    
    public String getEmail_user (){ return this.Email_user; }
    public int getIDBook (){ return this.ID_book; }
    public String getTitle (){ return this.Title; }
    public String getDescription (){ return this.Description; }
    public String getCover (){ return this.cover; }
    public ListWorksbook getMyWorks (){ return this.myWorks; }
    

    public Book () {}
    
    /**
     * Makes the Book
     * It takes as imput Email_user, IDexhibition, Title, Description, myWoks and makes a book with the WorkBooks contained in myWorks
     * @param Email_user
     * @param IDexibition
     * @param Title
     * @param Description
     * @param myWorks
     */
    public Book (String Email_user, int ID_book, String Title, String Description,String cover, ListWorksbook myWorks) {
        this.Email_user = Email_user;
        this.ID_book=ID_book;
        this.Title=Title;
        this.Description=Description;
        this.myWorks=myWorks;
        this.cover=cover;
    } 
    

    
}
