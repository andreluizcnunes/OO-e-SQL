package entities;

/**
 * A classe Product representa um produto em um sistema.
 */
public class Product {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUrl;

    /**
     * Construtor padrão da classe Product.
     */
    public Product() {
    }

    /**
     * Construtor da classe Product com todos os campos.
     *
     * @param id          O identificador único do produto.
     * @param name        O nome do produto.
     * @param price       O preço do produto.
     * @param description A descrição do produto.
     * @param imageUrl    A URL da imagem do produto.
     */
    public Product(Long id, String name, Double price, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    /**
     * Obtém o identificador único do produto.
     *
     * @return O identificador único do produto.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único do produto.
     *
     * @param id O identificador único do produto.
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Retorna uma representação em formato de String do objeto Product.
     *
     * @return Uma representação em formato de String do objeto Product.
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
