package model;

import java.time.LocalDateTime;

public class ServicoMedicoAgendamento extends Servico {

    private LocalDateTime dataHoraAgendada;
    private String estado;
    private int idPaciente;
    private String localidade;

    public ServicoMedicoAgendamento(int idServico, String descricao,
                                    LocalDateTime dataHoraAgendada,
                                    String estado, int idPaciente,
                                    String localidade) {
        super(idServico, descricao);
        this.dataHoraAgendada = dataHoraAgendada;
        this.estado = estado;
        this.idPaciente = idPaciente;
        this.localidade = localidade;
    }

    public LocalDateTime getDataHoraAgendada() {
        return dataHoraAgendada;
    }

    public String getEstado() {
        return estado;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public String getLocalidade() {
        return localidade;
    }
}
