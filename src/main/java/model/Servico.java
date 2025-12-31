package model;

import java.time.LocalDateTime;

public class Servico {

    protected int idServico;
    protected String descricao;
    protected LocalDateTime dataHoraInicio;

    public Servico(int idServico, String descricao, LocalDateTime dataHoraInicio) {
        this.idServico = idServico;
        this.descricao = descricao;
        this.dataHoraInicio = dataHoraInicio;
    }

    public int getIdServico() {
        return idServico;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public String getDescricao() {
        return descricao;
    }
}
