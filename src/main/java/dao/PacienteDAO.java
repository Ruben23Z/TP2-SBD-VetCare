package dao;

import model.Paciente;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    /* =========================
       INSERT
       ========================= */
    public void inserir(Paciente a, String nifCliente, String raca) throws SQLException {

        String sql = """
                    INSERT INTO Paciente (iDPaciente, nome, dataNascimento, NIF, raca)
                    VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, a.getidPaciente());
            ps.setString(2, a.getNome());
            ps.setDate(3, Date.valueOf(a.getDataNascimento()));
            ps.setString(4, nifCliente);
            ps.setString(5, raca);

            ps.executeUpdate();
        }
    }

    /* =========================
       UPDATE
       ========================= */
    public void update(Paciente a, String nifCliente, String raca) throws SQLException {

        String sql = """
                    UPDATE Paciente
                    SET nome = ?, dataNascimento = ?, NIF = ?, raca = ?
                    WHERE iDPaciente = ?
                """;

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, a.getNome());
            ps.setDate(2, Date.valueOf(a.getDataNascimento()));
            ps.setString(3, nifCliente);
            ps.setString(4, raca);
            ps.setInt(5, a.getidPaciente());

            ps.executeUpdate();
        }
    }

    /* =========================
       DELETE
       ========================= */
    public void delete(int idPaciente) throws SQLException {

        String sql = "DELETE FROM Paciente WHERE iDPaciente = ?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, idPaciente);
            ps.executeUpdate();
        }
    }

    /* =========================
       FIND BY ID
       ========================= */
    public Paciente findById(int idPaciente) throws SQLException {

        String sql = """
                    SELECT iDPaciente, nome, dataNascimento
                    FROM Paciente
                    WHERE iDPaciente = ?
                """;

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Paciente(
                        rs.getInt("iDPaciente"),
                        rs.getString("nome"),
                        rs.getDate("dataNascimento").toLocalDate(),
                        rs.getInt("pesoAtual"),
                        rs.getString("sexo").charAt(0),
                        rs.getString("raca"));
            }
        }
        return null;
    }

    /* =========================
       FIND BY TUTOR (NIF)
       ========================= */
    public List<Paciente> findByTutor(String nif) throws SQLException {

        List<Paciente> lista = new ArrayList<>();

        String sql = """
                    SELECT iDPaciente, nome, dataNascimento, pesoAtual, sexo, raca
                    FROM Paciente
                    WHERE NIF = ?
                    ORDER BY nome
                """;

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, nif);
            ResultSet rs = ps.executeQuery();



            while (rs.next()) {
                lista.add(new Paciente(
                        rs.getInt("iDPaciente"),
                        rs.getString("nome"),
                        rs.getDate("dataNascimento").toLocalDate(),
                        rs.getInt("pesoAtual"),
                        rs.getString("sexo").charAt(0),
                        rs.getString("raca")
                ));
            }
        }
        return lista;
    }
}
