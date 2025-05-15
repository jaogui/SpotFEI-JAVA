package spotfei.model;

import java.time.LocalDateTime;

/**
 * Representa um registro do histórico de buscas de um usuário.
 * Contém o ID do usuário, o termo pesquisado e o timestamp da busca.
 * 
 * @author unifjfaber
 */
public class HistoricoBusca {
    private int id;
    private int idUsuario;
    private String termoBusca;
    private LocalDateTime dataHora;

    /**
     * Cria um novo registro de histórico de busca para o usuário,
     * armazenando o termo buscado e o momento da criação.
     * 
     * @param idUsuario ID do usuário que realizou a busca
     * @param termoBusca Texto pesquisado pelo usuário
     */
    public HistoricoBusca(int idUsuario, String termoBusca) {
        this.idUsuario = idUsuario;
        this.termoBusca = termoBusca;
        this.dataHora = LocalDateTime.now();
    }

    /**
     * Retorna o ID do usuário que realizou a busca.
     * 
     * @return ID do usuário
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Retorna o termo pesquisado pelo usuário.
     * 
     * @return termo de busca
     */
    public String getTermoBusca() {
        return termoBusca;
    }

    /**
     * Retorna a data e hora em que a busca foi realizada.
     * 
     * @return data e hora da busca
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
