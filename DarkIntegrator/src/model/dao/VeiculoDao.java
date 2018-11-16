package model.dao;

import java.util.List;

import model.Veiculo;

public interface VeiculoDao {

    void adicionarVeiculo(Veiculo veiculo);
    void removerVeiculo(String veiculoId);
    List<Veiculo> getVeiculoList();
    void setDisponivel(String veiculoId, boolean disponivel);
    Veiculo findVeiculoByPK(String veiculoId);
}
