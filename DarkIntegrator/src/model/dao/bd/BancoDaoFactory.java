package model.dao.bd;

import model.dao.DaoFactory;
import model.dao.MotoristaDao;
import model.dao.ObjetoDao;
import model.dao.UsuarioDao;

public class BancoDaoFactory extends DaoFactory {

	private static final BancoDaoFactory INSTANCE = new BancoDaoFactory();

	public static BancoDaoFactory getDaoFactory() {
		return INSTANCE;
	}

	private BancoDaoFactory() {

	}

	@Override
	public ObjetoDao getObjetoDao() {
		return new BancoObjetoDao();
	}

	@Override
	public UsuarioDao getUsuarioDao() {
		return new BancoUsuarioDao();
	}

	@Override
	public MotoristaDao getMotoristaDao() {
		return new BancoMotoristaDao();
	}
}
