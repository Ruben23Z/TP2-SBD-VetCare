package model.Utilizador;


public class Empresa extends Cliente {
    private int capitalSocial;


    public Empresa(int iDUtilizador, String NIF, String nome, String email, String telefone,
                   String rua, String pais, String distrito, String concelho, String freguesia,
                   int capitalSocial) {
        super(iDUtilizador, NIF, nome, email, telefone, rua, pais, distrito, concelho, freguesia);
        this.capitalSocial = capitalSocial;
    }

    public int getCapitalSocial() { return capitalSocial; }
    public void setCapitalSocial(int capitalSocial) { this.capitalSocial = capitalSocial; }
}
