package dao;

import utils.DBConnection;
import java.sql.*;

public class DocumentacaoDAO {

    public ResultSet listarDocumentacao() throws SQLException {

        String sql = "SELECT * FROM Historico_Documentacoes";

        Connection c = DBConnection.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        return ps.executeQuery();
    }
}
