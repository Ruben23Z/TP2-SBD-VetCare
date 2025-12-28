package model;

import java.time.LocalDateTime;

public class Exame {

    private int idServico;
    private String tipoExame;
    private String observacaoTecnica;
    private int duracao;

    public Exame(int idServico, String tipoExame,
                 String observacaoTecnica, int duracao) {
        this.idServico = idServico;
        this.tipoExame = tipoExame;
        this.observacaoTecnica = observacaoTecnica;
        this.duracao = duracao;
    }

    public int getIdServico() {
        return idServico;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public String getObservacaoTecnica() {
        return observacaoTecnica;
    }

    public int getDuracao() {
        return duracao;
    }
}
