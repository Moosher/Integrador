package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Objeto.Status;
import model.dao.DaoFactory;
import model.dao.ObjetoDao;

public class Roteiro {

    private String id;

    private Veiculo veiculo;

    private Date data;

    private List<Objeto> objetosRoteiro;

    int capacidade;

    int carga = 0;

    public Roteiro(Date data, Veiculo veiculo) {
	this.data = data;
	this.veiculo = veiculo;
	this.capacidade = veiculo.getModelo().getCapacidade();
	this.objetosRoteiro = new ArrayList(this.capacidade);
	this.gerarRoteiro();
    }

    private void gerarRoteiro() {
	try {
	    this.adicionaPendente();
	    this.adicionaPostado();
	} catch (ParseException e) {
	    e.printStackTrace();
	}


    }

    public void adicionaPendente() throws ParseException {
	ObjetoDao objetoDao = DaoFactory.getDaoFactory().getObjetoDao();
	for (int i = 0; this.capacidade > this.carga && i < objetoDao.getObjetoList().size(); i++) {
	    Objeto objetoPendente = objetoDao.getObjetoList().get(i);

	    if(objetoPendente.getStatus().equals(Status.PENDENTE)) {
		objetoPendente.setStatus(Status.EM_ENTREGA);
		objetoDao.setStatus(objetoPendente, Status.EM_ENTREGA);
		this.objetosRoteiro.add(objetoPendente);
		this.carga++;

	    }
	}
    }

    public void adicionaPostado() throws ParseException {
	ObjetoDao objetoDao = DaoFactory.getDaoFactory().getObjetoDao();
	for (int i = 0; this.capacidade > this.carga && i < objetoDao.getObjetoList().size(); i++) {
	    Objeto objetoPostado = objetoDao.getObjetoList().get(i);

	    if(objetoPostado.getStatus().equals(Status.POSTADO)) {
		objetoPostado.setStatus(Status.EM_ENTREGA);
		objetoDao.setStatus(objetoPostado, Status.EM_ENTREGA);
		this.objetosRoteiro.add(objetoPostado);
		this.carga++;
	    }
	}
    }

    public String getId() {
	return this.id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public Veiculo getVeiculo() {
	return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
	this.veiculo = veiculo;
    }

    public Date getData() {
	return this.data;
    }

    public void setData(Date data) {
	this.data = data;
    }

    public List<Objeto> getObjetosRoteiro() {
	return this.objetosRoteiro;
    }

    public void setObjetosRoteiro(List<Objeto> objetosRoteiro) {
	this.objetosRoteiro = objetosRoteiro;
    }

    @Override
    public String toString() {
	return "Veículo: " + this.veiculo.toString();
    }
}
