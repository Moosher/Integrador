package model;

public class Modelo {

    private String id;
    private int capacidade;
    private String nome;

    public Modelo(String id, int capacidade, String nome) {
	this.id = id;
	this.capacidade = capacidade;
	this.nome = nome;
    }

    public String getId() {
	return this.id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public int getCapacidade() {
	return this.capacidade;
    }

    public void setCapacidade(int capacidade) {
	this.capacidade = capacidade;
    }

    public String getNome() {
	return this.nome;
    }
}
