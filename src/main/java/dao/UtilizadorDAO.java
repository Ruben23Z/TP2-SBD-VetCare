package dao;

import model.Utilizador.Utilizador;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilizadorDAO {

    public int inserir(Utilizador u) throws SQLException {
        String sql = "INSERT INTO Utilizador (username, password, isVeterinario, isRececionista, isCliente, isGerente) " + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, u.getUsername());
            pst.setString(2, u.getPassword());
            pst.setBoolean(3, u.isVeterinario());
            pst.setBoolean(4, u.isRececionista());
            pst.setBoolean(5, u.isCliente());
            pst.setBoolean(6, u.isGerente());

            pst.executeUpdate();

            try (ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);  // devolve o ID gerado
                } else {
                    throw new SQLException("Erro ao gerar ID do utilizador");
                }
            }
        }
    }


    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Utilizador WHERE iDUtilizador=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void atualizar(Utilizador u) throws SQLException {
        String sql = "UPDATE Utilizador SET isVeterinario=?, isRececionista=?, isCliente=? WHERE iDUtilizador=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, u.isVeterinario());
            ps.setBoolean(2, u.isRececionista());
            ps.setBoolean(3, u.isCliente());
            ps.setInt(4, u.getiDUtilizador());
            ps.executeUpdate();
        }
    }

    public Utilizador findById(int id) throws SQLException {
        String sql = "SELECT * FROM Utilizador WHERE iDUtilizador=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Utilizador(rs.getInt("iDUtilizador"), rs.getBoolean("isVeterinario"), rs.getBoolean("isRececionista"), rs.getBoolean("isCliente"), rs.getBoolean("isGerente")

                );
            }
        }
        return null;
    }

    public List<Utilizador> findAll() throws SQLException {
        List<Utilizador> list = new ArrayList<>();
        String sql = "SELECT * FROM Utilizador";
        try (Connection conn = DBConnection.getConnection(); Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new Utilizador(rs.getInt("iDUtilizador"), rs.getBoolean("isVeterinario"), rs.getBoolean("isRececionista"), rs.getBoolean("isCliente"), rs.getBoolean("isGerente")

                ));
            }
        }
        return list;
    }

    public Utilizador findByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "SELECT * FROM Utilizador WHERE username = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Utilizador(rs.getBoolean("isVeterinario"), rs.getBoolean("isRececionista"), rs.getBoolean("isCliente"), rs.getBoolean("isGerente"), rs.getString("username"), rs.getString("password"));
            }
        }
        return null;
    }

}
