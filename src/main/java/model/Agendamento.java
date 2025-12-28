package model;

import java.time.LocalDateTime;

public class Agendamento {

    private int id;
    private LocalDateTime dataHora;
    private String estado;

    public Agendamento(int id, LocalDateTime dataHora, String estado) {
        this.id = id;
        this.dataHora = dataHora;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getEstado() {
        return estado;
    }
}
