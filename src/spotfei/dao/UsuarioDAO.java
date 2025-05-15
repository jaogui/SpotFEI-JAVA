package spotfei.dao;

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

/**
 * Classe responsável pelas operações de banco de dados relacionadas ao usuário.
 * Implementa métodos para listar, buscar, cadastrar usuários, além de gerenciar curtidas,
 * descurtidas, playlists e histórico de buscas.
 * 
 * @author unifjfaber
 */
public class UsuarioDAO {

    /**
     * Recupera a lista completa de usuários cadastrados no sistema.
     * 
     * @return Lista de objetos Usuario encontrados no banco de dados.
     */
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

    /**
     * Busca um usuário pelo seu email e senha, usado para autenticação.
     * 
     * @param email Email do usuário.
     * @param senha Senha do usuário.
     * @return Objeto Usuario caso encontre correspondência, ou null caso contrário.
     */
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

    /**
     * Insere um novo usuário no banco de dados.
     * 
     * @param usuario Objeto Usuario com os dados a serem cadastrados.
     */
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

    /**
     * Marca uma música como curtida por um usuário.
     * Remove qualquer marcação de descurtida para essa música e usuário.
     * 
     * @param usuarioId ID do usuário que curte a música.
     * @param musicaId ID da música que será curtida.
     */
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

    /**
     * Marca uma música como descurtida por um usuário.
     * Remove qualquer marcação de curtida para essa música e usuário.
     * 
     * @param usuarioId ID do usuário que descurte a música.
     * @param musicaId ID da música que será descurtida.
     */
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

    /**
     * Cria uma nova playlist para um usuário.
     * 
     * @param nome Nome da playlist a ser criada.
     * @param usuarioId ID do usuário dono da playlist.
     * @throws SQLException Caso ocorra algum erro no banco.
     */
    public void criarPlaylist(String nome, int usuarioId) throws SQLException {
        String sqlInsert = "INSERT INTO playlist (nome, usuario_id) VALUES (?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nome);
            stmt.setInt(2, usuarioId);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Criar Playlist falhou, nenhuma linha foi afetada.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int playlistId = generatedKeys.getInt(1);
                    System.out.println("Playlist criada com ID: " + playlistId);
                } else {
                    throw new SQLException("Criar Playlist falhou, nenhum ID foi gerado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        }
    }

    /**
     * Atualiza as playlists de um usuário no banco, substituindo as músicas existentes pelas novas.
     * 
     * @param usuario Objeto Usuario com a lista atualizada de playlists.
     */
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

    /**
     * Busca o ID da playlist dado o nome e o ID do usuário.
     * 
     * @param nome Nome da playlist.
     * @param usuarioId ID do usuário dono da playlist.
     * @param conn Conexão com o banco de dados.
     * @return ID da playlist encontrada.
     * @throws SQLException Caso a playlist não seja encontrada.
     */
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

    /**
     * Registra uma busca feita pelo usuário no histórico.
     * 
     * @param idUsuario ID do usuário que realizou a busca.
     * @param termo Texto pesquisado pelo usuário.
     */
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

    /**
     * Obtém as últimas 10 buscas realizadas por um usuário.
     * 
     * @param idUsuario ID do usuário.
     * @return Lista com os termos buscados, do mais recente ao mais antigo.
     */
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

    /**
     * Busca os nomes das músicas curtidas por um usuário.
     * 
     * @param idUsuario ID do usuário.
     * @return Lista com os nomes das músicas curtidas.
     */
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

    /**
     * Busca os nomes das músicas descurtidas por um usuário.
     * 
     * @param idUsuario ID do usuário.
     * @return Lista com os nomes das músicas descurtidas.
     */
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