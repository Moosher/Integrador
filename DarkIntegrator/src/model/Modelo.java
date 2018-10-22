package model;

public class Modelo {
	
	private String id;
	private int capacidade;
	private String nome;

	public Modelo(int capacidade, String nome) {
		this.capacidade = capacidade;
		this.nome = nome;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getNome() {
		return nome;
	}
}
