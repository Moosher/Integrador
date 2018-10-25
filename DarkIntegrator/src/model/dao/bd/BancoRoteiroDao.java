package model.dao.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.Objeto;
import model.Roteiro;
import model.dao.RoteiroDao;

public class BancoRoteiroDao implements RoteiroDao {

	@Override
	public void adicionarRoteiro( Roteiro roteiro ) {
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
	public void removerRoteiro( Roteiro roteiro ) {

	}

	@Override
	public void atualizarRoteiro( Roteiro roteiro ) {

	}

	@Override
	public void gerarRoteiros( Date data ) {

	}

	@Override
	public List<Roteiro> getRoteiroList() {
		return null;
	}

	@Override
	public void carregarArquivo() throws IOException {

	}

	@Override
	public List<Objeto> getObjetoRoteiroList( String id ) {
		// TODO Auto-generated method stub
		return null;
	}

}
