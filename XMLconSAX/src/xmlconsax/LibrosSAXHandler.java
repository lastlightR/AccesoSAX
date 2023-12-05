/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xmlconsax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

/**
 *
 * @author Robyn
 */
public class LibrosSAXHandler extends DefaultHandler {
    
    int counter = 1; //to count the number of the book
    
    public LibrosSAXHandler() {
        
    }
    
    @Override
    public void startDocument() { //document starts with this header
        System.out.println("BOOK LIST");
        System.out.println("=========");
    }
    
    @Override
    public void startElement(String uri, String localName, String qName,
        Attributes attributes) throws SAXException {
            if (qName.equals("book")){
                System.out.println("Book no. "+counter+" | ID: "
                    +attributes.getValue(attributes.getQName(0))); //first attribute
                counter++; //increases the number in the counter for the next book
            }
            else if (qName.equals("author")){
                System.out.println("\nThe author of the book is: ");
                //wait for characters() to know the elements' contents, this simply starts the element
            }
            else if (qName.equals("title")){
                System.out.println("\nTitle of the work: ");
            }
            else if (qName.equals("genre")){
                System.out.println("\nGenre: ");
            }
            else if (qName.equals("price")){
                System.out.println("\nPrice: ");
            }
            else if (qName.equals("publish_date")){
                System.out.println("\nPublish date: ");
            }
            else if (qName.equals("description")){
                System.out.println("\nDescription: ");
            }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException { //when an element is processed fully, this will be printed at the end
        if (qName.equals("book"))
            System.out.println("\n------------------------------");
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String cst = new String(ch, start, length); //string to save the content of the element in question
        cst = cst.replaceAll("\t", ""); //no tabs
        cst = cst.replaceAll("\n", ""); //no line breaks
        System.out.println(cst); //prints the content of the elements as they come
    }
    
}
