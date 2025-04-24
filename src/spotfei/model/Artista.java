package spotfei.model;

import java.util.ArrayList;
import java.util.List;
import spotfei.model.Musica;
import spotfei.model.PlayList;


public class Artista extends Pessoa {
    private List<Musica> musicas;

    public Artista(String nome, String email, String senha) {
        super(nome, email, senha);
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public List<Musica> getMusicas() {
        return musicas;
    }
}
