package spotfei.model;

/**
 * Classe abstrata que representa uma pessoa no sistema,
 * com informações básicas como nome, email e senha.
 * Serve como base para outras classes que representam tipos específicos de pessoas.
 * 
 * @author unifjfaber
 */
public abstract class Pessoa {
    protected String nome;
    protected String email;
    protected String senha;

    /**
     * Cria uma pessoa com nome, email e senha.
     * 
     * @param nome Nome da pessoa
     * @param email Email da pessoa
     * @param senha Senha para acesso
     */
    public Pessoa(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    /**
     * Retorna o nome da pessoa.
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o email da pessoa.
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retorna a senha da pessoa.
     * 
     * @return senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define o nome da pessoa.
     * 
     * @param nome Novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define o email da pessoa.
     * 
     * @param email Novo email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Define a senha da pessoa.
     * 
     * @param senha Nova senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
