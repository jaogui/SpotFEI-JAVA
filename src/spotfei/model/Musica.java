package spotfei.model;

/**
 * Representa uma música com suas informações básicas,
 * como nome, gênero e o artista associado.
 * 
 * @author unifjfaber
 */
public class Musica {
    private int id;
    private String nome;
    private String genero;
    private int artista_id;
    private String nomeArtista;

    /**
     * Construtor que cria uma música com id, nome, gênero e id do artista.
     * 
     * @param id Identificador único da música
     * @param nome Nome da música
     * @param genero Gênero musical da música
     * @param artista_id Identificador do artista que criou a música
     */
    public Musica(int id, String nome, String genero, int artista_id) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.artista_id = artista_id;
    }

    /**
     * Retorna o ID da música.
     * 
     * @return id da música
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome da música.
     * 
     * @return nome da música
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o gênero da música.
     * 
     * @return gênero musical
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Retorna o ID do artista associado à música.
     * 
     * @return id do artista
     */
    public int getArtista() {
        return artista_id;
    }
}
