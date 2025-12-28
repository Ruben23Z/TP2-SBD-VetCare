package model;

import java.time.LocalDate;

public class Vacinacao {

    private int idServico;
    private String fabricante;
    private LocalDate dataReforco;

    public Vacinacao(int idServico, String fabricante, LocalDate dataReforco) {
        this.idServico = idServico;
        this.fabricante = fabricante;
        this.dataReforco = dataReforco;
    }

    public int getIdServico() {
        return idServico;
    }

    public String getFabricante() {
        return fabricante;
    }

    public LocalDate getDataReforco() {
        return dataReforco;
    }
}
