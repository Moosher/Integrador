package model.dao;

import java.io.IOException;
import java.util.List;

import model.Modelo;

public interface ModeloDao {

    void adicionarModelo(Modelo modelo);
    void removerModelo(String modeloId);
    List<Modelo> getModeloList();
    void carregarArquivo() throws IOException;
    void salvarPreDefinidos();
    Modelo findModeloByPK(String id);
}
