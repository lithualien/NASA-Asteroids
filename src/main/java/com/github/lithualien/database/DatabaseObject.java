package com.github.lithualien.database;

import java.sql.*;

public class DatabaseObject {
    private static final String url = "jdbc:mysql://localhost:3306/nasa?autoReconnect=true&useSSL=false";

    private static final String user = "admin";

    private static final String password = "admin1";

    public Connection con;

    public DatabaseObject() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
