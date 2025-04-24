package spotfei.model;

public class Musica {
    private int id;
    private String nome;
    private String genero;
    private Artista artista;

    public Musica(int id, String nome, String genero, Artista artista) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.artista = artista;
    }

    // Getters e Setters
}
