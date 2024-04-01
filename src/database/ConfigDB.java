package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    private static final String url = "jdbc:mysql://uqjfowll5oflfsv9:3QM6ri3NcZ5wY9t9Zkkl@bimhejn22yxhma2ihxfg-mysql.services.clever-cloud.com:3306/bimhejn22yxhma2ihxfg";
    private static final String user = "uqjfowll5oflfsv9";
    private static final String password = "3QM6ri3NcZ5wY9t9Zkkl";
    public static Connection connection = null;
    public static Connection openConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connected to database");
        }catch (SQLException error){
            System.out.println("Error in database\n"+error.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error in driver\n"+ e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        if (connection != null){
            try{
                connection.close();
                System.out.println("Closed connection");
            }catch (SQLException error){
                System.out.println("Error closing the database\n"+error.getMessage());
            }
        }
    }

}
