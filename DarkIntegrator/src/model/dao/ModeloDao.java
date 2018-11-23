package model.dao;

import java.util.List;

import model.Modelo;

public interface ModeloDao {

    void adicionarModelo(Modelo modelo);
    void removerModelo(String modeloId);
    List<Modelo> getModeloList();
    void salvarPreDefinidos();
    Modelo findModeloByPK(String id);
}
