package spotfei.dao;

import spotfei.model.Musica;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicaDAO {

    public List<Musica> buscarMusicas(String termoBusca) {
        List<Musica> musicas = new ArrayList<>();
        String sql = "SELECT * FROM musicas WHERE LOWER(nome) LIKE ? OR LOWER(genero) LIKE ? OR LOWER(artista) LIKE ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String busca = "%" + termoBusca.toLowerCase() + "%";
            stmt.setString(1, busca);
            stmt.setString(2, busca);
            stmt.setString(3, busca);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id"); 
                String nome = rs.getString("nome");
                String genero = rs.getString("genero");
                String artista = rs.getString("artista");
                Musica musica = new Musica(id, nome, genero, artista); 
                musicas.add(musica);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar músicas: " + e.getMessage());
        }

        return musicas;
    }
}
