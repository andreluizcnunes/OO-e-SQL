package app;

import db.DB;
import entities.Order;
import entities.OrderStatus;
import entities.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Programa {
    public static void main(String[] args) throws SQLException {

        try(Connection conn = DB.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from tb_order")){

            while (rs.next()){
                Order order = instantiateOrder(rs);
                System.out.println(order);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static Order instantiateOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setId(rs.getLong("id"));
        order.setLatitude(rs.getDouble("latitude"));
        order.setLongitude(rs.getDouble("longitude"));
        order.setMoment(rs.getTimestamp("moment").toInstant());
        order.setStatus(OrderStatus.values()[rs.getInt("status")]);

        return order;
    }

    public static Product instantiateProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setImageUrl(rs.getString("image_uri"));
        product.setPrice(rs.getDouble("price"));

        return product;
    }
}
