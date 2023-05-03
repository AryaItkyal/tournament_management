/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseConnection {
    static Connection connection = null;
    private static String  userName = "root";
    private static String password = "1234";
    static String DATABASE_URL = "jdbc:mysql://localhost:3306/ipl";


    // public DatabaseConnection(String DATABASE_URL){
      //  this.DATABASE_URL = DATABASE_URL;
  //  }


    public static Connection startConnection(){
           try {
            Class.forName("com.mysql.cj.jdbc.Driver") ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection =  DriverManager.getConnection(DATABASE_URL,userName,password);
            System.out.println("connected");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        return  connection;
    }
    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
