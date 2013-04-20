/**
 * Program to read locations from a text file and generate a KML
 * file that places icons and labels at those locations
 */
package jdom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


/**
 * @author hoeber
 *
 */
public class JavaDomForKml {
  static String inputFile = "data/kmlexample.txt";
  static String outputFile = "data/output.kml";

  public static void main(String[] args) {
    
    /*
     * Step 1: generate XML stub
     */
    Namespace ns = Namespace.getNamespace("", "http://earth.google.com/kml/2.2");
    Namespace ns1=Namespace.getNamespace("gx", "http://www.google.com/kml/ext/2.2" );
    // kml
    Element kml = new Element("kml", ns);
    
    Document kmlDocument = new Document(kml);
    
    // Document
    Element document = new Element("Document", ns);
    kml.addContent(document);
    
    // name
    Element name = new Element("name", ns);
    name.setText("Java Generated KML Document");
    document.addContent(name);
    
    /*
     * Step 2: add in Style elements
     */
    
    // Style
    Element style = new Element("Style", ns);
    style.setAttribute("id", "redIcon");
    document.addContent(style);
    
    // IconStyle
    Element iconStyle = new Element("IconStyle", ns);
    style.addContent(iconStyle);
    
    // color
    Element color = new Element("color", ns);
    color.setText("990000ff");
    iconStyle.addContent(color);
    
    // Icon
    Element icon = new Element("Icon", ns);
    iconStyle.addContent(icon);
    
    // href
    Element href = new Element("href", ns);
    href.setText("http://www.cs.mun.ca/~hoeber/teaching/cs4767/notes/02.1-kml/circle.png");
    icon.addContent(href);
    
    /*
     * Step 3: read data from source location and
     * add in a Placemark for each data element
     */
    
    File file = new File(inputFile);
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(file));
      try {
        String line = reader.readLine();
        while (line != null) {
          String[] lineParts = line.split(";");
          if (lineParts.length == 3) {
            // add in the Placemark
            
            // Placemark
            Element placemark = new Element("Placemark", ns);
            document.addContent(placemark);
            
            // name
            Element pmName = new Element("name", ns);
            pmName.setText(lineParts[0].trim());
            placemark.addContent(pmName);
            
            // description
            Element pmDescription = new Element("description", ns);
            pmDescription.setText(lineParts[1].trim());
            placemark.addContent(pmDescription);
            
            // styleUrl
            Element pmStyleUrl = new Element("styleUrl", ns);
            pmStyleUrl.setText("#redIcon");
            placemark.addContent(pmStyleUrl);
            
            // Point
            Element pmPoint = new Element("Point", ns);
            placemark.addContent(pmPoint);
            
            // coordinates
            Element pmCoordinates = new Element("coordinates", ns);
            pmCoordinates.setText(lineParts[2].trim());
            pmPoint.addContent(pmCoordinates);
            
          }
          // read the next line
          line = reader.readLine();
        }
        
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    
    /*
     * Step 4: write the XML file
     */
    try {
      XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream writer = new FileOutputStream(outputFile);
      outputter.output(kmlDocument, writer);
      List<Content> kmlContent=kmlDocument.getContent();
       
        //kmlDocument.toString();
     
      writer.close();
      
          BufferedReader br;
          br = new BufferedReader(new FileReader(new File(outputFile)));
          String line;
          StringBuilder sb = new StringBuilder();

while((line=br.readLine())!= null){
    sb.append(line.trim());
}
        System.out.println(sb);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
