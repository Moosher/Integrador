package model.dao;

import model.dao.arquivo.ArquivoDaoFactory;
import model.dao.bd.BancoDaoFactory;
import resources.AppConsts;

public abstract class DaoFactory{
	
	private static DaoFactory daoFactory = getDaoFactory();
	
	public static DaoFactory getDaoFactory() {
		if(AppConsts.BANCO) {
			return BancoDaoFactory.getDaoFactory();
		}else {
			return ArquivoDaoFactory.getDaoFactory();
		}
	}
	
	public ObjetoDao getObjetoDao() {
		return daoFactory.getObjetoDao();
	}
	
	public RoteiroDao getRoteiroDao() {
		return daoFactory.getRoteiroDao();
	}
	
	public MotoristaDao getMotoristaDao() {
		return daoFactory.getMotoristaDao();
	}
	
	public VeiculoDao getVeiculoDao() {
		return daoFactory.getVeiculoDao();
	}
	
	public ModeloDao getModeloDao() {
		return daoFactory.getModeloDao();
	}
	
	public UsuarioDao getUsuarioDao() {
		return daoFactory.getUsuarioDao();
	}
}
