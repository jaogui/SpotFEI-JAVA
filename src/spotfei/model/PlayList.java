package spotfei.model;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private int id;
    private String nome;
    private List<Musica> musicas;

    public PlayList(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void removerMusica(Musica musica) {
        musicas.remove(musica);
    }

    // Getters e Setters
}
