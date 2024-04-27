package app;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Programa {
    public static void main(String[] args) throws SQLException {

        Connection conn = DB.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("selec * from tb_product");

        while (rs.next()){
            System.out.println(rs.getLong("Id") + ", " + rs.getString("Name"));
        }
    }
}
