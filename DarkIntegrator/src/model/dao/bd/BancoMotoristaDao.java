package model.dao.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Motorista;
import model.dao.DaoFactory;
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
    public void removerMotorista( String motoristaId ) {

    }

    @Override
    public List<Motorista> getMotoristaList() {
	List<Motorista> lst = new ArrayList();
	Connection conn = DatabaseService.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	Motorista motorista = null;

	try {
	    ps = conn.prepareStatement("SELECT * FROM MOTORISTA");
	    rs = ps.executeQuery();

	    while(rs.next()) {
		String motoristaId = rs.getString(1);
		String nome = rs.getString(2);
		Date dataNasc = rs.getDate(3);
		String endereco = rs.getString(4);
		char tipoCNH = rs.getString(5).charAt(0);
		String cNH = rs.getString(6);
		String disponivelString = rs.getString(7);

		boolean disponivel;

		if (disponivelString.equalsIgnoreCase("T")) {
		    disponivel = true;
		} else {
		    disponivel = false;
		}

		DaoFactory daoFactory = DaoFactory.getDaoFactory();

		motorista = new Motorista(nome, dataNasc, endereco, tipoCNH, cNH, disponivel);
		motorista.setId(motoristaId);
		lst.add(motorista);
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

	return lst;
    }

    @Override
    public void setDisponivel( String motoristaId, boolean disponivel ) {

    }

    @Override
    public Motorista findMotoristaByPK(String motoristaId) {
	Connection conn = DatabaseService.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	Motorista motorista = null;

	try {
	    ps = conn.prepareStatement("SELECT * FROM MOTORISTA where motorista.motoristaid = ?");
	    ps.setString(1, motoristaId);
	    rs = ps.executeQuery();
	    rs.next();

	    String nome = rs.getString(2);
	    Date dataNasc = rs.getDate(3);
	    String endereco = rs.getString(4);
	    String tipoCNH = rs.getString(5);
	    char cNH = rs.getString(6).charAt(0);
	    String disponivelString = rs.getString(7);

	    boolean disponivel;

	    if (disponivelString.equalsIgnoreCase("T")) {
		disponivel = true;
	    } else {
		disponivel = false;
	    }

	    DaoFactory daoFactory = DaoFactory.getDaoFactory();

	    motorista = new Motorista(nome, dataNasc, endereco, cNH, tipoCNH, disponivel);
	    motorista.setId(motoristaId);

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

	return motorista;
    }
}
