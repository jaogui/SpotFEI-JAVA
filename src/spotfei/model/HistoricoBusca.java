/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spotfei.model;

import java.time.LocalDateTime;
/**
 *
 * @author unifjfaber
 */



public class HistoricoBusca {
    private int id;
    private int idUsuario;
    private String termoBusca;
    private LocalDateTime dataHora;

    // Construtores
    public HistoricoBusca(int idUsuario, String termoBusca) {
        this.idUsuario = idUsuario;
        this.termoBusca = termoBusca;
        this.dataHora = LocalDateTime.now();
    }

    // Getters e Setters
    public int getIdUsuario() { return idUsuario; }
    public String getTermoBusca() { return termoBusca; }
    public LocalDateTime getDataHora() { return dataHora; }
}

