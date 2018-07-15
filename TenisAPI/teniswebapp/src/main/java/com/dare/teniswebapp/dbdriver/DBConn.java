package com.dare.teniswebapp.dbdriver;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

    //TODO Remove temporary credentials after test

        static String username = "root";
        static String password = "CeaMaiTare777";
        static String dbURL = "jdbc:mysql://localhost:3306/tenisdb";

        private static Connection conn = null;

        public static void close() throws Throwable {
            conn.close();
        }

        public static Connection start() throws Throwable {

            conn = DriverManager.getConnection(dbURL, username, password);

            return conn;
        }
}
