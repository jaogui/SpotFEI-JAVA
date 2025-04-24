package spotfei.model;

import java.util.List;

public class Usuario extends Pessoa implements Autenticacao {
    private List<PlayList> playlists;

    public Usuario(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    @Override
    public boolean login(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    // Métodos para gerenciar playlists...
}
