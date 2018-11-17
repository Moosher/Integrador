package model.dao.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Modelo;
import model.Motorista;
import model.Veiculo;
import model.dao.DaoFactory;
import model.dao.VeiculoDao;

public class BancoVeiculoDao implements VeiculoDao {

    @Override
    public void adicionarVeiculo(Veiculo veiculo) {
	Connection conn = DatabaseService.getConnection();
	PreparedStatement ps = null;

	String disponivelString;

	if(veiculo.isDisponivel()) {
	    disponivelString = "T";
	}else {
	    disponivelString = "F";
	}

	try {
	    ps = conn.prepareStatement(
		    "INSERT INTO Veiculo (VeiculoID, VeiculoMarca, VeiculoAno, VeiculoPlaca, MotoristaID, VeiculoModeloID, VeiculoStatus) values(VEICULO_SEQ.NEXTVAL, ? , ? , ? , ? , ?, ?)");
	    ps.setString( 1, veiculo.getMarca());
	    ps.setString( 2, veiculo.getAno() );
	    ps.setString( 3, veiculo.getPlaca() );
	    int motoristaId = Integer.parseInt(veiculo.getMotorista().getId());
	    ps.setInt( 4, motoristaId );
	    int modeloId = Integer.parseInt(veiculo.getModelo().getId());
	    ps.setInt( 5, modeloId);
	    ps.setString( 6, disponivelString );
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
    public void removerVeiculo(String veiculoId) {

    }

    @Override
    public List<Veiculo> getVeiculoList() {
	List<Veiculo> lst = new ArrayList<>();
	Connection conn = DatabaseService.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	Veiculo veiculo;

	try {
	    ps = conn.prepareStatement( "SELECT * FROM Veiculo" );
	    rs = ps.executeQuery();

	    while ( rs.next() ) {
		String veiculoId = rs.getString(1);
		String marca = rs.getString(2);
		String ano = rs.getString(3);
		String placa = rs.getString(4);
		String motoristaId = rs.getString(5);
		String modeloId = rs.getString(6);
		String disponivelString = rs.getString(7);

		boolean disponivel;

		if (disponivelString.equalsIgnoreCase("T")) {
		    disponivel = true;
		} else {
		    disponivel = false;
		}

		DaoFactory daoFactory = DaoFactory.getDaoFactory();

		Motorista motorista = daoFactory.getMotoristaDao().findMotoristaByPK(motoristaId);
		Modelo modelo = daoFactory.getModeloDao().findModeloByPK(modeloId);

		veiculo = new Veiculo(veiculoId, marca, modelo, ano, placa, motorista, disponivel);

		lst.add(veiculo);
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
    public void setDisponivel(String veiculoId, boolean disponivel) {

    }

    @Override
    public Veiculo findVeiculoByPK(String veiculoId) {
	Connection conn = DatabaseService.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	Veiculo veiculo = null;

	try {
	    ps = conn.prepareStatement("SELECT * FROM VEICULO where veiculo.veiculoid = ? ;");
	    ps.setString(1, veiculoId);
	    rs = ps.executeQuery();

	    String marca = rs.getString(2);
	    String ano = rs.getString(3);
	    String placa = rs.getString(4);
	    String motoristaId = rs.getString(5);
	    String modeloId = rs.getString(6);
	    String disponivelString = rs.getString(7);

	    boolean disponivel;

	    if (disponivelString.equalsIgnoreCase("T")) {
		disponivel = true;
	    } else {
		disponivel = false;
	    }

	    DaoFactory daoFactory = DaoFactory.getDaoFactory();

	    Motorista motorista = daoFactory.getMotoristaDao().findMotoristaByPK(motoristaId);
	    Modelo modelo = daoFactory.getModeloDao().findModeloByPK(modeloId);

	    veiculo = new Veiculo(veiculoId, marca, modelo, ano, placa, motorista, disponivel);

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

	return veiculo;
    }
}
