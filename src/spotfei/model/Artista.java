/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package spotfei.model;
/**
 *
 * @author unifjfaber
 */
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
