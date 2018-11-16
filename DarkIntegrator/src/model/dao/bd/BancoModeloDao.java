package model.dao.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Modelo;
import model.dao.DaoFactory;
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
    public void removerModelo( String modeloId) {

    }

    @Override
    public List<Modelo> getModeloList() {
	List<Modelo> lst = new ArrayList();
	Connection conn = DatabaseService.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	Modelo modelo;

	try {
	    ps = conn.prepareStatement( "SELECT * FROM Modelo" );
	    rs = ps.executeQuery();

	    while ( rs.next() ) {
		String modeloId = rs.getString(1);
		String nome = rs.getString(2);
		int capacidade = Integer.parseInt(rs.getString(3));

		modelo = new Modelo(modeloId,capacidade, nome);

		lst.add(modelo);
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
    public void carregarArquivo() throws IOException {

    }

    @Override
    public void salvarPreDefinidos() {

    }

    @Override
    public Modelo findModeloByPK(String modeloId) {
	Connection conn = DatabaseService.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	Modelo modelo = null;

	try {
	    ps = conn.prepareStatement("SELECT * FROM MODELO where modelo.modeloid = ? ;");
	    ps.setString(1, modeloId);
	    rs = ps.executeQuery();

	    String nome = rs.getString(2);
	    int capacidade = Integer.parseInt(rs.getString(3));

	    DaoFactory daoFactory = DaoFactory.getDaoFactory();

	    modelo = new Modelo(modeloId,capacidade, nome);
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

	return modelo;
    }
}
