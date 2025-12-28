package dao;

import model.Agendamento;
import utils.DBConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class AgendamentoDAO {

    public void create(int idPaciente, int idUtilizador,
                       LocalDateTime data, String localidade) throws SQLException {

        String sql = """
            INSERT INTO ServicoMedicoAgendamento
            (descricao, dataHoraInicio, dataHoraAgendada,
             iDPaciente, iDUtilizador, localidade)
            VALUES ('Consulta', NOW(), ?, ?, ?, ?)
        """;

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setTimestamp(1, Timestamp.valueOf(data));
            ps.setInt(2, idPaciente);
            ps.setInt(3, idUtilizador);
            ps.setString(4, localidade);

            ps.executeUpdate();
        }
    }

    public List<Agendamento> pendentes() throws SQLException {
        List<Agendamento> lista = new ArrayList<>();

        String sql = "SELECT * FROM Servicos_Pendentes";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Agendamento(
                        rs.getInt("iDServico"),
                        rs.getTimestamp("dataHoraAgendada").toLocalDateTime(),
                        rs.getString("estado")
                ));
            }
        }
        return lista;
    }
}
