package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * A classe DB fornece métodos para obter conexão com o banco de dados e fechar essa conexão.
 */
public class DB {
    private static Connection conn = null;

    /**
     * Obtém uma conexão com o banco de dados.
     *
     * @return A conexão com o banco de dados.
     * @throws DbException Se ocorrer um erro ao obter a conexão.
     */
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties properties = loadProperties();
                String url = properties.getProperty("dburl");
                conn = DriverManager.getConnection(url, properties.getProperty("user"), properties.getProperty("password"));

            }catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    /**
     * Fecha a conexão com o banco de dados.
     *
     * @throws DbException Se ocorrer um erro ao fechar a conexão.
     */
    public static void closeConnection() {
        if(conn != null) {
            try{
                conn.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    /**
     * Carrega as propriedades do arquivo de configuração do banco de dados.
     *
     * @return As propriedades carregadas do arquivo de configuração.
     * @throws DbException Se ocorrer um erro ao carregar as propriedades.
     */
    private static Properties loadProperties() {
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties properties = new Properties();
            properties.load(fs);
            return properties;

        }catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }
}
