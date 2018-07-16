package com.dare.teniswebapp.dbdriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    //TODO Remove temporary credentials after test

        private static String username = "root";
        private static String password = "CeaMaiTare777";
        private static String dbURL = "";

        private static Connection conn = null;

        public static void close() throws SQLException {
            conn.close();
        }

        public static Connection start() throws SQLException {

            conn = DriverManager.getConnection(dbURL, username, password);

            return conn;
        }
}
