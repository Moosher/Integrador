package model;

public class Veiculo {

	private String id;

	public String getId() {
		return this.id;
	}

	public void setId( String id ) {
		this.id = id;
	}

	private String marca;

	private Modelo modelo;

	private String ano;

	private String placa;

	private Motorista motorista;

	private boolean disponivel;

	private int prioridade;

	public Veiculo( String marca, Modelo modelo, String ano, String placa ) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.placa = placa;
		this.disponivel = true;
		this.prioridade = modelo.getCapacidade();
	}

	public boolean isDisponivel() {
		return this.disponivel;
	}

	public void setDisponivel( boolean disponivel ) {
		this.disponivel = disponivel;
	}

	public int getPrioridade() {
		return this.prioridade;
	}

	public void setPrioridade( int prioridade ) {
		this.prioridade = prioridade;
	}

	public Modelo getModelo() {
		return this.modelo;
	}

	public void setModelo( Modelo modelo ) {
		this.modelo = modelo;
	}

	public Motorista getMotorista() {
		return this.motorista;
	}

	public void setMotorista( Motorista motorista ) {
		this.motorista = motorista;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca( String marca ) {
		this.marca = marca;
	}

	public String getAno() {
		return this.ano;
	}

	public void setAno( String ano ) {
		this.ano = ano;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca( String placa ) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		if ( this.motorista == null ) {
			return this.modelo.getNome() + " " + this.marca + ", placa: " + this.placa + ", motorista: motorista não alocado.";

		} else {
			return this.modelo.getNome() + " " + this.marca + ", placa: " + this.placa + ", motorista: " + this.motorista.getNome() + ", CNH: " + this.motorista.getCNH();
		}
	}
}
