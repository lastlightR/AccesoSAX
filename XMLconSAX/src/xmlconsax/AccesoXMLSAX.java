/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xmlconsax;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author Robyn
 */
public class AccesoXMLSAX {
    SAXParser parser; //creating a SAXParser to be later initialized with a factory instance
    
    public int parsearXMLconLibrosSAXHandler(File file){
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser(); //initializes parser using a factory instance
            LibrosSAXHandler saxHandler = new LibrosSAXHandler();
            parser.parse(file, saxHandler); //asigns XML file to a SAXHandler
            return 0;
        } catch(Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }
    
    public int parsearXMLconTitulosSAXHandler(File file) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            TitulosSAXHandler saxHandler = new TitulosSAXHandler();
            parser.parse(file, saxHandler); //same idea as before, but for TitulosSAXHandler
            return 0;
        } catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }
    
}
