package model.dao;

import java.io.IOException;
import java.util.List;
import model.Modelo;

public interface ModeloDao {

	void adicionarModelo(Modelo modelo);
	void removerModelo(Modelo modelo);
	List<Modelo> getModeloList();
	void carregarArquivo() throws IOException;
	void salvarPreDefinidos();
}
