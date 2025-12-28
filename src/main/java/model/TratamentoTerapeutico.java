package model;

import java.time.LocalDateTime;

public class TratamentoTerapeutico {

    private int idServico;
    private String tipoTratamento;
    private int frequencia;
    private LocalDateTime dataHoraFim;

    public TratamentoTerapeutico(int idServico, String tipoTratamento,
                                 int frequencia, LocalDateTime dataHoraFim) {
        this.idServico = idServico;
        this.tipoTratamento = tipoTratamento;
        this.frequencia = frequencia;
        this.dataHoraFim = dataHoraFim;
    }

    public int getIdServico() {
        return idServico;
    }

    public String getTipoTratamento() {
        return tipoTratamento;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }
}
