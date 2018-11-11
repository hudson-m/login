package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public abstract class UsuarioDAO {
	
	private static String sqlInsert = "INSERT INTO Usuario (nome, sobrenome, username, senha, salt) VALUES (?,?,?,?,?)";
	private static String sqlGetById = "SELECT * FROM Usuario WHERE nome = ?";
	private static String sqlGetByUsername = "SELECT * FROM Usuario WHERE username = ?";
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public static void insert(Usuario usuario) throws SQLException {
        try {
            ps = DBConnection.prepareStatement(sqlInsert);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSobrenome());
            ps.setString(3, usuario.getUsername());
            ps.setString(4, usuario.getSenha());
            ps.setString(5, usuario.getSalt());

            ps.execute();
        } finally {
            DBConnection.close();
        }
    }
    
    public static Usuario getByUsername(String nome) throws SQLException {
        try {
            Usuario usuario = null;
            ps = DBConnection.prepareStatement(sqlGetByUsername);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setUsername(rs.getString("username"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setSalt(rs.getString("salt"));
            }
            return usuario;
        } finally {
            DBConnection.close();
        }
    }
}
