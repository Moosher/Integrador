package model.dao;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import model.Roteiro;

public interface RoteiroDao {

	void adicionarRoteiro(Roteiro roteiro);
	void removerRoteiro(Roteiro roteiro);
	void atualizarRoteiro(Roteiro roteiro);
	void gerarRoteiros(Date data);
	List<Roteiro> getRoteiroList();
	void carregarArquivo() throws IOException;

}
