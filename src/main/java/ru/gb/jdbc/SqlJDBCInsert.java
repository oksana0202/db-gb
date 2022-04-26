package ru.gb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqlJDBCInsert {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.posgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5438/postgres");
            c.setAutoCommit(false);

            System.out.println("Opened database successfuly");

            stmt = c.createStatement();
                    String sql = "INSERT INTO TABLE COUNTRY(country_id,country_name)" +
                                    "VALUES (1, Russia);";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO TABLE COUNTRY(country_id,country_name)" +
                    "VALUES (2, France);";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO TABLE COUNTRY(country_id,country_name)" +
                    "VALUES (3, Italy);";
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfuly");

    }
}

