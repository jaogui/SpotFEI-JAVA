package Controller;

import spotfei.dao.UsuarioDAO;
import spotfei.model.Usuario;

/**
 * Controlador responsável por gerenciar as operações relacionadas ao usuário,
 * como cadastro e login, atuando como intermediário entre a camada de visualização
 * e o acesso a dados (DAO).
 * 
 * @author unifjfaber
 */
public class UsuarioController {

    /**
     * Instância do objeto que faz a persistência dos usuários no banco de dados.
     */
    private UsuarioDAO usuarioDAO;

    /**
     * Construtor que inicializa o UsuarioDAO.
     */
    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    /**
     * Realiza o cadastro de um novo usuário.
     * 
     * @param nome Nome do usuário.
     * @param email Email do usuário.
     * @param senha Senha do usuário.
     * @return true se o cadastro for válido e realizado, false se algum campo estiver vazio.
     */
    public boolean cadastrarUsuario(String nome, String email, String senha) {
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            return false;
        }

        // O ID é gerado pelo banco de dados
        Usuario usuario = new Usuario(0, nome, email, senha);
        usuarioDAO.cadastrarUsuario(usuario);
        return true;
    }

    /**
     * Efetua o login do usuário buscando no banco pelo email e senha.
     * 
     * @param email Email do usuário.
     * @param senha Senha do usuário.
     * @return Objeto Usuario caso as credenciais estejam corretas, ou null caso contrário.
     */
    public Usuario login(String email, String senha) {
        return usuarioDAO.buscarPorEmailESenha(email, senha);
    }
}
