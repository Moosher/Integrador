package model.dao.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;

import model.Objeto;
import model.Veiculo;
import model.Objeto.Status;
import model.dao.ObjetoDao;
import resources.AppConsts;

public class ArquivoObjetoDao implements ObjetoDao {

	private static List<Objeto> objetos = new ArrayList();

	@Override
	public void adicionarObjeto(Objeto objeto) {
		objeto.setId(FileControl.getInstance().gerarId());
		ArquivoObjetoDao.objetos.add(objeto);
		try {
			salvarArquivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removerObjeto(Objeto objeto) {
		ArquivoObjetoDao.objetos.remove(objeto);
		try {
			salvarArquivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verificaCodigo(String codigo) {
		if (!ArquivoObjetoDao.objetos.isEmpty()) {
			for (Objeto objeto : ArquivoObjetoDao.objetos) {
				if (objeto.getCodigoLocalizador().equals(codigo)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void setStatus(Objeto objeto, Status status) {
		objetos.get(objetos.indexOf(objeto)).setStatus(status);
		try {
			this.salvarArquivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Objeto> getObjetoList() throws ParseException {
		// TODO FERNANDO vê como fica isso, antes tava retornando uma lista de String
		return objetos;
	}

	public void salvarArquivo() throws IOException {

		Gson gson = new Gson();
		FileWriter lstJson = null;
		String lstDeposito = gson.toJson(objetos);

		try {
			lstJson = new FileWriter(AppConsts.CAMINHO_OBJETO, false);
			lstJson.write(lstDeposito);
			lstJson.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			lstJson.close();
		}

	}

	@Override
	public void carregarArquivo() throws IOException {
		File file = new File(AppConsts.CAMINHO_OBJETO);
		if (file.exists()) {
			BufferedReader lstDeposito = null;
			Gson gson = new Gson();
			try {
				lstDeposito = new BufferedReader(new FileReader(AppConsts.CAMINHO_OBJETO));

				Objeto[] depositoArray = gson.fromJson(lstDeposito, Objeto[].class);
				objetos.clear();
				objetos.addAll(Arrays.asList(depositoArray));

			} finally {
				lstDeposito.close();
			}
		} else {
			this.salvarArquivo();
		}
	}



}
