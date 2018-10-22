package model.dao;

import java.io.IOException;
import java.util.List;
import model.Motorista;

public interface MotoristaDao {

	void adicionarMotorista(Motorista motorista);
	void removerMotorista(Motorista motorista);
	List<Motorista> getMotoristaList();
	void carregarArquivo() throws IOException;
	void setDisponivel(Motorista motorista, boolean disponivel);
}
