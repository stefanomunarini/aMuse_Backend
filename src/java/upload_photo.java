/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import LibraryAMuse.*;


/**
 *
 * @author Fede
 */
@WebServlet(urlPatterns = {"/upload_photo"})
public class upload_photo extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload_photo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet upload_photo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id_book="",id_work="",len="";
        String []imgname =new String[2];
        int k=0;
        boolean []uploaded={false,false};

        
        // Imposto il content type della risposta e prendo l'output
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter(); 

//La dimensione massima di ogni singolo file su system
int dimensioneMassimaDelFileScrivibieSulFileSystemInByte = 10 * 1024 * 1024; // 10 MB
//Dimensione massima della request
int dimensioneMassimaDellaRequestInByte = 20 * 1024 * 1024; // 20 MB
//Cartella temporanea
File cartellaTemporanea = new File("C:\\tempo");
 

try {
// Creo un factory per l'accesso al filesystem
DiskFileItemFactory factory = new DiskFileItemFactory(); 

//Setto la dimensione massima di ogni file, opzionale
factory.setSizeThreshold(dimensioneMassimaDelFileScrivibieSulFileSystemInByte);
//Setto la cartella temporanea, Opzionale
factory.setRepository(cartellaTemporanea); 

// Istanzio la classe per l'upload
ServletFileUpload upload = new ServletFileUpload(factory); 

// Setto la dimensione massima della request, opzionale
upload.setSizeMax(dimensioneMassimaDellaRequestInByte); 

// Parso la riquest della servlet, mi viene ritornata una lista di FileItem con
// tutti i field sia di tipo file che gli altri
List<FileItem> items = upload.parseRequest(request); 

/*
*
* Giro per tutti i campi inviati
*/
for (int i = 0; i < items.size(); i++) {
FileItem item = items.get(i); 

// Controllo se si tratta di un campo di input normale
if (item.isFormField()) {
// Prendo solo il nome e il valore
String name = item.getFieldName();
String value = item.getString(); 
if (name.equals("id_book")){ id_book=value;}
if (name.equals("id_work")){ id_work=value;}
if (name.equals("len")){ len=value;}
}
// Se si stratta invece di un file ho varie possibilità
else {
// Dopo aver ripreso tutti i dati disponibili
String fieldName = item.getFieldName();
String fileName = item.getName();
String contentType = item.getContentType();
boolean isInMemory = item.isInMemory();
long sizeInBytes = item.getSize(); 

imgname[k]=fileName;

// scrivo direttamente su filesystem

File uploadedFile = new File("/Users/Babol/Desktop/dVruhero/aMuseWebsite/web/userPhoto/" + fileName);
// Solo se veramente ho inviato qualcosa
if (item.getSize() > 0) {
    item.write(uploadedFile);
    uploaded[k]=true;
    
}
k++;


}
} 
        String img1=imgname[0];
        String img2=imgname[1];
        if(img1.equals("")) img1="null";
        if(img2.equals("")) img2="null";
        int j=0; //nessuna
        if(uploaded[0]) j=1; //solo la prima
        else if(uploaded[1]) j=2; //solo la seconda
        if(uploaded[0] && uploaded[1]) j=3; // tutte e 2
        System.out.println(uploaded[0]+"____"+uploaded[1]);
        //metodo per aggiungere foto
        if(uploaded[0] || uploaded[1]) DBconnection.EditWorksbookUserImg(j,img1,img2, Integer.parseInt(id_book), Integer.parseInt(id_work));
    

//out.println("</body>");
//out.println("</html>"); 

}
catch (Exception ex) {
System.out.println("Errore: " + ex.getMessage());
}
finally {
    if(len.equals("ita")) response.sendRedirect("modify_book.jsp?id_book="+id_book); 
    else response.sendRedirect("modify_book_eng.jsp?id_book="+id_book); 
}
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
