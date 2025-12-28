package model;

import java.time.LocalDateTime;

public class Cirurgia {

    private int idServico;
    private String tipoCirurgia;
    private LocalDateTime dataHoraFim;

    public Cirurgia(int idServico, String tipoCirurgia, LocalDateTime dataHoraFim) {
        this.idServico = idServico;
        this.tipoCirurgia = tipoCirurgia;
        this.dataHoraFim = dataHoraFim;
    }

    public int getIdServico() {
        return idServico;
    }

    public String getTipoCirurgia() {
        return tipoCirurgia;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }
}
