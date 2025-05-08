/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package spotfei.model;
/**
 *
 * @author unifjfaber
 */
public class Musica {
    private int id;
    private String nome;
    private String genero;
    private int artista_id;
    private String nomeArtista;


    public Musica(int id, String nome, String genero, int artista_id) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.artista_id = artista_id;

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

    public int getArtista() {
        return artista_id;
    }
}
