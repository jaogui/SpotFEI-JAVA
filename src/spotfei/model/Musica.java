package spotfei.model;

public class Musica {
    private String nome;
    private String genero;
    private String artista;

    public Musica(String nome, String genero, String artista) {
        this.nome = nome;
        this.genero = genero;
        this.artista = artista;
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
