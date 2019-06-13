package Moive_booking;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBclass {
     static private Connection connection;
     public static Connection getConnection() throws Exception
     {
         if(connection==null)
         {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/user_information";
            String name="root";
            String password="1234";
            connection =DriverManager.getConnection(url, name,password);
         }
         return connection;
     }
    
}

