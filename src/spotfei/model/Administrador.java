package spotfei.model;

public class Administrador extends Pessoa implements Autenticacao {
    public Administrador(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    @Override
    public boolean login(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }
}
