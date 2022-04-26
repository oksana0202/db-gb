package ru.gb.jdbc;

import java.sql.*;

public class SqlJDBCSelect {
    public static void main(String args[]) throws SQLException {
        Connection c = null;
        Statement stmt = null;
            try {
                Class.forName("org.posgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5438/postgres");
            System.out.println("Opened database successfuly");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COUNTRY;");

            while (rs.next()) {
                int id = rs.getInt("country_id");
                String name = rs.getString("country_name");
                System.out.println("COUNTRY_ID = " + id);
                System.out.println("COUNTRY_NAME = " + name);
                System.out.println();

                stmt.close();
                c.close();

            System.out.println("Operation done successfuly");
        }
    }
}
