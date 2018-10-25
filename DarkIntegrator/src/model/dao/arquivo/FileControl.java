package model.dao.arquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import model.dao.DaoFactory;
import model.dao.ModeloDao;
import model.dao.MotoristaDao;
import model.dao.ObjetoDao;
import model.dao.RoteiroDao;
import model.dao.UsuarioDao;
import model.dao.VeiculoDao;
import resources.AppConsts;

public class FileControl {

	private static final FileControl INSTANCE = new FileControl();

	public static FileControl getInstance() {
		return INSTANCE;
	}

	private FileControl() {
		this.carregarSistema();
	}

	public void imprimirRecibo( String nomeRemetente, String enderecoRemetente, String nomeDestinatario, String enderecoDestinatario, String dataDeposito, double peso, String codLocalizador )
			throws IOException {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter( new FileWriter( new File( AppConsts.CAMINHO_RECIBO ) ) );

			bw.write( "Transportadora Entrega Rápida" );
			bw.newLine();
			bw.write( "Recibo " );
			bw.newLine();
			bw.write( "Código localizador: " + codLocalizador );
			bw.newLine();
			bw.write( "Nome do remetente: " + nomeRemetente );
			bw.newLine();
			bw.write( "Endereço do remetente: " + enderecoRemetente );
			bw.newLine();
			bw.write( "Nome do destinatário: " + nomeDestinatario );
			bw.newLine();
			bw.write( "Endereço do destinatário: " + enderecoDestinatario );
			bw.newLine();
			bw.write( "Data de depósito do objeto na empresa: " + dataDeposito );
			bw.newLine();
			bw.write( "Peso do objeto:" + peso );

		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			bw.close();
		}
	}

	private void carregarSistema() {

		try {

			ModeloDao modelo = DaoFactory.getDaoFactory().getModeloDao();
			modelo.salvarPreDefinidos();

			UsuarioDao usuario = DaoFactory.getDaoFactory().getUsuarioDao();
			//usuario.carregarArquivo();

			ObjetoDao objeto = DaoFactory.getDaoFactory().getObjetoDao();
			objeto.carregarArquivo();

			MotoristaDao motorista = DaoFactory.getDaoFactory().getMotoristaDao();
			motorista.carregarArquivo();

			VeiculoDao veiculo = DaoFactory.getDaoFactory().getVeiculoDao();
			veiculo.carregarArquivo();

			RoteiroDao roteiro = DaoFactory.getDaoFactory().getRoteiroDao();
			roteiro.carregarArquivo();

		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public String gerarId() {
		Date date = new Date();
		long idlongo = date.getTime();
		String id = String.valueOf( idlongo );
		id = id.substring( id.length() - 7 );
		return id;
	}

}
