package spotfei.model;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private String nome;

    private List<Musica> musicas;

    public PlayList(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void removerMusica(Musica musica) {
        musicas.remove(musica);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Musica> getMusicas() {
        return musicas;
    }
}
