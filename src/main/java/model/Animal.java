package model;

import java.sql.Date;
import java.time.LocalDate;

public class Animal {
    private int id;

    private int clienteId;
    private String nome;
    private String especie;
    private String raca;
    private Date dataNascimento;
    private String fotoPath; // caminho da fotografia


    public Animal(int id, int clienteId, String nome, String especie, String raca, Date dataNascimento, String fotoPath) {
        this.id = id;
        this.clienteId = clienteId;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.fotoPath = fotoPath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }


    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public String getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(String fotoPath) {
        this.fotoPath = fotoPath;
    }

    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

}

