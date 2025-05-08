package spotfei.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:postgresql://localhost:5432/SpotFei";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "fei";

    public static Connection getConexao() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados");
            throw e;
        }
    }
}
