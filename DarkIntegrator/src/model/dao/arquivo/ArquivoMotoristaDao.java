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

import model.Motorista;
import model.dao.MotoristaDao;
import resources.AppConsts;

public class ArquivoMotoristaDao implements MotoristaDao {

    public ArquivoMotoristaDao() {
	File file = new File(AppConsts.CAMINHO_MOTORISTA);
	if(!file.exists()) {
	    List<Motorista> motoristas = new ArrayList<>();
	    this.salvarArquivo(motoristas);
	}
    }
    @Override
    public void adicionarMotorista(Motorista motorista) {
	List<Motorista> motoristas = this.getMotoristaList();
	motorista.setId(FileControl.getInstance().gerarId());
	motoristas.add(motorista);

	this.salvarArquivo(motoristas);
    }

    @Override
    public void removerMotorista(String motoristaId) {
	// TODO Auto-generated method stub

    }

    @Override
    public void setDisponivel(String motoristaId, boolean disponivel) {
	List<Motorista> motoristas = this.getMotoristaList();
	int motoristaIndex = this.findIndexByPK(motoristaId);
	if(motoristaIndex > -1) {
	    motoristas.get(motoristaIndex).setDisponivel(disponivel);
	    this.salvarArquivo(motoristas);
	}
    }

    @Override
    public List<Motorista> getMotoristaList() {
	Gson gson = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create();
	List<Motorista> motoristas = new ArrayList();
	File file = new File(AppConsts.CAMINHO_MOTORISTA);
	BufferedReader lstMotorista = null;
	if(file.exists()) {
	    try {
		lstMotorista = new BufferedReader(new FileReader(AppConsts.CAMINHO_MOTORISTA));
		Motorista[] motoristaArray = gson.fromJson(lstMotorista, Motorista[].class);
		motoristas.clear();
		motoristas.addAll(Arrays.asList(motoristaArray));
	    }catch(IOException e) {
		e.printStackTrace();
	    } finally {
		try {
		    lstMotorista.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
	return motoristas;
    }

    private void salvarArquivo(List<Motorista> motoristas) {
	Gson gson = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create();
	FileWriter lstJson = null;
	String lstMotorista = gson.toJson(motoristas);

	try {
	    lstJson = new FileWriter(AppConsts.CAMINHO_MOTORISTA, false);
	    lstJson.write(lstMotorista);

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
    public Motorista findMotoristaByPK(String motoristaId) {
	List<Motorista> motoristas = this.getMotoristaList();
	for(Motorista motorista : motoristas) {
	    if(motorista.getId().equals(motoristaId)) {
		return motorista;
	    }
	}
	return null;
    }

    public int findIndexByPK(String motoristaId) {
	List<Motorista> motoristas = this.getMotoristaList();
	for(Motorista motorista : motoristas) {
	    if(motorista.getId().equals(motoristaId)) {
		return motoristas.indexOf(motorista);
	    }
	}
	return -1;
    }
}
