package model.dao.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Objeto;
import model.Objeto.Status;
import model.dao.ObjetoDao;
import resources.AppConsts;

public class ArquivoObjetoDao implements ObjetoDao {

	public ArquivoObjetoDao() {
		File file = new File(AppConsts.CAMINHO_OBJETO);
		if (!file.exists()) {
			List<Objeto> objetos = new ArrayList<>();
			this.salvarArquivo(objetos);
		}
	}

	@Override
	public void adicionarObjeto(Objeto objeto) {
		List<Objeto> objetos = this.getObjetoList();
		objeto.setId(FileControl.getInstance().gerarId());
		objetos.add(objeto);

		this.salvarArquivo(objetos);
	}

	@Override
	public void removerObjeto(String objetoId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Objeto> getObjetoList() {
		Gson gson = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create();
		List<Objeto> objetos = new ArrayList();
		File file = new File(AppConsts.CAMINHO_OBJETO);
		BufferedReader lstObjeto = null;
		if (file.exists()) {
			try {
				lstObjeto = new BufferedReader(new FileReader(AppConsts.CAMINHO_OBJETO));
				Objeto[] objetoArray = gson.fromJson(lstObjeto, Objeto[].class);
				objetos.clear();
				objetos.addAll(Arrays.asList(objetoArray));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					lstObjeto.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return objetos;
	}

	private void salvarArquivo(List<Objeto> objetos) {
		Gson gson = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create();
		FileWriter lstJson = null;
		String lstObjeto = gson.toJson(objetos);

		try {
			lstJson = new FileWriter(AppConsts.CAMINHO_OBJETO, false);
			lstJson.write(lstObjeto);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				lstJson.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Objeto findObjetoByPK(String objetoId) {
		List<Objeto> objetos = this.getObjetoList();
		for (Objeto objeto : objetos) {
			if (objeto.getId().equals(objetoId)) {
				return objeto;
			}
		}
		return null;
	}

	@Override
	public boolean verificaCodigo(String codigo) {
		List<Objeto> objetos = this.getObjetoList();
		if (!objetos.isEmpty()) {
			for (Objeto objeto : objetos) {
				if (objeto.getCodigoLocalizador().equals(codigo)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void setStatus(String objetoId, Status status) {
		List<Objeto> objetos = this.getObjetoList();
		int objetoIndex = this.findIndexByPK(objetoId);
		objetos.get(objetoIndex).setStatus(status);
		this.salvarArquivo(objetos);
	}

	public int findIndexByPK(String objetoId) {
		List<Objeto> objetos = this.getObjetoList();
		for (Objeto objeto : objetos) {
			if (objeto.getId().equals(objetoId)) {
				return objetos.indexOf(objeto);
			}
		}
		return -1;
	}
}
