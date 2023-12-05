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
public class TitulosSAXHandler extends DefaultHandler {
    
    private String markup; //string to save the name of the markup, to use it later in characters()
    
    public TitulosSAXHandler() {
        markup = "";
    }
    
    @Override public void startDocument() { //document starts with this header
        System.out.println("AUTHOR & TITLE LIST");
        System.out.println("===================");
    }
    
    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        if (qName.equals("book")) //all startElement() does is save the name of the element in markup
            markup = "book";
        if (qName.equals("author"))
            markup = "author";
        if (qName.equals("title"))
            markup = "title";
        if (qName.equals("genre"))
            markup = "genre";
        if (qName.equals("price"))
            markup = "price";
        if (qName.equals("publish_date"))
            markup = "publish_date";
        if (qName.equals("description"))
            markup = "description";
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String cst = new String(ch, start, length); //string to save the content of the element in question
        //String author = null; //secondary string to save the author, since it appears in the XML before title
        if (markup.equals("title")){            
            cst = cst.replaceAll("\t", ""); //no tabs
            cst = cst.replaceAll("\n", ""); //no line breaks
            System.out.println("\""+cst+"\""); //prints book's title in quotes
        }
        if (markup.equals("author")){
            cst = cst.replaceAll("\t", ""); //no tabs
            cst = cst.replaceAll("\n", ""); //no line breaks
            System.out.print("\nBy "+cst+": "); //prints author's name, no line break so that title is shown right after
        }
        //couldn't show it in the format "Title, Author" since author appears first in books.xml
    }
}
