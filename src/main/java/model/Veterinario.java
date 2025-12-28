package model;

public class Veterinario {

    private String nLicenca;
    private String nome;
    private String especialidade;

    public Veterinario(String nLicenca, String nome, String especialidade) {
        this.nLicenca = nLicenca;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getnLicenca() {
        return nLicenca;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}
