package model.dao.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.Objeto;
import model.Objeto.Status;
import model.dao.ObjetoDao;

public class BancoObjetoDao implements ObjetoDao {

	@Override
	public void adicionarObjeto( Objeto objeto ) {

		Connection conn = DatabaseService.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(
					"INSERT INTO Objeto (ObjetoID, ObjetoCodRastreio, ObjetoNomeRemetente, EnderecoRemetente, ObjetoNomeDestinatario, ObjetoEnderecoDestinatario, ObjetodataDeposito, ObjetoPeso, ObjetoStatus ) "
							+ "values(OBJETO_SEQ.NEXTVAL, ? , ? , ? , ? , ? , to_date(?, 'hh24:mi dd/MM/yyyy'), ? , ? )" );
			ps.setString( 1, objeto.getCodigoLocalizador() );
			ps.setString( 2, objeto.getNomeRemetente() );
			ps.setString( 3, objeto.getEnderecoRemetente() );
			ps.setString( 4, objeto.getNomeDestinatario() );
			ps.setString( 5, objeto.getEnderecoDestinatario() );
			ps.setString( 6, objeto.getDataDeposito() );
			ps.setDouble( 7, objeto.getPeso() );
			ps.setString( 8, String.valueOf( objeto.getStatuscod() ) );

			ps.executeQuery();

			DatabaseMetaData meta = conn.getMetaData();
			String fab = meta.getDatabaseProductName();
			String ver = meta.getDatabaseProductVersion();
			System.out.println( fab + " <==> " + ver );
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
	public List<Objeto> getObjetoList() throws ParseException {
		List<String> lst = new ArrayList();
		Connection conn = DatabaseService.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement( "SELECT * FROM Objeto" );
			rs = ps.executeQuery();

			while ( rs.next() ) {
				lst.add( String.valueOf( rs.getString( 1 ) + " | " + rs.getString( 2 ) + " | " + rs.getString( 3 ) + " | " + rs.getString( 4 ) + " | " + rs.getString( 5 ) + " | " + rs.getString( 6 )
						+ " | " + rs.getDate( 7 ) + " | " + rs.getString( 8 ) ) );
			}

		} catch ( SQLException e ) {
			e.printStackTrace();

		} finally {
			try {
				ps.close();
				rs.close();
				conn.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}

		//TODO Fernando aqui não vai funcionar pq retorna uma lista de String, não objeto.
		return null;
	}

	@Override
	public void removerObjeto( Objeto objeto ) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean verificaCodigo( String codigo ) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setStatus( Objeto objeto, Status status ) {
		//TODO Fazer isso aqui.
	}

	@Override
	public void carregarArquivo() throws IOException {
		// Não implementa.
	}
}
