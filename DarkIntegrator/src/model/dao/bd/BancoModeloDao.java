package model.dao.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Modelo;
import model.dao.ModeloDao;

public class BancoModeloDao implements ModeloDao {

	@Override
	public void adicionarModelo( Modelo modelo ) {
		Connection conn = DatabaseService.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement( "" );
			ps.executeQuery();

		} catch ( SQLException e ) {
			e.printStackTrace();

		} finally {
			try {
				ps.close();
				conn.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void removerModelo( Modelo modelo ) {

	}

	@Override
	public List<Modelo> getModeloList() {
		return null;
	}

	@Override
	public void carregarArquivo() throws IOException {

	}

	@Override
	public void salvarPreDefinidos() {

	}

}
