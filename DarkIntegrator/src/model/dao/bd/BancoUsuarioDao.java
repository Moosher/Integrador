package model.dao.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import model.Usuario;
import model.dao.UsuarioDao;

public class BancoUsuarioDao implements UsuarioDao {

	@Override
	public void adicionarUsuario(String login, String senha) {
		Connection conn = DatabaseService.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(
					"INSERT INTO Usuario (UsuarioID, UsuarioLogin, UsuarioPassword) values(USUARIO_SEQ.NEXTVAL, ? , ? )");
			ps.setString(1, login);
			ps.setString(2, senha);
			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				ps.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void carregarArquivo() throws IOException {

	}

	@Override
	public Usuario findUsuarioByPK(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getUsuarios() {
		return null;
	}

	@Override
	public void removerUsuario(String usuarioId) {
		Connection conn = DatabaseService.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("DELETE FROM Usuario WHERE UsuarioID = ?");
			ps.setString(1, usuarioId);
			ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean validacao(String login, String senha) {

		Connection conn = DatabaseService.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("SELECT COUNT(*) FROM Usuario WHERE UsuarioLogin = ? AND UsuarioPassword = ?");
			ps.setString(1, login);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) >= 1) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				ps.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
