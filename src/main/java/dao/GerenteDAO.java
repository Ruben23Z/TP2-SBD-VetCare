package dao;

import utils.DBConnection;
import java.sql.*;

public class GerenteDAO {

    public ResultSet historicoServicos() throws SQLException {
        Connection c = DBConnection.getConnection();
        return c.prepareStatement(
                "SELECT * FROM Historico_Servicos"
        ).executeQuery();
    }

    public ResultSet agendaClinica() throws SQLException {
        Connection c = DBConnection.getConnection();
        return c.prepareStatement(
                "SELECT * FROM Agenda_Clinica"
        ).executeQuery();
    }

    public ResultSet avaliacoes() throws SQLException {
        Connection c = DBConnection.getConnection();
        return c.prepareStatement(
                "SELECT * FROM Avaliacoes_Detalhadas"
        ).executeQuery();
    }
}
