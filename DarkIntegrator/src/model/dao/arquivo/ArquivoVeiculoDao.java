package model.dao.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;

import model.Veiculo;
import model.dao.VeiculoDao;
import resources.AppConsts;

public class ArquivoVeiculoDao implements VeiculoDao {

	private static List<Veiculo> veiculos = new ArrayList();

	@Override
	public void adicionarVeiculo( Veiculo veiculo ) {
		veiculo.setId( FileControl.getInstance().gerarId() );
		veiculos.add( veiculo );
		try {
			this.salvarArquivo();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	@Override
	public void removerVeiculo( Veiculo veiculo ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDisponivel( Veiculo veiculo, boolean disponivel ) {
		veiculos.get( veiculos.indexOf( veiculo ) ).setDisponivel( disponivel );
		try {
			this.salvarArquivo();
		} catch ( IOException e ) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Veiculo> getVeiculoList() {
		return veiculos;
	}

	public void salvarArquivo() throws IOException {

		Gson gson = new Gson();
		FileWriter lstJson = null;
		String lstVeiculo = gson.toJson( veiculos );

		try {
			lstJson = new FileWriter( AppConsts.CAMINHO_VEICULO, false );
			lstJson.write( lstVeiculo );

		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			lstJson.close();
		}

	}

	@Override
	public void carregarArquivo() throws IOException {
		File file = new File( AppConsts.CAMINHO_VEICULO );
		if ( file.exists() ) {
			BufferedReader lstVeiculo = null;
			Gson gson = new Gson();
			try {
				lstVeiculo = new BufferedReader( new FileReader( AppConsts.CAMINHO_VEICULO ) );
				Veiculo[] veiculoArray = gson.fromJson( lstVeiculo, Veiculo[].class );
				veiculos.clear();
				veiculos.addAll( Arrays.asList( veiculoArray ) );

			} finally {
				lstVeiculo.close();
			}
		} else {
			this.salvarArquivo();
		}
	}

	Comparator<Veiculo> cmp = new Comparator<Veiculo>() {

		@Override
		public int compare( Veiculo veiculo1, Veiculo veiculo2 ) {
			if ( veiculo1.getPrioridade() > veiculo2.getPrioridade() ) {
				return -1;
			} else if ( veiculo1.getPrioridade() == veiculo2.getPrioridade() ) {
				return 0;
			} else {
				return 1;
			}

		}
	};

}
