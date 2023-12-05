/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package xmlconsax;

import java.io.File;

/**
 *
 * @author Robyn
 */
public class XMLconSAX {

        public static void main(String[] args) {
        
            File file = new File("books.xml"); //our XML file in the root project folder
            AccesoXMLSAX acceso = new AccesoXMLSAX();
            //calls to parsing methods, with different Handlers
            acceso.parsearXMLconLibrosSAXHandler(file);
            acceso.parsearXMLconTitulosSAXHandler(file);
    }
    
}
