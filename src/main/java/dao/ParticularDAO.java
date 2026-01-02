package dao;

import model.Utilizador.Particular;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ParticularDAO {

    public void inserir(Particular p) throws Exception {

        String sql = "INSERT INTO Particular (NIF, prefLinguistica) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNif());
            ps.setString(2, p.getPrefLinguistica());
            ps.executeUpdate();
        }
    }

    public void deleteByNif(String nif) throws Exception {
        String sql = "DELETE FROM Particular WHERE NIF=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, nif);
            ps.executeUpdate();
        }
    }

}
