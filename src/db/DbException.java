package db;

/**
 * A classe DbException representa uma exceção específica para operações de banco de dados.
 */
public class DbException extends RuntimeException{

    /**
     * O número de série da classe, usado durante a serialização/desserialização.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Construtor que recebe uma mensagem de erro.
     *
     * @param msg A mensagem de erro associada à exceção.
     */
    public DbException(String msg){
        super(msg);
    }
}
