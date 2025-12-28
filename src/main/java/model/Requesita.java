package model;

import java.time.LocalDate;

public class Requesita {

    private int idAvaliacao;
    private String nifCliente;
    private int idServico;
    private LocalDate dataAvaliacao;
    private String avaliacao;
    private String comentario;

    public Requesita(int idAvaliacao, String nifCliente,
                     int idServico, LocalDate dataAvaliacao,
                     String avaliacao, String comentario) {
        this.idAvaliacao = idAvaliacao;
        this.nifCliente = nifCliente;
        this.idServico = idServico;
        this.dataAvaliacao = dataAvaliacao;
        this.avaliacao = avaliacao;
        this.comentario = comentario;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public String getNifCliente() {
        return nifCliente;
    }

    public int getIdServico() {
        return idServico;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public String getComentario() {
        return comentario;
    }
}
