package model.dao.arquivo;

import model.dao.DaoFactory;
import model.dao.ModeloDao;
import model.dao.MotoristaDao;
import model.dao.ObjetoDao;
import model.dao.RoteiroDao;
import model.dao.UsuarioDao;
import model.dao.VeiculoDao;

public class ArquivoDaoFactory extends DaoFactory{
	
	private static final ArquivoDaoFactory INSTANCE = new ArquivoDaoFactory();
	
	public static ArquivoDaoFactory getDaoFactory() {
		return INSTANCE;
	}
	
	private ArquivoDaoFactory(){
		
	}
	
	
	@Override
	public ObjetoDao getObjetoDao() {
		return new ArquivoObjetoDao();
	}
	
	@Override
	public RoteiroDao getRoteiroDao() {
		return new ArquivoRoteiroDao();
	}
	
	@Override
	public MotoristaDao getMotoristaDao() {
		return new ArquivoMotoristaDao();
	}
	
	@Override
	public VeiculoDao getVeiculoDao() {
		return new ArquivoVeiculoDao();
	}
	
	@Override
	public ModeloDao getModeloDao() {
		return new ArquivoModeloDao();
	}
	
	@Override
	public UsuarioDao getUsuarioDao() {
		return new ArquivoUsuarioDao();
	}
	
}
