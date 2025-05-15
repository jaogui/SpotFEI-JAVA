package spotfei.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um usuário do sistema, que herda os dados básicos de Pessoa
 * e implementa a interface de autenticação.
 * O usuário possui playlists, histórico de músicas tocadas,
 * além de listas de músicas curtidas e descurtidas.
 * 
 * Também contém uma classe interna para controlar o usuário atualmente logado.
 * 
 * @author unifjfaber
 */
public class Usuario extends Pessoa implements Autenticacao {

    private int id;
    private List<PlayList> playlists;
    private List<Musica> historico;
    private List<Musica> curtidas;
    private List<Musica> descurtidas;

    /**
     * Cria um usuário com id, nome, email e senha.
     * Inicializa as listas de playlists, histórico, curtidas e descurtidas vazias.
     * 
     * @param id Identificador único do usuário
     * @param nome Nome do usuário
     * @param email Email do usuário
     * @param senha Senha do usuário
     */
    public Usuario(int id, String nome, String email, String senha) {
        super(nome, email, senha);
        this.id = id;
        this.playlists = new ArrayList<>();
        this.historico = new ArrayList<>();
        this.curtidas = new ArrayList<>();
        this.descurtidas = new ArrayList<>();
    }

    /**
     * Retorna o ID do usuário.
     * 
     * @return id do usuário
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna a lista de playlists do usuário.
     * 
     * @return listas de playlists
     */
    public List<PlayList> getPlaylists() {
        return playlists;
    }

    /**
     * Define a lista de playlists do usuário.
     * 
     * @param playlists nova lista de playlists
     */
    public void setPlaylists(List<PlayList> playlists) {
        this.playlists = playlists;
    }

    /**
     * Retorna o histórico de músicas tocadas pelo usuário.
     * 
     * @return lista de músicas do histórico
     */
    public List<Musica> getHistorico() {
        return historico;
    }

    /**
     * Define o histórico de músicas do usuário.
     * 
     * @param historico nova lista para o histórico
     */
    public void setHistorico(List<Musica> historico) {
        this.historico = historico;
    }

    /**
     * Retorna a lista de músicas que o usuário curtiu.
     * 
     * @return lista de músicas curtidas
     */
    public List<Musica> getCurtidas() {
        return curtidas;
    }

    /**
     * Define a lista de músicas curtidas do usuário.
     * 
     * @param curtidas nova lista de músicas curtidas
     */
    public void setCurtidas(List<Musica> curtidas) {
        this.curtidas = curtidas;
    }

    /**
     * Retorna a lista de músicas descurtidas pelo usuário.
     * 
     * @return lista de músicas descurtidas
     */
    public List<Musica> getDescurtidas() {
        return descurtidas;
    }

    /**
     * Define a lista de músicas descurtidas do usuário.
     * 
     * @param descurtidas nova lista de músicas descurtidas
     */
    public void setDescurtidas(List<Musica> descurtidas) {
        this.descurtidas = descurtidas;
    }

    /**
     * Verifica se o email e senha fornecidos correspondem aos do usuário.
     * 
     * @param email Email para autenticação
     * @param senha Senha para autenticação
     * @return true se email e senha conferem, false caso contrário
     */
    @Override
    public boolean login(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    /**
     * Classe estática que mantém o controle do usuário atualmente logado.
     */
    public static class UsuarioLogado {
        private static Usuario usuarioLogado;

        /**
         * Retorna o usuário que está atualmente logado no sistema.
         * 
         * @return usuário logado
         */
        public static Usuario getUsuarioLogado() {
            return usuarioLogado;
        }

        /**
         * Define qual usuário está logado no sistema.
         * 
         * @param usuario usuário a ser marcado como logado
         */
        public static void setUsuarioLogado(Usuario usuario) {
            usuarioLogado = usuario;
        }
    }
}
