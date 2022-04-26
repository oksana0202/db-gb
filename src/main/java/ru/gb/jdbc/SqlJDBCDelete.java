package ru.gb.jdbc;

import java.sql.*;

public class SqlJDBCDelete {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.posgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5438/postgres");
            System.out.println("Opened database successfuly");

            stmt = c.createStatement();
            String sql = "DELETE from COUNTRY where ID=4;";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery("SELECT * FROM COUNTRY;");

            while (rs.next()) {
                int id = rs.getInt("country_id");
                String name = rs.getString("country_name");
                System.out.println("COUNTRY_ID = " + id);
                System.out.println("COUNTRY_NAME = " + name);
                System.out.println();
            }

            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e) {
            System.err.println(e.getClass().getName() +": " + e.getMessage() );
            System.exit(0);

            System.out.println("Operation done successfuly");
        }
    }
}


