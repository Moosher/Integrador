package model.dao.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Objeto;
import model.Roteiro;
import model.Veiculo;
import model.dao.DaoFactory;
import model.dao.RoteiroDao;
import resources.AppConsts;

public class ArquivoRoteiroDao implements RoteiroDao {

    public ArquivoRoteiroDao() {
	File file = new File(AppConsts.CAMINHO_ROTEIRO);
	if(!file.exists()) {
	    List<Roteiro> roteiros = new ArrayList<>();
	    this.salvarArquivo(roteiros);
	}
    }
    @Override
    public void adicionarRoteiro(Roteiro roteiro) {
	List<Roteiro> roteiros = this.getRoteiroList();
	roteiro.setId(FileControl.getInstance().gerarId());
	roteiros.add(roteiro);

	this.salvarArquivo(roteiros);
    }

    @Override
    public void removerRoteiro(String roteiroId) {
	// TODO Auto-generated method stub

    }


    @Override
    public List<Roteiro> getRoteiroList() {
	Gson gson = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create();
	List<Roteiro> roteiros = new ArrayList();
	File file = new File(AppConsts.CAMINHO_ROTEIRO);
	BufferedReader lstRoteiro = null;
	if(file.exists()) {
	    try {
		lstRoteiro = new BufferedReader(new FileReader(AppConsts.CAMINHO_ROTEIRO));
		Roteiro[] roteiroArray = gson.fromJson(lstRoteiro, Roteiro[].class);
		roteiros.clear();
		roteiros.addAll(Arrays.asList(roteiroArray));
	    }catch(IOException e) {
		e.printStackTrace();
	    } finally {
		try {
		    lstRoteiro.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
	return roteiros;
    }

    private void salvarArquivo(List<Roteiro> roteiros) {
	Gson gson = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create();
	FileWriter lstJson = null;
	String lstRoteiro = gson.toJson(roteiros);

	try {
	    lstJson = new FileWriter(AppConsts.CAMINHO_ROTEIRO, false);
	    lstJson.write(lstRoteiro);

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
    public Roteiro findRoteiroByPK(String roteiroId) {
	List<Roteiro> roteiros = this.getRoteiroList();
	for(Roteiro roteiro : roteiros) {
	    if(roteiro.getId().equals(roteiroId)) {
		return roteiro;
	    }
	}
	return null;
    }

    @Override
    public void gerarRoteiros( Date data ) {
	for ( Veiculo veiculo : DaoFactory.getDaoFactory().getVeiculoDao().getVeiculoList() ) {
	    if ( veiculo.isDisponivel() ) {
		Roteiro roteiro = new Roteiro( data, veiculo );
		DaoFactory.getDaoFactory().getVeiculoDao().setDisponivel( veiculo.getId(), false );
		this.adicionarRoteiro( roteiro );
	    }
	}
    }
    @Override
    public void atualizarRoteiro(Roteiro roteiro) {
	// TODO Auto-generated method stub

    }
    @Override
    public List<Roteiro> getRoteiroList(Date data) {

	return null;
    }
    @Override
    public List<Objeto> getObjetoRoteiroList( String id ) {
	for ( Roteiro roteiro : this.getRoteiroList() ) {
	    if ( roteiro.getId().equals( id ) ) {
		return roteiro.getObjetosRoteiro();
	    }
	}
	return null;
    }
}