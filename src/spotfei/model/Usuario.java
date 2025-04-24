package spotfei.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Pessoa implements Autenticacao {

    public List<PlayList> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlayList> playlists) {
        this.playlists = playlists;
    }

    public List<Musica> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Musica> historico) {
        this.historico = historico;
    }

    public List<Musica> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Musica> curtidas) {
        this.curtidas = curtidas;
    }

    public List<Musica> getDescurtidas() {
        return descurtidas;
    }

    public void setDescurtidas(List<Musica> descurtidas) {
        this.descurtidas = descurtidas;
    }
    private int id;
    private List<PlayList> playlists;
    private List<Musica> historico;
    private List<Musica> curtidas;
    private List<Musica> descurtidas;

    public Usuario(int id, String nome, String email, String senha) {
        super(nome, email, senha);
        this.id = id;
        this.playlists = new ArrayList<>();
        this.historico = new ArrayList<>();
        this.curtidas = new ArrayList<>();
        this.descurtidas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean login(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }
}
