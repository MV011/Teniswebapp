package com.dare.teniswebapp.dbdriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    //TODO Remove temporary credentials after test

        private static String username = "root";
        private static String password = "CeaMaiTare777";
        private static String dbURL = "jdbc:mysql://localhost:3306/tenisdb";

        private static Connection conn = null;

        public static void close() throws SQLException {
            conn.close();
        }

        public static Connection start() throws Throwable {

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            conn = DriverManager.getConnection(dbURL, username, password);

            return conn;
        }
}
