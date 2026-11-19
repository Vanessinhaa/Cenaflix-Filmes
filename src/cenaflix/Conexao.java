package cenaflix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável pela conexão
 * com o banco de dados Cenaflix.
 *
 * @author Vanes
 */

public class Conexao {
    /**
     * Estabelece a conexão com o banco MySQL.
     *
     * @return conexão com o banco de dados.
     * @throws SQLException caso ocorra
     * algum problema na conexão.
     */

    private static final String URL =
            "jdbc:mysql://localhost:3306/cenaflix";

    private static final String USUARIO = "cenaflix_app";
private static final String SENHA = "Cenaflix@2026";

   
public static Connection conectar() throws SQLException {

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

    } catch (ClassNotFoundException e) {
        throw new SQLException(
            "O driver MySQL Connector/J não foi encontrado no projeto.", e
        );
    }

    return DriverManager.getConnection(URL, USUARIO, SENHA);
}
    
    public static void main(String[] args) {
        try (Connection conexao = conectar()) {
            System.out.println("Conexão com o banco Cenaflix realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco:");
            e.printStackTrace();
        }
    }

}

