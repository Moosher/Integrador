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

import model.Modelo;
import model.dao.ModeloDao;
import resources.AppConsts;

public class ArquivoModeloDao implements ModeloDao {

	private static List<Modelo> modelos = new ArrayList();

	@Override
	public void adicionarModelo( Modelo modelo ) {
		modelo.setId( FileControl.getInstance().gerarId() );
		this.modelos.add( modelo );
		try {
			this.salvarArquivo();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	@Override
	public void removerModelo( Modelo modelo ) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Modelo> getModeloList() {
		// TODO Auto-generated method stub
		return modelos;
	}

	public void salvarArquivo() throws IOException {

		Gson gson = new Gson();
		FileWriter lstJson = null;
		String lstModelo = gson.toJson( modelos );

		try {
			lstJson = new FileWriter( AppConsts.CAMINHO_MODELO, false );
			lstJson.write( lstModelo );

		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			lstJson.close();
		}

	}

	@Override
	public void carregarArquivo() throws IOException {
		File file = new File( AppConsts.CAMINHO_MODELO );
		if ( file.exists() ) {
			BufferedReader lstModelo = null;
			Gson gson = new Gson();
			try {
				lstModelo = new BufferedReader( new FileReader( AppConsts.CAMINHO_MODELO ) );
				Modelo[] modeloArray = gson.fromJson( lstModelo, Modelo[].class );
				modelos.clear();
				modelos.addAll( Arrays.asList( modeloArray ) );

			} finally {
				lstModelo.close();
			}
		} else {
			this.salvarArquivo();
		}
	}

	@Override
	public void salvarPreDefinidos() {
		if ( this.modelos.isEmpty() ) {
			this.modelos.add( new Modelo( 10, "Carreta" ) );
			this.modelos.add( new Modelo( 3, "Caminhão Báu" ) );
			this.modelos.add( new Modelo( 1, "Van" ) );
		}
	}

	Comparator<Modelo> cmp = new Comparator<Modelo>() {

		@Override
		public int compare( Modelo modelo1, Modelo modelo2 ) {

			if ( modelo1.getCapacidade() > modelo2.getCapacidade() ) {
				return -1;
			} else if ( modelo1.getCapacidade() == modelo2.getCapacidade() ) {
				return 0;
			} else {
				return 1;
			}

		}
	};
}
