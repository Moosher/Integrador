package model.dao;

import java.io.IOException;
import java.util.List;

import model.Veiculo;

public interface VeiculoDao {

    void adicionarVeiculo(Veiculo veiculo);
    void removerVeiculo(String veiculoId);
    List<Veiculo> getVeiculoList();
    void carregarArquivo() throws IOException;
    void setDisponivel(Veiculo veiculo, boolean disponivel);
    Veiculo findVeiculoByPK(String veiculoId);
}
