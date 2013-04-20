/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdom;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.dao.MoonDao;
import model.dto.Moon;
import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


/**
 *
 * @author Smrita
 */
public class JdomForMoon 
{
    BufferedWriter bout;
  
    public void createKml()
    {
        String kml="";
        String placeMark="";
        String groundOverLay ="";
        String startTags;
        String endTags;
        String folder="";
        String middleTag="";
        MoonDao dataRetriever = new MoonDao();
        ArrayList<Moon> moonList=new ArrayList<Moon>();
        
       // Moon moonInfo = null;
        
        moonList=dataRetriever.retrieveData();
        System.out.println("moonlist size "+moonList.size());
        startTags="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        writeStringToFile(startTags);
        startTags="<kml xmlns=\"http://www.opengis.net/kml/2.2\" xmlns:gx=\"http://www.google.com/kml/ext/2.2\" hint=\"target=moon\">";
        writeStringToFile(startTags);
        startTags="<Folder>";
        writeStringToFile(startTags);
        folder="<folder>";//Dont forget to add this tag 
        writeStringToFile(folder);
      //  System.out.println(kml);
//        for(Moon moonInfo:moonList)
//        {
        
      //  for(int i=0;i<1;i++)
      //  {
            for(Moon moonInfo:moonList)
       {
         
            //Moon moonInfo=moonList.get(i);
            placeMark="<placemark>";
            writeStringToFile(placeMark);
            placeMark="<name> MoonKAM Images </name>";
            writeStringToFile(placeMark);
            placeMark="<description><![CDATA[<h1>"+moonInfo.getImageId()+"</h1>";
            writeStringToFile(placeMark);
            placeMark="<img src=\""+moonInfo.getImageLink()+"\" height=\"100\" width=\"100\"/>";
            writeStringToFile(placeMark);
            placeMark="<p><b>Date-Taken</b>"+moonInfo.getDate()+"</p>";
            writeStringToFile(placeMark);
            placeMark="<p><b>Altitude</b>"+moonInfo.getAltitude()+"</p>";
            writeStringToFile(placeMark);
//            placeMark+="\n<p><b>CenterLatitude</b>"+moonInfo.getCenterLat()+"</p>";
//            placeMark+="\n<p><b>CenterLongitude</b"+moonInfo.getCenterLong()+"</p>";
            placeMark="<p><b>CameraDirection</b>"+moonInfo.getCameraDirection()+"</p>";
            writeStringToFile(placeMark);
            placeMark="]]>";
            writeStringToFile(placeMark);
            placeMark="</description>";
            writeStringToFile(placeMark);
            placeMark="<lookAt>";
            writeStringToFile(placeMark);
            placeMark="<longitude>"+moonInfo.getCornerLong_1()+"</longitude>";
            writeStringToFile(placeMark);
            placeMark="<latitude>"+moonInfo.getCornerLat_1()+"</latitude>";
            writeStringToFile(placeMark);
            placeMark="<altitude>"+moonInfo.getAltitude()+"</altitude>";
            writeStringToFile(placeMark);
            placeMark="<heading>-4.10375541634e-007</heading>";
            writeStringToFile(placeMark);
            placeMark="<tilt>45.1094503672</tilt>";
            writeStringToFile(placeMark);
            placeMark="<range>327548.9342620896</range>";
            writeStringToFile(placeMark);
            placeMark="<gx:altitudeMode>relativeToSeaFloor</gx:altitudeMode>";
            writeStringToFile(placeMark);
            placeMark="</lookAt>";
            writeStringToFile(placeMark);
            placeMark="<Style id=\"s_ylw-pushpin\">";
            writeStringToFile(placeMark);
            placeMark="<IconStyle>";
            writeStringToFile(placeMark);
            placeMark="<scale>1.1</scale>";
            writeStringToFile(placeMark);
            placeMark="<Icon>";
            writeStringToFile(placeMark);
            placeMark="<href>http://maps.google.com/mapfiles/kml/pushpin/ylw-pushpin.png</href>";
            writeStringToFile(placeMark);
            placeMark="</Icon>";
            writeStringToFile(placeMark);
            placeMark="<hotSpot x=\"20\" y=\"2\" xunits=\"pixels\" yunits=\"pixels\"/>";
            writeStringToFile(placeMark);
            placeMark="</IconStyle>";
            writeStringToFile(placeMark);
            placeMark="</Style>";
            writeStringToFile(placeMark);
            placeMark="<Point>";
            writeStringToFile(placeMark);
            placeMark="<coordinates>"+moonInfo.getCornerLong_1()+","+moonInfo.getCornerLat_1()+",0"+"</coordinates>";
            writeStringToFile(placeMark);
            placeMark="</Point>";
            writeStringToFile(placeMark);
            placeMark="</placemark>";
            writeStringToFile(placeMark);
           // System.out.println(placeMark);
        }
        
        middleTag="<folder>\n<name>FLOW: 2012-03-15 to 2012-03-21</name>\n";
        writeStringToFile(middleTag);
     //   for(Moon moonInfo:moonList)
       // {
        for(Moon moonInfo:moonList)
        {
            
        groundOverLay="<GroundOverlay>";
        writeStringToFile(groundOverLay);
        groundOverLay="<name>"+moonInfo.getImageId()+"</name>";
        writeStringToFile(groundOverLay);
        groundOverLay="<visibility>1</visibility>";
        writeStringToFile(groundOverLay);
        groundOverLay="<Icon>";
        writeStringToFile(groundOverLay);
        groundOverLay="<href>"+moonInfo.getImageLink()+"</href>";
        writeStringToFile(groundOverLay);
        groundOverLay="<viewBoundScale>0.75</viewBoundScale>";
        writeStringToFile(groundOverLay);
        groundOverLay="</Icon>";
        writeStringToFile(groundOverLay);
        groundOverLay="<gx:LatLonQuad>";
        writeStringToFile(groundOverLay);
        groundOverLay="<coordinates>"+moonInfo.getCornerLong_1()+","+moonInfo.getCornerLat_1()+" "+moonInfo.getCornerLong_2()+","+moonInfo.getCornerLat_2()+" "+moonInfo.getCornerLong_3()+","+moonInfo.getCornerLat_3()+" "+moonInfo.getCornerLong_4()+","+moonInfo.getCornerLat_4()+"</coordinates>";
        writeStringToFile(groundOverLay);
        groundOverLay="</gx:LatLonQuad>";
        writeStringToFile(groundOverLay);
        groundOverLay="</GroundOverlay>";
        writeStringToFile(groundOverLay);
            //System.out.println(groundOverLay);
        }
        endTags="\n</Folder>\n</Folder>\n</kml>";
        writeStringToFile(endTags);
      //  System.out.println(placeMark);
        
        
        
      //  kml=startTags+placeMark+middleTag+groundOverLay+endTags;
       // System.out.println(kml);
        
       // return kml;
        
    }
    
    public static void main(String[] args) throws IOException 
    {
     JdomForMoon jm=new JdomForMoon();
     jm.createKml();
      
       //jm.writeStringToFile("Smrita Pokharel   ");
       
       //jm.writeStringToFile("Srija Pokharel");
      // jm.writeStringToFile("Srija Pokharel");
        
        
    }
    
    private void writeStringToFile(String contentToBeWritten)
    {
          try {
        
             bout = new BufferedWriter(new FileWriter("moonData.kml",true));
               bout.write(contentToBeWritten);
               bout.newLine();
               bout.close();
              // out.newLine();
          }         
       catch (IOException e)
       {
           System.out.println("cannot write to file");
           e.printStackTrace();
       }
          finally
          {
          }

    }
    
}
