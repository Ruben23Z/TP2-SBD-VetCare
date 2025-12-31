package dao;

import utils.DBConnection;
import java.sql.*;
import java.time.LocalDateTime;

public class ServicoDAO {

    public int criarServico(String descricao,
                            LocalDateTime agendada,
                            int idPaciente,
                            int idUtilizador,
                            String localidade) throws SQLException {

        String sql = """
            INSERT INTO ServicoMedicoAgendamento
            (descricao, dataHoraAgendada, dataHoraInicio,
             iDPaciente, iDUtilizador, localidade)
            VALUES (?, ?, NOW(), ?, ?, ?)
        """;

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps =
                     c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, descricao);
            ps.setTimestamp(2, Timestamp.valueOf(agendada));
            ps.setInt(3, idPaciente);
            ps.setInt(4, idUtilizador);
            ps.setString(5, localidade);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        }
    }
}
