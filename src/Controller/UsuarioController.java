package Controller;

import spotfei.dao.UsuarioDAO;
import spotfei.model.Usuario;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean cadastrarUsuario(String nome, String email, String senha) {
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            return false;
        }

        Usuario usuario = new Usuario(0, nome, email, senha); //o id quem faz é o banco 
        usuarioDAO.cadastrarUsuario(usuario);
        return true;
    }

    public Usuario login(String email, String senha) {
        return usuarioDAO.buscarPorEmailESenha(email, senha);
    }
}
