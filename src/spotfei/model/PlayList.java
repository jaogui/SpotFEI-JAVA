package spotfei.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma playlist, que é uma lista de músicas agrupadas sob um nome.
 * Permite adicionar e remover músicas, além de acessar suas informações.
 * 
 * @author unifjfaber
 */
public class PlayList {
    private String nome;
    private List<Musica> musicas;

    /**
     * Cria uma nova playlist com o nome informado e uma lista vazia de músicas.
     * 
     * @param nome Nome da playlist
     */
    public PlayList(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    /**
     * Adiciona uma música à playlist.
     * 
     * @param musica Música a ser adicionada
     */
    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    /**
     * Remove uma música da playlist.
     * 
     * @param musica Música a ser removida
     */
    public void removerMusica(Musica musica) {
        musicas.remove(musica);
    }

    /**
     * Retorna o nome da playlist.
     * 
     * @return nome da playlist
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define um novo nome para a playlist.
     * 
     * @param nome Novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a lista de músicas presentes na playlist.
     * 
     * @return lista de músicas
     */
    public List<Musica> getMusicas() {
        return musicas;
    }
}
