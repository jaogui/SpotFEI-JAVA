/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package spotfei.dao;
/**
 *
 * @author unifjfaber
 */
import spotfei.model.Musica;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicaDAO {

    public List<Musica> buscarMusicas(String termoBusca) {
        List<Musica> musicas = new ArrayList<>();
        String sql = "SELECT * FROM musica WHERE LOWER(nome) LIKE ? OR LOWER(genero) LIKE ? OR artista_id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String busca = "%" + termoBusca.toLowerCase() + "%";
            stmt.setString(1, busca);
            stmt.setString(2, busca);

            try {
                int artistaId = Integer.parseInt(termoBusca);
                stmt.setInt(3, artistaId);
            } catch (NumberFormatException e) {
                stmt.setInt(3, -1); 
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String genero = rs.getString("genero");
                int artista_id = rs.getInt("artista_id");
                Musica musica = new Musica(id, nome, genero, artista_id);
                musicas.add(musica);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar músicas: " + e.getMessage());
        }

        return musicas;
    }
}
