package model.dao.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Modelo;
import model.dao.ModeloDao;
import resources.AppConsts;

public class ArquivoModeloDao implements ModeloDao {

    public ArquivoModeloDao() {
	File file = new File(AppConsts.CAMINHO_MODELO);
	if(!file.exists()) {
	    List<Modelo> modelos = new ArrayList<>();
	    this.salvarArquivo(modelos);
	    this.salvarPreDefinidos();
	}
    }
    @Override
    public void adicionarModelo(Modelo modelo) {
	List<Modelo> modelos = this.getModeloList();
	modelo.setId(FileControl.getInstance().gerarId());
	modelos.add(modelo);

	this.salvarArquivo(modelos);
    }

    @Override
    public void removerModelo(String modeloId) {
	// TODO Auto-generated method stub

    }


    @Override
    public List<Modelo> getModeloList() {
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	List<Modelo> modelos = new ArrayList();
	File file = new File(AppConsts.CAMINHO_MODELO);
	BufferedReader lstModelo = null;
	if(file.exists()) {
	    try {
		lstModelo = new BufferedReader(new FileReader(AppConsts.CAMINHO_MODELO));
		Modelo[] modeloArray = gson.fromJson(lstModelo, Modelo[].class);
		modelos.clear();
		modelos.addAll(Arrays.asList(modeloArray));
	    }catch(IOException e) {
		e.printStackTrace();
	    } finally {
		try {
		    lstModelo.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
	return modelos;
    }

    private void salvarArquivo(List<Modelo> modelos) {
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	FileWriter lstJson = null;
	String lstModelo = gson.toJson(modelos);

	try {
	    lstJson = new FileWriter(AppConsts.CAMINHO_MODELO, false);
	    lstJson.write(lstModelo);

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
    public Modelo findModeloByPK(String modeloId) {
	List<Modelo> modelos = this.getModeloList();
	for(Modelo modelo : modelos) {
	    if(modelo.getId().equals(modeloId)) {
		return modelo;
	    }
	}
	return null;
    }

    @Override
    public void salvarPreDefinidos() {
	List<Modelo> modelos = this.getModeloList();
	if ( modelos.isEmpty() ) {
	    modelos.add( new Modelo("1",10, "Carreta" ) );
	    modelos.add( new Modelo("2", 3, "Caminhão Báu" ) );
	    modelos.add( new Modelo("3", 1, "Van" ) );
	    this.salvarArquivo(modelos);
	}
    }
}
