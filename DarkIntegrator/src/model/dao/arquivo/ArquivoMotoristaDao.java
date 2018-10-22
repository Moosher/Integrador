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

import model.Motorista;
import model.Veiculo;
import model.dao.MotoristaDao;
import resources.AppConsts;

public class ArquivoMotoristaDao implements MotoristaDao {

	public static List<Motorista> motoristas = new ArrayList();

	@Override
	public void adicionarMotorista(Motorista motorista) {
		motorista.setId(FileControl.getInstance().gerarId());
		this.motoristas.add(motorista);
		try {
			salvarArquivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void removerMotorista(Motorista motorista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisponivel(Motorista motorista, boolean disponivel) {
		motoristas.get(motoristas.indexOf(motorista)).setDisponivel(disponivel);
		try {
			this.salvarArquivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Motorista> getMotoristaList() {
		// TODO Auto-generated method stub
		return motoristas;
	}

	public void salvarArquivo() throws IOException {

		Gson gson = new Gson();
		FileWriter lstJson = null;
		String lstMotorista = gson.toJson(motoristas);

		try {
			lstJson = new FileWriter(AppConsts.CAMINHO_MOTORISTA, false);
			lstJson.write(lstMotorista);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			lstJson.close();
		}

	}

	@Override
	public void carregarArquivo() throws IOException {
		File file = new File(AppConsts.CAMINHO_MOTORISTA);
		if (file.exists()) {
			BufferedReader lstMotorista = null;
			Gson gson = new Gson();
			try {
				lstMotorista = new BufferedReader(new FileReader(AppConsts.CAMINHO_MOTORISTA));
				Motorista[] motoristaArray = gson.fromJson(lstMotorista, Motorista[].class);
				motoristas.clear();
				motoristas.addAll(Arrays.asList(motoristaArray));

			} finally {
				lstMotorista.close();
			}
		} else {
			this.salvarArquivo();
		}
	}



}
