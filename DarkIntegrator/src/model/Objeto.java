package model;

import java.util.Date;

public class Objeto {

    public enum Status {
	POSTADO("Postado"), ENTREGUE("Entregue"), PENDENTE("Pendente"), EM_ENTREGA("Em Entrega");

	private String status;

	Status(String status) {
	    this.status = status;
	}

	String getStatus(){
	    return this.status;
	}
    }

    private String id;

    private String codigoLocalizador;

    private String nomeRemetente;

    private String enderecoRemetente;

    private String nomeDestinatario;

    private String enderecoDestinatario;

    private Date dataDeposito;

    private double peso;

    private Status status;

    public Objeto(String codigoLocalizador, String nomeRemetente, String enderecoRemetente, String nomeDestinatario,
	    String enderecoDestinatario, Date dataDeposito, Double peso) {
	this.setCodigoLocalizador(codigoLocalizador);
	this.nomeRemetente = nomeRemetente;
	this.enderecoRemetente = enderecoRemetente;
	this.nomeDestinatario = nomeDestinatario;
	this.enderecoDestinatario = enderecoDestinatario;
	this.dataDeposito = dataDeposito;
	this.peso = peso;
	this.setStatus(Status.POSTADO);
    }

    public Objeto(String id, String codigoLocalizador, String nomeRemetente, String enderecoRemetente, String nomeDestinatario,
	    String enderecoDestinatario, Date dataDeposito, Double peso, String statusDesc) {
	this.id = id;
	this.setCodigoLocalizador(codigoLocalizador);
	this.nomeRemetente = nomeRemetente;
	this.enderecoRemetente = enderecoRemetente;
	this.nomeDestinatario = nomeDestinatario;
	this.enderecoDestinatario = enderecoDestinatario;
	this.dataDeposito = dataDeposito;
	this.peso = peso;
	this.setStatusDesc(statusDesc);


    }

    public String getCodigoLocalizador() {
	return this.codigoLocalizador;
    }

    public void setCodigoLocalizador(String codigoLocalizador) {

	if (codigoLocalizador.isEmpty()) {
	    this.codigoLocalizador = this.gerarCodigo();
	} else {
	    this.codigoLocalizador = codigoLocalizador;

	}

    }

    public String getNomeRemetente() {
	return this.nomeRemetente;
    }

    public void setNomeRemetente(String nomeRemetente) {
	this.nomeRemetente = nomeRemetente;
    }

    public String getEnderecoRemetente() {
	return this.enderecoRemetente;
    }

    public void setEnderecoRemetente(String enderecoRemetente) {
	this.enderecoRemetente = enderecoRemetente;
    }

    public String getNomeDestinatario() {
	return this.nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
	this.nomeDestinatario = nomeDestinatario;
    }

    public String getEnderecoDestinatario() {
	return this.enderecoDestinatario;
    }

    public void setEnderecoDestinatario(String enderecoDestinatario) {
	this.enderecoDestinatario = enderecoDestinatario;
    }

    public Status getStatus() {
	return this.status;
    }

    public String getStatusDesc() {
	return this.status.getStatus();
    }

    public void setStatusDesc(String statusDesc) {
	if(statusDesc.equalsIgnoreCase("Postado")) {
	    this.status = Status.POSTADO;
	}else if(statusDesc.equalsIgnoreCase("Entregue")){
	    this.status = Status.ENTREGUE;
	}else if(statusDesc.equalsIgnoreCase("Pendente")){
	    this.status = Status.PENDENTE;
	}else if(statusDesc.equalsIgnoreCase("Em Entrega")){
	    this.status = Status.EM_ENTREGA;
	}
    }

    public void setStatus(Status status) {
	this.status = status;
    }

    public String getId() {
	return this.id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getNomeR() {
	return this.nomeRemetente;
    }

    public void setNomeR(String nomeR) {
	this.nomeRemetente = nomeR;
    }

    public String getEnderecoR() {
	return this.enderecoRemetente;
    }

    public void setEnderecoR(String enderecoR) {
	this.enderecoRemetente = enderecoR;
    }

    public String getNomeD() {
	return this.nomeDestinatario;
    }

    public void setNomeD(String nomeD) {
	this.nomeDestinatario = nomeD;
    }

    public String getEnderecoD() {
	return this.enderecoDestinatario;
    }

    public void setEnderecoD(String enderecoD) {
	this.enderecoDestinatario = enderecoD;
    }

    public Date getDataDeposito() {
	return this.dataDeposito;
    }

    public void setDataDeposito(Date dataDeposito) {
	this.dataDeposito = dataDeposito;
    }

    public double getPeso() {
	return this.peso;
    }

    public void setPeso(double peso) {
	this.peso = peso;
    }

    // METODOS AUXILIARES
    public String gerarCodigo() {
	Date date = new Date();

	String codigo = String.valueOf(date.getTime());
	return codigo;

    }

    @Override
    public String toString() {
	return "Código: " + this.codigoLocalizador +" Data: " + this.dataDeposito +" Status: "+ this.status.getStatus();
    }
}
