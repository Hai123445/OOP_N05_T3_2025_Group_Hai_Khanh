package com.example.servingwebcontent.database;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.Class;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Value;
@Component
    public class myDBConnection {

    @Value("${my.database.url}")
    private String myDatabaseURL;

    @Value("${my.database.driver}")
    private String myDatabaseDriver;

    @Value("${my.database.username}")
    private String myDatabaseUsername;

    @Value("${my.database.password}")
    private String myDatabasePassword;

    public myDBConnection() {
        // Fallback values if properties are not loaded
        if (myDatabaseURL == null) {
            myDatabaseURL = "mysql://avnadmin:AVNS_fIeg8rQ_jgkVDcDFWyn@mysql-2954f5bb-opp-data.j.aivencloud.com:14833/defaultdb?ssl-mode=REQUIRED";
        }
        if (myDatabaseDriver == null) {
            myDatabaseDriver = "com.mysql.cj.jdbc.Driver";
        }
        if (myDatabaseUsername == null) {
            myDatabaseUsername = "avnadmin";
        }
        if (myDatabasePassword == null) {
            myDatabasePassword = "AVNS_fIeg8rQ_jgkVDcDFWyn";
        }
    }
    public Connection conn = null;
    public Statement getMyConn(){

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
    public boolean testConnection() {
        try (Connection conn = getOnlyConn()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Database connection test successful");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Database connection test failed: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

}