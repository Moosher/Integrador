package model.dao;

import java.io.IOException;
import java.util.List;

import model.Motorista;

public interface MotoristaDao {

    void adicionarMotorista( Motorista motorista );

    void removerMotorista( String motoristaId );

    List<Motorista> getMotoristaList();

    void carregarArquivo() throws IOException;

    void setDisponivel( String motoristaId, boolean disponivel );

    Motorista findMotoristaByPK(String motoristaId);
}
