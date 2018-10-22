package model.dao.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Veiculo;
import model.dao.VeiculoDao;

public class BancoVeiculoDao implements VeiculoDao {

	@Override
	public void adicionarVeiculo( Veiculo veiculo ) {
		Connection conn = DatabaseService.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(
					"INSERT INTO Veiculo (VeiculoID, VeiculoMarca, VeiculoModelo, VeiculoAno, VeiculoPlaca, MotoristaID, VeiculoTipoID) values(VEICULO_SEQ.NEXTVAL, ? , ? , ? , ? , ? , ? )" );
			ps.setString( 1, veiculo.getMarca() );
			//			ps.setString( 2, veiculo.getModelo() );
			//			ps.setString( 3, veiculo.getAno() );
			//			ps.setString( 4, veiculo.getPlaca() );
			//			ps.setString( 5, veiculo.getMotorista() );
			//			ps.setString( 6, veiculo.getModelo() );
			//			ps.executeQuery();

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
	public void removerVeiculo( Veiculo veiculo ) {

	}

	@Override
	public List<Veiculo> getVeiculoList() {
		return null;
	}

	@Override
	public void carregarArquivo() throws IOException {

	}

	@Override
	public void setDisponivel( Veiculo veiculo, boolean disponivel ) {

	}

}
