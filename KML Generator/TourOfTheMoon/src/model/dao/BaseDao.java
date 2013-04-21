package model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class BaseDao
{
      protected Connection connection;
      protected Statement statement;
      protected ResultSet resultSet;
      protected PreparedStatement preparedStatement;
      protected String query;
       
      
      public void connectToDb() throws ClassNotFoundException, SQLException
      {
    	 
                Class.forName("com.mysql.jdbc.Driver");//loading the jdbc driver
                connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tourthemoon","root","");
                statement=(Statement) connection.createStatement();
          
      }
      
      public void disconnectFromDb() throws SQLException
      {
    	  connection.close();
      }
      
      
      public static void main(String[] args) throws ClassNotFoundException, SQLException
      {
    	  BaseDao bd=new BaseDao();
    	  bd.connectToDb();
    	  
      }
}
