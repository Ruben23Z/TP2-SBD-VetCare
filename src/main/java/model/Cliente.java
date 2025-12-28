package model;

public class Cliente {

    private String nif;
    private String nome;
    private String email;
    private String telefone;

    public Cliente(String nif, String nome, String email, String telefone) {
        this.nif = nif;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNif() {
        return nif;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
