package dao;

import model.Utilizador.Particular;
import utils.DBConnection;

import java.sql.*;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.List;

public class ParticularDAO {

    public void insert(Particular p) throws SQLException {
        String sql = "INSERT INTO Particular (NIF, prefLinguistica) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNIF());
            ps.setString(2, p.getPrefLinguistica());
            ps.executeUpdate();
        }
    }

    public void update(Particular p) throws SQLException {
        String sql = "UPDATE Particular SET prefLinguistica=? WHERE NIF=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getPrefLinguistica());
            ps.setString(2, p.getNIF());
            ps.executeUpdate();
        }
    }

    public void delete(String NIF) throws SQLException {
        String sql = "DELETE FROM Particular WHERE NIF=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, NIF);
            ps.executeUpdate();
        }
    }

    public Particular findByNIF(String NIF) throws SQLException {

        String sql = """
                    SELECT u.iDUtilizador, c.NIF, u.nome, u.email, u.telefone,
                           u.rua, u.pais, u.distrito, u.concelho, u.freguesia,
                           p.prefLinguistica
                    FROM Particular p
                    JOIN Cliente c ON p.NIF = c.NIF
                    JOIN Utilizador u ON c.iDUtilizador = u.iDUtilizador
                    WHERE p.NIF = ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, NIF);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Particular(
                        rs.getInt("iDUtilizador"),
                        rs.getString("NIF"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("rua"),
                        rs.getString("pais"),
                        rs.getString("distrito"),
                        rs.getString("concelho"),
                        rs.getString("freguesia"),
                        rs.getString("prefLinguistica")
                );
            }
        }
        return null;
    }

    public List<Particular> findAll() throws SQLException {
        List<Particular> list = new ArrayList<>();

        String sql = """
                    SELECT u.iDUtilizador, c.NIF, u.nome, u.email, u.telefone,
                           u.rua, u.pais, u.distrito, u.concelho, u.freguesia,
                           p.prefLinguistica
                    FROM Particular p
                    JOIN Cliente c ON p.NIF = c.NIF
                    JOIN Utilizador u ON c.iDUtilizador = u.iDUtilizador
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                list.add(new Particular(
                        rs.getInt("iDUtilizador"),
                        rs.getString("NIF"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("rua"),
                        rs.getString("pais"),
                        rs.getString("distrito"),
                        rs.getString("concelho"),
                        rs.getString("freguesia"),
                        rs.getString("prefLinguistica")
                ));
            }
        }
        return list;
    }
}
