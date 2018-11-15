package model.dao.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Motorista;
import model.dao.MotoristaDao;

public class BancoMotoristaDao implements MotoristaDao {

    @Override
    public void adicionarMotorista( Motorista motorista ) {
	Connection conn = DatabaseService.getConnection();
	PreparedStatement ps = null;
	String aux1 = "";
	if ( motorista.isDisponivel() ) {
	    aux1 = "T";

	} else {
	    aux1 = "F";
	}

	try {
	    ps = conn.prepareStatement(
		    "INSERT INTO Motorista (MotoristaID, MotoristaNome, MotoristaDataNascimento, MotoristaEndereco, MotoristaTipoCNH, MotoristaNumCNH, MotoristaStatus) values(MOTORISTA_SEQ.NEXTVAL, ? , ? , ? , ? , ? , ? )" );
	    ps.setString( 1, motorista.getNome() );
	    ps.setDate( 2, new java.sql.Date(motorista.getDataNasc().getTime()));
	    ps.setString( 3, motorista.getEndereco() );
	    ps.setString( 4, String.valueOf( motorista.getTipoCNH() ) );
	    ps.setString( 5, motorista.getCNH() );
	    ps.setString( 6, aux1 );

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
    public void removerMotorista( Motorista motorista ) {

    }

    @Override
    public List<Motorista> getMotoristaList() {
	return null;
    }

    @Override
    public void carregarArquivo() throws IOException {

    }

    @Override
    public void setDisponivel( Motorista motorista, boolean disponivel ) {

    }

}
