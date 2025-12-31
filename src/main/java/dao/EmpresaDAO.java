package dao;

import model.Utilizador.Empresa;
import model.Utilizador.Particular;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {

    public void insert(Empresa e) throws SQLException {
        String sql = "INSERT INTO Empresa (NIF, capitalSocial) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, e.getNIF());
            ps.setInt(2, e.getCapitalSocial());
            ps.executeUpdate();
        }
    }

    public void update(Empresa e) throws SQLException {
        String sql = "UPDATE Empresa SET capitalSocial=? WHERE NIF=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, e.getCapitalSocial());
            ps.setString(2, e.getNIF());
            ps.executeUpdate();
        }
    }

    public void delete(String NIF) throws SQLException {
        String sql = "DELETE FROM Empresa WHERE NIF=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, NIF);
            ps.executeUpdate();
        }
    }


    public Empresa findByNIF(String NIF) throws SQLException {

        String sql = """
                    SELECT u.iDUtilizador, c.NIF, u.nome, u.email, u.telefone,
                           u.rua, u.pais, u.distrito, u.concelho, u.freguesia,
                           p.capitalSocial
                    FROM Empresa p
                    JOIN Cliente c ON p.NIF = c.NIF
                    JOIN Utilizador u ON c.iDUtilizador = u.iDUtilizador
                    WHERE p.NIF = ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, NIF);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Empresa(
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
                        rs.getInt("capitalSocial")
                );
            }
        }
        return null;
    }


    public List<Empresa> findAll() throws SQLException {
        List<Empresa> list = new ArrayList<>();

        String sql = """
                    SELECT u.iDUtilizador, c.NIF, u.nome, u.email, u.telefone,
                           u.rua, u.pais, u.distrito, u.concelho, u.freguesia,
                           p.prefLinguistica
                    FROM Empresa p
                    JOIN Cliente c ON p.NIF = c.NIF
                    JOIN Utilizador u ON c.iDUtilizador = u.iDUtilizador
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                list.add(new Empresa(
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
                        rs.getInt("CapitalSocial")
                ));
            }
        }
        return list;

    }
}
