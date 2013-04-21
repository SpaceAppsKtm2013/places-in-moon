/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.BaseDao;
import model.dto.Moon;

/**
 *
 * @author Smrita
 */
public class MoonDao extends BaseDao
{
    Moon moonData;
    ArrayList<Moon> moonDataList=new ArrayList<Moon>();
    
    
    public ArrayList<Moon> retrieveData()
    {
        
    moonData=null;
       try
       {
        connectToDb();   
     
       // query="select corner1_lat,corner1_lng,corner2_lat,corner2_lng , corner3_lat,corner3_lng,corner4_lat,corner4_lng,taken_utc,image_link from `table 1` WHERE image_id>?";
        query="select * from `table 1` WHERE image_id > ?";
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1, 0);
        resultSet=preparedStatement.executeQuery();
        moonDataList=setMoonAttributes(resultSet);
        
       }
       
       catch(Exception e)
       {
           System.out.println("coulnot retrieve information about lunar system");
           e.printStackTrace();
       }
       
       finally
       {
           try
           {
                disconnectFromDb();
           }
           
           catch(Exception e)
           {
               System.out.println("coulnot disconnect from db");
           }
      }
          
       
       
          return moonDataList;


    }
    
   
    public ArrayList<Moon> setMoonAttributes(ResultSet rs)
    {
        try 
        {
            while(rs.next())
            {
                
                try{
                 moonData=new Moon();
                 moonData.setCornerLong_1(Float.parseFloat(rs.getString("corner1_lng")));
                 moonData.setCornerLat_1(Float.parseFloat(rs.getString("corner1_lat")));
                 moonData.setCornerLong_2(Float.parseFloat(rs.getString("corner2_lng")));
                 moonData.setCornerLat_2(Float.parseFloat(rs.getString("corner2_lat")));
                 moonData.setCornerLong_3(Float.parseFloat(rs.getString("corner3_lng")));
                 moonData.setCornerLat_3(Float.parseFloat(rs.getString("corner3_lat")));
                 moonData.setCornerLong_4(Float.parseFloat(rs.getString("corner4_lng")));
                 moonData.setCornerLat_4(Float.parseFloat(rs.getString("corner4_lat")));
                 moonData.setDate(rs.getString("taken_utc"));
                 moonData.setImageLink(rs.getString("image_link"));
                 moonData.setCameraDirection(rs.getString("camera_dir"));
                 moonData.setImageId(rs.getInt("image_id"));
                 moonData.setDate(rs.getString("taken_utc"));
                 moonData.setNadirLat(Float.parseFloat(rs.getString("nadir_lat")));
                 moonData.setNadirLong(Float.parseFloat(rs.getString("nadir_lng")));
                 moonData.setAltitude(Float.parseFloat(rs.getString("altitude")));
                 moonData.setSchool("school");
                 moonDataList.add(moonData);
            }
                catch(Exception e)
                {
                    System.out.println("continued");
                    continue;
                }
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("SQL Exception occued while setting moon attributes");
        }
        
        return moonDataList;
    }
    
    public static void main(String[] args) 
    {
        MoonDao moonDao=new MoonDao();
       ArrayList<Moon> m=moonDao.retrieveData();
       for(Moon moon:m)
       {
        System.out.println(moon.getImageLink());
           System.out.println(moon.getCornerLat_1());
           System.out.println(moon.getCornerLong_1());
           System.out.println(moon.getCornerLat_2());
           System.out.println(moon.getCornerLong_2());
           System.out.println(moon.getCornerLat_3());
           System.out.println(moon.getCornerLong_3());
           System.out.println(moon.getCornerLat_4());
           System.out.println(moon.getCornerLong_4());
       }
       
       
//        
//        String abc=" ";
//        if(abc.contains(" "))
//        System.out.println("I am empty");
//        
    }
    
}