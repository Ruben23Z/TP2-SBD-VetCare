package dao;

import model.Tutor;
import utils.DBConnection;

import java.sql.*;

public class TutorDAO {

    public void create(Tutor t, int idUtilizador) throws SQLException {

        Connection c = DBConnection.getConnection();
        try {
            c.setAutoCommit(false);

            // 1️⃣ Inserir Utilizador
            String sqlUser = """
                INSERT INTO Utilizador (iDUtilizador, isCliente)
                VALUES (?, true)
            """;
            try (PreparedStatement ps = c.prepareStatement(sqlUser)) {
                ps.setInt(1, idUtilizador);
                ps.executeUpdate();
            }

            // 2️⃣ Inserir Cliente
            String sqlCliente = """
                INSERT INTO Cliente
                (iDUtilizador, NIF, nome, email, telefone, rua, pais)
                VALUES (?, ?, ?, ?, ?, 'Rua X', 'Portugal')
            """;

            try (PreparedStatement ps = c.prepareStatement(sqlCliente)) {
                ps.setInt(1, idUtilizador);
                ps.setString(2, t.getNif());
                ps.setString(3, t.getNome());
                ps.setString(4, t.getEmail());
                ps.setString(5, t.getTelefone());
                ps.executeUpdate();
            }

            c.commit();
        } catch (SQLException e) {
            c.rollback();
            throw e;
        } finally {
            c.close();
        }
    }
}
