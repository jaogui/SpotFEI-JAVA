/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package spotfei.dao;
/**
 *
 * @author unifjfaber
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import spotfei.model.Usuario;
import spotfei.model.PlayList;
import spotfei.model.Musica;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class UsuarioDAO {

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                usuarios.add(new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public Usuario buscarPorEmailESenha(String email, String senha) {
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void curtirMusica(int usuarioId, int musicaId) {   
    String deleteSql = "DELETE FROM descurtidas WHERE id_usuario = ? AND id_musica = ?";
    String insertSql = "INSERT INTO curtidas (id_usuario, id_musica) VALUES (?, ?)";
    try (Connection conn = Conexao.getConexao()) {
        conn.setAutoCommit(false);
        try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
             PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
            deleteStmt.setInt(1, usuarioId);
            deleteStmt.setInt(2, musicaId);
            deleteStmt.executeUpdate();
            insertStmt.setInt(1, usuarioId);
            insertStmt.setInt(2, musicaId);
            insertStmt.executeUpdate();

            conn.commit();
            System.out.println("Música curtida com sucesso!");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Erro ao curtir música: " + e.getMessage());
        } finally {
            conn.setAutoCommit(true);
        }
    } catch (SQLException e) {
        System.out.println("Erro na conexão: " + e.getMessage());
    }
}



public void descurtirMusica(int usuarioId, int musicaId) {
    String deleteSql = "DELETE FROM curtidas WHERE id_usuario = ? AND id_musica = ?";
    String insertSql = "INSERT INTO descurtidas (id_usuario, id_musica) VALUES (?, ?)";

    try (Connection conn = Conexao.getConexao()) {
        try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
             PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {

            deleteStmt.setInt(1, usuarioId);
            deleteStmt.setInt(2, musicaId);
            deleteStmt.executeUpdate();

            insertStmt.setInt(1, usuarioId);
            insertStmt.setInt(2, musicaId);
            insertStmt.executeUpdate();

            System.out.println("Música descurtida com sucesso!");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao descurtir música: " + e.getMessage());
    }
}


public void criarPlaylist(String nome, int usuarioId) throws SQLException {
    String sqlInsert = "INSERT INTO playlist (nome, usuario_id) VALUES (?, ?)";
    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
        stmt.setString(1, nome);
        stmt.setInt(2, usuarioId);

        int affectedRows = stmt.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Criar Playlis falhou, nenhuma linha foi afetada.");
        }
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int playlistId = generatedKeys.getInt(1);
                System.out.println("Playlist criada com ID: " + playlistId);
            } else {
                throw new SQLException("Criar Playlis falhou, nenhum ID foi gerado.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e; 
    }
}
public void atualizarPlayLists(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmtDelete = null;
        PreparedStatement stmtInsert = null;

        try {
            conn = Conexao.getConexao();
            String sqlDelete = "DELETE FROM musica_playlist WHERE playlist_id IN (SELECT id FROM playlist WHERE usuario_id = ?)";
            stmtDelete = conn.prepareStatement(sqlDelete);
            stmtDelete.setInt(1, usuario.getId());
            stmtDelete.executeUpdate();

            String sqlInsert = "INSERT INTO musica_playlist (playlist_id, musica_id) VALUES (?, ?)";
            stmtInsert = conn.prepareStatement(sqlInsert);

            for (PlayList p : usuario.getPlaylists()) {
                int playlistId = buscarPlaylistIdPorNomeEUsuario(p.getNome(), usuario.getId(), conn); 

                for (Musica m : p.getMusicas()) {
                    stmtInsert.setInt(1, playlistId);
                    stmtInsert.setInt(2, m.getId());
                    stmtInsert.addBatch();
                }
            }

            stmtInsert.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmtDelete != null) stmtDelete.close();
                if (stmtInsert != null) stmtInsert.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private int buscarPlaylistIdPorNomeEUsuario(String nome, int usuarioId, Connection conn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT id FROM playlist WHERE nome = ? AND usuario_id = ?");
        stmt.setString(1, nome);
        stmt.setInt(2, usuarioId);
        var rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        }
        throw new SQLException("Playlist não encontrada: " + nome);
    }

    public void registrarBusca(int idUsuario, String termo) {
        String sql = "INSERT INTO historico_buscas (id_usuario, texto_busca) VALUES (?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setString(2, termo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<String> obterUltimas10Buscas(int idUsuario) {
        List<String> historico = new ArrayList<>();
        String sql = "SELECT texto_busca FROM historico_buscas WHERE id_usuario = ? ORDER BY id DESC LIMIT 10";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                historico.add(rs.getString("texto_busca"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return historico;
    }

    
     public List<String> buscarMusicasCurtidas(int idUsuario) {
        List<String> nomesMusicas = new ArrayList<>();
        String sql = "SELECT m.nome FROM curtidas c " +
                     "JOIN musica m ON c.id_musica = m.id " +
                     "WHERE c.id_usuario = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    nomesMusicas.add(rs.getString("nome"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nomesMusicas;
    }
     
     public List<String> buscarMusicasDescurtidas(int idUsuario) {
        List<String> nomesMusicas = new ArrayList<>();
        String sql = "SELECT m.nome FROM descurtidas d " +
                     "JOIN musica m ON d.id_musica = m.id " +
                     "WHERE d.id_usuario = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    nomesMusicas.add(rs.getString("nome"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nomesMusicas;
    }
}
