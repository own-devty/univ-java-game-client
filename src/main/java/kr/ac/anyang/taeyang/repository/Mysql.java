package kr.ac.anyang.taeyang.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mysql {
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/service?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
//    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    Connection conn;

    public Mysql()
    {
        Connection connection = null;

        try
        {
//            Class.forName(DRIVER);
            connection = DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD);
            conn = connection;

            System.out.println("DB Connection [성공]");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
