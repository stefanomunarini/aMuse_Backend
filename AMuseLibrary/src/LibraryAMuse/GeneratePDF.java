/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 package LibraryAMuse;

import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.*;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
 
public class GeneratePDF {
 
    public static void generate(Book b,String lan) throws IOException, DocumentException {
        try{
            //preparazione documento
            Rectangle pageSize = new Rectangle(PageSize.A4);  //dimensione book
            pageSize.setBackgroundColor(new java.awt.Color(255,255,255));  //colore di sfondo
            Document document = new Document(pageSize);                //dimensione documento
            
            //path e nome da creare il PDF
            PdfWriter.getInstance(document, new FileOutputStream("/Users/Babol/Desktop/dVruhero/aMuseWebsite/build/web/pdfUser/"+b.getTitle()+".pdf"));

            //logo finale
            Image logo=Image.getInstance("/Users/Babol/Desktop/dVruhero/aMuseWebsite/build/web/images/logo.jpg");
            logo.scalePercent(30);
            logo.setAbsolutePosition(250, 15);            
            
            //apertura del documento
            document.open();

            //parametri
            b = DBconnection.SearchBookElements(b.getIDBook());
            ListWorksbook lwb = b.getMyWorks();
                
            float wi;
            float wp;
            float posx;
            float posy;
            String title;
            String description;
            Image img;
            Paragraph p1,p2,p3;

                        
            //tabella serve per la prima pagina
            PdfPTable table = new PdfPTable(1); //creazione tabella
            table.setWidthPercentage(100);      //dimensione tabella
            table.setWidthPercentage(100);
            document.add(table);                //aggiungo la tabella al documento
            
            //COPERTINA
            p1 = new Paragraph(b.getTitle(), FontFactory.getFont(FontFactory.HELVETICA, 34, Font.BOLDITALIC, new Color(102,0,0)));
            p1.setAlignment(Element.ALIGN_CENTER);
            p1.setSpacingBefore(100);
            p1.setSpacingAfter(20);
            p2 = new Paragraph(b.getDescription(), FontFactory.getFont(FontFactory.HELVETICA, 20, Font.ITALIC));
            p2.setAlignment(Element.ALIGN_CENTER);
            p2.setSpacingAfter(40);
            document.add(p1);
            document.add(p2);
            
            img=Image.getInstance("/Users/Babol/Desktop/dVruhero/aMuseWebsite/build/web/userPhoto/" + b.getCover() + "");
            
            img.scaleAbsolute(100, 300);
//            System.out.println(x+"  "+y);
            table.addCell(img); 
            document.add(table);
            document.newPage();
            //FINE COPERTINA
                
            String author="";
            //Layout generale
                for(int i=lwb.size()-1;i>=0;i--)
                {        
                    author = lwb.get(i).getAuthor();
                    if(author==null){
                        System.out.println("--------" + author);
                        author = "";
                    }
                    else{
                        author = "- "+lwb.get(i).getAuthor();
                    }
                    Graphic hr = new Graphic(); 
                    hr.setHorizontalLine(1, 100);   
                    document.add(hr); 
                    
                    //work
                    title = lwb.get(i).getTitle();
                    if(lan.equals("ita")){ description = lwb.get(i).getDescription();}
                    else{ description = lwb.get(i).getDescriptionEng();}
                    
                    
                    
                    
                    
                    img=Image.getInstance("/Users/Babol/Desktop/dVruhero/aMuseWebsite/web/imagesExhibition/"+lwb.get(i).getURLimg1());
                  
                    float h = img.height();
                    float w = img.width();
                    float newH=300;
                    float newW = 300*w/h;
                    if (newW > 500.00) {newH=500*h/w; newW=500; }
                    img.scaleAbsolute(newW, newH);
                    
                    wi = 500;
                    wp = pageSize.width();
                    posx = (wp-newW)/2;
                    posy = 150;
                    img.setAbsolutePosition(posx, posy);
                    img.setAlignment(Image.TEXTWRAP);
                //paragrafi
                p1 = new Paragraph(title, FontFactory.getFont(FontFactory.HELVETICA, 34, Font.BOLDITALIC, new Color(102,0,0)));
                p1.setAlignment(Element.ALIGN_CENTER);
                p1.setSpacingAfter(10);
                document.add(p1);
                p3 = new Paragraph(author, FontFactory.getFont(FontFactory.HELVETICA, 14, Font.ITALIC));
                p3.setAlignment(Element.ALIGN_CENTER);
                p3.setSpacingAfter(50);
                document.add(p3);
                p2 = new Paragraph(description, FontFactory.getFont(FontFactory.HELVETICA, 15));
                p2.setAlignment(Element.ALIGN_CENTER);
                p2.setSpacingAfter(40);
                document.add(p2);
                document.add(img);
                document.add(logo);
                document.newPage();
      
                }     
            document.close();
        }catch(Exception e){
                e.printStackTrace();
        }
        
    }
}