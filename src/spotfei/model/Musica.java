package spotfei.model;

public class Musica {
    private int id;
    private String nome;
    private String genero;
    private String artista;

    public Musica(int id, String nome, String genero, String artista) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.artista = artista;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public String getArtista() {
        return artista;
    }
}
