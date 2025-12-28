package model;

public class Clinica {

    private String localidade;
    private String codigoPostal;
    private String contacto;

    public Clinica(String localidade, String codigoPostal, String contacto) {
        this.localidade = localidade;
        this.codigoPostal = codigoPostal;
        this.contacto = contacto;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getContacto() {
        return contacto;
    }
}
