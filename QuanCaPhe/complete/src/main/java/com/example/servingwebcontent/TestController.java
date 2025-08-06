package com.example.servingwebcontent;

import com.example.servingwebcontent.database.myDBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private myDBConnection dbConnection;

    @GetMapping("/test-db")
    public String testDB() {
        boolean connected = dbConnection.testConnection();
        return connected ? "Database connected!" : "Failed to connect to database.";
    }
}
