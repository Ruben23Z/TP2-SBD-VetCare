package model;

public class Desparasitacao {

    private int idServico;
    private String dose;
    private boolean interna;

    public Desparasitacao(int idServico, String dose, boolean interna) {
        this.idServico = idServico;
        this.dose = dose;
        this.interna = interna;
    }

    public int getIdServico() {
        return idServico;
    }

    public String getDose() {
        return dose;
    }

    public boolean isInterna() {
        return interna;
    }
}
