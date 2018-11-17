package model.dao.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Objeto;
import model.Roteiro;
import model.Veiculo;
import model.dao.DaoFactory;
import model.dao.RoteiroDao;

public class BancoRoteiroDao implements RoteiroDao {

	@Override
	public void adicionarRoteiro(Roteiro roteiro) {
		Connection conn = DatabaseService.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("");
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
	public void removerRoteiro(String roteiroId) {

	}

	@Override
	public void atualizarRoteiro(Roteiro roteiro) {

	}

	@Override
	public void gerarRoteiros(Date data) {

	}

	@Override
	public List<Roteiro> getRoteiroList() {
		List<Roteiro> lst = new ArrayList<>();
		Connection conn = DatabaseService.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("SELECT * FROM Roteiro");
			rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				Date data = rs.getDate(2);
				String veiculoId = rs.getString(3);

				double peso = Double.parseDouble(rs.getString(8));
				int statusCod = Integer.parseInt(rs.getString(9));

				Veiculo veiculo = DaoFactory.getDaoFactory().getVeiculoDao().findVeiculoByPK(veiculoId);

				Roteiro roteiro = new Roteiro(data, veiculo);

				lst.add(roteiro);
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
	public List<Objeto> getObjetoRoteiroList(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roteiro> getRoteiroList(Date data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Roteiro findRoteiroByPK(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
