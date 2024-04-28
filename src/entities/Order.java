package entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


/**
 * A classe Order representa um pedido em um sistema.
 */
public class Order {
    private Long id;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;

    // A lista de produtos no pedido
    private List<Product> products = new ArrayList<>();


    /**
     * Obtém o identificador único do pedido.
     *
     * @return O identificador único do pedido.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único do pedido.
     *
     * @param id O identificador único do pedido.
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    /**
     * Retorna uma representação em formato de String do objeto Order.
     *
     * @return Uma representação em formato de String do objeto Order.
     */
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", moment=" + moment +
                ", status=" + status +
                '}';
    }
}
