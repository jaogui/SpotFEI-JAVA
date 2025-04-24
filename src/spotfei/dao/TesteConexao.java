package spotfei.dao;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection conn = Conexao.conectar();
            System.out.println("✅ Conexão bem-sucedida!");
            conn.close();
        } catch (Exception e) {
            System.out.println("❌ Erro ao conectar: " + e.getMessage());
        }
    }
}
