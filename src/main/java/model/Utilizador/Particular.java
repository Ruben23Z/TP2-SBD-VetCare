package model.Utilizador;

public class Particular {

    private String nif;
    private String prefLinguistica;

    public Particular(int idUtilizador, String nif, String prefLinguistica, String email, String telefone, String rua, String pais, String distrito, String concelho, String freguesia, String linguistica) {
        this.nif = nif;
        this.prefLinguistica = prefLinguistica;
    }

    public Particular(String nif, String prefLinguistica) {
        this.nif = nif;
        this.prefLinguistica = prefLinguistica;
    }


    public String getNif() { return nif; }
    public String getPrefLinguistica() { return prefLinguistica; }
}
