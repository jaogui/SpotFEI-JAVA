package spotfei.model;

import java.util.List;

public class Artista extends Pessoa {
    private List<Musica> musicas;

    public Artista(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    // Métodos para gerenciar músicas
}
