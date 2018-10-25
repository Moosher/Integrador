package model.dao;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import model.Objeto;
import model.Roteiro;

public interface RoteiroDao {

	void adicionarRoteiro( Roteiro roteiro );

	void removerRoteiro( Roteiro roteiro );

	void atualizarRoteiro( Roteiro roteiro );

	void gerarRoteiros( Date data );

	List<Roteiro> getRoteiroList();

	List<Objeto> getObjetoRoteiroList( String id );

	void carregarArquivo() throws IOException;

}
