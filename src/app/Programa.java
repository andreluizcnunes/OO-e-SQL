package app;

import db.DB;
import entities.Order;
import entities.OrderStatus;
import entities.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta classe contém o programa principal para analisar dados de pedidos e produtos do banco de dados.
 */
public class Programa {

    /**
     * O método principal que inicia a execução do programa.
     *
     * @param args Os argumentos de linha de comando (não utilizados neste programa).
     * @throws SQLException Se ocorrer um erro ao interagir com o banco de dados.
     */
    public static void main(String[] args) throws SQLException {

        try(Connection conn = DB.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_order "
                    + "INNER JOIN tb_order_product ON tb_order.id = tb_order_product.order_id "
                    + "INNER JOIN tb_product ON tb_product.id = tb_order_product.product_id")){

            Map<Long, Order> map = new HashMap<>();
            Map<Long, Product> prods = new HashMap<>();
            while (rs.next()){
                Long orderId = rs.getLong("order_id");
                if(map.get(orderId) == null){
                    Order order = instantiateOrder(rs);
                    map.put(orderId, order);
                }

                Long productId = rs.getLong("product_id");
                if(prods.get(productId) == null){
                    Product product = instantiateProduct(rs);
                    prods.put(productId, product);
                }

                map.get(orderId).getProducts().add((prods.get(productId)));
            }

            for (Long orderId : map.keySet()){
                System.out.println(map.get(orderId));
                for (Product product : map.get(orderId).getProducts()){
                    System.out.println(product);
                }
                System.out.println();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Método auxiliar para instanciar um objeto Order a partir dos resultados do ResultSet.
     *
     * @param rs O ResultSet contendo os dados do pedido.
     * @return O objeto Order instanciado.
     * @throws SQLException Se ocorrer um erro ao acessar os dados do ResultSet.
     */
    private static Order instantiateOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setId(rs.getLong("order_id"));
        order.setLatitude(rs.getDouble("latitude"));
        order.setLongitude(rs.getDouble("longitude"));
        order.setMoment(rs.getTimestamp("moment").toInstant());
        order.setStatus(OrderStatus.values()[rs.getInt("status")]);

        return order;
    }

    /**
     * Método auxiliar para instanciar um objeto Product a partir dos resultados do ResultSet.
     *
     * @param rs O ResultSet contendo os dados do produto.
     * @return O objeto Product instanciado.
     * @throws SQLException Se ocorrer um erro ao acessar os dados do ResultSet.
     */
    public static Product instantiateProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getLong("product_id"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setImageUrl(rs.getString("image_uri"));
        product.setPrice(rs.getDouble("price"));

        return product;
    }
}
