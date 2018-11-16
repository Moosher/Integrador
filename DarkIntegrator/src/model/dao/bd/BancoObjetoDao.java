package model.dao.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
			    + "values(OBJETO_SEQ.NEXTVAL, ? , ? , ? , ? , ? , ?, ? , ? )" );
	    ps.setString( 1, objeto.getCodigoLocalizador() );
	    ps.setString( 2, objeto.getNomeRemetente() );
	    ps.setString( 3, objeto.getEnderecoRemetente() );
	    ps.setString( 4, objeto.getNomeDestinatario() );
	    ps.setString( 5, objeto.getEnderecoDestinatario() );
	    ps.setDate( 6, new java.sql.Date(objeto.getDataDeposito().getTime()) );
	    ps.setDouble( 7, objeto.getPeso() );
	    ps.setString( 8, objeto.getStatusDesc());
	    ps.executeQuery();

	    //			DatabaseMetaData meta = conn.getMetaData();
	    //			String fab = meta.getDatabaseProductName();
	    //			String ver = meta.getDatabaseProductVersion();
	    //			System.out.println( fab + " <==> " + ver );
	    System.out.println("Objeto cadastrado com sucesso no banco de dados.");
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
	List<Objeto> lst = new ArrayList();
	Connection conn = DatabaseService.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;

	try {
	    ps = conn.prepareStatement( "SELECT * FROM Objeto" );
	    rs = ps.executeQuery();

	    while ( rs.next() ) {
		String id = rs.getString( 1 );
		String codigoLocalizador = rs.getString( 2 );
		String nomeRemetente = rs.getString( 3 );
		String enderecoRemetente = rs.getString( 4 );
		String nomeDestinatario = rs.getString( 5 );
		String enderecoDestinatario = rs.getString( 6 );
		Date dataDeposito = rs.getDate( 7 );
		double peso = Double.parseDouble(rs.getString( 8 ));
		String statusDesc = rs.getString(9);

		Objeto objeto = new Objeto(id, codigoLocalizador, nomeRemetente, enderecoRemetente,
			nomeDestinatario, enderecoDestinatario, dataDeposito, peso, statusDesc);

		lst.add(objeto);
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

	return lst;
    }

    @Override
    public void removerObjeto( String objetoId ) {

    }

    @Override
    public boolean verificaCodigo( String codigo ) {
	return true;
    }

    @Override
    public void setStatus( String objetoId, Status status ) {
    }

    @Override
    public void carregarArquivo() throws IOException {
    }

    @Override
    public Objeto findObjetoByPK(String objetoId) {
	return null;

    }
}
