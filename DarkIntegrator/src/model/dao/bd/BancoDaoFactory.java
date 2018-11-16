package model.dao.bd;

import model.dao.DaoFactory;
import model.dao.ModeloDao;
import model.dao.MotoristaDao;
import model.dao.ObjetoDao;
import model.dao.UsuarioDao;
import model.dao.VeiculoDao;

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

    @Override
    public VeiculoDao getVeiculoDao() {
	return new BancoVeiculoDao();
    }

    @Override
    public ModeloDao getModeloDao() {
	return new BancoModeloDao();
    }
}
