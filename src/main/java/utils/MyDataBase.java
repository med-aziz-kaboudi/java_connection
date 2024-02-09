package utils;

import java.sql.*;

public class MyDataBase {
    private Connection conn;
    String  user = "root";
    String  url = "jdbc:mysql://localhost:3306/esprit_test";
    String pwd ="";
    private  static MyDataBase instance ;
    private MyDataBase(){
        try {
            conn = DriverManager.getConnection(url , user, pwd);
            System.out.println("connected");
        } catch (SQLException e) {
            System.out.println( e.getMessage());

        }
    }
    public static MyDataBase getInstance(){
        if (instance == null){
            instance = new MyDataBase();
        }
        return instance;
    }
    public Connection getconn(){
        return conn ;

    }
}
