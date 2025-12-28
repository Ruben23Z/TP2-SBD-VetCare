package dao;

import model.Veterinario;
import utils.DBConnection;

import java.sql.*;
import java.util.*;

public class VeterinarioDAO {

    public List<Veterinario> listar() throws SQLException {
        List<Veterinario> lista = new ArrayList<>();

        String sql = "SELECT nLicenca, nome, especialidade FROM Veterinario";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Veterinario(
                        rs.getString("nLicenca"),
                        rs.getString("nome"),
                        rs.getString("especialidade")
                ));
            }
        }
        return lista;
    }
}
