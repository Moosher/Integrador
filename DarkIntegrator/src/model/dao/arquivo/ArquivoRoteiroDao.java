package model.dao.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import model.Objeto;
import model.Roteiro;
import model.Veiculo;
import model.dao.DaoFactory;
import model.dao.RoteiroDao;
import resources.AppConsts;

public class ArquivoRoteiroDao implements RoteiroDao {

	private static List<Roteiro> roteiros = new ArrayList();

	@Override
	public void adicionarRoteiro( Roteiro roteiro ) {
		roteiro.setId( FileControl.getInstance().gerarId() );
		this.roteiros.add( roteiro );
		try {
			this.salvarArquivo();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	@Override
	public void removerRoteiro( Roteiro roteiro ) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Roteiro> getRoteiroList() {
		return roteiros;
	}

	@Override
	public List<Objeto> getObjetoRoteiroList( String id ) {
		List<Objeto> lst = new ArrayList();
		for ( Roteiro roteiro : roteiros ) {
			if ( roteiro.getId().equals( id ) ) {
				return roteiro.getObjetosRoteiro();
			}
		}
		return lst;

	}

	@Override
	public void atualizarRoteiro( Roteiro roteiro ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void gerarRoteiros( Date data ) {
		for ( Veiculo veiculo : DaoFactory.getDaoFactory().getVeiculoDao().getVeiculoList() ) {
			if ( veiculo.isDisponivel() ) {
				Roteiro roteiro = new Roteiro( data, veiculo );
				DaoFactory.getDaoFactory().getVeiculoDao().setDisponivel( veiculo, false );
				this.adicionarRoteiro( roteiro );
			}
		}
	}

	public void salvarArquivo() throws IOException {

		Gson gson = new Gson();
		FileWriter lstJson = null;
		String lstRoteiro = gson.toJson( roteiros );

		try {
			lstJson = new FileWriter( AppConsts.CAMINHO_ROTEIRO, false );
			lstJson.write( lstRoteiro );

		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			lstJson.close();
		}

	}

	@Override
	public void carregarArquivo() throws IOException {
		File file = new File( AppConsts.CAMINHO_ROTEIRO );
		if ( file.exists() ) {
			BufferedReader lstRoteiro = null;
			Gson gson = new Gson();
			try {
				lstRoteiro = new BufferedReader( new FileReader( AppConsts.CAMINHO_ROTEIRO ) );
				Roteiro[] roteiroArray = gson.fromJson( lstRoteiro, Roteiro[].class );
				roteiros.clear();
				roteiros.addAll( Arrays.asList( roteiroArray ) );

			} finally {
				lstRoteiro.close();
			}
		} else {
			this.salvarArquivo();
		}
	}

}
