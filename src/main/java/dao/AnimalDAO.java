package dao;

import model.Animal;
import utils.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {


    public void inserir(Animal a) throws Exception {
        String sql = "INSERT INTO Paciente (clienteId, nome, especie, raca, dataNascimento, fotoPath) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, a.getClienteId());
            ps.setString(2, a.getNome());
            ps.setString(3, a.getEspecie());
            ps.setString(4, a.getRaca());
            ps.setDate(5, new java.sql.Date(a.getDataNascimento().getTime()));
            ps.setString(6, a.getFotoPath());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) a.setId(rs.getInt(1));
        }
    }
    public List<Animal> findAll() throws SQLException {
        List<Animal> list = new ArrayList<>();
        String sql = "SELECT * FROM Paciente";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Animal(
                        rs.getInt("id"),
                        rs.getInt("clienteId"),
                        rs.getString("nome"),
                        rs.getString("especie"),
                        rs.getString("raca"),
                        rs.getDate("dataNascimento"),
                        rs.getString("fotoPath")
                ));
            }
        }
        return list;
    }

    public void atualizar(Animal a) throws Exception {
        String sql = "UPDATE Paciente SET nome=?, especie=?, raca=?, dataNascimento=?, fotoPath=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, a.getNome());
            ps.setString(2, a.getEspecie());
            ps.setString(3, a.getRaca());
            ps.setDate(4, new java.sql.Date(a.getDataNascimento().getTime()));
            ps.setString(5, a.getFotoPath());
            ps.setInt(6, a.getId());

            ps.executeUpdate();
        }
    }

    public void deleteByCliente(String nifCliente) throws Exception {
        String sql = "DELETE FROM Paciente WHERE NIF = ?";        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(nifCliente));
            ps.executeUpdate();
        }
    }

}
