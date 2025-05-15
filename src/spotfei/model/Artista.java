package spotfei.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um artista no sistema Spotifei, que é uma especialização de Pessoa.
 * Um artista possui uma lista de músicas associadas.
 * 
 * @author unifjfaber
 */
public class Artista extends Pessoa {

    /** Lista de músicas associadas ao artista */
    private List<Musica> musicas;

    /**
     * Construtor que cria um artista com nome, email e senha.
     * Inicializa a lista de músicas vazia.
     * 
     * @param nome  o nome do artista
     * @param email o email do artista
     * @param senha a senha do artista
     */
    public Artista(String nome, String email, String senha) {
        super(nome, email, senha);
        this.musicas = new ArrayList<>();
    }

    /**
     * Adiciona uma música à lista de músicas do artista.
     * 
     * @param musica a música a ser adicionada
     */
    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    /**
     * Retorna a lista de músicas do artista.
     * 
     * @return lista das músicas associadas ao artista
     */
    public List<Musica> getMusicas() {
        return musicas;
    }
}
