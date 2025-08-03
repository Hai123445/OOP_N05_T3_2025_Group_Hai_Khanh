package com.example.servingwebcontent.database;

import org.springframework.stereotype.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.Class;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class myDBConnection {

    public myDBConnection() {
    };

    // @Value("${my.database.url}")
    // protected String myDatabaseURL;

    String myDatabaseURL = "jdbc:mysql://mysql-2954f5bb-opp-data.j.aivencloud.com:14833/defaultdb?sslMode=REQUIRED";

    // @Value("${my.database.driver}")
    // protected String myDatabaseDriver;

    String myDatabaseDriver = "com.mysql.cj.jdbc.Driver";
    

    public Connection conn = null;

    public Statement getMyConn() {

        try {

            Class.forName(myDatabaseDriver);
            conn = DriverManager.getConnection(myDatabaseURL);
            Statement sta = conn.createStatement();
            return sta;

        } catch (Exception e) {
            System.out.println("myDBConnection at 34" + e);
        }

        return null;

    }

    public Connection getOnlyConn() {
        try {
            Class.forName(myDatabaseDriver);

            conn = DriverManager.getConnection(myDatabaseURL);
            return conn;

        } catch (Exception e) {
            System.out.println("Database connection error: " + e);
        }

        return conn;

    }

}