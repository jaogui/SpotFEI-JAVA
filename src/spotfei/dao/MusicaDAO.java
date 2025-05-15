/**
 * Classe responsável pelo acesso e manipulação dos dados da tabela Musica no banco.
 * Possui métodos para buscar músicas conforme um termo de busca.
 */
package spotfei.dao;

import spotfei.model.Musica;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicaDAO {

    /**
     * Busca músicas que tenham o nome ou gênero parecidos com o termo informado,
     * ou que tenham o artista com o ID igual ao termo (caso seja número).
     *
     * @param termoBusca texto para buscar músicas (nome, gênero ou id do artista)
     * @return lista de músicas que correspondem ao critério de busca
     */
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
                stmt.setInt(3, -1); // Nenhum artista terá ID -1, evita erros na consulta
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
