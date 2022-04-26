package ru.gb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqlJDBCCreate {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.posgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5438/postgres");

        System.out.println("Opened database successfuly");

        stmt = c.createStatement();
        String sql = "CREATE TABLE COUNTRY" +
                       "(country_id` int(11) NOT NULL," +
                       "(country_name` varchar(450) COLLATE utf8mb4_unicode_ci NOT NULL," +
                       "( ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci)";
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfuly");

    }
}