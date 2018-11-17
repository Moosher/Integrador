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

import model.Veiculo;
import model.dao.VeiculoDao;
import resources.AppConsts;

public class ArquivoVeiculoDao implements VeiculoDao {

    public ArquivoVeiculoDao() {
	File file = new File(AppConsts.CAMINHO_VEICULO);
	if(!file.exists()) {
	    List<Veiculo> veiculos = new ArrayList<>();
	    this.salvarArquivo(veiculos);
	}
    }
    @Override
    public void adicionarVeiculo(Veiculo veiculo) {
	List<Veiculo> veiculos = this.getVeiculoList();
	veiculo.setId(FileControl.getInstance().gerarId());
	veiculos.add(veiculo);

	this.salvarArquivo(veiculos);
    }

    @Override
    public void removerVeiculo(String veiculoId) {
	// TODO Auto-generated method stub

    }

    @Override
    public void setDisponivel(String veiculoId, boolean disponivel) {
	List<Veiculo> veiculos = this.getVeiculoList();
	int veiculoIndex = this.findIndexByPK(veiculoId);
	if(veiculoIndex > -1) {
	    veiculos.get(veiculoIndex).setDisponivel(disponivel);
	    this.salvarArquivo(veiculos);
	}
    }

    @Override
    public List<Veiculo> getVeiculoList() {
	Gson gson = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create();
	List<Veiculo> veiculos = new ArrayList<>();
	File file = new File(AppConsts.CAMINHO_VEICULO);
	BufferedReader lstVeiculo = null;
	if(file.exists()) {
	    try {
		lstVeiculo = new BufferedReader(new FileReader(AppConsts.CAMINHO_VEICULO));
		Veiculo[] veiculoArray = gson.fromJson(lstVeiculo, Veiculo[].class);
		veiculos.clear();
		veiculos.addAll(Arrays.asList(veiculoArray));
	    }catch(IOException e) {
		e.printStackTrace();
	    } finally {
		try {
		    lstVeiculo.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
	return veiculos;
    }

    private void salvarArquivo(List<Veiculo> veiculos) {
	Gson gson = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create();
	FileWriter lstJson = null;
	String lstVeiculo = gson.toJson(veiculos);

	try {
	    lstJson = new FileWriter(AppConsts.CAMINHO_VEICULO, false);
	    lstJson.write(lstVeiculo);

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
    public Veiculo findVeiculoByPK(String veiculoId) {
	List<Veiculo> veiculos = this.getVeiculoList();
	for(Veiculo veiculo : veiculos) {
	    if(veiculo.getId().equals(veiculoId)) {
		return veiculo;
	    }
	}
	return null;
    }

    public int findIndexByPK(String veiculoId) {
	List<Veiculo> veiculos = this.getVeiculoList();
	for(Veiculo veiculo : veiculos) {
	    if(veiculo.getId().equals(veiculoId)) {
		return veiculos.indexOf(veiculo);
	    }
	}
	return -1;
    }
}
