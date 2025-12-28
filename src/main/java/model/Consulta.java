package model;

import java.time.LocalDateTime;

public class Consulta {

    private int idServico;
    private String diagnostico;
    private String sintomas;
    private LocalDateTime proxConsulta;

    public Consulta(int idServico, String diagnostico,
                    String sintomas, LocalDateTime proxConsulta) {
        this.idServico = idServico;
        this.diagnostico = diagnostico;
        this.sintomas = sintomas;
        this.proxConsulta = proxConsulta;
    }

    public int getIdServico() {
        return idServico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getSintomas() {
        return sintomas;
    }

    public LocalDateTime getProxConsulta() {
        return proxConsulta;
    }
}
